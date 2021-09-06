/**
 * Clase Controlador
 * Encargada de ejecutar el programa, llevar a cabo la seleccion de opciones, comunicarse con las
 * demás clases y sus respectivos procesos.
 * 
 * @version 1.0, 5/09/2021
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
        estac.leerArchivo();

        while (op != 5){
			//Menu
            op = v.mostrarMenu();
            estac.leerArchivo();
			switch (op){
				case 1:
                    String placa = v.pedirPlaca();
                    String marca = v.pedirMarca();
                    String modelo = v.pedirModelo();
                    int tiempo = v.pedirHoraEgreso();
                    Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, tiempo);
                    estac.ingresarVehiculo(vehiculo);
                break;

                case 2:
                    String p = v.pedirPlaca();
                    estac.SalidaVehiculo(p);
                break;

                case 3:
                    String tamano = v.pedirTamano();
                    String techoP = v.pedirTecho();
                    boolean techo = false;
                    String aereoP = v.pedirAereo();
                    boolean aereo = false;
                    int uso = 0;

                    if(techoP.equals("false")){
                        techo = false;
                    }else if(techoP.equals("true")){
                        techo = true;
                    }

                    if(aereoP.equals("false")){
                        aereo = false;
                    }else if(aereoP.equals("true")){
                        aereo = true;
                    }

                    estac.agregar_Espacios(tamano, techo, aereo, uso);
                    
                break;

                case 4:
                    double b = estac.getPromedio();
                    int d = estac.getRechazados();
                    String e = estac.getMarca();
                    String c = estac.getParqueoUsado();
                    String f = estac.getCaracteristicasP();
                    v.mostrarEstadisticas(b, c, d, e, f);
                break;

                case 5:
                    estac.escribirArchivo();
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
