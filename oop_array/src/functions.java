public class functions {
    public static void main(String[] args) {
        int nhan = multiplier(300,400);
        System.out.println(nhan);


        functions function = new functions();
        function.Boo();
        int [] number = {1,2,3,4,5,6,7};
        float avg = average(number);
        System.out.println(avg);


    }
    public  static int multiplier (int a , int b){
        int multiplier1 = a*b;
        return multiplier1;
    }
    // syntax của phương thức: *public stataic : acces_modifier , *int là  kiểu,add() add là name ,(params truyền vào)constructer

    public static  float average(int[]arr){
        int sum = 0;
        for(int i :arr){
            sum+=i;


        }
        return  (float) sum/ arr.length;

    }
    public static void Boo(){
        System.out.println("ádasdsasđs");
    }
}
