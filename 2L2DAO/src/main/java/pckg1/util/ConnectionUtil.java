package pckg1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil { // обычно ключевые функции выносятся в отдельный класс, который содержится в папке util
   // private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
   // private static final String USERNAME ="postgres";// хранить данные следует в отдельном файле расширения yml, или .properties
   // private static final String PSWRD = "LAck321laurus";
    // хранение таких ресурсов как пароли имена ссылки в этом файле - ФАТАЛЬНАЯ ОШИБКА
    // их необходимо хранить в отдельной "ресурсной" папке c особым именем aplication.properties
    // поля в нем записываются построчно без разделителей ;
   private static final String URL ="db.url";
    private static final String USERNAME ="db.name";
    private static final String PSWRD ="db.pass";
   public static Connection getConn(){
        try {
            return DriverManager.getConnection(
                    PropUtil.getProperty(URL), // получает значения по соответствующим ключам из application
                    PropUtil.getProperty(USERNAME),
                    PropUtil.getProperty(PSWRD)
            );
        }catch (SQLException E){
            throw new RuntimeException();
        }
    }
}
