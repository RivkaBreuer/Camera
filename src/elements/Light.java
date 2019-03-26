package elements;

import java.awt.Color;

import primitives.Point3D;

public abstract class Light {
	
	protected Color color;
	
	// ***************** Constructors ********************** // 
	
	public Light() {
	   this.color= Color.white;
	}



	public Light(Color color) {
		this.color = color;
	}
	
	public Light(Light other) {
		this.color = other.color;
	}


	// ***************** Getters/Setters ********************** // 

	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
	}

	// ***************** Administration  ******************** // 
	

	// ***************** Operations ******************** //		
	
	
	public abstract Color getIntensity(Point3D point);

}
