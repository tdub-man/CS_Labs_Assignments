package basicPicture;

import java.util.Comparator;

/**
 * Geometric is for organizational purposes.
 * We don't intend to create any 'Geometric' objects
 * directly.  
 * We will only create objects of subclasses.
 * 
 * We make Geometric an 'abstract class' to signal
 * to Java our intentions.
 * 
 * @author Ben Setzer
 *
 */
public abstract class Geometric extends Picture implements Comparable<Geometric>{

	public Geometric(PicPoint base) {
		super(base);
	}

	public abstract double getArea();



	@Override
	public int compareTo(Geometric o) {
		return (int)Math.signum(this.getArea() - o.getArea());
	}
}
