package dekker;

public class TestDkk {

    public static void main(String[] args) {
       H1 hilo1 = new H1(1);
       hilo1.start();
       H2 hilo2 = new H2(0);
       hilo2.start();
    }
    
}
