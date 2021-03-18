package Day2;

//abstract functionality
interface Shape{
    void draw();
}
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("drawing a circle");
    }
}
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("drawing a square");
    }
}
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("drawing a rectangle");
    }
}
//using facade pattern to hide the above implementation
class ShapeMaker{
    private Shape circle;
    private Shape square;
    private Shape rectangle;
    public ShapeMaker(Shape circle,Shape square,Shape rectangle){
        this.circle=circle;
        this.square=square;
        this.rectangle=rectangle;
    }
    public void drawCircle(){
        circle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
}
public class FacadePatternDemo {
    public static void main(String[] args) {
        //invoking facade
        ShapeMaker obj=new ShapeMaker(new Circle(),new Square(),new Rectangle());
        //drawing shapes
        obj.drawCircle();
        obj.drawSquare();
        obj.drawRectangle();
    }
}
