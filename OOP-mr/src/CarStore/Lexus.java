package CarStore;

import java.time.LocalDate;

public class Lexus extends  Car{

    public  Lexus (String name,int mileage, LocalDate releaseDate , double price){
        super(name, mileage, releaseDate, price);
    }
    @Override
    public String techInspection() {
        return null;
    }
}
