package OOP;

import java.util.Scanner;

public class Ex2 {
    static  String member;
    static String corporation ;
    public static  void ImpmemBer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Import in member :");
        member = sc.nextLine();
        System.out.println("Import in corporation: ");
        corporation = sc.nextLine();



    }
    public static void showInfo (){
        System.out.println("Result in member:"+member+"Reult in corporation : "+corporation);
    }

}
