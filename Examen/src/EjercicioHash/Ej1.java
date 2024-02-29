package EjercicioHash;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ej1 {
    public static void main(String args[]) {
        try {
            FileOutputStream fileout = new FileOutputStream("QUJOTE_HASH.DAT");
            ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
            MessageDigest md = MessageDigest.getInstance("SHA");
            String datos = "En un lugar de la mancha de cuyo nombre no quiero acordarme,/n"
            		+ "no ha mucho tiempo que vivia un hidalgo de los de lanza en astillero/n"
            		+ ", adarga antigua,rocin flaco y galgo corredor./n"
            		+ "Una olla de algo mas vaca que carnero,salpicon las mas noches duelos y quebrantos los sabados/n,"
            		+ "lantejas los viernes, algun palomino de añadidura los domingos, consumian las treas partes de su hacienda/n"
            		+ "El resto della concluian sayo de velarte calzass de velludo para las fiestas con sus pantuflos de lo mismo, y los dias de entresemana se honraba con su vellori de los mas fino";
            		
            byte dataBytes[] = datos.getBytes();
            md.update(dataBytes); 
            byte resumen[] = md.digest(); 
            dataOS.writeObject(datos);
            dataOS.writeObject(resumen); 
            dataOS.close();
            fileout.close();
            System.out.println("Datos:" + datos);
            System.out.println("\nResumen creado");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
