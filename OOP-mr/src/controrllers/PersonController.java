package controrllers;

import entities.Person;
import repositories.interfaces.IPersonRepository;

import java.util.List;

public class PersonController {
        private   final IPersonRepository personRepository;

        public  PersonController (IPersonRepository personRepository){
                this.personRepository = personRepository;
        }
        public String createPerson (String name , String  surname , String email , double income ,  int age ){

                Person person  =  new Person(name , surname , email  ,  income ,age);

                return  personRepository.createUser(person) ? "User was created!" : "User creation was failed!";
        }
        public String getPerson(int id) {
                Person person = personRepository.getUser(id);

                return (person == null ? "User was not found!" : person.toString());
        }

        public String getAllPeople() {
                List<Person> people = personRepository.getAllUsers();
                return people.toString();
        }
        public  String checkExistPerson(String name, String  surname, int age){
                Person person = personRepository.checkExistPerson(name , surname , age);
                return  (person == null ? "User was not found!" : person.toString());
        }
}
