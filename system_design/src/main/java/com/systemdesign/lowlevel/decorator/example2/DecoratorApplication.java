package com.systemdesign.lowlevel.decorator.example2;

public class DecoratorApplication {

    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription() + " -> $" + simpleCoffee.getCost());

        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println(milkCoffee.getDescription() + " -> $" + milkCoffee.getCost());

        Coffee milkAndSugarCoffee = new SugarDecorator(milkCoffee);
        System.out.println(milkAndSugarCoffee.getDescription() + " -> $" + milkAndSugarCoffee.getCost());
    }
}
