# OOP - Practical Work (TP) 2026

**Author:** Maamria Abderahmene  
**Institution:** National Higher School of Advanced Technologies (ENSTA)  
**Program:** 2nd Year Computer Engineering (MI2)  
**Module:** Object-Oriented Programming (POO)  
**Semester:** Second Semester - 2026  
**Instructor:** Dr. SENHADJI

---

## Repository Structure

```
oop-tp-2026/
├── tp1/           Basics - Display & Output
├── tp2/           Control Structures & Loops
├── tp3/           Classes & Objects
└── tp4/           Encapsulation, Inheritance & Polymorphism
    ├── exo1/      Training Center (Person / Teacher)
    ├── exo2/      Mini Battle Arena (GameCharacter / Warrior)
    ├── exo3/      Library System (Individual / Staff / SeniorStaff / Item / SpecialItem)
    ├── exo4/      Surface Calculation (Shape / Circle / Rectangle / Triangle)
    └── exo5/      Training Center - People & Courses (Individual / Teacher / SeniorTeacher / Course / OnlineCourse)
```

Each exercise in TP4 contains two solutions:
- **`simple/`** — Straightforward demo with hardcoded data
- **`dev/`** — Interactive menu-driven application with editing capabilities

---

## TP1 - Basics

| File | Description |
|------|-------------|
| `Exercise1.java` | Display student information |
| `Exercise2.java` | Basic output exercise |

---

## TP2 - Control Structures & Loops

| File | Description |
|------|-------------|
| `RectangleSurface.java` | Calculate the surface of a rectangle |
| `EvenOdd.java` | Check if a number is even or odd |
| `SignChecker.java` | Check if a number is positive or negative |
| `Factorial.java` | Calculate the factorial of a number |
| `SumEvenNumbers.java` | Sum of even numbers up to N |
| `ArrayMinMax.java` | Find maximum and minimum of an array |
| `ArraySum.java` | Sum of array elements |
| `VowelCounter.java` | Count vowels in a string |

---

## TP3 - Classes & Objects

| File | Description |
|------|-------------|
| `Calculator.java` | Simple calculator with basic operations |
| `NumberProperties.java` | Analyze number properties |
| `ArrayOps.java` | Array operations using objects |
| `Course.java` | Course management class |
| `Book.java` | Book management class |

---

## TP4 - Encapsulation, Inheritance & Polymorphism

### Exo 1 - Training Center

A system to manage teachers working in a training center.

| Class | Role |
|-------|------|
| `Person` | Base class (name, age, email) |
| `Teacher` | Extends Person (+ subject, experience, teach, evaluate) |

**Concepts:** Encapsulation, Inheritance, Constructor chaining

---

### Exo 2 - Mini Battle Arena

A simple battle game managing characters and warriors.

| Class | Role |
|-------|------|
| `GameCharacter` | Base class (name, health, power) |
| `Warrior` | Extends GameCharacter (+ armor, rageLevel, specialAttack, defend) |

**Concepts:** Encapsulation, Inheritance, Constructor reuse

---

### Exo 3 - Library System Design

A digital library system managing people and items.

| Class | Role |
|-------|------|
| `Individual` | Base class for people |
| `Staff` | Extends Individual (+ department, workYears) |
| `SeniorStaff` | Extends Staff (+ responsibilityLevel) |
| `Item` | Base class for library items (title, code, year) |
| `SpecialItem` | Extends Item (+ category, restricted) |

**Concepts:** Multi-level Inheritance, Encapsulation, Constructor chaining

---

### Exo 4 - Surface Calculation

A geometry application to calculate surface area of shapes using polymorphism.

| Class | Role |
|-------|------|
| `Shape` | Abstract base class (name, abstract calculateSurface) |
| `Circle` | Extends Shape (radius) |
| `Rectangle` | Extends Shape (width, height) |
| `Triangle` | Extends Shape (base, height) |

**Concepts:** Abstract classes, Polymorphism, Runtime method dispatch

---

### Exo 5 - Training Center (People & Courses)

A training center system managing individuals, teachers, and courses.

**Part 1 - People:**

| Class | Role |
|-------|------|
| `Individual` | Base class (name, id, age) |
| `Teacher` | Extends Individual (+ subject, experience, teaching, grading) |
| `SeniorTeacher` | Extends Teacher (+ responsibilityLevel, mentoring) |

**Part 2 - Courses:**

| Class | Role |
|-------|------|
| `Course` | Base class (title, code, duration) |
| `OnlineCourse` | Extends Course (+ platform, accessDuration, startOnlineSession, provideResources) |

**Concepts:** Multi-level Inheritance, Polymorphism (performAction, startCourse), Encapsulation

---

## How to Compile & Run

```bash
# Compile (example for exo5 dev)
javac tp4/exo5/dev/Individual.java tp4/exo5/dev/Teacher.java tp4/exo5/dev/SeniorTeacher.java tp4/exo5/dev/Course.java tp4/exo5/dev/OnlineCourse.java tp4/exo5/dev/Main.java

# Run
java tp4.exo5.dev.Main
```

> All code targets **Java 8+** for maximum compatibility.

---

## OOP Concepts Covered

- **Encapsulation** — Private fields with public getters/setters
- **Inheritance** — Single and multi-level class hierarchies
- **Polymorphism** — Method overriding with runtime dispatch
- **Abstraction** — Abstract classes and methods
- **Constructor Chaining** — Reuse of parent constructors via `super()`
