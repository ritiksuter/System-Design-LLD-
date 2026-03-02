interface Renderer {
    void renderCircle(double radius);

    void renderRectangle(double width, double height);
}

class RasterRenderer implements Renderer {
    @Override
    public void renderCircle(double radius) {
        System.out.println("Raster Rendering: Drawing Circle with radius " + radius);
    }

    @Override
    public void renderRectangle(double width, double height) {
        System.out.println("Raster Rendering: Drawing Rectangle with width " + width + " and height " + height);
    }
}

class VectorRenderer implements Renderer {
    @Override
    public void renderCircle(double radius) {
        System.out.println("Vector Rendering: Drawing Circle with radius " + radius);
    }

    @Override
    public void renderRectangle(double width, double height) {
        System.out.println("Vector Rendering: Drawing Rectangle with width " + width + " and height " + height);
    }
}

abstract class Shape {
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
}

class Circle extends Shape {
    private double radius;

    public Circle(Renderer renderer, double radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(Renderer renderer, double width, double height) {
        super(renderer);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        renderer.renderRectangle(width, height);
    }
}

public class BridgeDesign {
    public static void main(String[] args) {
        Renderer rasterRenderer = new RasterRenderer();
        Renderer vectorRenderer = new VectorRenderer();
        Shape rasterCircle = new Circle(rasterRenderer, 5);
        Shape vectorCircle = new Circle(vectorRenderer, 5);
        rasterCircle.draw();
        vectorCircle.draw();
    }
}