/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import org.junit.Test;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testBitmapConstructorGetter() {
        String[] input = new String[] {"home.jpg", "home2.jpg", "grayscale"};
        Bitmap test = new Bitmap(input);

        assertEquals(test.imageLocation, "home.jpg");
    }

    @Test
    public void testBitmapConstructorImageFileDoesExists(){
        String[] input = new String[] {"home.jpg", "home2.jpg", "grayscale"};
        Bitmap test = new Bitmap(input);
        assertNotNull(test.readImage());
    }

    @Test
    public void testBitmapConstructorImageFileNoExists(){
        String[] input = new String[] {"kaka.jpg", "home2.jpg", "grayscale"};
        Bitmap test = new Bitmap(input);
        assertEquals(null, test.image);
    }

    @Test
    public void testInvertSelectionInput() {
        String[] input = new String[] {"kaka.jpg", "home2.jpg", "invert"};
        Bitmap test = new Bitmap(input);
        assertEquals("invert", test.transformOption);
    }

    @Test
    public void testBorderSelectionInput() {
        String[] input = new String[] {"kaka.jpg", "home2.jpg", "border"};
        Bitmap test = new Bitmap(input);
        assertEquals("border", test.transformOption);
    }

    @Test
    public void testGrayscaleSelectionInput() {
        String[] input = new String[] {"kaka.jpg", "home2.jpg", "grayscale"};
        Bitmap test = new Bitmap(input);
        assertEquals("grayscale", test.transformOption);
    }

    @Test
    public void testRotateCCWSelectionInput() {
        String[] input = new String[] {"kaka.jpg", "home2.jpg", "rotateCCW"};
        Bitmap test = new Bitmap(input);
        assertEquals("rotateCCW", test.transformOption);
    }

    @Test
    public void testInverterTransform() {
        String[] input = new String[] {"home.jpg", "home2.jpg", "invert"};
        Bitmap test = new Bitmap(input);

        File output = new File(input[1]);
        output.delete();

        test.runTransform();

        assertEquals(true, output.exists());

    }

    @Test
    public void testBorderTransform() {
        String[] input = new String[] {"home.jpg", "home2.jpg", "border"};
        Bitmap test = new Bitmap(input);

        File output = new File(input[1]);
        output.delete();

        test.runTransform();

        assertEquals(true, output.exists());
    }

    @Test
    public void testGrayscaleTransform() {
        String[] input = new String[] {"home.jpg", "home2.jpg", "grayscale"};
        Bitmap test = new Bitmap(input);

        File output = new File(input[1]);
        output.delete();

        test.runTransform();

        assertEquals(true, output.exists());
    }

    @Test
    public void testRotateCCW() {
        String[] input = new String[] {"home.jpg", "home2.jpg", "rotateCCW"};
        Bitmap test = new Bitmap(input);

        File output = new File(input[1]);
        output.delete();

        test.runTransform();

        assertEquals(true, output.exists());
    }


    @Test
    public void testWrongOutputLocationSelected() {
        String[] input = new String[] {"home.jpg", "br/home2.jerggpg", "CCW"};
        Bitmap test = new Bitmap(input);

        File output = new File(input[1]);
        output.delete();

        test.runTransform();

        assertEquals(false, output.exists());

    }
}
