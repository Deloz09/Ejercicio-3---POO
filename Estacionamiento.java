import java.io.File;
import java.util.Scanner;
import java.io.*;

public class Estacionamiento{
    ///Parqueo[] parqueos = new Parqueo[np];
    
    private String[] dEspacio;
    private String[] dParqueo;
    private String[] dVehiculo;

    public void leerArchivo(){
        File archivo = new File("espacios.txt");
        try {
            Scanner scan = new Scanner(archivo);
            while(scan.hasNextLine()){
                dEspacio = scan.nextLine().split(";");
                dParqueo = dEspacio[0].split(",");
                dVehiculo = dEspacio[1].split(",");
                boolean tec = false;
                boolean aer = false;

                if(dVehiculo[0].equals("null")){
                    if(dParqueo[1].equals("false")){
                        tec = false;
                    } else {
                        tec = true;
                    }
                    if(dParqueo[2].equals("false")){
                        aer = false;
                    } else {
                        aer = true;
                    }
                    String tam = dParqueo[0];
                    Parqueo par = new Parqueo(tam, tec, aer, Integer.parseInt(dParqueo[3]));
                } else{
                    if(dParqueo[1].equals("false")){
                        tec = false;
                    } else {
                        tec = true;
                    }
                    if(dParqueo[2].equals("false")){
                        aer = false;
                    } else {
                        aer = true;
                    }
                    String tam = dParqueo[0];
                    Parqueo par = new Parqueo(tam, tec, aer, Integer.parseInt(dParqueo[3]));
                    Vehiculo veh = new Vehiculo(dVehiculo[0], dVehiculo[1], dVehiculo[2], Integer.parseInt(dVehiculo[0]));
                    par.setVehiculo(veh);
                }
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
