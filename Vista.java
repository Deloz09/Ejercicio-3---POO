import java.util.Scanner;

/**
 * Clase Vista
 * Encargada de recibir y mostrarle la información al usuario.
 * 
 * @version 1.0, 5/09/2021
 * @author Diego E. Lemus L. - 21469
 */

public class Vista {
    //-----PROPIEDADES-----
    Scanner scan = new Scanner(System.in);

    /** 
     * Método que muestra el menú, además lee y devuelve la opción del usuario.
     * @return int op, seleccionada por el usuario (1-7)
     */
    public int mostrarMenu(){
        System.out.println("\n\n\n--------------------Menu--------------------");
        System.out.println("Opcion 1: Ingreso vehiculo");
        System.out.println("Opcion 2: Salida vehiculo");
        System.out.println("Opcion 3: Ampliar estacionamiento");
        System.out.println("Opcion 4: Mostrar estadisticas");
        System.out.println("OPcion 5: Guardar y salir\n");
        int op = Integer.parseInt(scan.nextLine());
        return op;
    }

    /** 
     * Método que imprime la bienvenida.
     */
    public void bienvenida(){
        System.out.println("\n\nBienvenido al Sistema de Estacionamiento");
    }

    /** 
     * Método que imprime la despedida.
     */
    public void despedida(){
        System.out.println("\n\nHa salido del programa, que tenga un feliz día. :)\n");
    }

    /** 
     * Método que le pide al usuario la placa de su vehiculo, lee y devuelve.
     * @return String
     */
    public String pedirPlaca(){
        System.out.println("Ingrese la placa de su vehiculo:");
        String placa = scan.nextLine();
        return placa;
    }

    /** 
     * Método que le pide al usuario la marca de su vehiculo, lee y devuelve.
     * @return String
     */
    public String pedirMarca(){
        System.out.println("Ingrese la marca de su vehiculo:");
        String modelo = scan.nextLine();
        return modelo;
    }

    /** 
     * Método que le pide al usuario el modelo de su vehiculo, lee y devuelve.
     * @return String
     */
    public String pedirModelo(){
        System.out.println("Ingrese el modelo de su vehiculo:");
        String modelo = scan.nextLine();
        return modelo;
    }

    /** 
     * Método que le pide al usuario el tamano del parqueo, lee y devuelve.
     * @return String
     */
    public String pedirTamano(){
        System.out.println("Ingrese el tamano del parqueo:");
        System.out.println("Compacto");
        System.out.println("Estandar");
        System.out.println("Grande");
        String tamano = scan.nextLine();
        return tamano;
    }

    /** 
     * Método que le pide al usuario si el parqueo tiene techo, lee y devuelve.
     * @return String
     */
    public String pedirTecho(){
        System.out.println("Ingrese si el parqueo tiene techo (true/false):");
        String techo = scan.nextLine();
        return techo;
    }

    /** 
     * Método que le pide al usuario si el parqueo es aereo, lee y devuelve.
     * @return String
     */
    public String pedirAereo(){
        System.out.println("Ingrese si el parqueo es aereo (true/false):");
        String aereo = scan.nextLine();
        return aereo;
    }

    /** 
     * Método que le pide al usuario la hora de ingreso, lee y devuelve.
     * @return double
     */
    public double pedirHoraIngreso(){
        System.out.println("Ingrese la hora de ingreso de su vehiculo:");
        double ingreso = scan.nextDouble();
        return ingreso;
    }

    /** 
     * Método que le pide al usuario la hora de egreso, lee y devuelve.
     * @return int
     */
    public int pedirHoraEgreso(){
        System.out.println("Ingrese las horas enteras de estancia de su vehiculo:");
        int egreso = Integer.parseInt(scan.nextLine());
        return egreso;
    }

    /** 
     * Método que le notifica al usuario el ingreso de su vehiculo.
     */
    public void vehiculoIngreso(){
        System.out.println("Su vehiculo ha sido registrado exitosamente.");
    }

    /** 
     * Método que le notifica al usuario el egreso de su vehiculo.
     */
    public void vehiculoEgreso(){
        System.out.println("Su vehiculo ha sido egresado exitosamente.");
    }

    /** 
     * Método que le pide al usuario la cantidad de parqueos a agregar, lee y devuelve.
     * @return int
     */
    public int pedirEspacio(){
        System.out.println("Ingrese la cantidad de espacios que desea agregar:");
        int espacio = Integer.parseInt(scan.nextLine());
        return espacio;
    }

    /** 
     * Método que le notifica al usuario el parqueo no esta disponible.
     */
    public void espacioNoDisponible(){
        System.out.println("Actualmente no se cuenta con espacio de parqueo disponible..");
    }

    /** 
     * Método que le notifica al usuario el tiempo total de estancia.
     * @param tiempo
     */
    public void mostrarTiempoTotal(double tiempo){
        System.out.println("El tiempo total de estancia fue:"+tiempo);
    }
 
    /** 
     * Método que le notifica al usuario las estadisticas.
     * @param a
     * @param b
     * @param c
     * @param d
     * @param e
     * @param f
     */
    public void mostrarEstadisticas(double b, String c, int d, String e, String f){
        System.out.println("- Tiempo promedio de uso del parqueo: "+b);
        System.out.println("- Parqueo más utilizado: "+c);
        System.out.println("- Vehículos rechazados cuando el parqueo ya está lleno: "+d);
        System.out.println("- Marca de automóviles son mayormente utilizados: "+e);
        System.out.println("- Características poseen los parqueos que son más utilizados:"+f);
    }

    /** 
     * Método que indica que el ingreso de opcion no es válido.
     */
    public void ingresoIncorrecto(){
        System.out.println("\n%% Opcion invalida, intentelo otra vez. %%");
    }

}
