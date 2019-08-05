package com.company;

public class ChainOfResponsibilityApp {

    public static void main(String[] args) {
        Logger smsLogger = new SMSLogger(Level.ERROR);
        Logger fileLogger = new FileLogger(Level.DEBUG);
        Logger emailLogger = new EmailLogger((Level.INFO));

        smsLogger.setNext(fileLogger);
        fileLogger.setNext(emailLogger);

        smsLogger.writeMessage("Everything is ok", Level.INFO);
        smsLogger.writeMessage("System fall error", Level.ERROR);
        smsLogger.writeMessage("System fall debug", Level.DEBUG);

    }
}

class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}
abstract class Logger{
    int priority;
    Logger next;

    void writeMessage(String message, int level){
        if(level<=priority){
            write(message);
        }
        if(next!=null)
            next.writeMessage(message,level);
    }
    abstract void write(String msg);
    public Logger(int priority){
        this.priority = priority;
    }
    public void setNext(Logger next) {
        this.next = next;
    }

}

class SMSLogger extends Logger{

    public SMSLogger(int priority) {
        super(priority);
    }
    public void write(String message){
        System.out.println("SMS: "+ message);
    }
}

class FileLogger extends Logger{

    public FileLogger(int priority) {
        super(priority);
    }
    public void write(String message){
        System.out.println("File : "+ message);
    }
}

class EmailLogger extends Logger{

    public EmailLogger(int priority) {
       super(priority);
    }
    public void write(String message){
        System.out.println("Email : "+ message);
    }
}