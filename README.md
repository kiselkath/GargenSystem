# 🌸 Java Streams Practice Exercise: Flower Planting & Caring System

### 🏗 Структура классов:

* Flower (Хранит название цветка и список действий по уходу.)
* Gardener (Хранит имя садовника и список его цветов.)
* FlowerService cодержит 3 метода:
  1. flattenCareActions()
  2. countFlowersByType()
  3. collectUniqueCareActions()

* UniqueCareActionCollector (Кастомный Collector для сбора всех уникальных действий по уходу.)

* FlowerSystemDemo
Точка входа — создает данные, вызывает сервис и печатает результаты.

* FlowerServiceTest
JUnit 5 тесты для проверки логики всех методов.
---
## 🎯 Objective

Design a small system to model **flower planting and care tracking**, using Java Streams to:

* Flatten data with `flatMap()`
* Group by flower type with `groupingBy()`
* Count how many times each flower is cared for
* Write a **custom collector** that returns a `Set<String>` of unique flower actions per gardener

---

## 🧱 Starter Structure

### 📁 `model/Flower.java`

```java
public class Flower {
    private String name;
    private List<String> careActions;
    // constructor, getters
}
```

**Hint:** Each flower has a name (e.g., "Rose") and a list of care actions (e.g., "water", "prune").

➡️ Start by implementing the constructor and `getName()` and `getCareActions()` methods.

---

### 📁 `model/Gardener.java`

```java
public class Gardener {
    private String name;
    private List<Flower> assignedFlowers;
    // constructor, getters
}
```

**Hint:** Each gardener works on several flowers. Use this to create nested data.

➡️ This is the source of nested data structure you’ll flatten later.

---

### 📁 `collector/UniqueCareActionCollector.java`

```java
public class UniqueCareActionCollector implements Collector<Gardener, Map<String, Set<String>>, Set<String>> {
    // implement supplier, accumulator, combiner, finisher, characteristics
}
```

**Hint:**

* A: Use a `Map<String, Set<String>>` where key = gardener name, value = set of unique actions
* R: Combine all sets into a single `Set<String>` of all unique care actions
* Characteristics: return `Set.of(Characteristics.UNORDERED)`

➡️ Think of the intermediate container (Map) as helping you build a gardener → actions relationship before flattening.

---

### 📁 `service/FlowerService.java`

```java
public class FlowerService {
    public List<String> flattenCareActions(List<Gardener> gardeners) { /* TODO */ }
    public Map<String, Long> countFlowersByType(List<Gardener> gardeners) { /* TODO */ }
    public Set<String> collectUniqueCareActions(List<Gardener> gardeners) { /* TODO */ }
}
```

**Hints:**

* `flattenCareActions`: use `flatMap()` to turn gardener → flower → action into a flat list

    * ➡️ Start from gardeners → stream → flatMap to flowers → flatMap to care actions
* `countFlowersByType`: use `flatMap()` to stream all flowers, then group by `getName()`, then count
* `collectUniqueCareActions`: call `.stream().collect(new UniqueCareActionCollector())`

---

### 📁 `demo/FlowerSystemDemo.java`

```java
public class FlowerSystemDemo {
    public static void main(String[] args) {
        // Create sample data and call FlowerService methods
    }
}
```

**Hint:**

* Create 2–3 gardeners with 2–3 flowers each
* Each flower has 1–3 care actions
* Call all methods from `FlowerService` and print their results

➡️ This demo will help visualize and verify your stream logic in action.

---

### 📁 `test/FlowerServiceTest.java`

```java
public class FlowerServiceTest {
    // Write JUnit 5 tests for each method in FlowerService
}
```

**Hint:**

* Test that flattened actions match expected count
* Test group count map contains correct keys and values
* Test set of unique actions contains all used actions without duplicates

➡️ Use JUnit 5 and assert methods like `assertEquals`, `assertTrue`, `assertFalse`.

---

## ✅ Deliverables

* All classes above completed and organized into proper packages
* Use Java Streams where indicated
* Fully working custom collector
* At least 3 JUnit tests

---