package primitives;

public class Point3D extends Point2D{

	private Coordinate z;

// ***************** Constructors ********************** // 

		   public Point3D() {
			super();
			this.z = new Coordinate();
		}

		public Point3D(Coordinate c1, Coordinate c2, Coordinate c3) {
			super(c1, c2);
			this.z = new Coordinate(c3);
			
		}

		public Point3D(double n1, double n2, double n3) {
			super(n1, n2);
			this.z = new Coordinate(n3);
		}



		public Point3D(Point3D other) {
			super(other);
			this.z = new Coordinate(other.z);
		}
		
// ***************** Getters/Setters ********************** // 
		
		public Coordinate getZ() {
			return z;
		}

		public void setZ(Coordinate z) {
			this.z = z;
		}

// ***************** Administration  ******************** // 
		

		@Override
		public boolean equals(Object obj) {
		
			if (getClass() != obj.getClass())
				return false;
			Point3D other = (Point3D) obj;
			if (!super.equals(obj))
				return false;
			if (z == null){
				if (other.z != null)
					return false;
			} else if (!z.equals(other.z))
				return false;
			return true;
		}

		

		@Override
		public String toString() {
			return "(" + x + " , " + y + " , " +  z + ")";
		}
		
	
// ***************** Operations ******************** // 
	public Point3D add(Point3D p){
		double x = this.x.getCoordinate() +  p.x.getCoordinate();
		double y = this.y.getCoordinate() +  p.y.getCoordinate();
		double z = this.z.getCoordinate() +  p.z.getCoordinate();

		return new Point3D(x,y,z);
	}
	
	public Point3D substrct(Point3D p){
		double x = this.x.getCoordinate() -  p.x.getCoordinate();
		double y = this.y.getCoordinate() -  p.y.getCoordinate();
		double z = this.z.getCoordinate() -  p.z.getCoordinate();

		return new Point3D(x,y,z);
	}
	
	public double distance(Point3D p1){
		Coordinate x= p1.getX().substrct(this.getX());
		Coordinate y= p1.getY().substrct(this.getY());
		Coordinate z= p1.getZ().substrct(this.getZ());
		
		return (Math.sqrt(Math.pow(x.getCoordinate(), 2) + Math.pow(y.getCoordinate(), 2) + + Math.pow(z.getCoordinate(), 2)));
		
	}
	public Point3D addPointVector(Vector v)
	{
		Point3D p= new Point3D();
		p.setX(getX().add(v.getHead().getX()));
		p.setY(getY().add(v.getHead().getY()));
		p.setZ(getZ().add(v.getHead().getZ()));
		return p;
	}
	
	public Point3D addDouble(double d)
	{
	
		this.setX(getX().add(new Coordinate(d)));
		this.setY(getY().add(new Coordinate(d)));
		this.setZ(getZ().add(new Coordinate(d)));
		return new Point3D(this.getX(),this.getY(),this.getZ());
	}
}
