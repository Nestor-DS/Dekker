package dekker;

import java.util.logging.Level;
import java.util.logging.Logger;

public class H1 extends Thread {

    int id;
    Dekker obj = new Dekker();

    public H1(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            obj.bloquear(id);
            System.out.println("Hilo 1 - Proceso 0");
            obj.escrituraTexto("La computacion concurrente es una "
                    + "forma de computo en la cual varios calculos se realizan "
                    + "concurrentemente, y no uno a la vez de orma secuencial");
        } catch (Exception ex) {
            Logger.getLogger(H1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
