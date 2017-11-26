package Task5___17_11_2017;

import Task5___17_11_2017.model.Present;
import Task5___17_11_2017.model.candies.Candy;
import Task5___17_11_2017.model.candies.factory.RandomCandyFactory;

import java.util.ArrayList;
import java.util.List;

public class TaskDemonstrating {
    public static void main(String[] args) {
        // create candy objects
        System.out.println("!!! Creating 4 random candies !!!");
        RandomCandyFactory candyFactory = new RandomCandyFactory();
        ArrayList<Candy> candyList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Candy candy = candyFactory.getElement();
            System.out.println(candy);
            System.out.println();
            candyList.add(candy);
        }

        printDelimiter();

        // make a present with random candies
        System.out.println("!!! Making a present with random candies !!!");
        Present randomPresent = new Present();
        System.out.println(randomPresent);

        printDelimiter();

        // make present from existing candies
        System.out.println("!!! Making a present with existing 4 candies !!!");
        Present determinedPresent = new Present(candyList);
        System.out.println(determinedPresent);

        printDelimiter();

        determinedPresent.sortByWeight(true);
        System.out.println("After ascending sort by weight");
        System.out.println(determinedPresent);

        printDelimiter();

        determinedPresent.sortBySugarWeight(false);
        System.out.println("After descending sort by sugarWeight");
        System.out.println(determinedPresent);

        printDelimiter();

        System.out.print("Find candies with special range of sugarWeight ( ");
        demonstrateRangeFinding(determinedPresent);

    }

    public static void demonstrateRangeFinding(Present present) {
        double from = present.getCandyList().get(0).getSugarWeight() - 0.05;
        double to = present.getCandyList().get(0).getSugarWeight() + 0.05;

        List<Candy> list = present.getCandiesWithSpecialRangeOfSugarWeight(from, to);
        System.out.println("from: " + from + ", to: " + to + " ) :::");

        for (Candy candy : list) {
            System.out.println(candy);
        }

    }

    private static void printDelimiter() {
        System.out.println();
        System.out.println("//////////////////////////////////////////");
        System.out.println();
    }
}
