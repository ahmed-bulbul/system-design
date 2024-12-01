package com.systemdesign.lowlevel.decorator;

public class BasePizza implements Pizza{

    @Override
    public String bake() {
        return "Base Pizza";
    }

}
