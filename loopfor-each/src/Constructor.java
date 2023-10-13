public class Constructor {
    String model;
    int year;
    Constructor(String model,int year){
        this.model=model;
        this.year=year;
    }
    static class car{
        String fiter;
        String brand ;
        car(String fiter,String brand){
            this.fiter=fiter;
            this.brand =brand;
        }
    }
    public static  class animal{
        String  cat;
        String eat ;
        animal(String cat,String eat) {
            this.cat = cat;
            this.eat=eat;
        }
    }

    public static void main(String[] args) {
        animal animal1 = new animal("meomeo","fish");
        System.out.println(animal1.eat + " " + animal1.cat);
        Constructor cons1 = new Constructor("Yaz",2023);
        car car1 = new car("vision","honda");
        System.out.println(car1.brand + " " + car1.fiter);
        System.out.println(cons1.model+ " " + cons1.year);
    }
}
