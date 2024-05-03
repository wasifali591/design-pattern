/**
 * The Template Method pattern is a behavioral design pattern that defines the
 * skeleton of an algorithm in the superclass but lets subclasses override
 * specific steps of the algorithm without changing its structure. It allows
 * subclasses to redefine certain steps of an algorithm without changing the
 * overall algorithm's structure.
 * 
 * @author wasif
 * @version 1.0
 * @since 02/05/2024
 */

// Abstract class defining the template method for preparing a beverage
abstract class BeverageRecipe {
    // Template method defining the algorithm's structure
    public final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void brew();

    protected abstract void addCondiments();

    // Common steps shared by all subclasses
    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

// Concrete subclass implementing the template method for preparing tea
class TeaRecipe extends BeverageRecipe {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}

// Another concrete subclass implementing the template method for preparing
// coffee
class CoffeeRecipe extends BeverageRecipe {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        // Prepare tea
        System.out.println("Making tea...");
        BeverageRecipe teaRecipe = new TeaRecipe();
        teaRecipe.prepareBeverage();

        System.out.println();

        // Prepare coffee
        System.out.println("Making coffee...");
        BeverageRecipe coffeeRecipe = new CoffeeRecipe();
        coffeeRecipe.prepareBeverage();
    }
}