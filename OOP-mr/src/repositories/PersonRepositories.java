package repositories;

import data.interfaces.DB;
import entities.Person;
import repositories.interfaces.IPersonRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PersonRepositories implements IPersonRepository {
    private  final DB db ;
    public  PersonRepositories (DB db){
     this.db = db;
    }

    @Override
    public boolean createUser(Person person) {
             Connection con = null;
        try{
            con = db.createConnection();
            String sql ="INSERT INTO person (name, surname, email , income , age ) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setDouble(4, person.getIncome());
            preparedStatement.setInt(5, person.getAge());

            preparedStatement.execute();
            return  true;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Person getUser(int id) {

        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname, email, income ,age FROM person WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                Person person = new Person(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        rs.getDouble("income"),
                        rs.getInt("age")
                );

                return person;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Person> getAllUsers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname, email, income ,age  FROM person";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            List<Person> people = new LinkedList<>();

            while (rs.next()) {
                Person person = new Person(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        rs.getDouble("income"),
                        rs.getInt("age")
                );

                people.add(person);
            }

            return people;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Person checkExistPerson(String name , String surname , int age) {
//        Connection con =  null;
//
//        try {
//             con = db.getConnection();
//
//             String sql = "SELECT * FROM person WHERE name=?";
//
//            PreparedStatement st = con.prepareStatement(sql);;
//
//             st.setString(1, name);
//
//
//             ResultSet rs  = st.executeQuery();
//             if (rs.next()){
//
//                Person person =  new Person(
//                    rs.getInt("id"),
//                    rs.getString("name"),
//                    rs.getString("surname"),
//                    rs.getString("email"),
//                    rs.getDouble("income"),
//                    rs.getInt("age"));
//
//                 return person;
//             }
//        }catch (SQLException sqlException){
//            sqlException.printStackTrace();
//        }catch (ClassNotFoundException e){
//            e.getMessage();
//        }
        return null;
    }
}
