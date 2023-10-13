public class MathUtils {
    public static int add(int a , int b){
        System.out.println(a+b);
        return a + b ;
    }
    public static  int Factorial(int n ){
        if ( n <=0){
            return 1;
        }
        return  n * Factorial(n -1 );
    }
     public static  void messsage(){
        System.out.println("Resarch static and void");
    }
    static   void min(int [] arr) {
        int min = arr[0];
        for ( int i = 1; i <arr.length ;i ++) {
            if (min > arr[i]){
                min = arr[i];
            }
            System.out.println(min);
        }

    }
    interface Shape {
        double getArea();
        double getPrimeter();

    }

//    class Circle implements Shape{
//        private double radius;
//        public  Circle(double radius) {
//            this.radius = radius;
//
//        }
//
//
//    }


    public static void main(String[] args) {
        MathUtils.add(3,4);
        int fact = MathUtils.Factorial(5);
        System.out.println("Factorial : " + fact);
        messsage();
        int a [] = {33, 3, 4, 5};
        min(a);


    }
}
