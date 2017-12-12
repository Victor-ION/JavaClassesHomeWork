package Task3___14_11_2017.shapes;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.List;

public class ColorPolygon extends Polygon implements Colorable{
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public ColorPolygon(){}

    public ColorPolygon(int color, Point... apexes) {
        super(apexes);
        this.color = color;
    }

    public ColorPolygon(List<? extends Point> list, int color) {
        super(list);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ColorPolygon that = (ColorPolygon) o;

        return color == that.color;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + color;
        return result;
    }

    @Override
    public String toString() {
        return "ColorPolygon{" +
                "apexes=" + Arrays.deepToString(getApexes()) +
                "color=" + color +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Polygon p = (Polygon) super.clone();
        return new ColorPolygon(color, p.getApexes());
    }
}
