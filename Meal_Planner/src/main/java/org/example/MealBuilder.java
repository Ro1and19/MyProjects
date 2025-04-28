package org.example;

public class MealBuilder {
    private String category;
    private String name;
    private String[] ingredients;

    public MealBuilder category(String category) {
        this.category = category;
        return this;
    }

    public MealBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MealBuilder ingredients(String[] ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public Meal build() {
        return new Meal(category, name, ingredients);
    }
}
