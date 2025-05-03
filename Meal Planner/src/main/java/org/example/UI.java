package org.example;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class UI {

    private enum Command {
        SHOW,
        ADD
    }

    static final String JDBC_URL = "jdbc:postgresql://localhost:1337/meals_db?currentSchema=public&user=postgres&password=010204";
    private static Scanner sc = new Scanner(System.in);
    private boolean flag = true;

    public void start() {

        try {

            Connection connection = DriverManager.getConnection(JDBC_URL);

            while (flag) {

                System.out.println("What would you like to do (add, show, exit)?");
                switch (sc.nextLine()) {
                    case "add" -> addMeal(connection);
                    case "show" -> showMeals(connection);
                    case "exit" -> {
                        System.out.println("Bye!");
                        flag = false;
                    }
                }

            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void showMeals(Connection connection) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("SELECT category, name, ingredient, meals.meal_id AS id FROM meals " +
                                                                      "JOIN ingredients on meals.meal_id = ingredients.meal_id " +
                                                                      "WHERE category = ?");
        statement.setString(1, inputCategory(Command.SHOW));
        ResultSet rs = statement.executeQuery();

        if (!rs.isBeforeFirst()) {
            System.out.println("No meals saved. Add a meal first.");
        } else {
            int curr_id = 0;
            while (rs.next()) {
                if (rs.getInt("id") > curr_id) {
                    curr_id = rs.getInt("id");
                    System.out.printf(("""
                    
                    Category: %s
                    Name: %s
                    Ingredients:
                    """), rs.getString("category"),
                        rs.getString("name"));
                }
                System.out.println(rs.getString("ingredient"));

            }
            System.out.println();
        }

    }

    private void addMeal(Connection connection) throws SQLException {

        String category = inputCategory(Command.ADD);
        String name = inputName();
        String[] ingredients = inputIngredients();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT MAX(meal_id) FROM meals");
        rs.next();
        int meal_id = rs.getInt("max") + 1;

        String mealStatement = "INSERT INTO meals(meal_id, category, name) VALUES(?,?,?)";
        String ingredientStatement = "INSERT INTO ingredients(ingredient, meal_id) VALUES(?,?)";

        PreparedStatement statement1 = connection.prepareStatement(mealStatement);
        PreparedStatement statement2 = connection.prepareStatement(ingredientStatement);

        statement1.setInt(1, meal_id);
        statement1.setString(2, category);
        statement1.setString(3, name);
        statement1.executeUpdate();

        for (String str : ingredients) {
            statement2.setString(1, str);
            statement2.setInt(2, meal_id);
            statement2.executeUpdate();
        }

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

    private String inputCategory(Command command) {

        if (command == Command.ADD)
            System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
        else if (command == Command.SHOW)
            System.out.println("Which category do you want to print (breakfast, lunch, dinner)?");
        String input = sc.nextLine();
        while (!input.matches("(breakfast|lunch|dinner)")) {
            System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");
            input = sc.nextLine();
        }

        return input;
    }

    private void createTables(Statement statement) throws SQLException {

        statement.execute("CREATE TABLE IF NOT EXISTS meals(" +
                "meal_id SERIAL PRIMARY KEY," +
                "category VARCHAR(40)," +
                "name VARCHAR(40)" +
                ")");
        statement.execute("CREATE TABLE IF NOT EXISTS ingredients(" +
                "ingredient_id SERIAL PRIMARY KEY," +
                "ingredient VARCHAR(40)," +
                "meal_id INTEGER references meals(meal_id)" +
                ")");
    }

}
