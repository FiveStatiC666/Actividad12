import java.io.*;
import java.util.*;

public class AddressBook
{
    HashMap<String, String> nuevoHashMap = new HashMap<>();

    void load()
    {
        String token[]=null;

        try
        {
            BufferedReader lector = new BufferedReader(new FileReader("CargarContactos.txt"));

            String linea;

            while((linea= lector.readLine()) != null)
            {
                token=linea.split(", ");
                nuevoHashMap.put(token[0], token[1]);
            }
            lector.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    void save()
    {
        try
        {
            BufferedWriter escritor= new BufferedWriter(new FileWriter("CargarContactos.txt"));

            for(Map.Entry<String, String> entry: nuevoHashMap.entrySet())
            {
                escritor.write(entry.getKey() + "," + entry.getValue() + "\n");

            }
            escritor.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    void list()
    {
        for(Map.Entry<String, String> entry: nuevoHashMap.entrySet())
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    void create(String numero, String nombre)
    {
        nuevoHashMap.put(numero,nombre);
    }

    void delete(String numero)
    {
        nuevoHashMap.remove(numero);
    }
}
