import java.util.Scanner;

public class ExampleString {
    public static void main(String[] args) {
        String chuoi;
        char Kitu;
        boolean tonTai =false ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao mot chuoi : ");
        chuoi = sc.nextLine();
        System.out.println("Nhap vao mot chuoi kiem tra : ");
        Kitu = sc.nextLine().charAt(0);
        char mangkiTu [] = chuoi.toCharArray();
        for ( int i =0 ; i<mangkiTu.length ; i++){
            if (Kitu == mangkiTu[i]){
                System.out.println("YES");
                tonTai = true;

            }
        }
        if (tonTai == false){
            System.out.println("FALSE");
        }



    }
}
