public class PhepToan {
    public  static  int sum (int a , int b){
        return a + b;
    }
    public static int sum (int a ){
        return  a ;
    }
    public static int sum(){
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(sum(2,3));
        System.out.println(sum(0,3));
        System.out.println(sum(2,0));
        System.out.println(sum());

    }
}
