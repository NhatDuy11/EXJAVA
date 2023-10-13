public class BankAccount {
    private  double balances = 0 ;
    public  void despoit(double x ){
        if (x > 0) {
            this.balances +=x;
        }

    }
    class Employe{
        String name = "Duy";

    }
    class motobike extends Employe{

        String motoike = "SH";
    }



    public static void main(String[] args) {
        var yourAcc = new BankAccount();
        yourAcc.balances +=500;
        yourAcc.despoit(500);
        System.out.println(" " + yourAcc.balances);


    }
}

