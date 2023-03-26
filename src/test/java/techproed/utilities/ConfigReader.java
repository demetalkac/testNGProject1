package techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    //This class reads the configuration.properties file
    //Create Properties instance-property file’ı okumak için properti objecsi kullanılır
    private static Properties properties;
//  static block : ilk "static block" calısır
    static {
        //path of the configuration file- data cekmek istedigimiz dosyanın path'i
        String path="configuration.properties";
        try {
            //Opening configuration.properties file using FileInputStream
            FileInputStream fileInputStream = new FileInputStream(path);
            //properties objesini instantiate8deger atamak) ediyoruz
            properties = new Properties();
            //configuration.properties dosyasında olan dataları yukleme yapar
            properties.load(fileInputStream);
            //close the file
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//NOT: "FileInputStream()", "load()" ve "close()" fonksiyonları compare time exception verir. Bu sorunu ya try-catch
//      ile yada method signature'a exception koyarak cozulur.
    }

    //This method will get the key from properties file,
    //And return the value as String
    //We create this method to read the file
    //Yani bu method configuration.properties'in icine koyduklarımızı key-value olarak alabilmemize yarar.
    // Ornek:ConfigReader.gertProperty("browser"); ->chrome
    public static String getProperty(String key){
        String value=properties.getProperty(key);
        return value;
    }
    //TEST IF LOGIC WORKS
//    public static void main(String[] args) {
//        System.out.println(properties.getProperty("qa_environment"));
//    }
}
