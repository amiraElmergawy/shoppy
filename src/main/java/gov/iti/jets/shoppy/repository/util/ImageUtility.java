package gov.iti.jets.shoppy.repository.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public enum ImageUtility {
    INSTANCE;
    private final String path = this.getClass().getResource("/products").getPath();
    /**
     *
     * @param productId, images
     * @return
     */
    public boolean saveImages(Integer productId) {
        // create folder with productId as name at path
        // put images inside the folder
        return false;
    }

    public List<String> loadImages(Integer productId) {
        String folderName = productId + "";
        File[] listOfFiles = new File(path + "/" + folderName).listFiles();
        List<String> images = new ArrayList<>();
        if (listOfFiles == null) {
            folderName = "default";
            listOfFiles = new File(path + "/" + folderName).listFiles();
        }
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                images.add(folderName +"/"+listOfFiles[i].getName());
            }
        }
        return images;
    }

    public static void main(String[] args) {
        INSTANCE.loadImages(1);
    }
}
