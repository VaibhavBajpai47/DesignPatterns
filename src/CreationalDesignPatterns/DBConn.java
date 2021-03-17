package CreationalDesignPatterns;

import java.io.Serializable;

public class DBConn {
    private static DBConn obj=new DBConn();  //static instance with early instantiation
    private DBConn(){
        //private constructor
    }
    public static DBConn getInstance(){
        return obj;
    }
    synchronized public void getHashCode(){
        DBConn instance=DBConn.getInstance();
        System.out.println("Hash Code of instance is "+instance.hashCode());
    }

}
