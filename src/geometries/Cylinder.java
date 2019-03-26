package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Cylinder extends RadialGeometry{
	
	private Point3D axisPoint;
	private Vector axisDirection;
	
	//***************** Constructors ********************** // 
		

		public Cylinder() {
			super();
			this.axisPoint = new Point3D();
			this.axisDirection =new Vector();
			
		}

				
		public Cylinder(double radius, Point3D axisPoint, Vector axisDirection) {
		super(radius);
		this.axisPoint = axisPoint;
		this.axisDirection = axisDirection;
	}

		public Cylinder(Cylinder other) {
			this.radius= other.radius;
			this.axisDirection = other.axisDirection;
			this.axisPoint = other.axisPoint;
		}



		// ***************** Getters/Setters ********************** // 


		public Point3D getAxisPoint() {
			return axisPoint;
		}


		public void setAxisPoint(Point3D axisPoint) {
			this.axisPoint = axisPoint;
		}


		public Vector getAxisDirection() {
			return axisDirection;
		}


		public void setAxisDirection(Vector axisDirection) {
			this.axisDirection = axisDirection;
		}

		//***************** Administration  ******************** // 

		
	
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cylinder other = (Cylinder) obj;
			if (axisDirection == null) {
				if (other.axisDirection != null)
					return false;
			} else if (!axisDirection.equals(other.axisDirection))
				return false;
			if (axisPoint == null) {
				if (other.axisPoint != null)
					return false;
			} else if (!axisPoint.equals(other.axisPoint))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "" + getRadius() + " " +  axisPoint.toString() + " " + axisDirection.toString();
	}

		// ***************** Operations ******************** //		
		@Override
			public Vector getNormal (Point3D p) {
			
					return new Vector();
				}
		
		

}
