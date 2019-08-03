import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Shape sq1 = new Square();
        Shape c1 = new Circle();
        Shape t1 = new Triangle();
        Shape sq2 = new Square();
        Shape c2 = new Circle();
        Shape t2 = new Triangle();

        Composite composite1 = new Composite();
        Composite composite2 = new Composite();
        Composite composite = new Composite();
        composite1.addComponert(sq1);
        composite1.addComponert(sq2);
        composite1.addComponert(c1);

        composite2.addComponert(t1);
        composite2.addComponert(c2);

        composite.addComponert(t2);
        composite.addComponert(composite1);
        composite.addComponert(composite2);

        composite.draw();
        }
    }


interface Shape {
    void draw();
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("square");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("circle");
    }
}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("triangle");
    }
}

class Composite implements Shape {
    private List<Shape> components = new ArrayList<>();

    public void addComponert(Shape component) {
        components.add(component);
    }

    public void removeComponent(Shape component) {
        components.remove(component);
    }

    @Override
    public void draw() {
        for (Shape component : components)
            component.draw();
    }
}