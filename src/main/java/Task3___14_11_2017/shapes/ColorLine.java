package Task3___14_11_2017.shapes;

public class ColorLine extends Line implements Colorable{
    private int color;

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        if (color<0) throw new IllegalArgumentException("color is negative");

        this.color = color;
    }

    public ColorLine(Point begin, Point end, int color) {
        super(begin, end);
        this.setColor(color);
    }

    public ColorLine(int x1, int y1, int x2, int y2, int color) {
        super(x1, y1, x2, y2);
        this.color = color;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new ColorLine((Point) getBegin().clone(), (Point) getEnd().clone(), color);
    }

    @Override
    public String toString() {
        return "ColorLine{" +
                "color=" + color +
                ", begin=" + getBegin() +
                ", end=" + getEnd() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ColorLine colorLine = (ColorLine) o;

        return color == colorLine.color;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + color;
        return result;
    }
}
