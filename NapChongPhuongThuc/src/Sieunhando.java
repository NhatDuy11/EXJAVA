public class Sieunhando extends Sieunhan {
    private String mauAo;
    private String vuKhi;
    public Sieunhando(String ten ,String diaChi,String mauAo,String vuKhi){
        super(ten,diaChi);
        this.mauAo=mauAo;
        this.vuKhi = vuKhi;


    }

    @Override
    public  void thongTin(){
        super.thongTin();
        System.out.println(super.ten + mauAo +vuKhi);
    }
}
