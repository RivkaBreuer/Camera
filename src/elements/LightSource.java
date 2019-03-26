package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public interface LightSource {
	
	
	
	//***************** Operations ******************** //	
	public Vector getL (Point3D p);
	public Color getIntensity(Point3D point);

}
