
package TRYHARD;


import java.util.Scanner;


public class Hard3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hight;
        System.out.println("/n Nhập giá trị chiều cao của tam giác :" );
        hight = sc.nextInt();
        for (int i = 1 ; i<= hight ; ++i) {
            for(int j =1 ; j<=i;++j) {
                System.out.println("* ");
            }
        }
        System.out.println();

        System.out.println("n--------------------------------------------------");

    }

}
