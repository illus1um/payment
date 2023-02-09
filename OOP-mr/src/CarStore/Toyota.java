package CarStore;

import java.time.LocalDate;

public class Toyota extends  Car{
    public  Toyota (String name,int mileage, LocalDate releaseDate , double price){
        super(name, mileage, releaseDate, price);
    }
    @Override
    public String techInspection() {
        return null;
    }
}
