package Task3___14_11_2017.shapes;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ColorTriangle extends Triangle implements Colorable {
    private int color;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeObject(getColor());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        color = (int) in.readObject();
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    public ColorTriangle(){}

    public ColorTriangle(Point apexA, Point apexB, Point apexC, int color) {
        super(apexA, apexB, apexC);
        this.color = color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new ColorTriangle((Point) getApexA().clone(), (Point) getApexB().clone(), (Point) getApexC().clone(), color);
    }

    @Override
    public String toString() {
        return "ColorTriangle{" +
                "color=" + color +
                ", apexA=" + getApexA() +
                ", apexB=" + getApexB() +
                ", apexC=" + getApexC() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ColorTriangle that = (ColorTriangle) o;

        return color == that.color;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + color;
        return result;
    }
}
