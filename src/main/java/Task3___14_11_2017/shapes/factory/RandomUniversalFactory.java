package Task3___14_11_2017.shapes.factory;

import Task2___07_11_2017.RandomFieldGenerator;
import Task3___14_11_2017.shapes.Shape;

public class RandomUniversalFactory extends AbstractFactory{
    private RandomUncolorFactory uncolorFactory = new RandomUncolorFactory();
    private RandomColorFactory colorFactory = new RandomColorFactory();

    @Override
    public Shape createShape() {
        int i = RandomFieldGenerator.getInt(0, 2);
        switch (i){
            case 0: return uncolorFactory.createShape();
            case 1: return colorFactory.createShape();

        }
        return null;
    }
}
