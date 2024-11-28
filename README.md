# Low-Level Design Principles

[1.SOLID Principles](#solid-principles) <br>
[2.Strategy Pattern](#strategy-pattern) <br>
[3.Observer Pattern](#observer-pattern) <br>

# High-Level Design Principles

[1.wait and notify pattern](#wait-and-notify-pattern) <br>

---

## SOLID Principles() 

This document provides an overview of the **SOLID Principles** and focuses on two principles: **Single Responsibility Principle** and **Liskov Substitution Principle**.

The SOLID principles are guidelines for designing maintainable and scalable object-oriented systems.

1. [**S** - Single Responsibility Principle](#1-single-responsibility-principle-srp)  
2. [**O** - Open-Closed Principle](#2-open-closed-Principle-ocp)  
3. [**L** - Liskov Substitution Principle](#3-liskov-substitution-principle-lsp)  
4. [**I** - Interface Segregation Principle](#4-interface-segregation-principle-isp)  
5. [**D** - Dependency Inversion Principle](#5-dependency-inversion-principle-dip)

---

### 1. Single Responsibility Principle (SRP)

**Definition:**  
A class should have only one reason to change, meaning it should only have one responsibility.

**Key Points:**  
- A class with multiple responsibilities can lead to tightly coupled code, making it harder to maintain and test.  
- Adhering to SRP improves modularity and reduces complexity.  

**Example:**  
A class for user management should handle only user-related tasks, while logging or email-related responsibilities should be delegated to separate classes.
**Example:**  

Here is an example of violating LSP:

```java
class Marker{
    String name;
    String color;
    int price;
    int quantity;
    Marker(String name, String color, int price, int quantity){
        this.name = name;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }
    
}

class Invoice{
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity){
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal(){
        return marker.price * quantity;
    
    }

    public void printInvoice(){
        System.out.println("Invoice for " + quantity + " " + marker.name + "s");
        System.out.println("Total: $" + calculateTotal());
    }

    public void saveToDatabase(){
        // Save invoice to database
    }
}

```
Solution:

```java
class Invoice{
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity){
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal(){
        return marker.price * quantity;
    }
}

class InvoiceDao{
    Invoice invoice;

    public InvoiceDao(Invoice invoice){
        this.invoice = invoice;
    }

    public void saveToDatabase(){
        // Save invoice to database
    }
}

class InvoicePrinter{
    Invoice invoice;

    public InvoicePrinter(Invoice invoice){ 
        this.invoice = invoice;
    }

    public void printInvoice(){
        System.out.println("Invoice for " + quantity + " " + marker.name + "s");
        System.out.println("Total: $" + calculateTotal());
    }
}

---
```

### 2. Open Closed Principle (OCP)


**Definition:**
Software entities should be open for extension but closed for modification.

**Key Points:** 

- A class should be open for extension but closed for modification.

**Example:**

Here is an example of violating OCP:

```java
class InvoiceDao{
    Invoice invoice;
    public InvoiceDao(Invoice invoice){
        this.invoice = invoice;
    }
    public void saveToDatabase(){
        // Save invoice to database
    }

    // this point this is live 

    //after some time another requirement added to save invoice to file
    // but if I want add this requirement same class this need to test again and again
    //thats not good practice and voilests OCP


    //save invoice to file
    public void saveToFile(){
        // Save invoice to file
    }

}
```

Solution:

```java
interface InvoiceDao{
    void saveToDatabase();
    void saveToFile();
}

class DatabaseInvoiceDao implements InvoiceDao{

    public void saveToDatabase(){
        // Save invoice to database
    }
}

class FileInvoiceDao implements InvoiceDao{

    public void saveToFile(){
        // Save invoice to file
    }
}
``` 


### 3. Liskov Substitution Principle (LSP)

**Definition:**  
If class B is a subtype of class A, objects of class A should be replaceable with objects of class B without affecting the program's behavior.  

**Key Points:**  
- Subclasses should extend the capabilities of their parent class, not restrict them.  
- Violating LSP leads to unexpected behaviors when using polymorphism.  

**Example:**  

Here is an example of violating LSP:

```java
interface Bike {
    void turnOnEngine();
    void accelerate();
}

class MotorBike implements Bike {
    private boolean isEngineOn;
    private int speed;

    @Override
    public void turnOnEngine() {
        this.isEngineOn = true;
    }

    @Override
    public void accelerate() {
        if (isEngineOn) {
            this.speed += 10;
        }
    }
}

class Bicycle implements Bike {
    @Override
    public void turnOnEngine() {
        throw new UnsupportedOperationException("Bicycles do not have an engine.");
    }

    @Override
    public void accelerate() {
        // Bicycles accelerate manually
    }
}

```
Solution:

```java
// Base interface for all vehicles
interface Vehicle {
    void accelerate();
}

// Specialized interface for vehicles with engines
interface EngineVehicle extends Vehicle {
    void turnOnEngine();
}

// MotorBike class implements EngineVehicle
class MotorBike implements EngineVehicle {
    private boolean isEngineOn;
    private int speed;

    @Override
    public void turnOnEngine() {
        this.isEngineOn = true;
    }

    @Override
    public void accelerate() {
        if (isEngineOn) {
            this.speed += 10;
        }
    }
}

// Bicycle class implements Vehicle (without engine)
class Bicycle implements Vehicle {
    @Override
    public void accelerate() {
        // Bicycles accelerate manually
    }
}


```

### 4. Interface Segregation Principle (ISP)

**Definition:**
Interface should be such , that client should not implement unnesessary functions they do not need.

**Key Points:**

- A class should only depend on interfaces that it implements.

**Example:**


Here is an example of violating ISP:

```java
interface RestaurentEmployee{
    void washDishes();
    void serveCustomers();
    void cookFood();
}

class waiter implements RestaurentEmployee{
    @Override
    public void washDishes() {
        // not my job
    }

    @Override
    public void serveCustomers() {
        // my job
        System.out.println("Serving customers");
    }

    @Override
    public void cookFood() {
        // not my job
    }
}

```

Solution:

```java
interface ServeCustomers{
    void serveCustomers();
}

interface CookFood{
    void cookFood();
}

class waiter implements ServeCustomers{ 
    @Override
    public void serveCustomers() {
        // my job
        System.out.println("Serving customers");
    }
}

class chef implements CookFood{
    @Override
    public void cookFood() {
        // my job
        System.out.println("Cooking food");
    }
}

```
### 5. Dependency Inversion Principle (DIP)

**Definition:**
Class should depend on interface rather than concrete class.

High-level modules should not depend on low-level modules. Both should depend on abstractions.

**Key Points:**

- High-level modules should not depend on low-level modules. Both should depend on abstractions.

**Example:**


Here is an example of violating DIP:

The PaymentProcessor class depends directly on the PayPalService concrete class.
If you want to switch to another payment service (e.g., Stripe or Bkash), you would need to modify the PaymentProcessor class, breaking its closed-for-modification principle.

```java
// PayPal service for handling payments
class PayPalService {
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via PayPal.");
    }
}

// Payment processor tightly coupled with PayPalService
class PaymentProcessor {
    private PayPalService payPalService;

    public PaymentProcessor() {
        this.payPalService = new PayPalService(); // Direct dependency on a concrete class
    }

    public void process(double amount) {
        payPalService.processPayment(amount); // Tightly coupled call
    }
}

// Main class
public class DIPViolationExample {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.process(100.0);
    }
}
```

Solution:

```java
// Abstraction for payment service
interface PaymentService {
    void processPayment(double amount);
}

// PayPal service implementation
class PayPalService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via PayPal.");
    }
}

// Stripe service implementation
class StripeService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via Stripe.");
    }
}

// PaymentProcessor depends on abstraction, not concrete classes
class PaymentProcessor {
    private PaymentService paymentService;

    public PaymentProcessor(PaymentService paymentService) {
        this.paymentService = paymentService; // Inject dependency
    }

    public void process(double amount) {
        paymentService.processPayment(amount); // Call via abstraction
    }
}

// Main class
public class DIPSolutionExample {
    public static void main(String[] args) {
        PaymentService payPalService = new PayPalService();
        PaymentProcessor payPalProcessor = new PaymentProcessor(payPalService);
        payPalProcessor.process(100.0);

        PaymentService stripeService = new StripeService();
        PaymentProcessor stripeProcessor = new PaymentProcessor(stripeService);
        stripeProcessor.process(200.0);
    }
}

```

## Strategy Pattern:

Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

### 1. Application:

Use the Strategy pattern when you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another during runtime.

```java
public interface Strategy {

    public int doOperation(int num1, int num2);
}

public class OperationAdd implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

public class OperationSubtract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

public class OperationMultiply implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}

class StrategyPatternExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter operation (add, subtract, multiply): ");
        String operation = scanner.next();

        Strategy strategy;
        if (operation.equals("add")) {
            strategy = new OperationAdd();
        } else if (operation.equals("subtract")) {
            strategy = new OperationSubtract();
        } else if (operation.equals("multiply")) {
            strategy = new OperationMultiply();
        } else {
            System.out.println("Invalid operation");
            return;
        }

        Context context = new Context(strategy);
        int result = context.executeStrategy(num1, num2);
        System.out.println("Result: " + result);
    }
}
```
## Observer Pattern:

Observer is a behavioral design pattern that allows you to define a one-to-many dependency between objects, where one object updates other objects when it changes state.

### 1. Application:

Use the Observer pattern when changes to the state of one object may require changing other objects, and the actual set of objects is unknown beforehand or changes dynamically.

```java
public interface Observer {
    void update(String news);
}

public class Channel implements Observer {

    @Override
    public void update(String news) {
        System.out.println("Channel 1: " + news);
    }
}

public class Channel2 implements Observer {

    @Override
    public void update(String news) {
        System.out.println("Channel 2: " + news);
    }

}

public class Channel3 implements Observer {

    @Override
    public void update(String news) {
        System.out.println("Channel 3: " + news);
    }
}

public class NewsAgency {

    private Channel channel1;
    private Channel channel2;
    private Channel channel3;

    public NewsAgency(Channel channel1, Channel channel2, Channel channel3) {
        this.channel1 = channel1;
        this.channel2 = channel2;
        this.channel3 = channel3;
    }

    public void publishNews(String news) {
        channel1.update(news);
        channel2.update(news);
        channel3.update(news);
    }
}

class ObserverPatternExample {

    public static void main(String[] args) {
        Channel channel1 = new Channel();
        Channel channel2 = new Channel();
        Channel channel3 = new Channel();
        NewsAgency newsAgency = new NewsAgency(channel1, channel2, channel3);

        newsAgency.publishNews("Breaking news!");

        // Output: Channel 1: Breaking news!
        
    }


}