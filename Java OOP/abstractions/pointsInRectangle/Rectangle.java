package abstractions.pointsInRectangle;

public class Rectangle {

    private int[] bottomLeft;
    private int[] upperRight;

    public Rectangle(int[] bottomLeftPoint, int[] upperRightPoint) {
        this.bottomLeft = bottomLeftPoint;
        this.upperRight = upperRightPoint;
    }

    public boolean contains(Point point) {

        return point.getX() >= this.bottomLeft[0] && point.getX() <= this.upperRight[0]
                && point.getY() >= this.bottomLeft[1] && point.getY() <= this.upperRight[1];
    }

}
