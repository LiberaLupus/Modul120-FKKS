package sample.Functions;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;

public class ResourceManager {
    public static Image loadImage(String name) {

        return new Image(ResourceManager.class.getResource(name).toString());
    }

    public File [] ordnerinhalt(){
        File dir = new File("C:\\" + "FKKS-Bilder");
        dir.mkdir();
        File f = new File("C:\\FKKS-Bilder");
        File[] fileArray = f.listFiles();

        try {
            for(File element : fileArray) {
                System.out.println(element);
            }
        }catch (Exception java){

        }


        return fileArray;

    }
}
