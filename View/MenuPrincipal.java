package View;

import Util.Validador;

public class MenuPrincipal {
    public void mostrar() {
        while (true) {
            System.out.println("\n====== SISTEMA DE TALLER MECÁNICO ======");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Autos");
            System.out.println("3. Gestión de Mecánicos");
            System.out.println("4. Gestión de Herramientas");
            System.out.println("5. Salir");
            int opcion = Validador.leerOpcionMenu("Seleccione una opción: ", 1,2,3,4,5);

            switch (opcion) {
                case 1: new ClienteView().mostrarMenu(); break;
                case 2: new AutoView().mostrarMenu(); break;
                case 3: new MecanicoView().mostrarMenu(); break;
                case 4: new HerramientaView().mostrarMenu(); break;
                case 5: return;
            }
        }
    }
}

