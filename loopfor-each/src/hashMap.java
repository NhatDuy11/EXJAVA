import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;







public class hashMap {


    public static void main(String[] args) {
        HashMap<String,Integer> points = new HashMap<String,Integer>();
        points.put("ID",1);
        points.put("VALUE",2);
        System.out.println(points.containsValue(1));


        ArrayList<String> cars = new ArrayList<String>();
        cars.add("BMW");
        cars.add("VOLVO");
        cars.add("honda");
        cars.add("Yaz");
        cars.add("Dream");
        System.out.println(cars.size());
        for (String car : cars){

          if ( car == "BMW") {
              System.out.println("BMW");
          }else {
              System.out.println("TAT CA LOAI XE");
          }
        }
        for ( int i = 0 ; i<cars.size();i++){
            System.out.println(cars.indexOf(i));
        }


        try {
            File x = new File("D:\\DATA1.XML");
            Scanner sc = new Scanner(x);
            String content = " ";
            while (sc.hasNextLine()){
                content = content+sc.nextLine()+"\r\n";
                System.out.println(content);
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }

    }
}
