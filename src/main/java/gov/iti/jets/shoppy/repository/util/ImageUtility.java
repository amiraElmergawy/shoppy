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
//      this.path = System.getProperty("user.dir").replace("\\", "/") + "/products/";
        this.path = "C:/upload/products/";
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
        System.out.println("image utility" + path);

        List<String> images = new ArrayList<>();
        String folderName = productId + "";
        File[] listOfFiles = new File(path + folderName).listFiles();
        if (listOfFiles == null) {
            folderName = "default";
            listOfFiles = new File(path + folderName).listFiles();
        }
        for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++)
            if (listOfFiles[i].isFile())
                images.add("/" + path + folderName + "/" + listOfFiles[i].getName());
        return images;
    }

}
