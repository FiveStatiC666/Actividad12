import java.util.*;
import java.sql.*;

public class Main
{

    public static void Menu()
    {
        int opcion;

        Scanner scanner = new Scanner(System.in);

        AddressBook listaContactos = new AddressBook();

        System.out.println("Directorio de contactos");
        listaContactos.load();
        System.out.println("\n");

        while (true)
        {
            System.out.println("¿Que deseas realizar?");
            System.out.println("1.- Mostrar contactos");
            System.out.println("2.- Agregar contacto");
            System.out.println("3.- Eliminar contacto");
            System.out.println("4.- Guardar cambios");
            System.out.println("5.- Cerrar programa");
            System.out.println();

            opcion=scanner.nextInt();

            switch (opcion)
            {
                case 1:
                    System.out.println("Tus contactos son: ");
                    listaContactos.list();
                    System.out.println();
                    break;

                case 2:
                    String agregarNumero;
                    String agregarNombre;

                    System.out.println("Escribe la información del contacto a agregar");

                    System.out.println("Numero: ");
                    agregarNumero=scanner.next();

                    System.out.println("Nombre: ");
                    agregarNombre=scanner.next();

                    listaContactos.create(agregarNumero, agregarNombre);

                    System.out.println("Se agrego este nuevo contacto");
                    break;

                case 3:
                    System.out.println("Escribe el numero de contacto a eliminar");
                    listaContactos.delete(scanner.next());

                    System.out.println("Se elimino este contacto");
                    break;

                case 4:
                    listaContactos.save();
                    System.out.println("Se guardaron los contactos");
                    break;

                case 5:
                    System.out.println("Finalizando programa");
                    return;
            }
        }
    }





    public static void main(String[] args)
    {
        Menu();
    }
}
