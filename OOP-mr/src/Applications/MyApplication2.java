package Applications;

import CarStore.Car;
import Loan.InstallmentPlan;
import controrllers.CarController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MyApplication2 {

    private  final CarController carController;

    private  final Scanner scanner;
    public  static List<Car> cars =  new ArrayList<>();


    public  MyApplication2 (CarController carController){
        this.carController = carController;
        scanner = new Scanner(System.in);
    }
    public static  void addForCar (Car car){
        cars.add(car);
    }
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Admin Operations");
            System.out.println("Select option:");
            System.out.println("1. Get all Cars");
            System.out.println("2. Get car by id");
            System.out.println("3. Create CarMenu");
            System.out.println("4. Insert CarMenu");
            System.out.println("5. Take a loan");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-5): ");
                int option = scanner.nextInt();
                switch (option){
                    case 1:getAllCarMenu();break;
                    case 2:getCarByIdMenu();break;
                    case 3:createCarMenu();break;
                    case 4:insertCarMenu();break;
                    case 5:takeACarforLoan();break;
                    default: return;
                }

            }catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("--------------------------");

        }
    }
    public void takeACarforLoan() {
        System.out.println("Choose a car, enter id:");
        System.out.println(carController.getAllCarController());
        double price = 0;
        int id = scanner.nextInt();
        if (id == 1) {
            price = carController.getCarForLoan(1);
        }
        System.out.println("Choose a percentage");
        double percentage = scanner.nextDouble();

        System.out.println("Choose a year");
        int year = scanner.nextInt();
        InstallmentPlan installmentPlan = new InstallmentPlan(price, percentage, year); //
        System.out.println(installmentPlan.calculateMonthlyPayment());
    }


    public  void getAllCarMenu(){
        String response = carController.getAllCarController();
        System.out.println(response);
    }
    public  void getCarByIdMenu(){
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = carController.getCarByIdController(id);
        System.out.println(response);
    }
    public void createCarMenu(){
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter mileage");
        int mileage = scanner.nextInt();
        System.out.print("Enter date (yyyy-MM-dd): ");
        String release_date = scanner.next();
        LocalDate date = LocalDate.parse(release_date, DateTimeFormatter.ISO_DATE);
        System.out.println("Please enter price");
        double price = scanner.nextDouble();

        String response = carController.createCarByController(name , mileage ,  date , price);
        System.out.println(response);
    }
    public void  insertCarMenu(){
        for (Car c:  cars){
            String response = carController.insertCarController(c.getName(), c.getMileage() , c.getReleaseDate() , c.getPrice());
            System.out.println(response);
        }
    }
}
