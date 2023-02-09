package CarStore;

import CarStore.interfaces.ICar;

import java.time.LocalDate;

public  class Car implements ICar {
    private  int id;
    private String name ;

    private int mileage;
    private LocalDate releaseDate;

    private double price;

    public Car (){};

    public  Car(int  id , String name ,int mileage,  LocalDate releaseDate ,  double price){
        setId(id);
        setMileage(mileage);
        setPrice(price);
        setReleaseDate(releaseDate);
        setName(name);
    }
    public  Car(String name ,int mileage,  LocalDate releaseDate ,  double price){
        setMileage(mileage);
        setPrice(price);
        setReleaseDate(releaseDate);
        setName(name);

    };

    public  Car(String name ,int mileage, double price){
        setMileage(mileage);
        setPrice(price);
        setReleaseDate(releaseDate);
        setName(name);

    };

    public  void  setId (int id){
        this.id =  id;
    }
    public  int getId (){
        return  id;
    }
    public  void  setName (String name ){
        this.name =  name;
    }
    public String getName (){
        return name;
    }
    public  void setMileage (int mileage){
        this.mileage = mileage;
    }
    public  int getMileage (){
        return  mileage;
    }

    public void  setReleaseDate (LocalDate releaseDate){
        this.releaseDate =  releaseDate;
    }
    public  LocalDate getReleaseDate(){
        return  releaseDate;
    }
    public void  setPrice (double price ){
        this.price = price;
    }
    public  double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Car|" +
                "id [" + id + "]"+' '+
                "name [" + name + "]"+ ' ' +
                "mileage [" + mileage +"]"+ ' '+
                ", releaseDate [" + releaseDate +"]"+
                ", price [" + price +"]"+
                '|';
    }

    @Override
    public String techInspection() {
        return null;
    }
}
