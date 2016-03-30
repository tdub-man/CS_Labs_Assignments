package basicPicture;

public class Triangle extends Geometric {

	private PicPoint v1, v2;

	public Triangle(PicPoint v0, PicPoint v1, PicPoint v2) {
		super(v0);
		this.v1 = v1;
		this.v2 = v2;
	}

	public PicPoint getV1() {
		return v1;
	}

	public void setV1(PicPoint v1) {
		this.v1 = v1;
	}

	public PicPoint getV2() {
		return v2;
	}

	public void setV2(PicPoint v2) {
		this.v2 = v2;
	}


	@Override
	public double getArea() {
		return Double.NaN;
	}


}
