package com.youtube.systemdesign.strategy;

import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 20;

        Strategy strategy = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter operation (add,subtract) : ");
        String operation = sc.next();

        if(operation.equals("add")){
            strategy = new AddOperation();
        }else if(operation.equals("subtract")){
            strategy = new SubstractOperation();
        }else{
            System.out.println("Invalid operation");
            return;
        }



        Context context = new Context(strategy);

        int result = context.executeStrategy(num1, num2);
        System.out.println("The result is :: "+result);
        
    }

}
