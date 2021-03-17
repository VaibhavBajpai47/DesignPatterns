package CreationalDesignPatterns;

public class Main {
    public static void main(String[] args) {
        DBConn obj= DBConn.getInstance();
        obj.getHashCode();
    }
}
