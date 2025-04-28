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
        if (meals.isEmpty()) System.out.println("No meals saved. Add a meal first.");
        else {
            System.out.println();
            meals.forEach(System.out::println);
        }
    }

    private void addMeal() {
        MealBuilder builder = new MealBuilder();
        String category = inputCategory();
        String name = inputName();
        String[] ingredients = inputIngredients();
        Meal meal = builder.category(category)
                            .name(name)
                            .ingredients(ingredients)
                            .build();
        meals.add(meal);
    }

    private String[] inputIngredients() {
        System.out.println("Input the ingredients:");
        String input = sc.nextLine();
        while (input.matches(".*\\d.*")) {
            System.out.println("Wrong format. Use letters only!");
            input = sc.nextLine();
        }
        return Arrays.stream(input.split(",")).map(String::trim).toArray(String[]::new);
    }

    private String inputName() {
        System.out.println("Input the meal's name:");
        String input = sc.nextLine();
        while (!input.matches("[a-zA-Z ]+")) {
            System.out.println("Wrong format. Use letters only!");
            input = sc.nextLine();
        }
        return input;
    }

    private String inputCategory() {
        System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
        String input = sc.nextLine();
        while (!input.matches("(breakfast|lunch|dinner)")) {
            System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");
            input = sc.nextLine();
        }
        return input;
    }


}
