package Task5___17_11_2017.model;

import Task5___17_11_2017.model.candies.Candy;
import Task5___17_11_2017.model.candies.factory.RandomCandyFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Present {
    private ArrayList<Candy> candyList = new ArrayList<>();
    private Double weight;
    private Double sugarWeight;

    /**
     * sort candies by weight
     *
     * @param isAscending if true - sort in ascending order, if false - in descending
     */
    public void sortByWeight(boolean isAscending) {
        Collections.sort(candyList, new Comparator<Candy>() {
            @Override
            public int compare(Candy o1, Candy o2) {
                if (isAscending) {
                    double def = o1.getWeight() - o2.getWeight();
                    if (def == 0) return 0;
                    return (def) > 0 ? 1 : -1;
                } else {
                    double def = o1.getWeight() - o2.getWeight();
                    if (def == 0) return 0;
                    return (def) > 0 ? -1 : 1;
                }
            }
        });
    }

    /**
     * sort candies by SugarWeight
     *
     * @param isAscending if true - sort in ascending order, if false - in descending
     */
    public void sortBySugarWeight(boolean isAscending) {
        Collections.sort(candyList,
                (o1, o2) -> {
                    if (isAscending) {
                        double def = o1.getSugarWeight() - o2.getSugarWeight();
                        if (def == 0) return 0;
                        return (def) > 0 ? 1 : -1;
                    } else {
                        double def = o1.getSugarWeight() - o2.getSugarWeight();
                        if (def == 0) return 0;
                        return (def) > 0 ? -1 : 1;
                    }
                });
    }

    /**
     * finds all candies that has SugarContent value in the determined range
     *
     * @param from lower limit (including)
     * @param to   upper limit (including)
     * @return
     */
    public List<Candy> getCandiesWithSpecialRangeOfSugarWeight(double from, double to) {
        ArrayList<Candy> list = new ArrayList<>();
        for (Candy candy : candyList) {
            if (candy.getSugarWeight() >= from && candy.getSugarWeight() <= to) {
                list.add(candy);
            }
        }
        return list;
    }


    public Present(ArrayList<Candy> candyList) {
        this.candyList = candyList;
    }

    public Present() {
        this(((int) (Math.random() * 5)) + 1);

    }

    public Present(int candyAmount) {
        RandomCandyFactory factory = new RandomCandyFactory();
        for (int i = 0; i < candyAmount; i++) {
            addCandy(factory.getElement());
        }
    }


    public Present addCandy(Candy candy) {
        candyList.add(candy);
        return this;
    }

    public Present addCandies(List<Candy> list) {
        if (list == null || list.size() == 0) throw new IllegalArgumentException("incorrect list");
        for (Candy c : list) {
            addCandy(c);
        }
        return this;
    }

    public Present removeCandy(Candy candy) {
        if (!candyList.contains(candy)) throw new IllegalArgumentException("No such candy in present!");
        candyList.remove(candy);
        return this;
    }


    public ArrayList<Candy> getCandyList() {
        return candyList;
    }

    public void setCandyList(ArrayList<Candy> candyList) {
        this.candyList = candyList;
    }


    public Double getWeight() {
        if (weight == null) {
            weight = calculateWeight();
        }
        return weight;
    }

    private Double calculateWeight() {
        double res = 0;
        for (Candy candy : candyList) {
            res += candy.getWeight();
        }
        return res;
    }


    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getSugarWeight() {
        if (sugarWeight == null) {
            sugarWeight = calculateSugarWeight();
        }
        return sugarWeight;
    }

    private Double calculateSugarWeight() {
        double res = 0;
        for (Candy candy : candyList) {
            res += candy.getSugarWeight();
        }
        return res;
    }

    public void setSugarWeight(Double sugarWeight) {
        this.sugarWeight = sugarWeight;
    }

    public void changed() {
        setWeight(null);
        setSugarWeight(null);
    }

    @Override
    public String toString() {
        return "Present{\n"
                + stringList(candyList) +
                "weight=" + getWeight() +
                ", sugarWeight=" + getSugarWeight() +
                '}';
    }

    public String stringList(List<Candy> candyList) {
        StringBuilder sb = new StringBuilder("Candies : [[[\n");
        for (Candy candy : candyList) {
            sb.append("\t" + candy + "\n\n");
        }
        sb.append("\t]]] \n");
        return sb.toString();
    }

}
