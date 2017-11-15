package Task3___14_11_2017.shapes;

public class ColorTriangle extends Triangle implements Colorable {
    private int color;

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

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
