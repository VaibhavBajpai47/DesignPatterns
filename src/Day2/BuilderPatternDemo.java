package Day2;

import java.util.ArrayList;
import java.util.List;

interface Item{
    String name();
    Packing packing();
    float price();
}
interface Packing{
    String pack();
}
class Wrapper implements Packing{
    @Override
    public String pack(){
        return "Wrapper";
    }
}
class Bottle implements Packing{
    @Override
    public String pack(){
        return "Bottle";
    }
}
abstract class Burger implements Item{
    @Override
    public Packing packing(){
        return new Wrapper();
    }
    public abstract float price();
}
abstract class ColdDrink implements Item{
    @Override
    public Packing packing(){
        return new Bottle();
    }
    public abstract float price();
}
class VegBurger extends Burger{

    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}

//implementing chicken burger class
class ChickenBurger extends Burger{

    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
class Coke extends ColdDrink{

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}

//implementing pepsi class
class Pepsi extends ColdDrink{

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
class Meal{
    private List<Item> items=new ArrayList<>();
    public void addItem(Item item){
        items.add(item);
    }
    public float getPrice(){
        float price=0.0f;
        for (Item i:items){
            price+=i.price();
        }
        return price;
    }
    public void showItems(){
        for (Item i:items){
            System.out.println("Item: "+i.name());
            System.out.println("Packing: "+i.packing().pack());
            System.out.println("Price: "+i.price());
        }
    }
}
class MealBuilder{
    public Meal prepareVegMeal(){
        Meal m=new Meal();
        m.addItem(new VegBurger());
        m.addItem(new Coke());
        return m;
    }
    //prepare non-veg meal
    public Meal prepareNonVegMeal(){
        Meal m=new Meal();
        m.addItem(new ChickenBurger());
        m.addItem(new Pepsi());
        return m;
    }
}
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder build=new MealBuilder();
        Meal VegMeal=build.prepareVegMeal();
        System.out.println("Veg Meal: ");
        VegMeal.showItems();
        System.out.println("Total Cost: "+VegMeal.getPrice());

        Meal NonVegMeal=build.prepareNonVegMeal();
        System.out.println("Non Veg Meal: ");
        NonVegMeal.showItems();
        System.out.println("Total Cost: "+NonVegMeal.getPrice());
    }
}
