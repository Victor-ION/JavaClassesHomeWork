package Task2___07_11_2017.model;

import Task2___07_11_2017.RandomFieldGenerator;

public class RandomCVehicleFactory extends AbstractCVehicleFactory{
    @Override
    public CVehicle createCVehicle() {
        int i = RandomFieldGenerator.getInt(0, 5);
        switch (i){
            case 0: return new CCar();
            case 1: return new CPlane();
            case 2: return new CShip();
            case 3: return new AmphibiousCar();
            case 4: return new BatCar();
        }
        return null;

    }
}
