import java.util.InputMismatchException;
import java.util.Scanner;

public class tryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn bao nhiêu tuổi:");
       try{
           int age = scanner.nextInt();
           System.out.println("nhap tuoi cua ban:"+age);
       }
       catch (InputMismatchException ime){
           System.out.println("Vui lòng nhập số : ");
       }
        System.out.println("Kết thúc chương trình");
    }
}
