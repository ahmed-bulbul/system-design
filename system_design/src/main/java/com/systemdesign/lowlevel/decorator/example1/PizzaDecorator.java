package com.systemdesign.lowlevel.decorator.example1;

public abstract class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String bake() {
        return pizza.bake();
    }

}
