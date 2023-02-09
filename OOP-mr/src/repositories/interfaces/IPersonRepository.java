package repositories.interfaces;

import entities.Person;

import java.util.List;

public interface IPersonRepository {
    boolean createUser(Person  person);
    Person getUser(int id);
    List<Person> getAllUsers();

    Person checkExistPerson(String name , String  surname , int age);
}
