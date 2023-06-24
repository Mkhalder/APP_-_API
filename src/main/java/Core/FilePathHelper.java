package Core;

import java.io.File;

public class FilePathHelper {
    public static final String dir = System.getProperty("user.dir");
    static File f = new File(dir);
    static String filepath = f.getParent();
    public static final String FilePathInCore= filepath+"\\APiHandel\\src\\main\\java\\repository\\localRepo";

    public static final String postApiPath = FilePathInCore+"\\post.json";


}
