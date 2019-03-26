package tester;





import org.junit.jupiter.api.Test;

import renderer.ImageWriter;

class ImageWriterTest {

   
	@Test
	  public void writeImageTest(){

        ImageWriter imageWriter = new ImageWriter("Image writer test", 500, 500, 1, 1);
        for (int i = 0; i < imageWriter.getHeight(); i++){
            for (int j = 0; j < imageWriter.getWidth(); j++)
            {

                if (i % 50 == 0 || j % 50 == 0 || i == 499 || j == 499 )
                    imageWriter.writePixel(j, i, 255, 255, 255);  // White 
                else
                
                    imageWriter.writePixel(j, i, 0, 0, 0); // Black
               
            }
        }

        imageWriter.writeToimage();

    

	}

}
