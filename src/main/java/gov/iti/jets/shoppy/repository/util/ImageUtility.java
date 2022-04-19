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
//      this.path = System.getProperty("user.dir").replace("\\", "/") + "/products/";
        this.path = "C:/upload/products/";
    }

    public static ImageUtility getInstance() {
        return imageUtility;
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
                images.add("/" + path + folderName + "/" + listOfFiles[i].getName());
        return images;
    }

    public boolean saveImages(Integer productId, List<String> encodedImages) {
        StringBuilder imgPath;
        try {
            String folderPath = createFolder(productId);
            for(int i = 0;i < encodedImages.size(); i++){
                String []array = encodedImages.get(i).split(",");
                imgPath = new StringBuilder();
                imgPath.append(folderPath)
                        .append("/")
                        .append(i)
                        .append(".")
                        .append(getImageExtension(array[0]));
                writeImageToDisk(imgPath.toString(), array[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean writeImageToDisk(String path, String encodedString) {
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

    private String createFolder(Integer productId) throws IOException {
        String folderPath = path + productId;
        if (Files.exists(Path.of(folderPath))) {
            FileUtils.cleanDirectory( new File(folderPath));
        } else {
            new File(path + productId).mkdir();
        }
        return folderPath;
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

}
