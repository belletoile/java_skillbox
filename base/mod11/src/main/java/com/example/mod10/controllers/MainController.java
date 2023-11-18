package com.example.mod10.controllers;

import com.example.mod10.models.Reviews;
import com.example.mod10.models.Role;
import com.example.mod10.models.User;
import com.example.mod10.repo.ReviewRepository;
import com.example.mod10.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Map<String, Object> model) {
        model.put("title", "Главная страница");
        return "home";
    }

    @GetMapping("/uslugi/")
    public String uslugi(Map<String, Object> model) {
        model.put("title", "Услуги");
        return "uslugi";
    }

    @GetMapping("/reviews")
    public String reviews(Map<String, Object> model) {
        Iterable<Reviews> reviews = reviewRepository.findAll();
        model.put("title", "Услуги");
        model.put("reviews", reviews);
        return "reviews";
    }

    @PostMapping("/reviews-add")
    public String reviewsAdd(@RequestParam String title,
                             @RequestParam String text,
                             Map<String, Object> model) {
        Reviews reviews = new Reviews(title, text);
        reviewRepository.save(reviews);

        return "redirect:/reviews";
    }

    @GetMapping("/reviews/{id}")
    public String reviewInfo(@PathVariable(value = "id") long id,
                             Map<String, Object> model) {
        Optional<Reviews> review = reviewRepository.findById(id);
        ArrayList<Reviews> result = new ArrayList<>();
        review.ifPresent(result::add);
        model.put("review", result);
        return "review-info";
    }

    @GetMapping("/reviews/{id}/update")
    public String reviewUpdate(@PathVariable(value = "id") long id,
                               Map<String, Object> model) {
        Optional<Reviews> review = reviewRepository.findById(id);

        ArrayList<Reviews> result = new ArrayList<>();
        review.ifPresent(result::add);

        model.put("review", result);
        return "review-update";
    }

    @PostMapping("/reviews/{id}/update")
    public String reviewsUpdateForm(@PathVariable(value = "id") long id,
                                    @RequestParam String title,
                                    @RequestParam String text,
                                    Map<String, Object> model) throws ClassNotFoundException {
        Reviews review = reviewRepository.findById(id).orElseThrow(() -> new ClassNotFoundException());

        review.setTitle(title);
        review.setText(text);

        reviewRepository.save(review);
        return "redirect:/reviews/" + id;
    }

    @PostMapping("reviews/{id}/delete")
    public String reviewsDeleteForm(@PathVariable(value = "id") long id,
                                    Map<String, Object> model) throws ClassNotFoundException {
        Reviews review = reviewRepository.findById(id).orElseThrow(() -> new ClassNotFoundException());

        reviewRepository.delete(review);
        return "redirect:/reviews";
    }

    @GetMapping("/reg")
    public String reg(User user, Model model) {
        model.addAttribute("roles", Role.values());
        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(User user, Map<String, Object> model) {
        user.setEnabled(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";
    }


    @GetMapping("/user/")
    public String userUpdate(@AuthenticationPrincipal UserDetails userDetails,
                             Map<String, Object> model) {
        String username = userDetails.getUsername();
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));

        ArrayList<User> result = new ArrayList<>();
        user.ifPresent(result::add);

        model.put("user", result);
        return "user-update";
    }

    @PostMapping("/user/")
    public String userUpdateForm(@AuthenticationPrincipal UserDetails userDetails,
                                 @RequestParam String username,
                                 @RequestParam String email,
//                                 @RequestParam String role,
                                 Map<String, Object> model) throws ClassNotFoundException {
        String name = userDetails.getUsername();
        User user = userRepository.findByUsername(name);
        user.setUsername(username);
        user.setEmail(email);
//        user.setRoles(Collections.singleton(Role.USER));
//        if(role.equals("USER"))
//            user.setRoles(Collections.singleton(Role.USER));
//        else if (role.equals("ADMIN"))
//        {
//            user.setRoles(Collections.singleton(Role.ADMIN));
//        }

        userRepository.save(user);
        return "redirect:/";
    }
}

