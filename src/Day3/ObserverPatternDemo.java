package Day3;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

interface Observer1{
    void update(Message m);
}
interface Subject{
    void attach(Observer1 o);
    void detach(Observer1 o);
    void notifyAllUpdate(Message m);
}

class MessagePublisher implements Subject{
    private List<Observer1> observers=new ArrayList<>();
    //state object
    int state=1;
    @Override
    public void attach(Observer1 o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer1 o) {
        observers.remove(o);
    }

    @Override
    public void notifyAllUpdate(Message m) {
        for (Observer1 o:observers){
            o.update(m);
        }
    }
    //method to change state
    public void changeState(int newState){
        state=newState;
        notifyAllUpdate(new Message("State updated"));
    }
}
class MessageSubscriberOne implements Observer1{

    @Override
    public void update(Message msg) {
        System.out.println("Message Subscriber one ::"+msg.getMessageContent());
    }
}
class MessageSubscriberTwo implements Observer1{

    @Override
    public void update(Message msg) {
        System.out.println("Message Subscriber two ::"+msg.getMessageContent());
    }
}
class MessageSubscriberThree implements Observer1{

    @Override
    public void update(Message msg) {
        System.out.println("Message Subscriber three ::"+msg.getMessageContent());
    }
}
class Message{
    final String messageContent;
    public  Message(String m){
        this.messageContent=m;
    }
    public String getMessageContent(){
        return messageContent;
    }
}
public class ObserverPatternDemo {
    public static void main(String[] args) {
        MessageSubscriberOne s1=new MessageSubscriberOne();
        MessageSubscriberTwo s2=new MessageSubscriberTwo();
        MessageSubscriberThree s3=new MessageSubscriberThree();

        MessagePublisher p=new MessagePublisher();
        p.attach(s1);
        p.attach(s2);
        p.changeState(2);

        p.notifyAllUpdate(new Message("First Message"));
        p.detach(s2);
        p.attach(s3);

        p.notifyAllUpdate(new Message("Second Message"));
    }
}
