 class Person{
    private  String name ;
    private  int age;
    public Person(String name , int age){
        this.age =age;
        this.name = name;

    }
    public String getName(){
        return name;
    }
    public  int getAge(){
        return age;
    }
    @Override
    public String toString(){
        return "Person [name = " + name +  ", age=" +age + "]";
    }




}
public class cast {



    public static void main(String[] args) {
            Person[] people = new Person[3];
            people[0] = new Person("DUY",23);
            people[1] = new Person("LOI",22);
            people[2] = new Person("HOA",24);
            for (Person person :people){
                System.out.println("Name : "  + person.getName() + "Age :   " + person.getAge() );
            }
        }
    }

