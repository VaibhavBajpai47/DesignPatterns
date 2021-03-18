package Day2;

import java.util.Scanner;

interface Food{
    String prepareFood();
    double foodPrice();
}
class VegFood implements Food{

    @Override
    public String prepareFood() {
        return ("Veg Food");
    }

    @Override
    public double foodPrice() {
        return 50.0;
    }
}
abstract class FoodDecorator implements Food{
    private Food newFood;
    public FoodDecorator(Food newFood){
        this.newFood=newFood;
    }
    @Override
    public String prepareFood(){
        return newFood.prepareFood();
    }
    @Override
    public double foodPrice(){
        return newFood.foodPrice();
    }
}
class NonVegFood extends FoodDecorator{

    public NonVegFood(Food newFood) {
        super(newFood);
    }
    @Override
    public String prepareFood(){
        return super.prepareFood()+" with roasted chicken and chicken curry";
    }
    @Override
    public double foodPrice(){
        return super.foodPrice()+150.0;
    }
}
class ChineseFood extends FoodDecorator{

    public ChineseFood(Food newFood) {
        super(newFood);
    }
    @Override
    public String prepareFood(){
        return super.prepareFood()+" with fried rice and munchurian";
    }
    @Override
    public double foodPrice(){
        return super.foodPrice()+65.0;
    }
}
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        do{
            System.out.println("========Food Menu=======");
            System.out.println("1. Veg Food");
            System.out.println("2. Non Veg Food");
            System.out.println("3. Chinese Food");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice=sc.nextInt();
            switch (choice){
                case 1:{
                    VegFood veg=new VegFood();
                    System.out.println(veg.prepareFood());
                    System.out.println(veg.foodPrice());
                    }
                    break;
                case 2:{
                    Food f2=new NonVegFood(new VegFood());
                    System.out.println(f2.prepareFood());
                    System.out.println(f2.foodPrice());
                    }
                    break;
                case 3:{
                    Food f3=new ChineseFood(new VegFood());
                    System.out.println(f3.prepareFood());
                    System.out.println(f3.foodPrice());
                    }
                    break;
                default:
                    System.out.println("Other than these no foods are available");
            }
        }while (choice!=4);

    }
}
