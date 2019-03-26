package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light  implements LightSource{

	
	protected Point3D position;
	protected double kc;
	protected double kl;
	protected double kq;
	
	
	// ***************** Constructors ********************** // 
	public PointLight() {
		super();
		this.position = new Point3D();
		this.kc = 0.1;
		this.kl = 0.1;
		this.kq = 0.1;
	}
	
	public PointLight(Color c,Point3D position, double kc, double kl, double kq) {
		super(c);
		this.position = position;
		this.kc = kc;
		this.kl = kl;
		this.kq = kq;
	}
	
	public PointLight(PointLight other) {
		super(other);
		this.position = other.position;
		this.kc = other.kc;
		this.kl = other.kl;
		this.kq = other.kq;
	}
	
	
	// ***************** Getters/Setters ********************** //
	

public Point3D getPosition() {
	return position;
}


public void setPosition(Point3D position) {
	this.position = position;
}

public double getKc() {
	return kc;
}

public void setKc(double kc) {
	this.kc = kc;
}

public double getKl() {
	return kl;
}

public void setKl(double kl) {
	this.kl = kl;
}

public double getKq() {
	return kq;
}

public void setKq(double kq) {
	this.kq = kq;
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
		PointLight other = (PointLight) obj;
		if (Double.doubleToLongBits(kc) != Double.doubleToLongBits(other.kc))
			return false;
		if (Double.doubleToLongBits(kl) != Double.doubleToLongBits(other.kl))
			return false;
		if (Double.doubleToLongBits(kq) != Double.doubleToLongBits(other.kq))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

@Override
public String toString() 
{
	return "("+ "color" + this.getColor() + "position" + this.position + "kc" + this.kc + "kl" + this.kl + "kq" + this.kq +")";

}
	// ***************** Operations ******************** //	
	@Override
	public Color getIntensity(Point3D point)
	{
		{
			double distance = point.distance(point);
			Color color = new Color(this.getColor().getRGB());
			double K = 1/(kc + kl * distance +kq * Math.pow(distance, 2));
			if(K<1) 
			K=1;
			int red = (int)(color.getRed() * K);
			int green = (int)(color.getGreen() * K);
			int blue = (int)(color.getBlue() * K);
			if (red<0)
			red=0;
			if (green<0)
			green=0;
			if (blue<0)
			blue=0;
			if (red>255)
			red=255;
			if (green>255)
			green=255;
			if (blue>255)
			blue=255;
			return new Color(red,green,blue);
			}
	}
	
	public Vector getL(Point3D point) {
		return new Vector(point.substrct(position)).normalizationVector();
	}




	

}
