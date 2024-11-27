package com.systemdesign.lowlevel.strategy;

import java.util.Scanner;

public class StategyApplication {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int result = 0;

        System.out.print("Enter operation (add, subtract, multiply): ");
        String operation = scanner.next();

        switch (operation) {
            case "add":
                result = new Context(new AddOperation()).executeStrategy(num1, num2);
                break;
            case "subtract":
                result = new Context(new SubstractOperation()).executeStrategy(num1, num2);
                break;
            default:
                System.out.println("Invalid operation");
                break;
        }

        System.out.println("Result: " + result);
        scanner.close();

    }

}
