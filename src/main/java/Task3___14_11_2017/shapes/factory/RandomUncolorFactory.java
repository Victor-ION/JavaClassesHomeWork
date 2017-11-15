package Task3___14_11_2017.shapes.factory;

import Task2___07_11_2017.RandomFieldGenerator;
import Task3___14_11_2017.shapes.Shape;

public class RandomUncolorFactory extends AbstractFactory{
    @Override
    public Shape createShape() {
        int i = RandomFieldGenerator.getInt(0, 4);
        switch (i){
            case 0: return SimpleGenerator.createPoint();
            case 1: return SimpleGenerator.createLine();
            case 2: return SimpleGenerator.createTriangle();
            case 3: return SimpleGenerator.createPolygon();
        }
        return null;

    }




}
