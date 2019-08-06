public class VisitorApp {
    public static void main(String[] args) {
        Visitor hooligan = new HooliganVisitor();
        Visitor mechanic = new MechanicVisitor();


        Element body = new BodyElement();
        body.accept(hooligan);
        body.accept(mechanic);
    }
}

interface Visitor{
    void visit(EngineElement engineElement);
    void visit(BodyElement bodyElement);
}


interface Element{
    void accept(Visitor visitor);
}

class BodyElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class EngineElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor{
    @Override
    public void visit(EngineElement engineElement) {
        System.out.println("hooligan with engine");
    }

    @Override
    public void visit(BodyElement bodyElement) {
        System.out.println("hooligan with body");
    }
}
class MechanicVisitor implements Visitor{
    @Override
    public void visit(EngineElement engineElement) {
        System.out.println("mechanic with engine");
    }

    @Override
    public void visit(BodyElement bodyElement) {
        System.out.println("mechanic with body");
    }
}