package Task3___14_11_2017.shapes.factory;

import Task2___07_11_2017.RandomFieldGenerator;
import Task3___14_11_2017.shapes.*;

public class SimpleGenerator {

    public static Point createPoint(){
        return new Point(RandomFieldGenerator.getInt(-100, 100), RandomFieldGenerator.getInt(-100, 100));
    }
    public static ColorPoint createColorPoint(){
        return new ColorPoint(RandomFieldGenerator.getInt(-100, 100), RandomFieldGenerator.getInt(-100, 100), RandomFieldGenerator.getInt(0,256));
    }
    public static Line createLine(){
        return new Line(createPoint(), createPoint());
    }
    public static ColorLine createColorLine(){
        return new ColorLine(createPoint(), createPoint(), RandomFieldGenerator.getInt(0, 256));
    }
    public static Triangle createTriangle(){
        return new Triangle(createPoint(), createPoint(), createPoint());
    }
    public static ColorTriangle createColorTriangle(){
        return new ColorTriangle(createPoint(), createPoint(), createPoint(), RandomFieldGenerator.getInt(0,256));
    }
    public static Polygon createPolygon(){
        int number = RandomFieldGenerator.getInt(3, 6);
        Point[] arr = new Point[number];
        for (int i = 0; i < number; i++){
            arr[i] = createPoint();
        }
        return new Polygon(arr);
    }


    public static ColorPolygon createColorPolygon(){
        int number = RandomFieldGenerator.getInt(3, 6);
        Point[] arr = new Point[number];
        for (int i = 0; i < number; i++){
            arr[i] = createPoint();
        }
        return new ColorPolygon(RandomFieldGenerator.getInt(0, 256), arr);
    }
}
