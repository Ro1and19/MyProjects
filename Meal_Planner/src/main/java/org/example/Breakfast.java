package org.example;

public class Breakfast extends Meal {
  Breakfast(String name, String[] ingredients) {
    super(name, ingredients);
    this.category = "breakfast";
  }
}
