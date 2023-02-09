package controrllers;

import CarStore.Car;
import entities.Person;
import repositories.interfaces.ICarRepository;
import repositories.interfaces.IPersonRepository;

import java.time.LocalDate;
import java.util.List;

public class CarController {

    private  final ICarRepository carRepository;

    public  CarController (ICarRepository carRepository ){
        this.carRepository = carRepository;
    }
     public String createCarByController (String name , int mileage, LocalDate release_date , double price){

         Car car  =  new Car(name , mileage , release_date ,  price);
         return  carRepository.createCar(car) ? "User was created!" : "User creation was failed!";
    }

    public double getCarForLoan(int id) {
        Car car  = carRepository.getCarById(id);
        return (car == null ? 0 : car.getPrice());
    }

    public String getCarByIdController(int id) {
        Car car  = carRepository.getCarById(id);
        return (car == null ? "Car was not found!" : car.toString());
    }

    public String getAllCarController() {
        List<Car> cars = carRepository.getAllCars();
        return cars.toString();
    }
    public  String insertCarController(String name,  int mileage , LocalDate release_date , double price){
        Car car =  new Car(name ,mileage ,release_date , price);

         return  carRepository.insertCars(car)? "Market was created" : " Market creation was failed";
    }
}
