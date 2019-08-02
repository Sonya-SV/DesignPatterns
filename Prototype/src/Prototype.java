public class Prototype {
    public static void main(String[] args) {
        Human origanal = new Human(18, "Max");
        System.out.println(origanal);

        Human copy = (Human)origanal.copy();
        System.out.println(copy);

        HumanFactory humanFactory = new HumanFactory(copy);
        Human newHuman = humanFactory.makeCopy();
        System.out.println(newHuman);

    }
}

interface Copyable{
    Object copy();
}
class Human implements Copyable{
    int age;
    String name;

    Human(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public Object copy() {
        Human copy = new Human(age, name);
        return copy;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class  HumanFactory{
    Human human;

    HumanFactory(Human human){
        setPrototype(human);
    }
    public void setPrototype(Human human){
        this.human =human;
    }

    Human makeCopy(){
        return (Human) human.copy();
    }
}