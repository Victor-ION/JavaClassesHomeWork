package Task2___07_11_2017;

import Task2___07_11_2017.model.*;
import Task2___07_11_2017.model.Ables.Flyable;
import Task2___07_11_2017.model.Ables.Moveable;
import Task2___07_11_2017.model.Ables.Swimable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    /**
     * Написать программу, создающую список обьектов этих классов в динамической памяти.
     * Программа должна содержать меню, позволяющее осуществить проверку всех методов классов.
     *
     * @param args
     */
    public static void main(String[] args) {
        AbstractCVehicleFactory factory = new RandomCVehicleFactory();

        List<CVehicle> vehicleList = new ArrayList<>(50);
        for (int i = 0; i < 50; i++) {
            vehicleList.add(factory.createCVehicle());
        }

        console(vehicleList);


    }

    public static void console(List<CVehicle> list) {
        while (true) {
            System.out.println("Menu:\n" +
                    "1 - механизмы с наименьшей ценой с наибольшей скоростью и не старше 5 лет\n" +
                    "2 - найти из механизмов Plane c с высотой полета выше 5000 с годом выпуска после 2000\n" +
                    "3 - найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane\n" +
                    "4 - создать 3 масива сгупированых по Интерфейсам Flyable, MoveAble, SwimAble (и вывести их в консоль)\n" +
                    "5 - step in vehicle's array\n" +
                    "6 - add new vehicle to array\n" +
                    "7 - exit\n" +
                    "Enter number of action: ");

            try {
                int i = ConsoleHelper.readInt();
                if (i < 1 || i > 7) throw new Exception();
                if (i == 7) break;
                doAction(i, list);
                System.out.println();

            } catch (Exception e) {
                System.out.println("Incorrect! Try again!\n");
            }
        }
    }

    private static void doAction(int i, List<CVehicle> list) {
        switch (i) {
            case 1: {
                solution1(list);
                break;
            }
            case 2: {
                solution2(list);
                break;
            }
            case 3: {
                solution3(list);
                break;
            }
            case 4: {
                solution4(list);
                break;
            }
            case 5: {
                solution5(list);
                break;
            }
            case 6: {
                solution6(list);
                break;
            }
        }
    }

    /**
     * 1 - механизмы с наименьшей ценой с наибольшей скоростью и не старше 5 лет
     * <p>
     * NOTE: find any vehicle not older than 5 years, with the lowest price,
     * then if prices are equal - choose vehicle with the biggest velocity,
     * if there are a few vehicles, add them all to the list.
     * After all, print resulting list
     */
    public static void solution1(List<CVehicle> list) {
        List<CVehicle> res = new ArrayList<>();
        CVehicle currentRes = null;
        for (int i = 0; i < list.size(); i++) {
            CVehicle vehicle = list.get(i);
            if (vehicle.getYearOfIssue() < LocalDate.now().getYear() - 5) continue;

            if (currentRes == null) {
                currentRes = vehicle;
                res.add(vehicle);
                continue;
            }
            if (Math.round(vehicle.getPrice()) < Math.round(currentRes.getPrice())) {
                currentRes = vehicle;
                res.clear();
                res.add(vehicle);
                continue;
            }
            if (Math.round(vehicle.getPrice()) == Math.round(currentRes.getPrice())) {
                if (Math.round(vehicle.getVelocity()) > Math.round(currentRes.getVelocity())) {
                    currentRes = vehicle;
                    res.clear();
                    res.add(vehicle);
                } else if (Math.round(vehicle.getVelocity()) == Math.round(currentRes.getVelocity())) {
                    res.add(vehicle);
                }

            }
        }

        if (res.isEmpty()) System.out.println("no vehicle that is not older than 5 years");
        else {
            System.out.println("механизмы с наименьшей ценой с наибольшей скоростью и не старше 5 лет:");
            for (CVehicle vehicle : res) System.out.println(vehicle);
        }
    }

    /**
     * 2 - найти из механизмов Plane c с высотой полета выше 5000 с годом выпуска после 2000
     */
    public static void solution2(List<CVehicle> list) {
        List<CVehicle> res = new ArrayList<>();
        for (CVehicle vehicle : list) {
            if (vehicle instanceof CPlane) {
                CPlane plane = (CPlane) vehicle;
                if (plane.getHeight() > 5000 && plane.getYearOfIssue() > 2000) {
                    res.add(vehicle);
                }
            }
        }
        if (res.isEmpty()) System.out.println("no such vehicle");
        else {
            System.out.println("Plane c с высотой полета выше 5000 с годом выпуска после 2000:");
            for (CVehicle vehicle : res) System.out.println(vehicle);
        }
    }


    /**
     * 3 - найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane
     */
    public static void solution3(List<CVehicle> list) {
        List<CVehicle> res = new ArrayList<>();
        for (CVehicle vehicle : list) {
            if (!(vehicle instanceof CPlane)) {
                if (vehicle.getVelocity() >= 200 && vehicle.getVelocity() <= 500) {
                    res.add(vehicle);
                }
            }
        }
        if (res.isEmpty()) System.out.println("no such vehicle");
        else {
            System.out.println("механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane:");
            for (CVehicle vehicle : res) System.out.println(vehicle);
        }
    }

    /**
     * 4 - создать 3 масива сгупированых по Интерфейсам Flyable, MoveAble, SwimAble (и вывести их в консоль)
     */
    public static void solution4(List<CVehicle> list) {
        List<Moveable> moveables = new ArrayList<>();
        List<Flyable> flyables = new ArrayList<>();
        List<Swimable> swimables = new ArrayList<>();
        for (CVehicle vehicle : list) {
            if (vehicle instanceof Moveable) {
                moveables.add((Moveable) vehicle);
            }
            if (vehicle instanceof Flyable) {
                flyables.add((Flyable) vehicle);
            }
            if (vehicle instanceof Swimable) {
                swimables.add((Swimable) vehicle);
            }
        }

        System.out.println("Moveables:\n");
        for (Moveable moveable : moveables) {
            System.out.println(moveable);
        }
        System.out.println();
        System.out.println("Flyables:\n");
        for (Flyable flyable : flyables) {
            System.out.println(flyable);
        }
        System.out.println();
        System.out.println("Swimables:\n");
        for (Swimable swimable : swimables) {
            System.out.println(swimable);
        }

    }

    /**
     * 5 - to enter vehicle's array
     */
    public static void solution5(List<CVehicle> list) {
        while (true) {
            System.out.println("There are " + list.size() + " vehicles in list");
            System.out.println("Enter the index for element you want to see/change");
            try {
                int i = ConsoleHelper.readInt();
                if (i < 0 || i >= list.size()) throw new Exception();
                CVehicle vehicle = list.get(i);
                System.out.println("You choose: " + vehicle.toString());
                break;

            } catch (Exception e) {
                System.out.println("incorrect input! try again!");
            }
        }
    }

    /**
     * 6 - add new vehicle to array
     */
    public static void solution6(List<CVehicle> list) {
        System.out.println("Creating new vehicle...");
        System.out.println("1 - CCar\n" +
                "2 - CPlane\n" +
                "3 - CShip\n" +
                "Enter number of type you want to create: ");
        try {
            int i = ConsoleHelper.readInt();
            CVehicle vehicle = null;
            switch (i) {
                case 1:
                    vehicle = new CCar();
                    break;
                case 2:
                    vehicle = new CPlane();
                    break;
                case 3:
                    vehicle = new CShip();
                    break;
            }
            if (vehicle != null) {
                list.add(vehicle);
                System.out.println("Successfully added: " + vehicle.toString());
            }
        } catch (Exception e) {
            System.out.println("Smth is wrong! Exciting ...");
        }
    }


}
