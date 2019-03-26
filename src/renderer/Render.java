package renderer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map.Entry;

import elements.LightSource;
import geometries.FlatGeometry;
import geometries.Geometry;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

public class Render {

	private int RECURSION_LEVEL=3;
	private Scene scene;
	private ImageWriter imageWriter;
	
	// ***************** Constructors ********************** // 	
	public Render(){}
	public Render( ImageWriter imageWriter,Scene scene) {
		
		this.scene =scene;
		this.imageWriter = imageWriter;
	}
	
    public Render(Render other) {
		
		this.scene =other.scene;
		this.imageWriter = other.imageWriter;
	}

	
	// ***************** Getters/Setters ********************** //

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public ImageWriter getImageWriter() {
		return imageWriter;
	}

	public void setImageWriter(ImageWriter imageWriter) {
		this.imageWriter = imageWriter;
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
		Render other = (Render) obj;
		if (imageWriter == null) {
			if (other.imageWriter != null)
				return false;
		} else if (!imageWriter.equals(other.imageWriter))
			return false;
		if (scene == null) {
			if (other.scene != null)
				return false;
		} else if (!scene.equals(other.scene))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Render [scene=" + scene + ", imageWriter=" + imageWriter + "]";
	}
	

	
	
	// ***************** Operations ******************** // 
	
		public void renderImage() {
			
		for (int i=0; i<imageWriter.getHeight();i++) {
			for (int j =0;j<imageWriter.getWidth();j++)
			{
				Ray ray =new Ray(scene.getCamera().constructRayThroughPixel
						(imageWriter.getNx(), imageWriter.getNy(),j,i,
						scene.getScreenDistance(), imageWriter.getWidth(),
						imageWriter.getHeight()));
				double dis= (imageWriter.getHeight()/imageWriter.getNx())/2;
				Point3D p1=new Point3D(dis,dis,ray.getPoo().getZ().getCoordinate());
				Point3D p2=new Point3D(-dis,-dis,ray.getPoo().getZ().getCoordinate());
				Point3D p3=new Point3D(-dis,dis,ray.getPoo().getZ().getCoordinate());
				Point3D p4=new Point3D(dis,-dis,ray.getPoo().getZ().getCoordinate());
				Ray ray1=new Ray(ray.getPoo().add(p1),ray.getDirection());
				Ray ray2=new Ray(ray.getPoo().add(p2),ray.getDirection());
				Ray ray3=new Ray(ray.getPoo().add(p3),ray.getDirection());
				Ray ray4=new Ray(ray.getPoo().add(p4),ray.getDirection());
				 HashMap<Geometry, List<Point3D>> intersectionPoints =getSceneRayIntersections(ray);
				 HashMap<Geometry, List<Point3D>> intersectionPoints1 =getSceneRayIntersections(ray1);
				 HashMap<Geometry, List<Point3D>> intersectionPoints2 =getSceneRayIntersections(ray2);
				 HashMap<Geometry, List<Point3D>> intersectionPoints3 =getSceneRayIntersections(ray3);
				 HashMap<Geometry, List<Point3D>> intersectionPoints4 =getSceneRayIntersections(ray4);
			if (intersectionPoints.isEmpty())
			    imageWriter.writePixel(j,i, scene.getBackground()) ;
				else
				{
					 Color c = new Color(0,0,0);
					 Color c1= new Color(0,0,0);
					 Color c2= new Color(0,0,0);
					 Color c3= new Color(0,0,0);
					 Color c4= new Color(0,0,0);

					 HashMap<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
					 HashMap<Geometry, Point3D> closestPoint1 = getClosestPoint(intersectionPoints1);
					 HashMap<Geometry, Point3D> closestPoint2 = getClosestPoint(intersectionPoints2);
					 HashMap<Geometry, Point3D> closestPoint3 = getClosestPoint(intersectionPoints3);
					 HashMap<Geometry, Point3D> closestPoint4 = getClosestPoint(intersectionPoints4);
					 
					            
					 for(Entry<Geometry, Point3D> entry:closestPoint.entrySet()) 
                    	 c = calcColor(entry.getValue(), entry.getKey(), ray);
	                 
					 for(Entry<Geometry, Point3D> entry1:closestPoint1.entrySet()) 
						 c1 = calcColor(entry1.getValue(), entry1.getKey(), ray1);		             
					 for(Entry<Geometry, Point3D> entry2:closestPoint2.entrySet()) 
						 c2 = calcColor(entry2.getValue(), entry2.getKey(), ray2);
			         for(Entry<Geometry, Point3D> entry3:closestPoint3.entrySet()) 
			        	 c3 = calcColor(entry3.getValue(), entry3.getKey(), ray3);
			         for(Entry<Geometry, Point3D> entry4:closestPoint4.entrySet()) 
			        	 c4 = calcColor(entry4.getValue(), entry4.getKey(), ray4);	
			         
			         c=mult(c,0.9);
			         c1=mult(c1,0.025);
			         c2=mult(c2,0.025);
			         c3=mult(c3,0.025);
			         c4=mult(c4,0.025); 
					                
			   imageWriter.writePixel((int) j, (int) i, add(add(add(add(c,c1),c2),c3),c4));
				}
			}
		}
					    
			}
		
		
		
	
		    private  HashMap<Geometry, List<Point3D>> getSceneRayIntersections(Ray ray) {
			Iterator<Geometry> geometries = scene.getGeometriesIterator();
			 HashMap<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();
			List<Point3D> geometryIntersectionPoints =new ArrayList<Point3D>(); 
		    Geometry geometry;
			while (geometries.hasNext())
			{
				geometry = geometries.next();
				geometryIntersectionPoints=(geometry.findIntersections(ray));
				if(geometryIntersectionPoints!=null)
					if(!geometryIntersectionPoints.isEmpty())
			      intersectionPoints.put(geometry,geometryIntersectionPoints);
			}
			
			return intersectionPoints; 
			}
			
