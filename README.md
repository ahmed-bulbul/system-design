# Low-Level Design Principles

This document provides an overview of the **SOLID Principles** and focuses on two principles: **Single Responsibility Principle** and **Liskov Substitution Principle**.

---

## SOLID Principles

The SOLID principles are guidelines for designing maintainable and scalable object-oriented systems.

1. **S** - Single Responsibility Principle  
2. **O** - Open-Closed Principle  
3. **L** - Liskov Substitution Principle  
4. **I** - Interface Segregation Principle  
5. **D** - Dependency Inversion Principle  

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