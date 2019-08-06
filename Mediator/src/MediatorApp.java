import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MediatorApp {

    public static void main(String[] args) {
        TextChat textChat = new TextChat();

        User admin = new Admin(textChat);
        User u1 = new SimpleUser(textChat);
        User u2 = new SimpleUser(textChat);

        textChat.setAdmin(admin);
        textChat.addUser(u1);
        textChat.addUser(u2);

        u1.sendMessage("Hi");
        admin.sendMessage("Admin");
    }
}

interface User {
    void sendMessage(String message);

    void getMessage(String message);
}

interface Chat {
    void sendMessage(String message, User user);
}

class Admin implements User {
    Chat chat;

    public Admin(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Admin get message " + message);
    }
}

class SimpleUser implements User {
    Chat chat;

    public SimpleUser(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("User get message " + message);
    }
}

class TextChat implements Chat{
    User admin;
    List<User> users = new ArrayList<>();
    public TextChat() {
    }

    void setAdmin(User admin){
        this.admin = admin;
    }

    void addUser(User user){
        users.add(user);
    }
    @Override
    public void sendMessage(String message, User user) {
        for (User u : users)
            u.getMessage(message);
        admin.getMessage(message);
    }
}