		private  HashMap<Geometry,Point3D> getClosestPoint(HashMap<Geometry, List<Point3D>> intersectionPoints) {

			
			double distance = Double.MAX_VALUE;
			Point3D P0 = scene.getCamera().getP0();
			
			HashMap<Geometry, Point3D> minDistancePoint=new HashMap<>();
			for (Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet())
				 for (Point3D point: entry.getValue()){
				if (P0.distance(point) < distance)
			{
				
					 minDistancePoint.clear();
	                 minDistancePoint.put(entry.getKey(), new Point3D(point));
	                 distance=P0.distance(point);
			}
				 }
				return minDistancePoint;
				
	}
		private Color calcColor(Point3D p, Geometry ge, Ray inRay)
		{
			 return calcColor( ge,  p,  inRay, 0);		
		}
		private Color calcColor(Geometry ge, Point3D point, Ray inRay, int level) 
		{
			if (level == RECURSION_LEVEL) return new Color(0, 0, 0);
			
			Color ambientLight = scene.getAmbientLight().getIntensity(point);
			Color emissionLight =ge.getEmmission();
			
	
			Iterator<LightSource> lights = scene.getLightIterator();
			
			Color diffuseLight= new Color(0,0,0);
			Color specularLight= new Color(0,0,0);
			while(lights.hasNext())
			{  
			
			LightSource light = lights.next();
			
			if(!occluded(light, point, ge))	
			{
			diffuseLight =add( diffuseLight, calcDiffuseComp(ge.getMaterial().getKd(),
						 ge.getNormal(point),
						 light.getL(point),
						 light.getIntensity(point)));
						 
			specularLight = add(specularLight, calcSpecularComp(ge.getMaterial().ks,
						 new Vector( scene.getCamera().getP0()),
						 ge.getNormal(point),
						 light.getL(point),
						 ge.getMaterial().nShininess,
						 light.getIntensity(point)));
			}}
			Color refractedColor = new Color(0,0,0);
			Color reflectedColor = new Color(0,0,0);
			
			Ray reflectedRay = constructReflectedRay(ge.getNormal(point), point, inRay);
			HashMap<Geometry,Point3D>reflectedEntry = getClosestPoint(getSceneRayIntersections(reflectedRay));
			
	           for(Entry<Geometry, Point3D> entry: reflectedEntry.entrySet())
	        	  reflectedColor= calcColor(entry.getKey(), entry.getValue(), reflectedRay, level+1);
	     
	        double kr = ge.getMaterial().getKr();
			Color reflectedLight = mult( reflectedColor,kr);
			// Recursive call for a retracted ray
			Ray refractedRay = constructRefractedRay(ge.getNormal(point), point, inRay);
			HashMap<Geometry,Point3D> refractedEntry =getClosestPoint(getSceneRayIntersections(refractedRay));
	     		 for(Entry<Geometry, Point3D> entry: refractedEntry.entrySet())
			refractedColor = calcColor(entry.getKey(), entry.getValue(), refractedRay, level+1);
	    	double kt = ge.getMaterial().getKt();
			Color refractedLight =mult ( refractedColor, kt);
			int rf = ambientLight.getRed() +emissionLight.getRed()+diffuseLight.getRed()+ specularLight.getRed()+reflectedLight.getRed()+refractedLight.getRed();
			if(rf>255) rf = 255;
			int gf =  ambientLight.getGreen() +emissionLight.getGreen()+diffuseLight.getGreen()+ specularLight.getGreen()+reflectedLight.getGreen()+refractedLight.getGreen();
			if(gf>255) gf = 255;
			int bf =ambientLight.getBlue() +emissionLight.getBlue()+diffuseLight.getBlue()+ specularLight.getBlue()+reflectedLight.getBlue()+refractedLight.getBlue();
			if(bf>255) bf = 255;
	
			return new Color(rf,gf,bf);
	/*
			int r= ambientLight.getRed() + emissionLight.getRed() + diffuseLight.getRed() +specularLight.getRed();
			int g= ambientLight.getGreen() + emissionLight.getGreen()+ diffuseLight.getGreen() +specularLight.getGreen();
			int b= ambientLight.getBlue() + emissionLight.getBlue()+ diffuseLight.getBlue() +specularLight.getBlue();
			
			if (r>255) r=255;
			if (r<0) r=0;
			if (g>255) g=255;
			if (g<0) g=0;
			if (b>255) b=255;
			if (b<0) b=0;
			
			return new Color(r,g,b);
	*/
			}

