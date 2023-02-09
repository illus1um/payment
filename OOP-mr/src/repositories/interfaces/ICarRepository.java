package repositories.interfaces;

import CarStore.Car;

import java.util.List;

public interface ICarRepository {
    boolean createCar (Car car);

    boolean insertCars(Car car);

    List<Car> getAllCars ();

    Car getCarById (int id);
}
