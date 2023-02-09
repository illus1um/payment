import Applications.*;
import controrllers.CarController;
import controrllers.PersonController;
import data.PostgresDB;
import data.PostgresDBCar;
import data.interfaces.DB;
import repositories.CarRepositories;
import repositories.PersonRepositories;
import repositories.interfaces.ICarRepository;
import repositories.interfaces.IPersonRepository;
import CarStore.*;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ManageOfRequest {

    private   Scanner sc;
    public  ManageOfRequest (){
        sc = new Scanner(System.in);
    }
    public  void Requests () {


        while (true) {
            System.out.println();
            System.out.println("Welcome to  CarCity");
            System.out.println("Select option:");
            System.out.println("1. Buy a car");
            System.out.println("2. Insert new part of cars");
           // System.out.println("3. Manager");
            System.out.println("0. Exit");
            System.out.println();


            try {
                System.out.print("Enter option (1-2): ");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        connectToApp();
                        break;
                    case 2:
                        createRandomCars();
                    default:
                        return;
                }

            }catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                sc.nextLine();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("--------------------");
        }
    }
    public  void  connectToApp() throws SQLException, ClassNotFoundException {

        System.out.println("--------------------");
        System.out.println("Please Log in");
        System.out.println("--------------------");

        connectToDataBase(1);
    }
    public  void createRandomCars () throws SQLException, ClassNotFoundException {
        Random random =  new Random(System.nanoTime());
        CarStore carStore =  new CarStore();

        for (int i = 0; i < 15; i++) {
            int n = 1 + random.nextInt(4);
            switch (n) {
                case 1:
                    carStore.add(new Lexus("Lexus LX 570", carStore.getRandomMileAge(), carStore.getRandomReleaseCar(), 153456));
                    break;
                case 2:
                    carStore.add(new Mercedes("Mercedes W 222", carStore.getRandomMileAge(), carStore.getRandomReleaseCar(), 120465));
                    break;
                case 3:
                    carStore.add(new Suzuki("Suzuki GrandV", carStore.getRandomMileAge(), carStore.getRandomReleaseCar(), 53456));
                    break;
                case 4:
                    carStore.add(new Toyota("Toyota Camry 50", carStore.getRandomMileAge(), carStore.getRandomReleaseCar(), 74289));
                    break;
            }
        }

        for  (Car car : carStore.getCars()){
                MyApplication2.addForCar(car);
        }

        connectToDataBase(2);
    }
    private  void  connectToDataBase(int n) throws SQLException, ClassNotFoundException {



        switch (n){
            case 1:
                DB db = new PostgresDB();
                db.createConnection();
                IPersonRepository repository = new PersonRepositories(db);
                PersonController controller = new PersonController(repository);
                MyApplication app = new MyApplication(controller);
                app.start();
                break;
            case 2:
                DB db2 = new PostgresDBCar();
                db2.createConnection();
                ICarRepository repository2 =  new CarRepositories(db2);
                CarController carController =  new CarController(repository2);
                MyApplication2 app2 = new MyApplication2(carController);
                app2.start();
                break;
            default:
        }
    }
}
