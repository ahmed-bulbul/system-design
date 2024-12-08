package com.youtube.systemdesign.decorator;

public class CofeeApp {
    public static void main(String[] args) {

        Coffee simpleCofee = new SimpleCoffee();
        System.out.println(simpleCofee.getDescription() +"-> $"+simpleCofee.getCost());

        Coffee milkCoffee = new MilkDecorator(simpleCofee);
        System.out.println(milkCoffee.getDescription() +"->$"+milkCoffee.getCost());

        Coffee milkAndSugar = new SugarDecorator(milkCoffee);
        System.out.println(milkAndSugar.getDescription()+"->$"+milkAndSugar.getCost());
    }
}
