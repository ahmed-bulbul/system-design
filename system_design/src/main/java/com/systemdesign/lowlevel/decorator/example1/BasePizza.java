package com.systemdesign.lowlevel.decorator.example1;

public class BasePizza implements Pizza{

    @Override
    public String bake() {
        return "Base Pizza";
    }

}
