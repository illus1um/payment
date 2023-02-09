import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import CarStore.*;

public class CarStore {
    private List<Car> cars=  new ArrayList<>();

    public void  add (Car car){
        cars.add(car);
    }
    public  List<Car> getCars (){
        return cars;
    }
    public LocalDate getRandomReleaseCar () {
        Random random = new Random(System.nanoTime());
        int year =  1 +  random.nextInt(30);
        int month =  1 + random.nextInt(12);
        int days  = 1 + random.nextInt(365);
        return LocalDate.now().minusYears(year).minusMonths(month).minusDays(days);
    }
    public  int getRandomMileAge(){
        Random random = new Random();
        int mult = 1 + random.nextInt(5);
        int mileage  = 10000 * mult + random.nextInt(80000);
        return mileage;
    }
}
