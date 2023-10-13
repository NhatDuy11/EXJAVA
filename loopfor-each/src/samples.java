public class samples {
    private  int age;
    public  int getAge(){
        return  age;
    }
    public  void setAge( int age){
        this.age =age;
    }

    private String bikes;
    private  String motobikes ;
    public String getBikes(){
        return  bikes;
    }
    public String getMotobikes(){
        return  motobikes;
    }
    public  void setBikes(String bikes ) {
        this.bikes=bikes;
    }
    public void setMotobikes (String motobikes) {
        this.motobikes = motobikes;
    }



    public static void main(String[] args) {
        samples v1  = new samples() ;
        v1.setAge(30);
        v1.setBikes("SH");
        v1.setMotobikes("LEXUS");

        System.out.println("Age : "  + v1.getAge());
        System.out.println("Bikes  : " + v1.getBikes());
        System.out.println("Motobikes : " + v1.getMotobikes());
    }
}

