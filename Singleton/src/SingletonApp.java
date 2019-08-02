import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

public class SingletonApp {
    public static void main(String[] args) {

        Thread[] t = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            t[i] = new Thread(new R());
            t[i].start();
        }
        try {
            for (int i = 0; i < 1000; i++)
                t[i].join();
        } catch (Exception e) {
        }
        System.out.println(Singleton.count);
//        Singleton []arr = new Singleton[1000];
//        for(int i =0; i<1000; i++)
//            arr[i] = Singleton.getInstance();
//        System.out.println(Singleton.count);
    }
}

class Singleton {
    public static int count = 0;
    private static volatile Singleton instance;
            //= new Singleton();

    private Singleton() {
        count++;
    }

    public static Singleton getInstance(){
        if(instance == null)
            synchronized (Singleton.class) {
            if(instance == null)
                instance = new Singleton();
            }
        return instance;
    }
//    public static synchronized Singleton getInstance(){
//        if(instance == null)
//            instance = new Singleton();
//        return instance;
//    }

//    public static Singleton getInstance() {
//        return instance;

//    public static Singleton getInstance() {
//        if (instance == null)
//            instance = new Singleton();
//        return instance;
//    }
}

class R implements Runnable {

    @Override
    public void run() {
        Singleton.getInstance();
    }
}

