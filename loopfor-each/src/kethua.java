
class Employee{
    String name = "Duy";
    public  void eat(){
        System.out.println("eat kingbbq");
    }
}
class bike extends  Employee {
    String bikesyes = "honda";
}

public class kethua {


    public static void main(String[] args) {
        bike v1 = new bike();
        System.out.println(v1.name);
        v1.eat();
       
    }
}
