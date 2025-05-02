package org.example;

public class Meal {
    private String category;
    private String name;
    private String[] ingredients;

    Meal(String category, String name, String[] ingredients) {
        this.category = category;
        this.name = name;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (String s : ingredients)
            str.append(s).append("\n");

        return ("""
            Category: %s
            Name: %s
            Ingredients:
            %s""").formatted(category, name, str.toString());
    }
}
