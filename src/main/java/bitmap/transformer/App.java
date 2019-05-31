/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        String[] input = new String[] {"src/main/resources/img_lights.bmp", "src/main/resources/img_lights_output.bmp", "grayscale"};
        Bitmap image = new Bitmap(input);
        image.runTransform();
    }
}
