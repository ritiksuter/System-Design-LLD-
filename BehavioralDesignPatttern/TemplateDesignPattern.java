abstract class BeverageWithHook {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();

        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    void boilWater() {
        System.out.println("Boiling Water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    abstract void brew();
    abstract void addCondiments();

    abstract boolean customerWantsCondiments();
}

class CustomCoffee extends BeverageWithHook {
    @Override
    void brew() {
        System.out.println("Brewing Coffee...");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }

    @Override
    boolean customerWantsCondiments() {
        return false;
    }
}

public class TemplateDesignPattern {
    public static void main(String[] args) {
        BeverageWithHook coffee = new CustomCoffee();
        System.out.println("Making custom coffee...");
        coffee.prepareRecipe();
    }
}