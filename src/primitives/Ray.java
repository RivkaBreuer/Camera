package primitives;

public class Ray {
	
	private Point3D poo;
	private Vector direction;
	
// ***************** Constructors ********************** // 	
	public Ray() {
		this.poo= new Point3D();
		this.direction = new Vector();
	}
	
	public Ray(Point3D poo, Vector direction) {
		this.poo = new Point3D(poo);
		this.direction = new Vector(direction) ;
	}
	
	public Ray(Ray other) {
		this.poo = new Point3D(other.poo);
		this.direction = new Vector(other.direction) ;
	}


	
// ***************** Getters/Setters ********************** // 

	public Point3D getPoo() {
		return poo;
	}

	public void setPoo(Point3D poo) {
		this.poo = poo;
	}

	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) {
		this.direction = direction;
	}
	
	// ***************** Administration  ******************** // 
	
	@Override
	public boolean equals(Object obj) {
	
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		
		return ( poo.equals(other.poo) && direction.equals(other.direction) );
			
	}

	
	@Override
	public String toString() {
		return  poo.toString()+ " "+ direction.toString();
	}
	
	// ***************** Operations ******************** // 
}
