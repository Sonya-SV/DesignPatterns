public class StateApp2 {
    public static void main(String[] args) {
        Human human = new Human();
        human.setState(new WeekEnd());
        for(int i=0; i<10;i++)
            human.doSomething();
    }
}
//Context
class Human{
    private Activity state;

    public void setState(Activity state) {
        this.state = state;
    }
    public void doSomething(){
        state.doSomething(this);
    }
}
//State
interface Activity{
    void doSomething(Human context);
}

class Work implements  Activity{
    @Override
    public void doSomething(Human context) {
        System.out.println("Working...");
        context.setState(new WeekEnd());
    }
}
class WeekEnd implements Activity{
    private int count =0;
    @Override
    public void doSomething(Human context) {
        if(count<3){
            System.out.println("Have a rest");
            count++;
        }
        else
            context.setState(new Work());

    }
}