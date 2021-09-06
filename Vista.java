import java.util.Scanner;

/**
 * Clase Vista
 * Encargada de recibir y mostrarle la información al usuario.
 * 
 * @version 1.0, 22/08/2021
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
        System.out.println("\n\nBienvenido al Sistema de Hogares Temporales para Canes [HTC]");
    }

    /** 
     * Método que imprime la despedida.
     */
    public void despedida(){
        System.out.println("\n\nHa salido del programa, que tenga un feliz día. :)\n");
    }

    public String pedirPlaca(){
        System.out.println("Ingrese la placa de su vehiculo:");
        String placa = scan.nextLine();
        return placa;
    }

    public String pedirMarca(){
        System.out.println("Ingrese la marca de su vehiculo:");
        String modelo = scan.nextLine();
        return modelo;
    }

    public String pedirModelo(){
        System.out.println("Ingrese el modelo de su vehiculo:");
        String modelo = scan.nextLine();
        return modelo;
    }

    public String pedirTamano(){
        System.out.println("Ingrese el tamano de su vehiculo:");
        String tamano = scan.nextLine();
        return tamano;
    }

    public double pedirHoraIngreso(){
        System.out.println("Ingrese la hora de ingreso de su vehiculo:");
        double ingreso = scan.nextDouble();
        return ingreso;
    }

    public int pedirHoraEgreso(){
        System.out.println("Ingrese la hora de ingreso de su vehiculo:");
        int egreso = Integer.parseInt(scan.nextLine());
        return egreso;
    }

    public void vehiculoIngreso(){
        System.out.println("Su vehiculo ha sido registrado exitosamente.");
    }

    public void vehiculoEgreso(){
        System.out.println("Su vehiculo ha sido egresado exitosamente.");
    }

    public int pedirEspacio(){
        System.out.println("Ingrese la cantidad de espacios que desea agregar:");
        int espacio = Integer.parseInt(scan.nextLine());
        return espacio;
    }

    public void espacioNoDisponible(){
        System.out.println("Actualmente no se cuenta con espacio de parqueo disponible..");
    }

    public void mostrarTiempoTotal(double tiempo){
        System.out.println("El tiempo total de estancia fue:"+tiempo);
    }

    public void mostrarEstadisticas(String a, int b, String c, int d, String e, String f){
        System.out.println("- Horarios de mayor utilización: "+a);
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
