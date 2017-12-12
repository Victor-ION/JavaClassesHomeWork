package Task3___14_11_2017.shapes;

import java.io.*;

public class Triangle implements Cloneable, Shape, Externalizable{
    private Point apexA;
    private Point apexB;
    private Point apexC;
    private Line sideAB;
    private Line sideAC;
    private Line sideBC;
    private Double area;
    private Boolean correct;
    private Double perimeter;


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getApexA());
        out.writeObject(getApexB());
        out.writeObject(getApexC());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        apexA = (Point) in.readObject();
        apexB = (Point) in.readObject();
        apexC = (Point) in.readObject();
    }

    public Triangle(){}

    public Triangle(Point apexA, Point apexB, Point apexC) {
        this.apexA = apexA;
        this.apexB = apexB;
        this.apexC = apexC;
    }


    /**
     * calculate area (square) of triangle by Heron formula
     * @return area via double  representation
     */
    public double getArea(){
        if (area == null){
            double p = (getSideAB().getLength() + getSideAC().getLength() + getSideBC().getLength())/2.0;
            area = Math.sqrt( p*(p- getSideAB().getLength())*(p- getSideBC().getLength())*(p- getSideAC().getLength()) );
        }
        return area;
    }

    /**
     * check if triangle is correct (if apexA/B/C isn't at one line (approximately!) )
     * @return true in case triangle is correct
     */
    public boolean isCorrect(){
        if (correct != null) return correct;
        double mod1 = Math.abs(getSideAB().getLength()+ getSideAC().getLength()- getSideBC().getLength());
        double mod2 = Math.abs(getSideAB().getLength()+ getSideBC().getLength()- getSideAC().getLength());
        double mod3 = Math.abs(getSideBC().getLength()+ getSideAC().getLength()- getSideAB().getLength());

        if (mod1<0.001 || mod2 < 0.001 || mod3 < 0.001){
            correct = false;
        }
        else correct = true;
        return correct;
    }

    public double getPerimeter(){
        if (perimeter == null){
            perimeter = getSideAB().getLength() + getSideBC().getLength() + getSideAC().getLength();
        }
        return perimeter;
    }

    public Line getSideAB() {
        if (sideAB == null){
            sideAB = new Line(apexA, apexB);
        }
        return sideAB;
    }

    public Line getSideAC() {
        if (sideAC == null){
            sideAC = new Line(apexA, apexC);
        }
        return sideAC;
    }

    public Line getSideBC() {
        if (sideBC == null){
            sideBC = new Line(apexB, apexC);
        }
        return sideBC;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Triangle((Point) apexA.clone(), (Point) apexB.clone(), (Point) apexC.clone());
    }

    public Point getApexA() {

        return apexA;
    }

    public void setApexA(Point apexA) {
        this.apexA = apexA;
        sideAB = null;
        sideAC = null;
        perimeter = null;
        area = null;
        correct = null;
    }

    public Point getApexB() {
        return apexB;
    }

    public void setApexB(Point apexB) {
        this.apexB = apexB;
        sideAB = null;
        sideBC = null;
        perimeter = null;
        area = null;
        correct = null;
    }

    public Point getApexC() {
        return apexC;
    }

    public void setApexC(Point apexC) {
        this.apexC = apexC;
        sideBC = null;
        sideAC = null;
        perimeter = null;
        area = null;
        correct = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (apexA != null ? !apexA.equals(triangle.apexA) : triangle.apexA != null) return false;
        if (apexB != null ? !apexB.equals(triangle.apexB) : triangle.apexB != null) return false;
        return apexC != null ? apexC.equals(triangle.apexC) : triangle.apexC == null;
    }

    @Override
    public int hashCode() {
        int result = apexA != null ? apexA.hashCode() : 0;
        result = 31 * result + (apexB != null ? apexB.hashCode() : 0);
        result = 31 * result + (apexC != null ? apexC.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "apexA=" + apexA +
                ", apexB=" + apexB +
                ", apexC=" + apexC +
                '}';
    }


}
