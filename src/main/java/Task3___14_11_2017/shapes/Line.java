package Task3___14_11_2017.shapes;

public class Line implements Cloneable, Shape{
    private Point begin;
    private Point end;
    private Double length;

    public Line(Point begin, Point end) {
        if (begin == null || end == null) throw new IllegalArgumentException();
        this.begin = begin;
        this.end = end;

    }

    public Line(int x1, int y1, int x2, int y2) {
        this.begin = new Point(x1, y1);
        this.end = new Point(x2, y2);
//        if (this.begin.equals(this.end)) throw new IllegalArgumentException("points are the same");
    }

    /**
     * calculate length of the line
     * @return return length via double representation
     */
    public double getLength(){
        if (length == null){
            int l1 = begin.getX() - end.getX();
            int l2 = begin.getY() - end.getY();
            length = Math.sqrt(Math.pow(l1, 2) + Math.pow(l2, 2));
        }
        return length;
    }




    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Line((Point)begin.clone(), (Point)end.clone());
    }

    @Override
    public String toString() {
        return "Line{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (begin != null ? !begin.equals(line.begin) : line.begin != null) return false;
        return end != null ? end.equals(line.end) : line.end == null;
    }

    @Override
    public int hashCode() {
        int result = begin != null ? begin.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }

    public Point getBegin() {
        return begin;
    }

    public void setBegin(Point begin) {
        if (begin == null) throw new IllegalArgumentException();
        this.begin = begin;
        length = null;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        if (end == null) throw new IllegalArgumentException();

        this.end = end;
        length = null;
    }
}
