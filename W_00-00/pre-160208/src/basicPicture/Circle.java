package basicPicture;

public class Circle extends Geometric {

	private double radius;

	public Circle(PicPoint base, double radius) {
		super(base);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	

		
}






