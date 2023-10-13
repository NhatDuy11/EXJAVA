package OOP;

public class EX5 {
   public static  int myvariale = 32;

   public static  void Statmicmethod(){
       System.out.println("hello static");
   }

    public static void main(String[] args) {
        int x = EX5.myvariale;
        System.out.println(x);
        EX5.Statmicmethod();
    }

}
