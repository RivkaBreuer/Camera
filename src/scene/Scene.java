package scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import elements.AmbientLight;
import elements.Camera;
import elements.LightSource;
import geometries.Geometry;


public class Scene {
	
	   private String sceneName;
	   private Color background; 
       private AmbientLight ambientLight;
	   private List<Geometry> geometries=new ArrayList<>();
       private Camera camera;
	   private double screenDistance;
	   private List<LightSource> lights=new ArrayList<>();

	
	   
	 //***************** Constructors ********************** // 
	   
	   public Scene(String sceneName, Color background, AmbientLight ambientLight, List<Geometry> geometries, Camera camera, double screenDistance) {
		
		this.sceneName = sceneName;
		this.background = background;
		this.ambientLight = ambientLight;
		this.geometries = new ArrayList<Geometry>();
		this.camera = camera;
		this.screenDistance = screenDistance;
		
	
		
	}
	   public Scene() {
			
		this.sceneName = "MyScene";
		this.background = Color.black;
		this.ambientLight = new AmbientLight();
		this.geometries = new ArrayList<Geometry>();
		this.camera = new Camera();
		this.screenDistance = 100;
		
	}
	   
	   public Scene(Scene other) {
		   this.sceneName = other.sceneName;
			this.background = other.background;
			this.ambientLight = other.ambientLight;
			this.geometries = other.geometries;
			this.camera = other.camera;
			this.screenDistance = other.screenDistance;
		}
	   
	// ***************** Getters/Setters ********************** // 
	   
	   public String getSceneName() {
		return sceneName;
	}


	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}


	public Color getBackground() {
		return background;
	}


	public void setBackground(Color background) {
		this.background = background;
	}


public AmbientLight getAmbientLight() {
		return ambientLight;
	}


	public void setAmbientLight(AmbientLight ambientLight) {
		this.ambientLight = ambientLight;
	}


	public List<Geometry> getGeometries() {
		return geometries;
	}


	public void setGeometries(List<Geometry> geometries) {
		this.geometries = geometries;
	}


	public Camera getCamera() {
		return camera;
	}


	public void setCamera(Camera camera) {
		this.camera = camera;
	}


	public double getScreenDistance() {
		return screenDistance;
	}


	public void setScreenDistance(double screenDistance) {
		this.screenDistance = screenDistance;
	}
	
	public List<LightSource> getLights() {
		return lights;
	}
	public void setLights(List<LightSource> lights) {
		this.lights = lights;
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
		Scene other = (Scene) obj;
		if (ambientLight == null) {
			if (other.ambientLight != null)
				return false;
		} else if (!ambientLight.equals(other.ambientLight))
			return false;
		if (background == null) {
			if (other.background != null)
				return false;
		} else if (!background.equals(other.background))
			return false;
		if (camera == null) {
			if (other.camera != null)
				return false;
		} else if (!camera.equals(other.camera))
			return false;
		if (geometries == null) {
			if (other.geometries != null)
				return false;
		} else if (!geometries.equals(other.geometries))
			return false;
		if (lights == null) {
			if (other.lights != null)
				return false;
		} else if (!lights.equals(other.lights))
			return false;
		if (sceneName == null) {
			if (other.sceneName != null)
				return false;
		} else if (!sceneName.equals(other.sceneName))
			return false;
		if (Double.doubleToLongBits(screenDistance) != Double.doubleToLongBits(other.screenDistance))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "Scene [sceneName=" + sceneName + ", background=" + background + ", geometries=" + geometries
				+ ", camera=" + camera + ", screanDistance=" + screenDistance + "lights" +lights + "]";

	}
	
	// ***************** Operations ******************** //	
	
	 
	
	 public void addGeometry (Geometry g)
	{
		  geometries.add(g);
	}
	  	   
	 public Iterator<Geometry> getGeometriesIterator()
	 {
		 return geometries.iterator();
	 }
	 
	 public Iterator<LightSource> getLightIterator()
		{
			return lights.iterator();
		}
		
	 public void addLightSource(LightSource lightSource) {
			lights.add(lightSource);
		}
		   
	

	   
}


