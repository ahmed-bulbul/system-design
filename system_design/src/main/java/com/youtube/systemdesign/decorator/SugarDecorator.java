package com.youtube.systemdesign.decorator;

public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription()+", Sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }
}
