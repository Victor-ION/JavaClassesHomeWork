package Task3___14_11_2017;

import Task3___14_11_2017.shapes.Line;
import Task3___14_11_2017.shapes.Point;
import Task3___14_11_2017.shapes.Shape;
import Task3___14_11_2017.shapes.Triangle;
import Task3___14_11_2017.shapes.factory.SimpleGenerator;

import java.io.*;
import java.util.ArrayList;

public class SerializationDemo {

    
    public static void main(String[] args) throws Exception{

        ArrayList<Shape> list = new ArrayList<>();
        Point p1 = SimpleGenerator.createPoint();
        Point p2 = SimpleGenerator.createPoint();
        Point p3 = SimpleGenerator.createPoint();
        Point p4 = SimpleGenerator.createPoint();

        Triangle triangle1 = new Triangle(p1, p2, p3);
        Triangle triangle2 = new Triangle(p1, p2, p4);
        Line line = new Line(p1, p2);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);

        out.writeObject(p1);
        out.writeObject(p2);
        out.writeObject(p3);
        out.writeObject(p4);
        out.writeObject(triangle1);
        out.writeObject(triangle2);
        out.writeObject(line);


        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Point p1copy = (Point) in.readObject();
        Point p2copy = (Point) in.readObject();
        Point p3copy = (Point) in.readObject();
        Point p4copy = (Point) in.readObject();
        Triangle triangle1copy = (Triangle) in.readObject();
        Triangle triangle2copy = (Triangle) in.readObject();

        System.out.println(triangle1.getApexA() == triangle2.getApexA());
        System.out.println(triangle1.getApexB() == triangle2.getApexB());
        System.out.println(triangle1.getApexC() == triangle2.getApexC());
    }
}
