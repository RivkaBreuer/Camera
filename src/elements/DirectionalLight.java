package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource {

	
	private Vector direction;
		
	
	
	// ***************** Constructors ********************** // 
	
	public DirectionalLight() {
		super();
		this.direction =new Vector();
	}

	public DirectionalLight(Color color, Vector v) {
		super(color);
		this.direction =new Vector(v);
	}

	public DirectionalLight(DirectionalLight other) {
		super(other);
		this.direction= other.direction;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectionalLight other = (DirectionalLight) obj;
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
		return "("+ "color" + this.getColor() + "direction" + this.direction + ")";

	}



	// ***************** Operations ******************** //	
	@Override
	public Color getIntensity(Point3D point)
	{
		return this.getColor();
	}

	@Override
	public Vector getL (Point3D p) {
		return new Vector(p.substrct(direction.getHead())).normalizationVector();
	}

	
}
