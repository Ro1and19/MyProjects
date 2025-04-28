package org.example;

public class Dinner extends Meal {
  Dinner(String name, String[] ingredients) {
    super(name, ingredients);
    this.category = "dinner";
  }
}
