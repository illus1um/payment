package repositories;

import CarStore.Car;
import data.interfaces.DB;
import entities.Person;
import repositories.interfaces.ICarRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CarRepositories implements ICarRepository {

    private  final DB db;

    public  CarRepositories (DB db){
        this.db =  db;
    }

    @Override
    public boolean createCar(Car car) {
        Connection con = null;
        try{

            con = db.createConnection();
            String sql ="INSERT INTO car (name, mileage, release_date, price  ) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, car.getName());
            preparedStatement.setInt(2, car.getMileage());
            preparedStatement.setDate(3, Date.valueOf(car.getReleaseDate()));
            preparedStatement.setDouble(4, car.getPrice());

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
    public boolean insertCars(Car car) {
        Connection con = null;
        try{

            con = db.createConnection();
            String sql ="INSERT INTO car (name, mileage, release_date, price  ) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, car.getName());
            preparedStatement.setInt(2, car.getMileage());
            preparedStatement.setDate(3, Date.valueOf(car.getReleaseDate()));
            preparedStatement.setDouble(4, car.getPrice());

            preparedStatement.execute();

            System.out.println("Data inserted successfully.");
            return  true;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public List<Car> getAllCars() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT *  FROM car";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            List<Car> cars = new LinkedList<>();

            while (rs.next()) {
                Car car = new Car(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("mileage"),
                        rs.getDate("release_date").toLocalDate(),
                        rs.getDouble("price")
                );
                cars.add(car);
            }
            System.out.println("----------------------------------------");
            for (Car c : cars){
                System.out.println(c);
            }
            System.out.println("----------------------------------------");
            return cars;
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
    public Car getCarById(int id) {

        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM person WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Car car = new Car(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("mileage"),
                        rs.getDate("release_date").toLocalDate(),
                        rs.getDouble("price")
                 );
                return car;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
