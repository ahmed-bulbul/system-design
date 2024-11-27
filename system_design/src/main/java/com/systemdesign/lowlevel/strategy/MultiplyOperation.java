package com.systemdesign.lowlevel.strategy;

public class MultiplyOperation implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
    
}
