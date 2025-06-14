import Controller.*;
import Util.Validador;

public class Main {
    public static void main(String[] args) { // Inicio

         AutoController auto = new AutoController();
         ClienteController cliente = new ClienteController();
         MecanicoController mecanico = new MecanicoController();
         HerramientaController herramienta = new HerramientaController();
         Validador validador = new Validador();
        int opcion;

        do {
            System.out.println("Bienvenido al Menu Principal");
            System.out.println("1.- Ingresar al menu Autos");
            System.out.println("2.- Ingresar al menu Clientes");
            System.out.println("3.- Ingresar al menu Herramientas");
            System.out.println("4.- Ingresar al menu Mecanicos");
            System.out.println("5.- Salir");

            opcion = validador.validarInt(1);

            switch (opcion){

                case 1 -> auto.iniciar();
                case 2 -> cliente.iniciar();
                case 3 -> herramienta.iniciar();
                case 4 -> mecanico.iniciar();
                case 5 -> System.out.println("Bye Bye");

                default -> System.out.println("Ingrese un numero valido" + "\n");

            }

        } while (opcion != 5);

    } // Final
}
