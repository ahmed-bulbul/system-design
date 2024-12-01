package com.systemdesign.lowlevel.decorator;

public class DecoratorApplication {

    public static void main(String[] args) {
        Pizza pizza = new CheeseBurstDecorator(new JalepanoDecorator(new BasePizza()));
        System.out.println(pizza.bake());
    }

}
