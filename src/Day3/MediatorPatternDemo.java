package Day3;

import java.util.ArrayList;
import java.util.List;

interface ChatRoom{
    void addUser(User user);
    void sendMessage(String msg,User u);
}
interface User{
    void receiveMessage(String msg);
    void sendMessage(User u);
}
class ChatMediator implements ChatRoom{
    List<User> lst=new ArrayList<>();
    @Override
    public void addUser(User user) {
        lst.add(user);
    }
    @Override
    public void sendMessage(String msg,User u) {
        u.receiveMessage(msg);
    }
}
class BasicUser implements User{
    ChatMediator chatMediator;
    String name;
    public BasicUser(String name,ChatMediator chat){
        this.chatMediator=chat;
        this.name=name;
    }
    @Override
    public void receiveMessage(String msg) {
        System.out.println("name: "+name+" Message: "+msg);
    }

    @Override
    public void sendMessage(User u) {
        chatMediator.sendMessage("Message from basic user",u);
    }
}
class PremiumUser implements User{
    ChatMediator chatMediator;
    String name;
    public PremiumUser(String name, ChatMediator chat){
        this.chatMediator=chat;
        this.name=name;
    }

    @Override
    public void receiveMessage(String msg) {
        System.out.println("name: "+name+" Message: "+msg);
    }

    @Override
    public void sendMessage(User u) {
        chatMediator.sendMessage("Message from premium user",u);
    }
}
public class MediatorPatternDemo {
    public static void main(String[] args) {
        ChatMediator chat=new ChatMediator();
        User u1=new BasicUser("Vaibhav",chat);
        User u2=new PremiumUser("ABC",chat);

        User sender=new BasicUser("Sender",new ChatMediator());
        sender.sendMessage(u1);
        sender.sendMessage(u2);
    }
}
