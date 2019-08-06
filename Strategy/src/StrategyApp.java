public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient client = new StrategyClient();

        String array = "array";
        client.setStrategy(new Sort1());
        client.executeStrategy(array);

        String array1 = "arrayAnother";
        client.setStrategy(new Sort2());
        client.executeStrategy(array1);
    }
}

//Context
class StrategyClient{
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(String arr){
        strategy.sort(arr);
    }
}

interface Sorting{
    void sort(String arr);
}

class Sort1 implements Sorting{
    @Override
    public void sort(String arr) {
        System.out.println("sorting by sort1 "+ arr);
    }
}
class Sort2 implements Sorting{
    @Override
    public void sort(String arr) {
        System.out.println("sorting by sort2 "+ arr);
    }
}
class Sort3 implements Sorting{
    @Override
    public void sort(String arr) {
        System.out.println("sorting by sort3"+ arr);
    }
}