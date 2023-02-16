import java.util.Scanner;

public class Maquina {
    public static void main(String[] args) {
        int opc = 0; // Esta es la opción que eligirá el usuario.
        int fila; // En esta variable se guardará la posición x de la tabla.
        int columna; // En esta variable se guardará la posición y de la tabla.
        int cant; // Esta es la cantidad que se añadirá o reducirá según la elección del usuario.
        // Creamos el escaner.
        Scanner sc = new Scanner(System.in);
        Software.rellenarMatriz(5); // LLamamos al método rellenarMatriz de la clase Software.
        // Mientras el usuario no eliga la opción 4 se ejecutará el bucle.
        while (opc!=4){
            // Se muestran la opciones.
            System.out.println("Elija una opción:\n" +
                    "1. Mostrar golosinas.\n" +
                    "2. Pedir golosinas.\n" +
                    "3. Rellenar golosinas.\n" +
                    "4. Apagar máquina.");
            // El usuario elige.
            opc = sc.nextInt();
            switch (opc){
                // Si el usuario elige la opción 1:
                case 1:
                    // Llamamos al método mostrarGolosinas de la clase Software.
                    Software.mostrarGolosinas();
                    break;
                    // si el usuario elige la opción 2:
                case 2:
                    System.out.println("Introduzca una fila");
                    fila = sc.nextInt();
                    System.out.println("Introduzca una columna");
                    columna = sc.nextInt();
                    // Si el método validarPos de la clase Software devuelve true:
                    if (Software.validarPos(fila, columna) == true){
                        // Si el método hayValorPosicion de la clase Software devuelve true llamamos al método reducirPosicion de la clase Software.
                        if (Software.hayValorPosicion(fila, columna) == true){
                            Software.reducirPosicion(fila, columna, 1);
                            Software.anyadirVenta(fila, columna);
                            // Sino mostramos por pantalla un mensaje.
                        }else
                            System.out.println("No hay existencias de esa golosina");
                    } // Fin primer if.
                    break;
                    // Si el usuario elige la opcion 3:
                case 3:
                    String contraseña;
                    System.out.println("Introduzca la contraseña");
                    contraseña = sc.next();
                    // Si la contraseña que pedimos al usuario es correcta pedimos fila, columna y cantidad.
                    if (contraseña.equals("Maquina2023")){
                        System.out.println("Introduzca una fila");
                        fila = sc.nextInt();
                        System.out.println("Introduzca una columna");
                        columna = sc.nextInt();
                        System.out.println("Introduzca la cantidad que desea rellenar");
                        cant = sc.nextInt();
                        // Si el método validarPos de la clase Software devuelve true llamamos al método aumentarPosicion de la clase Software.
                        if (Software.validarPos(fila, columna) == true)
                        Software.aumentarPosicion(fila, columna, cant);
                        // Sino mostramos mensaje.
                    }else
                        System.out.println("La contraseña es incorrecta");
                    break;
                    // Si el usuario elige la opción 4:
                case 4:
                    // Llamamos al método imprimirVentasTotales de la clase Software.
                    Software.imprimirVentasTotales();
                    break;
                    // Si no elige una de las opciones anteriores mostramos un mensaje de error.
                default:
                    System.out.println("Opción no válida");
            } // Fin switch.
        } // Fin while.
    }
}
