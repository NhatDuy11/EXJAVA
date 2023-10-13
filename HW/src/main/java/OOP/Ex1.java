package OOP;

public class Ex1 {
    public static int tinhTong (int a , int b ){
        return a + b;
    }
    public  static int tinhTru(int c, int d){
        return c - d;
    }

    public static void main(String[] args) {
        int c = tinhTong(3,5);
        System.out.println(c);
        int e = tinhTru(10,6);
        System.out.println(e);

    }
}
