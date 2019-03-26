package tester;

import java.awt.Color;


import org.junit.Test;


import elements.Camera;
import elements.PointLight;
import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class LightingTest {

	/*
	
	
	@Test 
	public void emmissionTest() throws Exception{
		
		
		Scene scene = new Scene();
	    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));

		scene.setScreenDistance(50);
		   scene.addGeometry(new Sphere(280, new Point3D(0, 0, 400),new Color(255,255,255), new Material()));

		//scene.addGeometry(new Sphere(50, new Point3D(0.0, 0.0, -50)));
		
		Triangle triangle = new Triangle(new Point3D( 100, 0, -49),
				 						 new Point3D(  0, 100, -49),
				 						 new Point3D( 100, 100, -49));
		
		Triangle triangle2 = new Triangle(new Point3D( 100, 0, -49),
				 			 			  new Point3D(  0, -100, -49),
				 			 			  new Point3D( 100,-100, -49));
		triangle2.setEmmission(new Color (50, 200, 50));
		
		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49),
				 						  new Point3D(  0, 100, -49),
				 						  new Point3D(-100, 100, -49));
		triangle3.setEmmission(new Color (50, 50, 200));
		
		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49),
				 			 			  new Point3D(  0,  -100, -49),
				 			 			  new Point3D(-100, -100, -49));
		triangle4.setEmmission(new Color (200, 50, 50));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
		ImageWriter imageWriter = new ImageWriter("Emmission test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.printGrid(50);
		render.getImageWriter().writeToimage();
	}
	
	
	@Test 
	public void testdec25a() throws Exception{
		
	        
	      
		
		Scene scene = new Scene();
	    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));
	  
		scene.setScreenDistance(50);
		   scene.addGeometry(new Sphere(350, new Point3D(0, 0, 400),new Color(200,50,50), new Material()));

		
		   scene.addLightSource(new SpotLight(new Color(255, 100, 100), new Point3D(-200.0, -200.0, -150.0), 0.1, 0.00001, 0.000005, new Vector(new Point3D(2, 2, -3))));
		   

	
	

		
		ImageWriter imageWriter = new ImageWriter("dec25a test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		//render.printGrid(50);
		render.getImageWriter().writeToimage();
	}
	
	@Test 
	public void testdec25b() throws Exception{
		
	        
	      
		
		Scene scene = new Scene();
	    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));
		scene.setScreenDistance(50);
		Sphere s = new Sphere(350, new Point3D(0, 0, 400),new Color(200,50,50), new Material());
		   scene.addGeometry(s);
		   s.getMaterial().setnShininess(20);
			s.setEmmission(new Color(0, 0, 100));
			scene.addGeometry(s);
			scene.addLightSource(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 0, 0.00001, 0.000005, 
						   new Vector(new Point3D(2, 2, -3))));
		
		   scene.addLightSource(new SpotLight(new Color(255, 100, 100), new Point3D(-200.0, -200.0, -150.0), 0.1, 0.00001, 0.000005, new Vector(new Point3D(2, 2, -3))));
		   

	
	

		
		ImageWriter imageWriter = new ImageWriter("dec25b test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		//render.printGrid(50);
		render.getImageWriter().writeToimage();
	}


	@Test
	public void spotLightT1est2() throws Exception{

		Scene scene = new Scene();
	    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));

		scene.setScreenDistance(50);
		Sphere s =new Sphere(350, new Point3D(0, 0, 400),new Color(255,255,255), new Material());
		   scene.addGeometry(s);

		s.getMaterial().setnShininess(20);
		s.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(s);
		
		Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
										 new Point3D(-225, -125, -260),
										 new Point3D(-225, -225, -270));
		
		triangle.setEmmission(new Color (0, 0, 100));
		triangle.getMaterial().setnShininess(4);
		scene.addGeometry(triangle);
		
		scene.addLightSource(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				 0.1, 0.00001, 0.000005,new Vector(new Point3D(2, 2, -3))));
	
		ImageWriter imageWriter = new ImageWriter("Spot test 12", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
		
	}
	
	
	@Test
	public void spotLightTest() throws Exception{
		
		Scene scene = new Scene();
	    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));
		scene.setScreenDistance(50);
		Sphere s = new Sphere(350, new Point3D(0, 0, 400),new Color(200,50,50), new Material());
		   scene.addGeometry(s);
		s.getMaterial().setnShininess(20);
		s.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(s);
		scene.addLightSource(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 0, 0.00001, 0.000005, 
					   new Vector(new Point3D(2, 2, -3))));
	
		ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
		
	}

	 
	@Test
	public void pointLightTest() throws Exception{
		
		Scene scene = new Scene();
	    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));
		scene.setScreenDistance(50);
		Sphere s = new Sphere(350, new Point3D(0, 0, 400),new Color(200,50,50), new Material());
		   scene.addGeometry(s);
		s.getMaterial().setnShininess(20);
		s.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(s);
		scene.addLightSource(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100), 
					   0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
		
		
	}
	
	

  

	
	@Test
	public void basicRendering() throws Exception {
		Scene scene = new Scene();
	    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));
		scene.setScreenDistance(50);
		
		
		Material m = new Material(0.8, 0.9,20,0.01,0.21);

		scene.addGeometry(new Sphere(350, new Point3D(0, 0, 400),new Color(200,50,50),m));
		scene.addGeometry(new Triangle(new Point3D(-125, -225, -260),
				 new Point3D(-225, -125, -260),
				 new Point3D(-225, -225, -270)));
	
        
		PointLight pointLight = new PointLight(new Color(100, 50, 200), new Point3D(-50, -50, 0), 1, 0.0001, 0.0001);
		SpotLight spotLight = new SpotLight(new Color(255, 155, 255), new Point3D(-30, -30, 0), 1.0, 0.005, 0.0000001,
				new Vector(new Point3D(0, 0, -1)));

		scene.addLightSource(pointLight);
		scene.addLightSource(spotLight);

		ImageWriter imageWriter = new ImageWriter("Render test lights", 501, 501, 501, 501);

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.printGrid(50);
		render.getImageWriter().writeToimage();
	}
	
	
	 @Test
		public void spotLightTest1()throws Exception
	        {
			
			Scene scene = new Scene();
		    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));
			scene.setScreenDistance(50);
			
			
			Material m = new Material(0.8, 0.9,30,0.01,0.21);

			scene.addGeometry(new Sphere(350, new Point3D(0, 0, 400),new Color(200,50,50),m));
			
	                scene.addLightSource(new SpotLight(
	                         new Color(20, 95, 95),
	                         new Point3D(20,20,10), 
				 0.0, 0.00001, 0.000005,new Vector(new Point3D(2,2,3))));
	                       
		
			ImageWriter imageWriter = new ImageWriter("SpotTestNew", 500, 500, 500, 500);
			
			Render render = new Render(imageWriter,scene);
			
			render.renderImage();
			render.getImageWriter().writeToimage();

		}
	 @Test
		public void shadowTest(){
			
		 Scene scene = new Scene();
		    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));

			scene.setScreenDistance(50);
			  Sphere s=new Sphere(280, new Point3D(0, 0, 400),new Color(255,255,255), new Material(0.8,0.7,30,0.02,0.1));
			s.getMaterial().setnShininess(20);
			s.setEmmission(new Color(0, 0, 100));
			
			scene.addGeometry(s);
			

			Triangle triangle = new Triangle(new Point3D(-175, -275, -310),
											 new Point3D(-275, -175, -310),
											 new Point3D(-275, -275, -320));

			Triangle triangle2 = new Triangle(new Point3D( 100, 0, -49),
		 			  new Point3D(  0, -100, -49),
		 			  new Point3D( 100,-100, -49));

			triangle2.setEmmission(new Color (50, 200, 50));
			
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);
			
			   scene.addLightSource(new SpotLight(
                       new Color(20, 95, 95),
                       new Point3D(20,20,10), 
			 0.0, 0.00001, 0.000005,new Vector(new Point3D(2,2,3))));
			
			ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
			
			Render render = new Render(imageWriter, scene);
			
			render.renderImage();
			render.getImageWriter().writeToimage();
			
		}
	 @Test
		public void refTest() {

		 Scene scene = new Scene();
		    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));

			scene.setScreenDistance(200);
		//	   scene.addGeometry(new Sphere(280, new Point3D(0, 0, 400),new Color(255,255,255), new Material()));
	        Color c = (Color.MAGENTA);
			Material m = new Material(0.8, 1, 20, 1, 0.5);
			Material m1 = new Material(0.8, 1, 20, 0.2, 0.03);
	        scene.addGeometry(new Triangle(new Color (0,0,0), new Point3D(20,-10,-40), new Point3D(-10,-10,-20),new Point3D(-10,20,-20),m));
	        scene.addGeometry(new Sphere(5.0,  new Point3D(10,10,-25),c,m1));
	        
			//scene.addGeometry(new Plane(new Color(0, 0, 128), new Point3D(0, 80, 0), new Vector(new Point3D(0, 1, -1)), m));

			PointLight pointLight = new PointLight(new Color(25, 20, 20), new Point3D(-30, -30, 0), 1, 0.0001, 0.0001);
			SpotLight spotLight = new SpotLight(new Color(55, 15, 25), new Point3D(-30, -30, 0), 1.0, 0.005, 0.0000001,
					new Vector(new Point3D(2, 0, 1)));

			scene.addLightSource(pointLight);
			scene.addLightSource(spotLight);
	

			ImageWriter imageWriter = new ImageWriter("Reflection test", 501, 501, 501, 501);

			Render render = new Render(imageWriter, scene);

			render.renderImage();
			// render.printGrid(50);
			render.getImageWriter().writeToimage();
		}
	
	 
	 @Test
		public void shadowTesttttt(){
			
			Scene scene = new Scene();
			scene.setScreenDistance(100);
			   scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,-1)), new primitives.Vector(new Point3D(0,1,0))));
			Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000), new Color(0), new Material());
			sphere.getMaterial().setnShininess(20);
			sphere.setColor(new Color(0, 0, 100));
			
			scene.addGeometry(sphere);
			
			Triangle triangle = new Triangle(new Color(0,0,0),new Point3D(  3500,  3500, -2000),
					 						 new Point3D( -3500, -3500, -1000),
					 						 new Point3D(  3500, -3500, -2000), new Material());

			Triangle triangle2 = new Triangle(new Color(0,0,0),new Point3D(  3500,  3500, -2000),
					  						  new Point3D( -3500,  3500, -1000),
					  						  new Point3D( -3500, -3500, -1000), new Material());
			
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);
			
			scene.addLightSource(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 0, 0.000001, 0.0000005,
					   new Vector(new Point3D(-2, -2, -3))));
		
			
			ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
			
			Render render = new Render(imageWriter, scene);
			
			render.renderImage();
			render.getImageWriter().writeToimage();
	 }
	 
	 
	@Test
	public void spotLightTest2() throws Exception{

		Scene scene = new Scene();
	    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));

		scene.setScreenDistance(50);
		Sphere s =new Sphere(350, new Point3D(0, 0, 400),new Color(255,255,255), new Material());
		   scene.addGeometry(s);

		s.getMaterial().setnShininess(20);
		s.setEmmission(new Color(0, 0, 100));
		scene.addGeometry(s);
		
		Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
										 new Point3D(-225, -125, -260),
										 new Point3D(-225, -225, -270));
		
		triangle.setEmmission(new Color (0, 0, 100));
		triangle.getMaterial().setnShininess(4);
		scene.addGeometry(triangle);
		
		scene.addLightSource(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				 0.1, 0.00001, 0.000005,new Vector(new Point3D(2, 2, -3))));
	
		ImageWriter imageWriter = new ImageWriter("Spot test end", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
		
	}
	@Test
	public void recursiveTest(){
		
		Scene scene = new Scene();
	    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));

		scene.setScreenDistance(200);
		
		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
		sphere.getMaterial().setnShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		sphere.getMaterial().setKt(0.5);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
		sphere2.getMaterial().setnShininess(20);
		sphere2.setEmmission(new Color(100, 20, 20));
		sphere2.getMaterial().setKt(0);
		scene.addGeometry(sphere2);
		
		scene.addLightSource(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					   0.000005, 0.1, 0.00001, new Vector(new Point3D(2, 2, -3))));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
		
	}
	*/
	@Test
	public void recursiveTest2(){
		Scene scene = new Scene();
	    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));

		scene.setScreenDistance(200);
		
		Sphere sphere = new Sphere(300, new Point3D(-550, -500, -1000));
		sphere.getMaterial().setnShininess(20);
		sphere.setEmmission(new Color(0, 0, 100));
		sphere.getMaterial().setKt(0.5);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(150, new Point3D(-550, -500, -1000));
		sphere2.getMaterial().setnShininess(20);
		sphere2.setEmmission(new Color(100, 20, 20));
		sphere2.getMaterial().setKt(0);
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
				 						 new Point3D( -1500,  1500, -1500),
				 						 new Point3D(  200,  200, -375));
		
		Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
										  new Point3D( -1500,  1500, -1500),
										  new Point3D( -1500, -1500, -1500));
		
		triangle.setEmmission(new Color(20, 20, 20));
		triangle2.setEmmission(new Color(20, 20, 20));
		triangle.getMaterial().setKr(1);
		triangle2.getMaterial().setKr(0.5);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLightSource(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
				   0.000005, 0, 0.00001, new Vector(new Point3D(2, 2, -3))));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
		
	}
	

		}
	
	
	

