public class method {
    static void hello(){
        System.out.println("hello java");
    }

    static  void Showname(String ... names) {
        int shownames = names.length;
        for ( String name : names){
            System.out.println("full name : " +name);
        }
    }
    static int sum(int val1 , int val2){
        return val1+val2;
    }
    public static void seeyou( String sayyes) {
        String [] arr2 = {"ABCDEFRGFFDDFG"};
        for ( int i = 0 ; i < arr2.length ; i++){
            System.out.println(arr2[i] + sayyes);

        }

    }
    public  void cat(){
        System.out.println("meomeo");
    }
    public static  String abc() {
        String tomcat = "ABCNAMEYOU";
        return tomcat;
    }

//Khi phương thức bạn xây dựng mà không có giá trị trả về thì cần phải khai báo với từ khóa void.
    public static void main(String[] args) {
        hello();
       Showname("Linh","Duy","Bao","Trung","Tin");
          seeyou("name");

       int x = sum(2,5);
        System.out.println(x);
        method cat = new method();
        cat.cat();
         String c = abc();
        System.out.println(c);
        String exp = "learnJavaWithkafka";
        int a = exp.length();
        System.out.println("length is String exp : "  + a );
        String exp2 = "learnjava";
        System.out.println("tochararray : " + exp2.charAt(0));
        if(exp.equals(exp2)){
            System.out.println("YES");

        }else {
            System.out.println("NO");
        }
        String[] myname = {"a","b","c","d","e","f"};
        System.out.println(myname[2]);


        int [] myArr = {2,1,3,4,5,6,7,8,9,10};
        int sum = 0 ;
        for (int i = 0 ; i <myArr.length;i++){
            sum = sum +myArr[i];
            System.out.println(sum);

        }
        double tee = 23.443433;
        int tee2 = (int) tee ;
        System.out.println("value tee2 : "  + tee2) ;





    }



}
