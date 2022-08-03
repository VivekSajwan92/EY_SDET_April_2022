package decorator;

public abstract class ShapeDecorator implements Shape{


    // aggregation - proxy layer
    public Shape shapeDecorator;

    public ShapeDecorator(Shape shapeDecorator){
        this.shapeDecorator=shapeDecorator;
    }
}
