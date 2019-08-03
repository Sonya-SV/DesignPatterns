import java.util.HashMap;

public class FacadeApp {
    public static void main(String[] args) {
//        Power power = new Power();
//        power.on();
//
//        DVDRom dvdRom = new DVDRom();
//        dvdRom.load();
//
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvdRom);
        Computer computer = new Computer();
        computer.copy();
    }
}

class Computer{ //facade

    private Power power = new Power();
    private DVDRom dvdRom = new DVDRom();
    private HDD hdd = new HDD();
    void copy(){
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
    }
}
class Power{
    void on(){
        System.out.println("power on");
    }
    void off(){
        System.out.println("power off");
    }
}

class DVDRom{
    private boolean data;
    public boolean hasData(){
        return data;
    }
    void load(){
        data=true;
    }
    void unload(){
        data=false;
    }
}

class HDD{
    void copyFromDVD(DVDRom dvd){
        if(dvd.hasData())
            System.out.println("loading");
        else
            System.out.println("no dvd");
    }
}