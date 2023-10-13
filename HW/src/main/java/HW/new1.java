package HW;

import java.util.Scanner;

public class new1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message ;
        System.out.println("Nhap vao gia tri");
        message = sc.nextLine();
        char [] Arraychar = message.toCharArray();
        for (int i = 0 ; i<Arraychar.length;i++){
            if (Arraychar[i] >= 65 && Arraychar[i] <=90){
                Arraychar[i] +=32;
            }
        }
        message=String.valueOf(Arraychar);
        System.out.println("Nhap gia tri sau khi thay doi :"+message);


    }
}
