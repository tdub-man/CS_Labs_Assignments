package basicPicture;

public class PicPoint {
	private double x, y;
    
    public PicPoint(double x, double y){
        this.x = x;
        this.y = y;
    }

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double distance(PicPoint other) {
		return Math.hypot(x-other.x, y-other.y);
	}
	
}








