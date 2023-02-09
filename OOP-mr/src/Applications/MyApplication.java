package Applications;

import Loan.InstallmentPlan;
import controrllers.PersonController;
import CarStore.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {


    private  final PersonController controller;
     private  final Scanner scanner;
    public  MyApplication (PersonController controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }
     public void start() {
        while (true) {
            System.out.println();
            System.out.println("Admin Operations");
            System.out.println("Select option:");
            System.out.println("1. Get all people");
            System.out.println("2. Get person by id");
            System.out.println("3. Sign up");
            System.out.println("4. Sign in");
             System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                switch (option){
                    case 1:getAllPeopleMenu();break;
                    case 2:getPersonByIdMenu();break;
                    case 3:createPersonMenu();break;
                    case 4:checkPersonExist();break;
                    default: return;
                }

            }catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("---------------------------------------------------");

        }
    }



    public void getAllPeopleMenu() {
        String response = controller.getAllPeople();
        System.out.println(response);
    }

    public void getPersonByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getPerson(id);
        System.out.println(response);
    }

    public void createPersonMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter email");
        String email = scanner.next();
        System.out.println("Please enter your income");
        double income = scanner.nextDouble();
        System.out.println("Please enter age");
        int  age = scanner.nextInt();


        String response = controller.createPerson(name, surname, email , income , age );
        System.out.println(response);
    }
    public void checkPersonExist (){
        System.out.println("Please enter name");
        String name =  scanner.next();
        System.out.println("Please enter surname");
        String surname = scanner.next();
        System.out.println("Please enter age");
        int  age  = scanner.nextInt();

        String response = controller.checkExistPerson(name , surname , age);
        System.out.println(response);
    }
}
