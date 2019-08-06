public class TemplateMethodApp {
    public static void main(String[] args) {

        C a = new A();
        a.templateMethod();

        C b = new B();
        b.templateMethod();
    }
}


abstract class C {
    void templateMethod() {
        System.out.println("1");
        System.out.println("2");
        differ();
    }

    abstract void differ();
}

class A extends C {
    @Override
    void differ() {
        System.out.println("5");
    }

}

class B extends C {
    @Override
    void differ() {
        System.out.println("6");
    }
}
/*
class A{
    void method(){
        System.out.println("1");
        System.out.println("2");
        System.out.println("5");
    }
}
class B{
    void method(){
        System.out.println("1");
        System.out.println("2");
        System.out.println("6");
    }
}*/
