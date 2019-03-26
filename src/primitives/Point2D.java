package primitives;

public class Point2D {

	protected Coordinate x;
	protected Coordinate y;
	
// ***************** Constructors ********************** // 
	public Point2D() {
		this.x = new Coordinate();
		this.y = new Coordinate();
	}
	
	public Point2D(Coordinate c1, Coordinate c2) {
		this.x = new Coordinate(c1);
		this.y = new Coordinate(c2);
	}
	
	public Point2D(double n1, double n2) {
		this.x = new Coordinate(n1);
		this.y = new Coordinate(n2);
	}
	
	public Point2D(Point2D other) {
		this.x = new Coordinate(other.x);
		this.y = new Coordinate(other.y);
	}
	
// ***************** Getters/Setters ********************** // 
	
	public Coordinate getX() {
		return x;
	}

	public void setX(Coordinate x) {
		this.x = x;
	}

	public Coordinate getY() {
		return y;
	}

	public void setY(Coordinate y) {
		this.y = y;
	}
	

	// ***************** Administration  ******************** // 

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		return (this.x.equals(other.x) && this.y.equals(other.y));
	}

	// ***************** Operations ******************** // 






}
