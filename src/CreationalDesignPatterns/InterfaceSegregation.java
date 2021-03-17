package CreationalDesignPatterns;

import java.util.Locale;
import java.util.Scanner;

//interface segregation
interface PhoneOrder{
    void processOrder(String modelName);
}
interface PhoneRepair{
    void processPhoneRepair(String modelName);
}
interface AccessoryRepair{
    void processAccessoryRepair(String accessoryType);
}

//single responsibility principle
class ImplementPhoneRepair implements PhoneRepair{
    @Override
    public void processPhoneRepair(String modelName){
        System.out.println(modelName+" repair accepted!");
    }
}
class ImplementAccessoryRepair implements AccessoryRepair{
    @Override
    public void processAccessoryRepair(String accessoryType){
        System.out.println(accessoryType+" repair accepted!");
    }
}
class ImplementPhoneOrder implements PhoneOrder{

    @Override
    public void processOrder(String modelName) {
        System.out.println(modelName+" order accepted!");
    }
}

//driver class
public class InterfaceSegregation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to our site. Would you like to order or repair?");
        String processOption=sc.nextLine().trim().toLowerCase();
        String productDetails;
        switch (processOption){
            case "order":
                System.out.println("Enter the model name: ");
                productDetails=sc.nextLine().trim().toLowerCase();
                ImplementPhoneOrder order=new ImplementPhoneOrder();
                order.processOrder(productDetails);
                break;
            case "repair":
                System.out.println("Is it the phone or the accessory you want to be repaired?");
                String productType=sc.nextLine().trim().toLowerCase(Locale.ROOT);
                if(productType.equalsIgnoreCase("phone")){
                    System.out.println("Please provide the phone model name");
                    productDetails=sc.nextLine().trim().toLowerCase(Locale.ROOT);
                    ImplementPhoneRepair pRepair=new ImplementPhoneRepair();
                    pRepair.processPhoneRepair(productDetails);
                }
                else{
                    System.out.println("Please provide the accessory detail, like headphone, tempered glass");
                    productDetails=sc.nextLine().trim().toLowerCase(Locale.ROOT);
                    ImplementAccessoryRepair aRepair=new ImplementAccessoryRepair();
                    aRepair.processAccessoryRepair(productDetails);
                }
                break;
            default:
                break;
        }
    }
}
