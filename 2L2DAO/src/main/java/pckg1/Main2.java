package pckg1;

import pckg1.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = ConnectionUtil.getConn(); // КОНСТРУКЦИЯ TRY С РЕСУРСАМИ(AUTOCLOSABLE
            PreparedStatement ps = connection.prepareStatement("insert into people (last_name, first_name,second_name,sex)"+
                    "values( ?,?,?,?)")){ // позволяет заранее задавать шаблон ввода и тем самым обороняться от SQL- инъекций

            ps.setFetchSize(100);// число одновременно за раз обрабатываемых данных

            ps.setQueryTimeout(1); //время на обработку запроса

            ps.setMaxFieldSize(1000);// число всех данных

            ps.setString(1,"Petrov"); // принимает место, что поместить
            //..
            //..
            int res = ps.executeUpdate();

            }
        }
    }

