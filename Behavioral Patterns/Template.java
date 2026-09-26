
abstract class Beverage {

    public void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public abstract void brew();

    public abstract void addCondiments();

    public void boilWater() {
        System.out.println("Boiling water");
    }

    public void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

class Coffee extends Beverage {

    public void brew() {
        System.out.println("Brewing coffee");
    }

    public void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

class Tea extends Beverage {

    public void brew() {
        System.out.println("Brewing tea");
    }

    public void addCondiments() {
        System.out.println("Adding lemon");
    }
}

class Template {

    public static void main(String[] jayesh) {
        Beverage coffee = new Coffee();
        coffee.prepareRecipe();
        Beverage tea = new Tea();
        tea.prepareRecipe();
    }
}
