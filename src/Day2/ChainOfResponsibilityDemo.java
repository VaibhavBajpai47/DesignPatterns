package Day2;

abstract class AbstractLogger{
    public static int INFO=1;
    public static int DEBUG=2;
    public static int ERROR=3;
    protected int level;

    //next object in chain of responsibility
    public AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger=nextLogger;
    }
    public void logMessage(int level,String msg){
        if(this.level<=level){
            write(msg);
        }
        if(this.nextLogger!=null){
            nextLogger.logMessage(level,msg);
        }
    }
    abstract protected void write(String msg);
}
class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int lvl){
        this.level=lvl;
    }

    @Override
    protected void write(String msg) {
        System.out.println("STD CONSOLE::LOGGER: "+msg);
    }
}
class ConsoleLogger extends AbstractLogger{
    public ConsoleLogger(int lvl){
        this.level=lvl;
    }
    @Override
    protected void write(String msg) {
        System.out.println("ERROR CONSOLE::LOGGER: "+msg);
    }
}
class FileLogger extends AbstractLogger{
    public FileLogger(int lvl){
        this.level=lvl;
    }
    @Override
    protected void write(String msg) {
        System.out.println("FILE CONSOLE::LOGGER: "+msg);
    }
}
public class ChainOfResponsibilityDemo {
    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger errLogger=new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger=new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger=new ConsoleLogger(AbstractLogger.INFO);

        errLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errLogger;
    }

    public static void main(String[] args) {
        AbstractLogger obj=getChainOfLoggers();
        obj.logMessage(AbstractLogger.INFO,"This is info");
        obj.logMessage(AbstractLogger.DEBUG,"This is debug info");
        obj.logMessage(AbstractLogger.ERROR,"This is error msg");
    }
}
