package decorator;

public class DecoratorDemo {

    public static void main(String[] args) {

        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

       /* System.out.println("these are shapes with normal borders\n");
        circle.draw();
        rectangle.draw();*/

        System.out.println("this is a circle with red line as a border");
        RedDecoratorShape redDecoratorShape = new RedDecoratorShape(circle);
        redDecoratorShape.draw();

        System.out.println("this is a rectangle with red line as a border");
        redDecoratorShape = new RedDecoratorShape(rectangle);
        redDecoratorShape.draw();
    }
}
