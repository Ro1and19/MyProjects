package org.example;

public abstract class Meal {
    protected String category;
    protected String name;
    protected String[] ingredients;

    Meal(String name, String[] ingredients) {
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
