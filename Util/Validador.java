package Util;

import java.util.*;

public class Validador { //Inicio

    private Scanner sc = new Scanner(System.in);



        public String validarString(int longitud) {
            String dato = sc.nextLine();
            dato = dato.trim(); // Elimina espacios antes y después

            boolean valido = false;

            do {
                if (dato.isEmpty()) {
                    System.out.println("El dato no puede estar vacío. Ingrese uno:");
                    dato = sc.nextLine().trim();

                } else if (dato.length() > longitud) {
                    System.out.println("La máxima longitud de datos es: " + longitud +
                            "\nUsted ingresó: " + dato.length() + "\nIntente de nuevo:");
                    dato = sc.nextLine().trim();

                } else if (dato.matches("\\d+")) {
                    System.out.println("El dato no puede ser solo numérico. Intente de nuevo:");
                    dato = sc.nextLine().trim();
                    // matches compara la cadena de texto con lo que se pide abajo
                    // \\d significa números del 0 al 9
                    // + significa uno o más dígitos seguidos
                    // Si es solo números, devuelve true

                } else if (!dato.matches("^[a-zA-ZñÑáéíóúÁÉÍÓÚ0-9.\\-]+( [a-zA-ZñÑáéíóúÁÉÍÓÚ0-9.\\-]+)*$")) {
                    System.out.println("El dato solo puede contener letras (incluyendo ñ y acentos), números y espacios simples entre palabras. Sin símbolos especiales. Intente de nuevo:");
                    dato = sc.nextLine().trim();
                    // acepta numeros, letras, espacios, guiones, puntos, tildes y ñ
                    // no acepta multiples espacios seguidos
                 } else if (validarRepetidos(dato)) {
                    System.out.println("El dato no puede ser una letra repetida. Intente de nuevo:");
                    continue;
                }else {
                    valido = true;
                }
            } while (!valido);

            return dato;

    }

    public String validarStringExacto(int longitud) {
        String dato;
        do {

            dato = validarString(longitud);
            if (dato.length() != longitud) {
                System.out.println("El dato debe tener exactamente " + longitud + " caracteres. Intente de nuevo:");
            }
        } while (dato.length() != longitud);

        return dato;
    }

    public int validarInt( int longitud) {
            String dato = sc.nextLine();
        dato = dato.trim();
        boolean valido = false;

        int numero = 0;


            do {
                if (dato.isEmpty()) {
                    System.out.println("El dato no puede estar vacío. Intente de nuevo:");
                    dato = sc.nextLine().trim();
                    continue;
                }

                if (dato.length() > longitud) {
                    System.out.println("La máxima longitud permitida es: " + longitud + ". Intente de nuevo:");
                    dato = sc.nextLine().trim();
                    continue;
                }
                if (!dato.matches("\\d+")) {
                    System.out.println("El número no debe contener letras ni símbolos. Intente de nuevo:");
                    dato = sc.nextLine().trim();
                    continue;
                }

                try {
                     numero = Integer.parseInt(dato);
                    if (numero <= 0) {
                        System.out.println("El número debe ser positivo. Intente de nuevo:");
                        dato = sc.nextLine().trim();
                    } else {
                        valido = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Debe ingresar un número válido. Intente de nuevo:");
                    dato = sc.nextLine().trim();
                }
            } while (!valido);

        return numero;

    }

    public int validarAnio(){
            int dato;
            boolean valido = false;

            do {
                dato = validarInt(4);
                if (dato < 1885){
                    System.out.println("El año no es valido. Ingrese un año superior.");
                } else if (dato > 2026){
                    System.out.println("El año no es valido. Ingrese un año menor.");
                } else {
                    valido = true;
                }
            } while (!valido);
            return dato;
    }


  public boolean validarRepetidos(String dato) {
        if (dato.length() <= 1) return false;

        char primerChar = dato.charAt(0);

        for (int i = 1; i < dato.length(); i++) {
            if (dato.charAt(i) != primerChar) {
                return false;
            }
        }

        return true;
    }

} // Final
