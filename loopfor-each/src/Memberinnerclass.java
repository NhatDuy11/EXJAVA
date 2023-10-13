public class Memberinnerclass {
    private  int outner = 10 ;
    class Innerclass {
        void display(){
            System.out.println(" value os ounter :  " + outner);
        }
        public  static  String abc (String name ){
            System.out.println(name);
            return name;

        }

        public  static  void ced(){
            int arr [] = {1,2,3,4,5,6,7,8,9,10};

            for ( int i = 0 ; i< arr.length; i++){
                if( arr [i] > 4) {
                    System.out.println("lon hon 4 : " + arr[i]);
                } else {
                    System.out.println(arr[i]);
                }

            }
        }
    }

    public static void main(String[] args) {
        Memberinnerclass outmem = new Memberinnerclass();
        Memberinnerclass.Innerclass inner = outmem.new Innerclass();
        inner.display();
        Memberinnerclass.Innerclass.abc("abc");
        Memberinnerclass.Innerclass.ced();


//        inner.abc("dsdadadad");
    }
}
