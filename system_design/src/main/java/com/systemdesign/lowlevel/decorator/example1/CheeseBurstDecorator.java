package com.systemdesign.lowlevel.decorator.example1;

public class CheeseBurstDecorator extends PizzaDecorator{

    public CheeseBurstDecorator(Pizza pizza) {
        super(pizza);

    }

    @Override
    public String bake() {
        return super.bake() + addCheeseBursts();
    }

    public String addCheeseBursts() {
        return "CheeseBursts";
    }

}
