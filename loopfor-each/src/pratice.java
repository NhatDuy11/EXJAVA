import java.util.Scanner;

public class pratice {
    // tinh tong cac so nguyen duong n ,tinh tong cac so chan trong khoang tu 0 - n
    public static void main(OnlyString[] args) {
//        int n;
//        int sum = 0 ;
//        System.out.println("Nhập vào số nguyên : " );
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        for (int i = 0 ; i <=n; i++){
//            if (n %2 == 0){
//                sum +=i;
//                System.out.println(sum);
//            }
//        }
        int k ;
        int sum = 0 ;
        System.out.println("Nhập vào một sô nguyên : ");
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        for ( int i = 0 ; i <= k ; i ++) {
            if (k % 2 == 0){
                sum = sum+i;
                System.out.println(sum);
            }
        }
    }
}
