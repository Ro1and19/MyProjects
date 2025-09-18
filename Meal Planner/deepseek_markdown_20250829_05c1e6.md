# JSON Database with Java

## Description

Aside from creating a practically useful tool, you will learn about relational databases, SQL, file operations, and arrays.

## Examples

The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

### Example 1: standard execution

```
What would you like to do (add, show, exit)?
> add
Which meal do you want to add (breakfast, lunch, dinner)?
> lunch
Input the meal's name:
> salad
Input the ingredients:
> lettuce, tomato, onion, cheese, olives
The meal has been added!
What would you like to do (add, show, exit)?
> add
Which meal do you want to add (breakfast, lunch, dinner)?
> lunch
Input the meal's name:
> omelette
Input the ingredients:
> eggs, milk, cheese
The meal has been added!
What would you like to do (add, show, exit)?
> add
Which meal do you want to add (breakfast, lunch, dinner)?
> breakfast
Input the meal's name:
> oatmeal
Input the ingredients:
> oats, milk, banana, peanut butter
The meal has been added!
What would you like to do (add, show, exit)?
> show
Which category do you want to print (breakfast, lunch, dinner)?
> breakfast
Category: breakfast
Name: oatmeal
Ingredients:
oats
milk
banana
peanut butter
What would you like to do (add, show, exit)?
> show
Which category do you want to print (breakfast, lunch, dinner)?
> lunch
Category: lunch

Name: salad
Ingredients:
lettuce
tomato
onion
cheese
olives

Name: omelette
Ingredients:
eggs
milk
cheese

What would you like to do (add, show, exit)?
> exit
Bye!
```

### Example 2: warnings during execution

```
What would you like to do (add, show, exit)?
> show
Which category do you want to print (breakfast, lunch, dinner)?
> dinner
No meals found.
What would you like to do (add, show, exit)?
> show
Which category do you want to print (breakfast, lunch, dinner)?
> brunch
Wrong meal category! Choose from: breakfast, lunch, dinner.
> dinner
No meals found.
What would you like to do (add, show, exit)?
> exit
Bye!
```
