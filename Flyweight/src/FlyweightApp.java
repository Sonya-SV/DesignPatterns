import java.util.*;

public class FlyweightApp {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        List<Shape> shapeList = new ArrayList<>();

        shapeList.add(shapeFactory.getShape("square"));
        shapeList.add(shapeFactory.getShape("circle"));
        shapeList.add(shapeFactory.getShape("point"));
        shapeList.add(shapeFactory.getShape("point"));
        shapeList.add(shapeFactory.getShape("square"));

        Random rand = new Random();
        for(Shape shape : shapeList){
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            shape.draw(x,y);
        }
    }
}

interface Shape{
    void draw(int x, int y);
}
class Point implements Shape{  //flyweight
    @Override
    public void draw(int x, int y) {
        System.out.println("draw point "+ "(" + x + ", " + y + ")");
    }
}

class Circle implements Shape{ //flyweight
    int r =5;
    @Override
    public void draw(int x, int y) {
        System.out.println("draw circle "+ "(" + x + ", " + y + ") with radius: " + r );
    }
}

class Square implements Shape{ //flyweight
    int a =10;
    @Override
    public void draw(int x, int y) {
        System.out.println("draw square "+ "(" + x + ", " + y + ") with side: " + a );
    }
}

class ShapeFactory{
    private static final Map<String, Shape> shapes = new HashMap<>();
    public Shape getShape(String nameShape){
        Shape shape = shapes.get(nameShape);
        if(shape == null){
            switch(nameShape){
                case "circle":
                    shape = new Circle();
                    System.out.println("create circle");
                    break;
                case "point":
                    shape = new Point();
                    System.out.println("create point");
                    break;
                case "square":
                    shape = new Square();
                    System.out.println("create square");
                    break;
            }
            shapes.put(nameShape, shape);
        }

        return shape;
    }
}