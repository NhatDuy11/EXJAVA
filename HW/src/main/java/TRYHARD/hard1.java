package TRYHARD;

import java.util.Scanner;

public class hard1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num , sum = 0;
        System.out.println("Nhập giá trị số nguyên :");
        num = sc.nextInt();
        for (int i = 0 ; i<=num;i++){
            //
            sum = sum +i;
            // = 0+1 =1 ,2+1=3
            System.out.println("Gía trị tong là : "+ sum);
        }
    }


}
