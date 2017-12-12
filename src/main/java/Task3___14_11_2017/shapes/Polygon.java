package Task3___14_11_2017.shapes;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Polygon implements Cloneable, Shape, Externalizable{
    private Point[] apexes;
    private Double perimeter;


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(getApexes());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        apexes  = (Point[]) in.readObject();

    }

    public Polygon(){}

    public Polygon(Point... apexes) {
        if (apexes == null || apexes.length == 0) throw new IllegalArgumentException("empty parameter");
        this.apexes = apexes;
    }
    public Polygon(List<? extends Point> list){
        if (list== null || list.size() ==0) throw new IllegalArgumentException("empty parameter");
        apexes = new Point[list.size()];
        for (int i  = 0; i < list.size(); i++){
            apexes[i] = list.get(i);
        }
    }

    /**
     * return side of the polygon with special number
     * @param ordinal number of the side (e.g. 0 - side between apexes[0] and apexes[1])
     * @return Line that represents side
     */
    public Line getSide(int ordinal){
        if (ordinal == apexes.length-1) return new Line(apexes[ordinal], apexes[0]);
        return new Line(apexes[ordinal], apexes[ordinal+1]);
    }

    /**
     * calculate Perimeter
     * @return perimeter of the polygon
     */
    public double getPerimeter(){
        if (perimeter == null){
            perimeter = 0.0;
            for (int i = 0; i < apexes.length; i++){
                perimeter += getSide(i).getLength();
            }
        }
        return perimeter;
    }

    public Point[] getApexes() {
        return apexes;
    }

    public void setApexes(Point[] apexes) {
        this.apexes = apexes;
        perimeter = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Polygon polygon = (Polygon) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(apexes, polygon.apexes);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(apexes);
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "apexes=" + Arrays.deepToString(apexes) +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Point[] apexes2 = new Point[apexes.length];
        for (int i = 0; i < apexes.length; i++){
            apexes2[i] = (Point) apexes[i].clone();
        }

        return new Polygon(apexes2);
    }
}
