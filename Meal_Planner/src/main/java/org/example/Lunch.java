package org.example;

public class Lunch extends Meal {
  Lunch(String name, String[] ingredients) {
    super(name, ingredients);
    this.category = "lunch";
  }
}
