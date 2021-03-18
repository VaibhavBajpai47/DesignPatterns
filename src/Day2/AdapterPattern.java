package Day2;
interface MovableAdapter{
    double speed();//returns speed in kmph
}
interface Movable{
    double speed();//returns speed in mph
}
class BugatiVeyron implements Movable{

    @Override
    public double speed() {
        return 268.0;
    }
}
class MovableAdapterImpl implements MovableAdapter{
    private Movable luxuryCars;
    //constructor
    public MovableAdapterImpl(Movable obj){
        this.luxuryCars=obj;
    }
    @Override
    public double speed() {
        return ConvertMPHtoKMPH(luxuryCars.speed());
    }
    private double ConvertMPHtoKMPH(double mph){
        return mph*1.60934;
    }
}
public class AdapterPattern {
    public static void main(String[] args) {
        BugatiVeyron car=new BugatiVeyron();
        System.out.println("Bugati veyron speed in Miles per hour");
        System.out.println(car.speed());    //speed in mph
        MovableAdapter bugatiVeyronAdapter=new MovableAdapterImpl(car);
        System.out.println("Bugati veyron speed in Kilometers per hour");
        System.out.println(bugatiVeyronAdapter.speed());    //speed in kmph
    }
}
