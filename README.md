# 🌸 Java Streams Practice Exercise: Flower Planting & Caring System

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

## 📦 Maven Project Scaffold

### `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.flowers</groupId>
    <artifactId>flower-care-system</artifactId>
    <version>1.0-SNAPSHOT</version>
    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- JUnit 5 -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.10.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.10.0</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0</version>
            </plugin>
        </plugins>
    </build>
</project>
```

➡️ Save this file in the root directory to enable Maven build and testing.

---

## 📝 GitHub README.md Tips

* ✅ Copy this content into your repository `README.md`
* ✅ Mark completed steps with checkboxes in PRs
* ✅ Organize folders by package (`model/`, `service/`, `collector/`, `test/`, `demo/`)

---

Happy coding and keep your flowers blooming! 🌼