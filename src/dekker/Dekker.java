package dekker;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Dekker {

    boolean[] states = {false, false};
    private int turn = 0;

    public Dekker() {
        this.turn = 0;
        this.states = states;
    }

    public synchronized void bloquear(int id) throws Exception {
        int otro = (id + 1) % 2;
        for (int i = 0; i < 2; i++) {
            states[id] = true;
            while (states[otro] == true) {
                if (turn == otro) {
                    states[id] = false;
                    while (turn != id) {
                        System.out.printf("Espedando al otro hilo...");
                    }
                    states[id] = true;
                }
            }
            turn = otro;
            states[id] = false;
        }
    }

    public synchronized void desbloquear(int id) throws Exception {
        states[0] = false;
        System.out.println("Listo para entrar... DESBLOQUEAR");
    }

    public synchronized void escrituraTexto(String escrituraTxt) throws Exception{
        try {
            System.out.println("Generando archivo de texto");
            FileWriter archivo = new FileWriter("lectura.txt");
            archivo.write(escrituraTxt);
            archivo.close();
        } catch (Exception e) {
            System.out.println("No se pudo generar el archivo!!!");
        }

    }

    public synchronized void lecturaTexto() throws Exception {
        String texto = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader("archivo.txt"));
            String tempo = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                tempo = tempo + bfRead;
            }
            texto = tempo;
            System.out.println("El archivo de texto dice: " + texto);
        } catch (Exception e) {
            System.out.println("No se encontro tu archivo");
        }
    }
    
    public synchronized void abrirArchivo() throws Exception{
        try {
            File file = new
            File("C:\\Users\\nesto\\Documents\\NetBeansProjects\\Dekker IY\\lectura.txt");
            if(!Desktop.isDesktopSupported()){
                System.out.println("No soportado");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if(file.exists()){
                System.out.println("Abriendo archivo de texto");
                desktop.open(file);
            }else{
                System.out.println("Error al abrir archivo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
