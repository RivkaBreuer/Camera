package elements;

import java.awt.Color;


import primitives.Point3D;

public class AmbientLight extends Light {

	protected Color color;
	protected double ka;

	
	
	
	// ***************** Constructors ********************** // 
	
		public AmbientLight(Color color, double ka) {
	
		this.color = color;
		this.ka = ka;
	}
		
		public AmbientLight() {
			
			this.color = Color.white;
			this.ka = 0.1;
		}
		
	public AmbientLight(int r, int g, int b) {
			
			this.color = new Color(r,g,b);
			this.ka = 0.1;
		}
		
       public AmbientLight(AmbientLight other) {
			
			this.color = other.color;
			this.ka = other.ka;
		}
	
	
	
	// ***************** Getters/Setters ********************** // 
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	public double getKa() {
		return ka;
	}
	public void setKa(double ka) {
		this.ka = ka;
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
		AmbientLight other = (AmbientLight) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(ka) != Double.doubleToLongBits(other.ka))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() 
	{
		return "("+ "color" + this.color + "ka" + this.ka + ")";

	}
	
	// ***************** Operations ******************** //		
	@Override
	public Color getIntensity(Point3D point)
	{
		double b=this.color.getBlue()*ka;
		if(b>255)
			b=255;
		double g=this.color.getGreen()*ka;
		if(g>255)
			g=255;
		double r=this.color.getRed()*ka;
		if(r>255)
			r=255;
		
		return new Color( (int)r, (int)g, (int)b);
	}
}
