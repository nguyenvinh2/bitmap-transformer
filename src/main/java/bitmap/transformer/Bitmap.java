package bitmap.transformer;

import com.google.common.io.Files;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {
    String imageLocation;
    String exportLocation;
    String transformOption;
    File imageFile;
    BufferedImage image;

    public Bitmap(String[] args) {
        this.imageLocation = args[0];
        this.exportLocation = args[1];
        this.transformOption =  args[2];
        this.imageFile = new File(imageLocation);
        this.image = readImage();
    }

    public BufferedImage readImage() {
        BufferedImage bmpImage = null;
        try {
            if(this.imageFile.exists()) {
                bmpImage = ImageIO.read(this.imageFile);
                System.out.println(bmpImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpImage;
    }

    public String[][] readRGBValue() {
        String[][] imageArray = new String[this.image.getWidth()][this.image.getHeight()];

        for(int i = 0; i < imageArray.length; i++) {
            for(int j = 0; j < imageArray[i].length; j++) {
             Color color = new Color(this.image.getRGB(i,j));
             imageArray[i][j] = "Red: " + color.getRed() + " Green: " + color.getGreen() + " Blue: " + color.getBlue() + " ";
             System.out.print(imageArray[i][j]);
            }
            System.out.println();
        }

        return imageArray;
    }

    public void runTransform() {
        switch(this.transformOption) {
            case "invert":
                runInversion();
                break;
            case "grayscale":
                runGrayScaleTransformation();
                break;
            case "border":
                runCreateBorder();
                break;
            case "rotateCCW":
                runRotateCCW();
                break;
        }
    }

    public void runInversion() {
        BufferedImage transformedImage = new BufferedImage(this.image.getWidth(), this.image.getHeight(), this.image.getType());
        for(int i = 0; i < this.image.getWidth(); i++) {
            for(int j = 0; j < this.image.getHeight(); j++) {
                transformedImage.setRGB(i, j, 0xFFFFFF - this.image.getRGB(i,j));
            }
        }
        try {
            File outputImageFileLocation = new File(this.exportLocation);
            ImageIO.write(transformedImage, Files.getFileExtension(this.imageLocation), outputImageFileLocation);
            System.out.println("Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runGrayScaleTransformation() {
        BufferedImage transformedImage = new BufferedImage(this.image.getWidth(), this.image.getHeight(), this.image.getType());
        for(int i = 0; i < this.image.getWidth(); i++) {
            for(int j = 0; j < this.image.getHeight(); j++) {
                Color color = new Color(this.image.getRGB(i, j));
                int averageColor = (color.getRed() + color.getGreen() + color.getBlue())/3;
                color = new Color(averageColor, averageColor, averageColor);
                transformedImage.setRGB(i, j, color.getRGB());
            }
        }
        try {
            File outputImageFileLocation = new File(this.exportLocation);
            ImageIO.write(transformedImage, Files.getFileExtension(this.imageLocation), outputImageFileLocation);
            System.out.println("Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runCreateBorder() {
        BufferedImage transformedImage = new BufferedImage(this.image.getWidth() + 10, this.image.getHeight() + 10, this.image.getType());
        for(int i = 0; i < this.image.getWidth(); i++) {
            for(int j = 0; j < this.image.getHeight(); j++) {
                Color color = new Color(this.image.getRGB(i, j));
                transformedImage.setRGB(i + 5, j + 5, color.getRGB());
            }
        }
        try {
            File outputImageFileLocation = new File(this.exportLocation);
            ImageIO.write(transformedImage, Files.getFileExtension(this.imageLocation), outputImageFileLocation);
            System.out.println("Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runRotateCCW() {
        BufferedImage transformedImage = new BufferedImage(this.image.getHeight(), this.image.getWidth(), this.image.getType());
        for(int i = 0; i < this.image.getWidth(); i++) {
            for(int j = 0; j < this.image.getHeight(); j++) {
                transformedImage.setRGB(j, i, this.image.getRGB(i, j));
            }
        }
        try {
            File outputImageFileLocation = new File(this.exportLocation);
            ImageIO.write(transformedImage, Files.getFileExtension(this.imageLocation), outputImageFileLocation);
            System.out.println("Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
