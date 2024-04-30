package pckg1;

import pckg1.util.ConnectionUtil;

import java.sql.*;

public class Main {
    //pgAdmin
    public static void main(String[] args)  {
        //String url = "jdbc:postgresql://localhost:5432/postgres";// так хранить данные противопоказано
        //String username ="postgres";// хранить данные следует в отдельном файле расширения yml, или .properties
       // String pswrd = "LAck321laurus";//
       try(Connection connection = ConnectionUtil.getConn();
           Statement statement = connection.createStatement()){// с помощью этого интерфейса осуществляем формирование запроса к источнику данных

           System.out.println(connection.getSchema()); // выводит название схемы

            ResultSet resultSet = statement.executeQuery("select * from people;");//!!! ПРИЕМ ЗНАЧЕНИЙ ИЗ ТАБЛИЦЫ, ОДНАКО ОН ПОРОЖДАЕТ ЦЕЛУЮ КУЧУ ЛИШНЕГО КОДА
            while (resultSet.next()){ // пробег по строкам
            int id = resultSet.getInt("id");
            String name = resultSet.getString("first_name");
                System.out.println(id+" "+name);
            }
       }
       catch (SQLException e) {
           throw new RuntimeException(e);
       }
        // оно бросает проверяемое исключение а потому его надо обработать
        //try с ресурсами сам закрывает ресурс в конце

        // connection.close(); - так Conncection, может быть закрыт как ресурс AutoClosable
    }
}
