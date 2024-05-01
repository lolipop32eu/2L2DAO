package pckg1.service;

import pckg1.DAO.DAOPeople;
import pckg1.DAO.DAOPeopleImpl;
import pckg1.model.People;

import java.sql.SQLException;
import java.util.List;

public class PeopleServiceImpl implements PeopleService{ // непосредственная реализация БИЗНЕС ЛОГИКИ
    DAOPeople daoPeople = new DAOPeopleImpl();
    @Override
    public void createPeople(int id, String last_name, String first_name, String second_name, String sex, String birthday) {
        daoPeople.createPeople(id,last_name, first_name, second_name, sex, birthday);
    }

    @Override
    public People getPeopleById(int id) {
        return null;
    }

    @Override
    public void updatePeopleById(int id, String last_name, String first_name, String second_name, String sex, String birthday) {

    }

    @Override
    public void removePeopleById(int id) {

    }

    @Override
    public List<People> getAllPeople() throws SQLException {
        return daoPeople.getAllPeople();
    }
}
