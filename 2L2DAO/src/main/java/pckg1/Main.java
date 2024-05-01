package pckg1;

import pckg1.util.ConnectionUtil;

import java.sql.*;

public class Main {
    //pgAdmin
    public static void main(String[] args)  {
        //String url = "jdbc:postgresql://localhost:5432/postgres";// так хранить данные противопоказано
        //String username ="postgres";// хранить данные следует в отдельном файле расширения yml, или .properties
       // String pswrd = "LAck321laurus";//

       try(Connection connection = ConnectionUtil.getConn(); // КОНСТРУКЦИЯ TRY С РЕСУРСАМИ(AUTOCLOSABLE)
           Statement statement = connection.createStatement()){// с помощью этого интерфейса осуществляем формирование запроса к источнику данных
            System.out.println(connection.getSchema()); // выводит название схемы
//
            ResultSet resultSet = statement.executeQuery("select * from people;");//!!! ПРИЕМ ЗНАЧЕНИЙ ИЗ ТАБЛИЦЫ, ОДНАКО ОН ПОРОЖДАЕТ ЦЕЛУЮ КУЧУ ЛИШНЕГО КОДА
            while (resultSet.next()){ // пробег по строкам
            int id = resultSet.getInt("id");
            String name = resultSet.getString("first_name");
                System.out.println(id+" "+name);
           //
            }
       }
       catch (SQLException e) {
           throw new RuntimeException(e);
       }
        // открыли новое соединение
        String query = "select id, first_name from people where id between ? and ?"; // все фильмы из заданного промежутка id
        try(Connection connection = ConnectionUtil.getConn(); // КОНСТРУКЦИЯ TRY С РЕСУРСАМИ(AUTOCLOSABLE)
            PreparedStatement statement = connection.prepareStatement(query)) { //открывать дважды соединение
            // в 1 программе крайне не рекомендуется, поскольку это сильно нагружает систему, но в качестве примера можно
            statement.setLong(1,3);
            statement.setLong(2,6);
            ResultSet rs = statement.executeQuery(); // вывод как помним resultSet
            while(rs.next()){
                System.out.println(rs.getInt("id")+" "+ rs.getString("first_name"));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // приложение не соответствует шаблону DAO
    }
}
