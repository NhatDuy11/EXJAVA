package oop;
// tạo 1 lớp truu tuong
abstract class Dongvat1{
    // tao phương thức truu tuong noi ()
    public abstract  void noi();
    public void ngu(){
        System.out.println("ngu dong roi");
    }
    public void gunn(){
        System.out.println("gungun");
    }

}
interface  DongvatCasi{
    void hat ();

}
class HoaMi implements DongvatCasi{
    @Override
    public void hat() {
        System.out.println("ekoekoek");
    }
}
class Meo1 extends Dongvat1{
    // minh can phai khai bao phuong thuc void cho lop  ke thua
    public  void noi(){
        System.out.println(" meo meo");
    }

}
public class main1 {
    public static void main(String[] args) {
        Dongvat1 dongvat1 = new Meo1();
        dongvat1.ngu();
        dongvat1.noi();
        dongvat1.gunn();
        DongvatCasi dongvat_2 = new HoaMi();
        dongvat_2.hat();


    }
}
