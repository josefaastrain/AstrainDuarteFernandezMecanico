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
            System.out.println("\n🚗👥🧰🔧 𝗠𝗲𝗻𝘂́ 𝗣𝗿𝗶𝗻𝗰𝗶𝗽𝗮𝗹 🔧🧰👥🚗");
            System.out.println("1.-  🚗 Ingresar al menú Autos");
            System.out.println("2.-  👥 Ingresar al menú Clientes");
            System.out.println("3.-  🧰 Ingresar al menú Herramientas");
            System.out.println("4.-  🔧 Ingresar al menú Mecánicos");
            System.out.println("5.-  🚪 Salir");

            System.out.print("👉 Selecciona una opción: ");
            opcion = validador.validarInt(1);

            switch (opcion){

                case 1 -> auto.iniciar();
                case 2 -> cliente.iniciar();
                case 3 -> herramienta.iniciar();
                case 4 -> mecanico.iniciar();
                case 5 -> System.out.println("👋 ¡Bye Bye! 🚀");

                default -> System.out.println("⚠️  Ingrese un número válido.\n");

            }

        } while (opcion != 5);

    }
}
