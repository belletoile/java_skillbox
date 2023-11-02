package com.example.mod7;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> choice_box;

    @FXML
    private TextField input_text;

    @FXML
    private Label output_gr;

    @FXML
    private Label output_kg;

    @FXML
    private Label output_tn;

    int t = 0;
    int kg = 0;
    int gr = 0;

    @FXML
    void initialize() {
        input_text.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                Double.parseDouble(newValue);
            } catch (NumberFormatException e) {
                input_text.setText(oldValue);
            }
        });


        choice_box.getItems().addAll("Тонны", "Килограммы", "Граммы");
        choice_box.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String input = input_text.getText();
                int mass = Integer.parseInt(input);
                switch(newValue) {
                    case "Тонны":
                        convert(mass, mass * 1000, mass * 1000000);
                        output();
                        break;
                    case "Килограммы":
                        convert(mass / 1000, mass, mass * 1000);
                        output();
                        break;
                    case "Граммы":
                        convert(mass / 1000000, mass / 1000, mass);
                        output();
                        break;
                }
            }
        });
    }

    private void convert(int tn, int kg, int gr) {
        this.t = tn;
        this.kg = kg;
        this.gr = gr;
    }

    private void output() {
        output_tn.setText(Integer.toString(t));
        output_kg.setText(Integer.toString(kg));
        output_gr.setText(Integer.toString(gr));
    }
}



