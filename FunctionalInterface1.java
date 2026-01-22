import java.lang.FunctionalInterface;

@FunctionalInterface
 interface F1 {
    void m1();   
}
public class FunctionalInterface1 {

    public static void main(String[] args) {
        F1 printf1=(()->System.out.println("hello shivam"));
       
    }
}



