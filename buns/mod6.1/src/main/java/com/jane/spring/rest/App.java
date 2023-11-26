package com.jane.spring.rest;

import com.jane.spring.rest.configuration.MyConfig;
import com.jane.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

        List<Employee> allEmployees = communication.getAllEmployess();
        System.out.println(allEmployees);

        Employee empById = communication.getEmployee(1);
        System.out.println(empById);

        Employee emp = new Employee("Sveta", "Smirnova", "IT", 1150);
        communication.saveEmployee(emp);

//        После добавления сотрудника надо подставить его id, чтобы обновить информацию о нем
//        Employee emp = new Employee( "Sveta", "Smirnova", "HR", 1200);
//        emp.setId(10);
//        communication.saveEmployee(emp);

//        Указываем id сотрудника, которого хотим удалить
//        communication.deleteEmployee(10);
    }
}
