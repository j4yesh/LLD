# Low Level Design (LLD)

<div align="center">
  <img src="assets/cute_boy_learning_lld.jpg" alt="Cute Boy Learning LLD" width="600"/>
</div>

Welcome to my LLD repository! This workspace contains my notes, explorations, and code implementations for various Low Level Design (LLD) concepts, Object-Oriented principles, and Design Patterns.

---

## Contents

- [Creational Design Patterns](#creational-design-patterns)
  - [Overview & Quick Links](#overview--quick-links)
  - [1. Factory Pattern](#1-factory-pattern)
  - [2. Abstract Factory Pattern](#2-abstract-factory-pattern)
  - [3. Singleton Pattern](#3-singleton-pattern)
  - [4. Builder Pattern](#4-builder-pattern)
  - [5. Prototype Pattern](#5-prototype-pattern)
- [Summary Comparison Table](#summary-comparison-table)

---

## Creational Design Patterns

Creational design patterns focus on how objects are created. Instead of creating objects directly in the main code, these patterns help create objects in a cleaner, organized, and flexible way.

### Overview & Quick Links

| Pattern | What it does | Java Code |
| :--- | :--- | :--- |
| **Factory Pattern** | Creates different objects in one place based on requirements. | [`Factory.java`](./Creational%20Patterns/Factory.java) |
| **Abstract Factory Pattern** | Creates families of related objects together without specifying exact classes. | [`AbstractFactory.java`](./Creational%20Patterns/AbstractFactory.java) |
| **Singleton Pattern** | Keeps and gives access to only one instance of a class across the app. | [`Singletone.java`](./Creational%20Patterns/Singletone.java) |
| **Builder Pattern** | Builds complex objects step-by-step using method chaining. | [`Builder.java`](./Creational%20Patterns/Builder.java) |
| **Prototype Pattern** | Creates new objects by cloning an existing object instead of starting from scratch. | [`Prototype.java`](./Creational%20Patterns/Prototype.java) |
| **My Raw Notes** | Original notes file. | [`Notes.txt`](./Creational%20Patterns/Notes.txt) |

---

### 1. Factory Pattern

#### **Q. What is the Factory Pattern?**
**Ans:** A creational design pattern used to create different objects based on requirements without exposing the creation logic directly.

#### **Q. What problem does it solve?**
**Ans:** It helps create objects in a centralized place without making the main code messy or cluttered.

#### **Q. How is it implemented?**
**Ans:** Create a factory class with a method (like `getVehicle(type)`) that checks conditions and returns the required object.

#### **Q. Real-world example?**
**Ans:** A `VehicleFactory` class that returns different vehicle objects like `Bike`, `Car`, or `Bus` based on what you pass to it.

> **Code:** [`Factory.java`](./Creational%20Patterns/Factory.java)

---

### 2. Abstract Factory Pattern

#### **Q. What is the Abstract Factory Pattern?**
**Ans:** A creational design pattern that provides an interface for creating families of related objects without specifying their concrete classes.

#### **Q. What problem does it solve?**
**Ans:** When we need to create multiple related objects, Abstract Factory separates their creation into different factories and ensures that related objects are created together.

#### **Q. How is it implemented?**
**Ans:** Create an abstract factory interface with methods to create each product. Then create separate factory classes (like `BMWfactory` and `KTMfactory`) that implement it.

#### **Q. Real-world example?**
**Ans:** Different product families based on vehicle brands: `BMWfactory` creates BMW-related vehicles and `KTMfactory` creates KTM-related vehicles.

> **Code:** [`AbstractFactory.java`](./Creational%20Patterns/AbstractFactory.java)

---

### 3. Singleton Pattern

#### **Q. What is the Singleton Pattern?**
**Ans:** A creational design pattern that ensures only one instance of a class exists throughout the system and provides a global way to access it.

#### **Q. What problem does it solve?**
**Ans:** It makes sure only one instance of a class exists when having multiple instances is unnecessary or causes problems (like multiple database connections fighting each other).

#### **Q. How is it implemented?**
**Ans:**
1. Create a class with a `private` constructor so nobody can call `new` directly.
2. Keep a `static` instance of the class inside it.
3. Every time `getInstance()` is called, check if the instance is already available. If not, create it, and then return it.

#### **Q. Real-world example?**
**Ans:** A single database connection for an application, or a shared logger.

> **Code:** [`Singletone.java`](./Creational%20Patterns/Singletone.java)

---

### 4. Builder Pattern

#### **Q. What is the Builder Pattern?**
**Ans:** A creational design pattern that allows you to build objects with complex data and lots of optional fields.

#### **Q. What problem does it solve?**
**Ans:** It is tedious and repetitive to call constructors that have too many parameters and optional fields.

#### **Q. How is it implemented?**
**Ans:**
1. Inside the target class, create a static `Builder` class with the same fields.
2. Write setter methods in a way that each method returns `this` (to form a chain-like pattern).
3. Add a `build()` method that creates and returns the target object with the set values.

#### **Q. Real-world example?**
**Ans:** Java's `StringBuilder` or building an `HttpRequest`.

> **Code:** [`Builder.java`](./Creational%20Patterns/Builder.java)

---

### 5. Prototype Pattern

#### **Q. What is the Prototype Pattern?**
**Ans:** A creational design pattern that creates new objects by cloning an existing object (the prototype) instead of creating and setting up a new object from scratch.

#### **Q. What problem does it solve?**
**Ans:** When creating and setting up an object is complex or heavy, Prototype allows us to quickly create a new object by copying an already configured one.

#### **Q. How is it implemented?**
**Ans:** When a new object is needed, clone the prototype instead of creating it from scratch. A factory or registry can optionally store and provide the prototypes.

#### **Q. Real-world example?**
**Ans:** Creating characters or enemies in game development, or copying UI widgets in GUI frameworks.

> **Code:** [`Prototype.java`](./Creational%20Patterns/Prototype.java)

---

## Summary Comparison Table

| Pattern | In Simple Words | Main Benefit | When to Use |
| :--- | :--- | :--- | :--- |
| **Factory** | One method decides which object to create | Cleans up object creation from main code | When you have different subclasses based on an input |
| **Abstract Factory** | Factory of factories for related objects | Keeps related objects compatible | When working with product families (e.g. BMW vs KTM) |
| **Singleton** | Only one single instance exists everywhere | Prevents conflicts and saves resources | Database connection, app logger, cache |
| **Builder** | Builds an object step-by-step with chaining | No giant constructors with lots of nulls | When an object has many optional fields |
| **Prototype** | Copies an existing object | Saves time when object setup is complex | Spawning game objects, copying configured templates |

---
