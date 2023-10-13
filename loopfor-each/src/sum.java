import java.util.Scanner;

public class sum {
    public static void main(OnlyString[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập giá trị vào : ");
        int num , sum = 0;
        num = scanner.nextInt();
        for(int i = 1; i<=num;i++){
            sum=sum+i;


        }
        System.out.println("Tổng các số tự nhiên :" + num + "là :"+sum);
    }
}
