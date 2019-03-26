package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class SpotLight extends PointLight{

	private Vector direction;
	
	
	// ***************** Constructors ********************** // 
	
	public SpotLight (Color c,Point3D position, double kc, double kl, double kq,Vector direction) {
		super(c,position, kc, kl, kq);
		this.direction = direction;
	}
	
	public SpotLight() {
		super();
		this.direction = new Vector();
	}
	
	public SpotLight(SpotLight other) {
		super(other);
		this.direction = other.direction;
	}
	
	// ***************** Getters/Setters ********************** //
	
	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) {
		this.direction = direction;
	}
	
	// ***************** Administration  ******************** // 
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpotLight other = (SpotLight) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		return true;
	}	
		@Override
		public String toString() 
		{
			return "("+ "color" + this.getColor() + "position" + this.position + "kc" + this.kc + "kl" + this.kl + "kq" + this.kq + "direction" + this.direction +")";

		}	

	// ***************** Operations ******************** //	
	@Override
	public Color getIntensity(Point3D point)
	
	{
		Vector l=getL(point);
        direction.normalizationVector();
        Double tmp=l.scalarMulti(direction);
        double d=point.distance(position);
        double r=(getColor().getRed()*tmp)/(kc+(kl*d)+(kq*Math.pow(d,2)));
        double g=(getColor().getGreen()*tmp)/(kc+(kl*d)+(kq*Math.pow(d,2)));
        double b=(getColor().getBlue()*tmp)/(kc+(kl*d)+(kq*Math.pow(d,2)));
        if(r>255)r=255;
        if(g>255)g =255;
        if(b>255)b=255;
        if(r<0)r=0;
        if(g<0)g =0;
        if(b<0)b=0;
        return new Color((int)r, (int)g, (int)b);
	}

	}

	

	
	



