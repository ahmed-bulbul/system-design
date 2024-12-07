package com.systemdesign.lowlevel.decorator.example2;


import java.util.logging.Logger;

public class DecoratorApplication {

    public static final Logger logger = Logger.getLogger(DecoratorApplication.class.getName());
    public static final String NEW_LINE = "\n";
    public static final String DECORATION = " -> $ ";
    public static void main(String[] args) {

        Coffee simpleCoffee = new SimpleCoffee();
        logger.info(simpleCoffee.getDescription() + DECORATION + simpleCoffee.getCost());

        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        logger.info(milkCoffee.getDescription() + DECORATION + milkCoffee.getCost());

        Coffee milkAndSugarCoffee = new SugarDecorator(milkCoffee);
        logger.info(milkAndSugarCoffee.getDescription() + DECORATION + milkAndSugarCoffee.getCost());
    }
}
