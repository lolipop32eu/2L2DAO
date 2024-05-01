package pckg1.service;

import pckg1.model.People;

import java.sql.SQLException;
import java.util.List;

public interface PeopleService {
    //CRUD create read upd...
    void createPeople(int id,String last_name,String first_name,String second_name,String sex, String birthday);
    People getPeopleById(int id);
    void updatePeopleById(int id,String last_name,String first_name,String second_name,String sex, String birthday);
    void removePeopleById(int id);
    List<People> getAllPeople() throws SQLException;
}
