import java.awt.font.FontRenderContext;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> posiciones = new ArrayList<>();

        BufferedReader br = null;
        BufferedWriter bw = null;
        char[] characteres = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K','L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        try {
            br = new BufferedReader(new FileReader("mensaje.txt"));
            bw = new BufferedWriter(new FileWriter("mensaje_cifrado.txt"));

            String linea = null;
            String clave;
            /* Lectura y validación  de clave */

            do {
                System.out.println("Introduce la clave: ");
                clave = sc.nextLine();
                clave.toUpperCase();
            }while(!claveValida(clave));

            while ((linea = br.readLine()) != null) {
                StringBuilder sb = new StringBuilder(linea.length());

                /* Aquí vendría la lógica del programa */

                for (int i=0; i < linea.length(); i++){
                    for (int j=0; j < characteres.length; j++){
                        if(linea.charAt(i) == characteres[j]) {
                            posiciones.add(j);
                        }
                    }
                }

                System.out.println(posiciones);
                bw.write(sb.toString()); /* Escribe la cadena de caracteres en el fichero*/
                bw.newLine(); /* escribe nueva línea en el fichero */

            }
            System.out.println("El mensaje ha sido cifrado correctamente");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    public static boolean claveValida(String clave){
        if(clave.length() > 12) {
            return false;
        }
        for (int i = 0; i < clave.length(); i++){
            if(!Character.isLetter(clave.charAt(i)))
                return false;
        }
        return true;
    }

}


