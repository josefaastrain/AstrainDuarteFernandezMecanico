package Util;

import java.util.Scanner;

public class Validador {
    private static final Scanner sc = new Scanner(System.in);

    public static int leerEntero(String mensaje, int min, int max) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine();
            try {
                valor = Integer.parseInt(input);
                if (valor < min || valor > max) {
                    System.out.println("El valor debe estar entre " + min + " y " + max + ".");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero.");
            }
        }
    }

    public static double leerDoublePositivo(String mensaje) {
        double valor;
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine();
            try {
                valor = Double.parseDouble(input);
                if (valor < 0) {
                    System.out.println("El valor debe ser positivo.");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }

    public static String leerTexto(String mensaje, int maxLength) {
        String texto;
        while (true) {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("El campo no puede estar vacío.");
            } else if (texto.length() > maxLength) {
                System.out.println("Máximo " + maxLength + " caracteres.");
            } else {
                return texto;
            }
        }
    }

    public static int leerOpcionMenu(String mensaje, int... opciones) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine();
            try {
                valor = Integer.parseInt(input);
                boolean valido = false;
                for (int op : opciones) {
                    if (valor == op) {
                        valido = true;
                        break;
                    }
                }
                if (!valido) {
                    System.out.println("Opción no válida. Opciones posibles: " + opcionesToString(opciones));
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar una opción válida.");
            }
        }
    }

    private static String opcionesToString(int[] opciones) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < opciones.length; i++) {
            sb.append(opciones[i]);
            if (i < opciones.length - 1) sb.append(", ");
        }
        return sb.toString();
    }
}
