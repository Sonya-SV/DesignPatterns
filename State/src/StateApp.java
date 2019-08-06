public class StateApp {
    public static void main(String[] args) {
        Radio radio = new Radio();
        radio.setStation(new RadioIPT());

        for(int i =0; i<7; i++) {
            radio.playRadio();
            radio.nextStation();
        }

    }
}

interface Station{
    void play();
}
class RadioDFM implements Station{
    @Override
    public void play() {
        System.out.println("RadioDFM ...");
    }
}
class Radio7 implements Station{
    @Override
    public void play() {
        System.out.println("Radio7 ...");
    }
}
class RadioIPT implements Station{
    @Override
    public void play() {
        System.out.println("RadioIPT ...");
    }
}
//Context
class Radio{
    Station station;

    public void setStation(Station station) {
        this.station = station;
    }
    public void nextStation(){
        if(station instanceof Radio7)
            setStation(new RadioDFM());
        else if(station instanceof RadioDFM)
            setStation(new RadioIPT());
        else if(station instanceof  RadioIPT)
            setStation(new Radio7());
    }

    public void playRadio(){
        station.play();
    }
}