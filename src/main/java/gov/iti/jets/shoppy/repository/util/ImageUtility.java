package gov.iti.jets.shoppy.repository.util;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImageUtility {
    private static final ImageUtility imageUtility = new ImageUtility();
    private String path;

    private ImageUtility(){
        try {
            this.path = new URI(getClass().getResource("/products").toString()).getPath();
        } catch (URISyntaxException e) {
            System.out.println("Exception happened when loading product images paths");
        }
    }

    public static ImageUtility getInstance() {
        return imageUtility;
    }

    public boolean saveImages(Integer productId) {
        // create folder with productId as name at path
        // put images inside the folder
        return false;
    }

    public List<String> loadImages(Integer productId) {
        List<String> images = new ArrayList<>();
        String folderName = productId + "";
        File[] listOfFiles = new File(path + folderName).listFiles();
        if (listOfFiles == null) {
            folderName = "default";
            listOfFiles = new File(path + folderName).listFiles();
        }
        for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++)
            if (listOfFiles[i].isFile())
                images.add(folderName + "/" + listOfFiles[i].getName());
        return images;
    }

}
