/**
 * Clase Controlador
 * Encargada de ejecutar el programa, llevar a cabo la seleccion de opciones, comunicarse con las
 * demás clases y sus respectivos procesos.
 * 
 * @version 1.0, 22/08/2021
 * @author Diego E. Lemus L. - 21469
 */

public class Controlador{
	/** 
     * @param args
     */
	public static void main(String[] args){

		//-----PROPIEDADES-----
        int op = 0;
        Vista v = new Vista();
        Estacionamiento estac = new Estacionamiento();
        //Parqueo parq = new Parqueo();

        //Mensaje de bienvenida
		v.bienvenida();

        while (op != 5){
			//Menu
            op = v.mostrarMenu();
            estac.leerArchivo();
			switch (op){
				case 1:
                    String placa = v.pedirPlaca();
                    String marca = v.pedirMarca();
                    String modelo = v.pedirModelo();
                    int tiempo = v.pedirHoraEgreso()
                    Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, tiempo);

                break;

                case 2:
                    String p = v.pedirPlaca();

                break;

                case 3:
                    estac.leerArchivo();
                break;

                case 4:

                break;

                case 5:
                    op = 5;
                break;

                default://En caso de valor de opcion invalido
                    v.ingresoIncorrecto();
            }
        }
        //Mensaje de despedida
		v.despedida();
    }
}
