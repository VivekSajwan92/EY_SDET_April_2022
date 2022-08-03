package decorator;

public class RedDecoratorShape extends ShapeDecorator{


    public RedDecoratorShape(Shape shapeDecorator) {
        super(shapeDecorator);
    }

    @Override
    public void draw() {
        shapeDecorator.draw(); // what kind of shape it is
        // introduce new behavior
        decorate();

    }

    public void decorate(){
        System.out.println("This is Red line bordered");
    }
}
