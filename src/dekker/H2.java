package dekker;

import java.util.logging.Level;
import java.util.logging.Logger;

public class H2 extends Thread {

    int id;
    Dekker obj = new Dekker();

    public H2(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            obj.bloquear(id);
            obj.abrirArchivo();
            obj.lecturaTexto();
            System.out.println("Hilo 2 - Proceso 1 ");
        } catch (Exception ex) {
            Logger.getLogger(H1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
