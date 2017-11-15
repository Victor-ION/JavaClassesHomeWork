package Task3___14_11_2017.shapes;

public class ColorPoint extends Point implements Colorable {
    private int color;

    public ColorPoint(int x, int y, int color) {
        super(x, y);
        this.color = color;
    }
    public ColorPoint(ColorPoint p){
        super(p);
        color = p.getColor();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ColorPoint that = (ColorPoint) o;

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
        return "ColorPoint{" +
                "color=" + color +
                ", x=" + getX() +
                ", y=" + getY() +
                '}';
    }
}
