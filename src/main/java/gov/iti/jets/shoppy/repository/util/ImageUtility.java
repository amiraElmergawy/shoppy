package gov.iti.jets.shoppy.repository.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
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

    public boolean saveImages(Integer productId, List<String> encodedImages) {
        System.out.println("hehe");
        try {
            createFolder(productId);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for(int i = 0;i < encodedImages.size(); i++){
//            String []array = encodedImages.get(i).split(",");
//            StringBuilder imgName = new StringBuilder();
//            imgName.append(getImageExtension(array[0])).append(array[1]);
//            writeImageToDisk(, array[1]);
//        }
        return false;
    }

    private void createFolder(Integer productId) throws IOException {
        if (Files.exists(Path.of(path))) {
            FileUtils.cleanDirectory( new File(path + productId));
        } else {
            new File(path + productId).mkdir();
        }
    }

    private String getImageExtension(String imageInfo) {
        int i = 0;
        StringBuilder str = new StringBuilder();
        boolean flag = false;
        while(i < imageInfo.length()) {
            if(imageInfo.charAt(i) == '/')
                flag = true;
            else if(imageInfo.charAt(i) == ';')
                break;
            else if(flag)
                str.append(imageInfo.charAt(i));
            i++;
        }
        return str.toString();
    }

    public boolean writeImageToDisk(String path, String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        boolean written = false;
        try {
            File file = new File(path);
            FileUtils.writeByteArrayToFile(file, decodedBytes);
            written = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return written;
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
