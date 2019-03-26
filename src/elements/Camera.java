package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Camera  {
	
	protected Point3D p0;
	protected Vector vUp;
	protected Vector vTo;
	protected Vector vRight;
	
	
// ***************** Constructors ********************** // 

	public Camera(Point3D p0, Vector vTo, Vector vRight) {
	this.p0 = p0;
	this.vTo = vTo;
	this.vRight = vRight;
	this.vUp = vTo.vectorProduct(vRight);
	}
	
	public Camera() {
		this.p0 = new Point3D(0,0,0);
		this.vTo = new Vector(new Point3D(1,0,0));
		this.vRight = new Vector(new Point3D(0,1,0));
		this.vUp = new Vector(new Point3D(0,0,1));
		
}
	
// ***************** Getters/Setters ********************** // 
		
	

	public Point3D getP0() {
		return p0;
	}

	public void setP0(Point3D p0) {
		this.p0 = p0;
	}
	public Vector getvUp() {
		return vUp;
	}
	public void setvUp(Vector vUp) {
		this.vUp = vUp;
	}
	public Vector getvTo() {
		return vTo;
	}
	public void setvTo(Vector vTo) {
		this.vTo = vTo;
	}
	public Vector getvRight() {
		return vRight;
	}
	public void setvRight(Vector vRight) {
		this.vRight = vRight;
	}
	
	
// ***************** Administration  ******************** // 
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camera other = (Camera) obj;
		if (p0 == null) {
			if (other.p0 != null)
				return false;
		} else if (!p0.equals(other.p0))
			return false;
		if (vRight == null) {
			if (other.vRight != null)
				return false;
		} else if (!vRight.equals(other.vRight))
			return false;
		if (vTo == null) {
			if (other.vTo != null)
				return false;
		} else if (!vTo.equals(other.vTo))
			return false;
		if (vUp == null) {
			if (other.vUp != null)
				return false;
		} else if (!vUp.equals(other.vUp))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "("+this.p0+" , "+ this.vRight + this.vTo + this.vUp + ")";
	
	}
	

// ***************** Operations ******************** //		

	

	

	public Ray constructRayThroughPixel (int Nx, int Ny, double x, double y,
            double screenDist, double screenWidth,
            double screenHeight)
	{
		
		//Point3D pc= p0.addDouble(vTo.length());
		
		Point3D pc= p0.addPointVector(vTo.multiInScalar(screenDist));
		double Rx = screenWidth/Nx;   
		double Ry = screenHeight/Ny; 
		double Mx= (x-(Nx/2))*Rx + (Rx/2);
		double My= (y-(Ny/2))*Ry + (Ry/2);
		Vector Vx = new Vector(vRight.multiInScalar(Mx));
		Vector Vy = new Vector(vUp.multiInScalar(My));
		Point3D p = pc.addPointVector(Vx.substrct(Vy));
		return new Ray(p0,new Vector(p.substrct(p0)));
	}

	
	
	
	
	

}
