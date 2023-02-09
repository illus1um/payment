package entities;

public class Person {
   private  int  id ;
   private  String name;
   private  String surname;
   private  String email;
   private  double income;
   private  int age;

   public  Person (){}

   public  Person (String name  , String surname  , String email , double income , int age){
         setName(name);
         setSurname(surname);
         setEmail(email);
         setIncome(income);
         setAge(age);
   }
   public  Person (int id  , String name  , String surname  , String email , double income , int age){
      setId(id);
      setName(name);
      setSurname(surname);
      setEmail(email);
      setIncome(income);
      setAge(age);
   }

   public void  setId (int id){
      this.id =  id;
   }
   public  int  getId (){
      return  id;
   }
   public void   setName  (String name ){
      this.name = name;
   }
   public String getName  (){
      return  name;
   }
   public void   setSurname  (String surname ){
      this.surname =surname;
   }
   public String getSurname  (){
      return  surname;
   }
   public void   setEmail  (String email ){
      this.email = email;
   }
   public String getEmail  (){
      return  email;
   }
   public  void  setIncome (double income){
      this.income = income;
   }
   public  double getIncome (){
      return  income;
   }
   public  void  setAge (int age){
      this.age = age;
   }
   public  int getAge (){
      return  age;
   }

   @Override
   public String toString() {
      return "Person{" +
              "id[" + id + "]"+
              ", name[" + name + "]" + '\'' +
              ", surname[" + surname+"]" + '\'' +
              ", email[" + email+ "]" + '\'' +
              ", income[" + income +"]"+
              ", age[" + age + "]"+
              '}';
   }
}
