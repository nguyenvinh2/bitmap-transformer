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
        //string[] input = new String[]{"src/main/resources/img_lights.bmp", "src/main/resources/img_lights_output.bmp","rotateCCW"};
        Bitmap image = new Bitmap(args);
        image.runTransform();

        // ./gradlew run --args 'src/main/resources/img_lights.bmp src/main/resources/img_lights_output.bmp rotateCCW'
    }
}
