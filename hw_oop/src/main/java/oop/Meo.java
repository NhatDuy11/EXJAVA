package oop;
// class Meo la khuon mau chua nhung thong tin  va chua nhung phuong thuc keu
public class Meo extends Dongvat {
    public String mau;
    public String tuoi;
    public String ten;
   // phuong thuc cua Meo la "meomeo"
    public void keu(){
        System.out.println("meomeo");
    }
    // tính đa hình nạp chồng phương thức
    public void keu(String tiengmeo){
        System.out.println(tiengmeo);

    }

}
