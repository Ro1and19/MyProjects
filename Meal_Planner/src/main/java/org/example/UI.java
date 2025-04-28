package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UI {
    
    private static Scanner sc = new Scanner(System.in);
    private boolean flag = true;
    private List<Meal> meals = new ArrayList<>();
    
    public void start() {
        
        while (flag) {
            
            System.out.println("What would you like to do (add, show, exit)?");
            switch (sc.nextLine()) {
                case "add" -> addMeal();
                case "show" -> showMeals();
                case "exit" -> {
                    System.out.println("Bye!");
                    flag = false;
                }
            }
            
        }

    }

    private void showMeals() {

    }

    private void addMeal() {
        System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
        String input = sc.nextLine();
        while (!input.matches("(breakfast|lunch|dinner)")) {
            System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");
            input = sc.nextLine();
        }
        String category = input;

        
    }


}
