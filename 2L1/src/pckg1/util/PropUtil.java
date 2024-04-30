package pckg1.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class PropUtil {
    // данный класс отвечает за то чтобы доставать данные из файла application
    public static final Properties PROPERTIES = new Properties();

    static { // ДЛЯ ИСПОЛНЕНИЯ ЕДИНОЖДЫ, КОГДА ЗАГРУЖАЕТСЯ КЛАСС
        getProps();
    }

    public static String getProperty(String key){
        return PROPERTIES.getProperty(key); // закинули эти проперти в вывод функции
    }
    public static void getProps(){
      try (InputStream propsStream = PropUtil.class.getClassLoader().getResourceAsStream("application.properties")){
          PROPERTIES.load(propsStream);
      }catch (IOException e){
          throw new RuntimeException(e);
      }
    // загрузка строчек из файла application в поток, getClassLoader - получает ссылку на загрузчик класса и загружает ресурсы
        // по ссылке
    }
}