		private Ray  constructReflectedRay(Vector n, Point3D point ,Ray  d)
		{
			Vector dd = d.getDirection().normalizationVector();
			Vector r = dd.substrct(n.multiInScalar(2*dd.scalarMulti(n)));
			Ray  R = new Ray ( point.add(r.multiInScalar(2).getHead()) ,r);
			
			return R;
		}
		
		
		private Ray constructRefractedRay(Vector n, Point3D point ,Ray  d)
		{
			return new Ray (point.add(d.getDirection().multiInScalar(0.1).getHead()), d.getDirection());
		}
		
		
		private Color mult(Color rc, double kr) {
			int r=(int)(rc.getRed()*kr);
			if(r>255) r=255; if(r<0) r = -1*r;
			int g=(int)(rc.getGreen()*kr);
			if(g>255) g=255; if(r<0) g = -1*g;
			int b=(int)(rc.getBlue()*kr);
			if(b>255) b=255; if(b<0) b = -1*b;
			
			return (new Color(r,g,b));

		}
		
		private Color add (Color c1, Color c2)
		{
			int r =(int)( c1.getRed()+c2.getRed());
			if(r>255) r=255; if(r<0) r = -1*r;
			int g =(int)( c1.getGreen()+c2.getGreen());
			if(g>255) g=255; if(g<0) g = -1*g;
			int b =(int)( c1.getBlue()+c2.getBlue());
			if(b>255) b=255; if(b<0) b = -1*b;
			return new Color(r,g,b);
			
			
		}
		
		public Color calcDiffuseComp (double kd, Vector N, Vector L, Color intensity)
		{
			double nl = N.scalarMulti(L);
			int r=(int)(Math.abs(kd*nl*intensity.getRed()));
	        int g=(int)(Math.abs(kd*nl*intensity.getGreen()));
	        int b=(int)(Math.abs(kd*nl*intensity.getBlue()));
	    	if (r>255) r=255;
			if (r<0) r=0;
			if (g>255) g=255;
			if (g<0) g=0;
			if (b>255) b=255;
			if (b<0) b=0;
	        return new Color(r,g,b);
		}
		
		public Color calcSpecularComp(double ks, Vector V, Vector N, Vector L, int n, Color intensity) {
			
			double d=2;
			double ln= L.scalarMulti(N);
			double dln= d*ln;
			Vector dlnn= N.multiInScalar(dln);
			Vector R= new Vector(L.substrct(dlnn));
			
			double lr = L.scalarMulti(R);
			double lrn= Math.pow(lr, n);
			
			int r=(int)(Math.abs(ks*lrn*intensity.getRed()));
	        int g=(int)(Math.abs(ks*lrn*intensity.getGreen()));
	        int b=(int)(Math.abs(ks*lrn*intensity.getBlue()));
	    	if (r>255) r=255;
			if (r<0) r=0;
			if (g>255) g=255;
			if (g<0) g=0;
			if (b>255) b=255;
			if (b<0) b=0;
	        return new Color(r,g,b);

		}
			
		private boolean occluded(LightSource light, Point3D point, Geometry geometry) 
		{ 
			Vector lightDirection = light.getL(point); 
			lightDirection=lightDirection.multiInScalar(-1);
			Point3D geometryPoint = new Point3D(point);
			Vector epsVector = new Vector(geometry.getNormal(point));
			epsVector=epsVector.multiInScalar(2);    
			geometryPoint.add(epsVector.getHead()); 
			Ray lightRay = new Ray(geometryPoint, lightDirection);  
			HashMap<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);  
			// Flat geometry cannot self intersect  
			if (geometry instanceof FlatGeometry)
			  intersectionPoints.remove(geometry);
				
			  for (Entry<Geometry, List<Point3D>>entry:intersectionPoints.entrySet() )
				   if (entry.getKey().getMaterial().getKt() == 0)
				   return true;
				   return false;
		             
		}
	
			
		public void printGrid(int interval)
	    {
	        for(int i=0; i<500 ; i+=interval)
	            for(int j=0;j<500; j++)
	                this.imageWriter.writePixel(i, j, Color.WHITE);
	        for(int i=0; i<500 ; i++)
	            for(int j=0;j<500; j+=interval)
	                this.imageWriter.writePixel(i, j, Color.WHITE);
	    }

	
	

}	
				

			
