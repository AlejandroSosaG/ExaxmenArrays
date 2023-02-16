import java.util.Arrays;

public class Software {
    /**
     * Se crea la tabla con el nombre de todas las golosina que tiene la máquina.
     */
    static String[][] nombresGolosinas = {
            {"KitKat", "Chicles de fresa", "Lacasitos", "Palotes"},
            {"Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix"},
            {"Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta"},
            {"Lacasitos", "Crunch", "Milkybar", "KitKat"}
    };
    /**
     * Se crea la tabla con el precio que tiene cada golosina.
     */
    static double[][] precio = {
            {1.1, 0.8, 1.5, 0.9},
            {1.8, 1, 1.2, 1},
            {1.8, 1.3, 1.2, 0.8},
            {1.5, 1.1, 1.1, 1.1}
    };
    static int[][] cantidades = new int[4][4]; // Esta es la tabla con la cantidad de golosinas que hay en cada posición.
    static String[] ventas = new String[0];// Este es el array que guarda el nombre dde todas las golosinas que ha pedido el usuario.
    static double total = 0; // Esta es la suma de los precios de todas las golosinas que ha pedido el usuario.

    /**
     * El método rellenarMatriz se encarga de poner en todas las posiciones de la tabla cantidades el valor num que se le pasa por parámetro.
     * @param num
     */
    public static void rellenarMatriz(int num){
        for (int i = 0; i < cantidades.length; i++) {
            for (int j = 0; j < cantidades[i].length; j++) {
                cantidades[i][j] = num; // Igualamos el valor de la tabla cantidades en la posición i y j a num.
            } // Fin segundo for.
        } // Fin primer for.
    }

    /**
     * El método mostrarGolosinas se encarga de mostrar por pantalla el código a marcar, el nombre de la golosina de ese código y su precio.
     */
    public static void mostrarGolosinas(){
        int posX = 0; // Esta variable es la posición x de la tabla.
        int posY = 0; // Esta variable es la posición y de la tabla.
        for (int i = 0; i < nombresGolosinas.length; i++) {
            for (int j = 0; j < nombresGolosinas[i].length; j++) {
                System.out.print(posY + " " + posX + " " + nombresGolosinas[posY][posX] + " " + precio[posY][posX]);
                posX++; // Aumentamos el valor de posX.
                System.out.println(); // Hacemos un salto de línea.
            } // Fin segundo for.
            System.out.println(); // Hacemos un salto de línea.
            posX = 0; // Igualamos el valor de posX a 0.
            posY++; // Aumentamos el valor de posY.
        } // Fin primer for.
    }

    /**
     * El método validarPos se encarga de comprobar que la posición que se le pasa por parámetro está dentro de la tabla nombresGolosinas.
     * @param fila
     * @param columna
     * @return Devolvemos el valor de validación.
     */
    public static boolean validarPos(int fila, int columna){
        boolean validacion = false; // Esta es la variable que utilizaremos para validar que la posición está en la tabla
        for (int i = 0; i < nombresGolosinas.length; i++) {
            for (int j = 0; j < nombresGolosinas[i].length; j++) {
                if (nombresGolosinas[fila-1][columna-1]!=null) // Si existe la psicion en la tabla igualamos validacion a true.
                    validacion = true;
            } // Fin segundo for.
        } // Fin primer for.
        return validacion;
    }

    /**
     * El método hayValorPosicion se encarga de comprobar si en la posición que se le pasa por parámetro de la tabla cantidades hay un valor mayor de cero.
     * @param fila
     * @param columna
     * @return Se devuelve el valor de existencias
     */
    public static boolean hayValorPosicion(int fila, int columna){
        boolean existencias = false;
        for (int i = 0; i < cantidades.length; i++) {
            for (int j = 0; j < cantidades[i].length; j++) {
                if (cantidades[fila-1][columna-1]>0) // Si el valor de cantidades en la posición que se le pasa es mayor a cero igualamos existencias a true.
                    existencias = true;
            } // Fin segundo for
        } // Fin primer for.
        return existencias;
    }

    /**
     * el método aumentarPosicion se encarga de incrementar el valor de la tabla cantidades en la posicion que se le pasa una cantidad que se le pasa por parámetro.
     * @param fila
     * @param columna
     * @param cant
     */
    public static void aumentarPosicion(int fila, int columna, int cant){
        cantidades[fila-1][columna-1] += cant;
    }

    /**
     * El método reducirPosicion se encarga de decrementar el valor de cantidades en la psicion que se le pasa en una cantidad tambien pasado por parámetro.
     * @param fila
     * @param columna
     * @param cant
     */
    public static void reducirPosicion(int fila, int columna, int cant){
        cantidades[fila-1][columna-1] -= cant;
    }

    /**
     * El método anyadirVenta se encarga de aumentar el tamaño de la tabla ventas e introducir en su última posición el valor de la tabla nombresGolosinas en la posición que se le pasa
     * y  sumar a la variable total el valor de la tabla precio en la posición que se pasa por parámetro.
     * @param fila
     * @param columna
     */
    public static void anyadirVenta(int fila, int columna){
        ventas = Arrays.copyOf(ventas, ventas.length+1); // Aumentamos el tamaño de ventas en uno.
        ventas[ventas.length-1] = nombresGolosinas[fila-1][columna-1];
        total += precio[fila-1][columna-1];
    }

    /**
     * El método imprimirVentasTotales se encarga de mostrar por pantalla el contenido de la tabla ventas y el valor de la variable total-
     */
    public static void imprimirVentasTotales(){
        System.out.println(Arrays.toString(ventas) + " " + total);
    }
}
