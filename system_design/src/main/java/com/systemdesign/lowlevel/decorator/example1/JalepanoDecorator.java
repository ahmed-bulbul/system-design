package com.systemdesign.lowlevel.decorator.example1;

public class JalepanoDecorator extends PizzaDecorator {

    public JalepanoDecorator(Pizza pizza) { 
        super(pizza);
    }

    @Override
    public String bake() {
        return super.bake() + addJalepano();
    }

    public String addJalepano(){
        return "Jalepano";
    }

}
