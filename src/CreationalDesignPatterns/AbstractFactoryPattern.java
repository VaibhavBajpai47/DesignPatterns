package CreationalDesignPatterns;

import java.util.Scanner;

//creating tire parent class
class Tire{
    public void makeTire() {
        System.out.println("Tire class");
    }
}
//creating headlight parent class
class HeadLight{
    public void makeHeadLight() {
        System.out.println("Headlight class");
    }
}
//factory interface
interface Factory{
    void produceComponents();
}

class MercedesHeadLight extends HeadLight{
    @Override
    public  void makeHeadLight(){
        System.out.println("Mercedes car headlight produced");
    }
}
class AudiHeadLight extends HeadLight{
    @Override
    public  void makeHeadLight(){
        System.out.println("Audi car headlight produced");
    }
}
class MercedesTire extends Tire{
    @Override
    public  void makeTire(){
        System.out.println("Mercedes car tire produced");
    }
}
class AudiTire extends Tire{
    @Override
    public  void makeTire(){
        System.out.println("Audi car tire produced");
    }
}
//implementing factory
class MercedesFactory implements Factory{
    public void produceComponents(){
        MercedesTire t=new MercedesTire();
        t.makeTire();
        MercedesHeadLight h=new MercedesHeadLight();
        h.makeHeadLight();
    }
}
class AudiFactory implements Factory{
    public void produceComponents(){
        AudiTire t=new AudiTire();
        t.makeTire();
        AudiHeadLight h=new AudiHeadLight();
        h.makeHeadLight();
    }
}
//lazy instantiation of concrete class based on input
class FactoryGetter{
    public Factory getFactory(String name){
        if(name==null)
            System.out.println("No factory selected");
        else if(name.equalsIgnoreCase("Mercedes")){
            return new MercedesFactory();
        }
        else if(name.equalsIgnoreCase("Audi")){
            return new AudiFactory();
        }
        return null;
    }
}
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the car company: ");
        String company=sc.nextLine();   //input
        FactoryGetter obj=new FactoryGetter();
        //creating instance of class
        Factory f=obj.getFactory(company);
        //Tire tObj=new Tire();
        //tObj.makeTire();
        f.produceComponents();
    }
}
