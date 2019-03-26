package tester;



import java.awt.Color;

import org.junit.jupiter.api.Test;

import elements.Camera;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

class RenderTest {
/*
@Test
public void basicRendering(){
	
	     
  Scene scene = new Scene();
    Color c=new Color(255,0,0);
    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));
  //  scene.addGeometry(new Sphere(new Point3D(0.0, 0.0, -50),50,c));
    scene.setScreenDistance(50);
   scene.addGeometry(new Sphere(280, new Point3D(0, 0, 400),new Color(255,0,0)));
    Triangle triangle = new Triangle(c,new Point3D( 100, 0, -49),
                                     new Point3D(  0, 100, -49),
                                     new Point3D( 100, 100, -49));
     
    Triangle triangle2 = new Triangle(c,new Point3D( 100, 0, -49),
                                      new Point3D(  0, -100, -49),
                                      new Point3D( 100,-100, -49));
     
    Triangle triangle3 = new Triangle(c,new Point3D(-100, 0, -49),
                                      new Point3D(  0, 100, -49),
                                      new Point3D(-100, 100, -49));
     
    Triangle triangle4 = new Triangle(c,new Point3D(-100, 0, -49),
                                      new Point3D(  0,  -100, -49),
                                      new Point3D(-100, -100, -49));
     
    scene.addGeometry(triangle);
    scene.addGeometry(triangle2);
    scene.addGeometry(triangle3);
    scene.addGeometry(triangle4);
     
    ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
     
    Render render = new Render(imageWriter,scene);
  
 
	render.renderImage();
	render.printGrid(50);
	render.getImageWriter().writeToimage();
}
*//*
@Test
public void basicRendering2() throws Exception{
	
	     
  Scene scene = new Scene();
  
    scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));
  //  scene.addGeometry(new Sphere(new Point3D(0.0, 0.0, -50),50,c));
    scene.setScreenDistance(50);
   scene.addGeometry(new Sphere(280, new Point3D(0, 0, 400),new Color(255,255,255),new Material()));
   
   Triangle triangle = new Triangle(new Color(0,255,0),new Point3D( 100, 0, -49),
                                     new Point3D(  0, 100, -49),
                                     new Point3D( 100, 100, -49),new Material());
     
    Triangle triangle2 = new Triangle(new Color(255,255,255),new Point3D( 100, 0, -49),
                                      new Point3D(  0, -100, -49),
                                      new Point3D( 100,-100, -49),new Material());
     
    Triangle triangle3 = new Triangle(new Color(255,0,0),new Point3D(-100, 0, -49),
                                      new Point3D(  0, 100, -49),
                                      new Point3D(-100, 100, -49),new Material());
     
    Triangle triangle4 = new Triangle(new Color(0,0,255),new Point3D(-100, 0, -49),
                                      new Point3D(  0,  -100, -49),
                                      new Point3D(-100, -100, -49),new Material());
     
    scene.addGeometry(triangle);
    scene.addGeometry(triangle2);
    scene.addGeometry(triangle3);
    scene.addGeometry(triangle4);
     
    ImageWriter imageWriter = new ImageWriter("Render test2", 500, 500, 500,500);
     
    Render render = new Render(imageWriter,scene);
  
 
	render.renderImage();
	render.printGrid(50);
	render.getImageWriter().writeToimage();
}*/

@Test
public void basicRendering1() throws Exception{
	
	     
  Scene scene = new Scene();
  Color c=new Color(255,255,255);
  
	scene.setCamera(new Camera(
  		new Point3D(0, 0, 0), 
  		new Vector(new Point3D(0,0,-1)), 
  		new Vector(new Point3D(0,1,0))));
 // scene.setCamera(new Camera(new Point3D(0, 0, 0), new primitives.Vector(new Point3D(0,0,1)), new primitives.Vector(new Point3D(0,1,0))));
  //  scene.addGeometry(new Sphere(new Point3D(0.0, 0.0, -50),50,c));
    scene.setScreenDistance(50);
   scene.addGeometry(new Sphere(280, new Point3D(0, 0, 400),c,new Material()));
   
   Triangle triangle = new Triangle(c,new Point3D( 100, 0, -49),
                                     new Point3D(  0, 100, -49),
                                     new Point3D( 100, 100, -49),new Material());
     
    Triangle triangle2 = new Triangle(c,new Point3D( 100, 0, -49),
                                      new Point3D(  0, -100, -49),
                                      new Point3D( 100,-100, -49),new Material());
     
    Triangle triangle3 = new Triangle(c,new Point3D(-100, 0, -49),
                                      new Point3D(  0, 100, -49),
                                      new Point3D(-100, 100, -49),new Material());
     
    Triangle triangle4 = new Triangle(c,new Point3D(-100, 0, -49),
                                      new Point3D(  0,  -100, -49),
                                      new Point3D(-100, -100, -49),new Material());
     
    scene.addGeometry(triangle);
    scene.addGeometry(triangle2);
    scene.addGeometry(triangle3);
    scene.addGeometry(triangle4);
     
    ImageWriter imageWriter = new ImageWriter("Render test1", 500, 500, 500,500);
     
    Render render = new Render(imageWriter,scene);
  
 
	render.renderImage();
	render.printGrid(50);
	render.getImageWriter().writeToimage();
}}


