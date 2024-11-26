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