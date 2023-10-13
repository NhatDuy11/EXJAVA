import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NumberisArray {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Nhập số phần tử của mảng : ");
        int n = scanner.nextInt();
        // khoi tao array
        int [] arr = new int[n];
        System.out.println(" Nhập phần tử của mảng : ");
        for ( int i = 0 ; i <n ; i ++) {
            System.out.printf("a[%d] = ", i);
            arr[i] = scanner.nextInt();
        }
            Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
            for ( int i = 0 ; i<n;i++) {
                addElement(map, arr[i]);
            }
            System.out.printf("Các phần tử  chỉ xuất hiện 1ư lần : ");
            for(Integer key : map.keySet()){
                if(map.get(key) == 1){
                    System.out.print(key + " ");
                }
            }



    }
    public static void addElement(Map<Integer,Integer> map,int element) {
        if(map.containsKey(element)){

            int count = map.get(element)+1;
            map.put(element,count);

        }else {
            map.put(element,1);
        }
        System.out.println("element : " + element);
    }
}
