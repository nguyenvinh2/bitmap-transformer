# bitmap-transformer

## Intro

This application transforms input images based on several pre selected options

## Instructions

Clone this folder to your local desktop. Navigate to the root directory
of this project using the CLI. To run the application, type in the following
command:

        ./gradlew run --args '{Input Image Location} {Output Image Location} {Transform Option}'
        
        Input Image Location: replace with the directory location of the image you want to be tranformed
        Output Image Location: replaced with the directory location of the transformed image you program to send to
        Transform Option:
            invert - inverts the color of the selected image
            border - adds a 5 pixel thick border around the image
            rotateCCW - rotate the image CCW by 90 degrees
            grayscale - removes colors (everything is a shade of gray)
            
## Technology

    Gradle
    JUnit
    Java 8
    IntelliJ