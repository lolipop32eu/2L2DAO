package pckg1;

import pckg1.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = ConnectionUtil.getConn(); // КОНСТРУКЦИЯ TRY С РЕСУРСАМИ(AUTOCLOSABLE)
            Statement statement = connection.createStatement()){
           int res = statement.executeUpdate("insert into people (last_name, first_name,second_name,sex)"+
                   "values( 'PETR','Tolstoy','Igorevich','m')");

            }
        }
    }

