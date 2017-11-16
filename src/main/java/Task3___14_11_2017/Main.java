package Task3___14_11_2017;

import Task3___14_11_2017.shapes.*;
import Task3___14_11_2017.shapes.factory.RandomUniversalFactory;

import java.util.*;

public class Main {
    /**
     * 1. создать последовательность из фигур  используя фабрики цветных и нецветных фигур
     *    (and print them!)
     * 2. получить масивы цветных и не цветных и сколько каждых фигур в нем присутсвует
     *
     * 3. групируем в масивах фигуры
     */
    public static void main(String[] args) throws Exception {
//        printDiffAbilities();

        List<Shape> list = createRandomList();

        System.out.println("\n Color: ");
        Shape[] color = getColorShapes(list);
        System.out.println(Arrays.deepToString(color));

        System.out.println("\n Uncolor: ");
        Shape[] uncolor = getUncolorShapes(list);
        System.out.println(Arrays.deepToString(uncolor));

        HashMap<Class<? extends Shape>, List<Shape>> mapColor = groupByType(color);
        System.out.println("\n After grouping Color:");
        for (Map.Entry<Class<? extends Shape>, List<Shape>> pair : mapColor.entrySet()){
            System.out.println(pair.getKey().getSimpleName() + " --- "+ pair.getValue().size() +"\n");
            for (Shape shape : pair.getValue()){
                System.out.println("\t" + shape);
            }
        }

        HashMap<Class<? extends Shape>, List<Shape>> mapUncolor = groupByType(uncolor);
        System.out.println("\n After grouping Uncolor:");
        for (Map.Entry<Class<? extends Shape>, List<Shape>> pair : mapUncolor.entrySet()){
            System.out.println(pair.getKey().getSimpleName() + " --- "+ pair.getValue().size() +"\n");
            for (Shape shape : pair.getValue()){
                System.out.println("\t" + shape);
            }
        }



    }


    /**
     * 1. создать последовательность из фигур  используя фабрики цветных и нецветных фигур
     *    (and print them!)
     */
    public static List<Shape> createRandomList(){
        RandomUniversalFactory factory = new RandomUniversalFactory();
        ArrayList<Shape> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            Shape shape = factory.createShape();
            System.out.println(shape);
            list.add(shape);
        }

        return list;
    }

    /**
     * 2. получить масив цветных
     */
    public static Shape[] getColorShapes(List<Shape> list){
        List<Shape> res = new ArrayList<>();
        for (Shape shape : list){
            if (shape instanceof Colorable) res.add(shape);
        }
        Shape[] arr = new Shape[res.size()];
        return res.toArray(arr);
    }


    /**
     * 2. получить масив не цветных
     */
    public static Shape[] getUncolorShapes(List<Shape> list){
        List<Shape> res = new ArrayList<>();
        for (Shape shape : list){
            if ( !(shape instanceof Colorable) ) res.add(shape);
        }
        Shape[] arr = new Shape[res.size()];
        return res.toArray(arr);
    }

    /**
     *  3. групируем в масивах фигуры
     *
     * @param arr of Shapes
     * @return map where keys are ShapeType.class and values are List with all shapes of this ShapeType
     */
    public static HashMap<Class<? extends Shape>, List<Shape> > groupByType(Shape[] arr){
        HashMap<Class<? extends Shape>, List<Shape>> map = new HashMap<>();
        if (arr == null || arr.length == 0) return map;
        for (Shape shape : arr){
//            System.out.println("////////////////   "+shape);
            if (map.containsKey(shape.getClass())){
                map.get(shape.getClass()).add(shape);
            } else {
                ArrayList<Shape> list = new ArrayList<>();
                list.add(shape);
                map.put(shape.getClass(), list);
            }
        }
        return map;
    }



    private static void printDiffAbilities() throws CloneNotSupportedException {
        Point p1 = new Point(1,2);
        System.out.println(p1);
        ColorPoint p2 = new ColorPoint(3,4, 100);
        System.out.println(p2);
        ColorPoint pCl = (ColorPoint) p2.clone();
        System.out.println(pCl);
        System.out.println(pCl.getX());
        System.out.println();
        System.out.println();

        ColorPoint pp1 = new ColorPoint(1, 2, 3);
        ColorPoint pp2 = new ColorPoint(pp1);
        System.out.println(pp2);
        pp2.setX(33);
        System.out.println(pp1);
        System.out.println(pp2.getX());

        System.out.println();
        System.out.println();
        Line l1 = new Line(1,1,2,2);
        System.out.println(l1.getLength());
    }
}
