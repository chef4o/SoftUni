package encapsulationsEx.classBox;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
    }

    private void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    private void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea () {
        return (2 * this.length * this.width) +
                (2 * this.length * this.height) +
                (2 * this.width * this.height);
    }

    public double calculateLateralSurfaceArea () {
        return (2 * this.length * this. height) +
                (2 * this.width * this.height);
    }

    public double calculateVolume () {
        return this.length * this.width * this.height;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Surface Area - ")
                .append(String.format("%.2f", calculateSurfaceArea()))
                .append(System.lineSeparator());
        output.append("Lateral Surface Area - ")
                .append(String.format("%.2f", calculateLateralSurfaceArea()))
                .append(System.lineSeparator());
        output.append("Volume - ")
                .append(String.format("%.2f", calculateVolume()))
                .append(System.lineSeparator());
        return output.toString();
    }
}
