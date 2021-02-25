package com.example.demo.web.controller;

import com.example.demo.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;
import java.util.Scanner;

@Configuration
public class ConsoleController {
    UserController userController;
    Scanner in = new Scanner(System.in);
    boolean answer = true;

    @Autowired
    public ConsoleController(UserController controller) {
        this.userController = controller;
    }

    public void run() {
        System.out.println("'User Manager'");
        System.out.println("For start press 'y' and if you want exit press any key");
        System.out.print("Your choose: ");
        while(in.next().equals("y")) {
            System.out.println("1. If you want save user in to database press '1'");
            System.out.println("2. If you want show all users that database press '2'");
            System.out.println("3. If you want exit press 'e'");
            System.out.print("Your choose: ");
            chooseOption(in.next());
            System.out.println("Repeat run program again? (y/any key)");
            System.out.print("Your choose: ");
        }
        System.out.println("You exit from 'User Manager'");
    }

    public void chooseOption(String answer) {
        switch(answer)  {
            case "1":
                UserDto user = new UserDto();
                System.out.print("Enter name: ");
                user.setName(in.next());
                System.out.print("Enter lastname: ");
                user.setLastname(in.next());
                System.out.print("Enter position: ");
                user.setPosition(in.next());
                System.out.print("Enter username: ");
                user.setUsername(in.next());
                userController.save(user);
                break;
            case "2":
                for (UserDto userDto: userController.findAll()) {
                    System.out.println(userDto.getId()
                            + " | " + userDto.getName()
                            + " | " + userDto.getLastname()
                            + " | " + userDto.getPosition()
                            + " | " + userDto.getUsername());
                }
                break;
            case "e":
                break;
        }
    }

}
