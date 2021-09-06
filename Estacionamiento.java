import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.io.*;

/**
 * Clase Estacionamiento
 * Encargada de llevar a cabo el registro de vehiculos y parqueos, asi como la asignacion de estos, ingresos, salidas, 
 * leer y guardar los datos en el archivo, y llevar las estadisticas. 
 * 
 * @version 1.0, 5/09/2021
 * @author Diego E. Lemus L. - 21469
 */

public class Estacionamiento{
    //-----PROPIEDADES-----
    private String[] dEspacio;
    private String[] dParqueo;
    private String[] dVehiculo;
    private int rechazados = 0;
    private ArrayList <Parqueo> parqueos = new ArrayList<Parqueo>();
    private ArrayList <String[]> marcas = new ArrayList<String[]>();

    /** 
     * Metodo para leer el archivo
     */
    public void leerArchivo(){
        File archivo = new File("espacios.txt");//abre el archivo
        try {
            Scanner scan = new Scanner(archivo);
            while(scan.hasNextLine()){//separa las partes del archivo
                dEspacio = scan.nextLine().split(";");
                dParqueo = dEspacio[0].split(",");
                dVehiculo = dEspacio[1].split(",");
                boolean tec = false;
                boolean aer = false;

                //En caso de no haber vehiculo
                if(dVehiculo[0].equals("null")){
                    //Techo
                    if(dParqueo[1].equals("false")){
                        tec = false;
                    } else {
                        tec = true;
                    }
                    //Aereo
                    if(dParqueo[2].equals("false")){
                        aer = false;
                    } else {
                        aer = true;
                    }
                    String tam = dParqueo[0];
                    Parqueo par = new Parqueo(tam, tec, aer, Integer.parseInt(dParqueo[3]));
                    parqueos.add(par);
                //En caso de si haber vehiculo
                } else{
                    //techo
                    if(dParqueo[1].equals("false")){
                        tec = false;
                    } else {
                        tec = true;
                    }
                    //aereo
                    if(dParqueo[2].equals("false")){
                        aer = false;
                    } else {
                        aer = true;
                    }
                    //Se guardan los datos
                    String tam = dParqueo[0];
                    Parqueo par = new Parqueo(tam, tec, aer, Integer.parseInt(dParqueo[3]));
                    Vehiculo veh = new Vehiculo(dVehiculo[0], dVehiculo[1], dVehiculo[2], Integer.parseInt(dVehiculo[0]));
                    par.setVehiculo(veh);
                    parqueos.add(par);
                }
                
            }
            //Se cierra la lectura
            scan.close();
        }
        //En caso de no haber archivo
        catch(Exception e){
            e.printStackTrace();
        }
    }

    
    /** 
     * Metodo para ingresar un nuevo vehiculo
     * @param vehiculo
     */
    public void ingresarVehiculo(Vehiculo vehiculo){
        boolean b = false;
        int j = 0;
        boolean encontrado = false;
        //Se comprueba que no este asigando
        for (int i=0;i<parqueos.size()&&encontrado==false;i++){
            if(parqueos.get(i).getVehiculo() == null){
                parqueos.get(i).setVehiculo(vehiculo);
                //Se asigna
                encontrado = true;
                j=i;
            }
        }
        //Se lleva a cabo el conteo de marcas
        String marca = parqueos.get(j).getVehiculo().getMarca();
        if(marcas.size()>0){
            for(int m=0;m<marcas.size();m++){
                if(marcas.get(m)!=null){
                    b=true;
                    int cont = Integer.parseInt(marcas.get(m)[1]);
                    cont++;
                    marcas.get(m)[1]=cont+""; 
                }
            }
        }
        //En caso de que sea una marca nueva
        if(!b){
            marcas.add(new String[]{marca,"1"});
        }
    }

    
    /** 
     * Metodo para egresar un vehiculo
     * @param placa
     */
    public void SalidaVehiculo(String placa){
        int i = 0;
        //Se comprueba que este dentro del sistema
        boolean encontrado = false;
        for(i=0;i<parqueos.size()&& encontrado == false;i++){
            if (parqueos.get(i).getVehiculo() != null){
                if (parqueos.get(i).getVehiculo().getPlaca().equals(placa)){
                    //Salida
                    parqueos.get(i).setNoVehiculo();
                    encontrado = true;
                }
            }
        }
    }

    /** 
     * Metodo para agregar un nuevo espacio de parqueo
     * @param tamano
     * @param techado
     * @param aereo
     * @param uso
     */
    public void agregar_Espacios(String tamano, boolean techado, boolean aereo, int uso){
        parqueos.add(new Parqueo(tamano, techado, aereo, uso));
    }
    
    /** 
     * Metodo para obtener el promedio del total de horas de estancia
     * @return Double
     */
    public Double getPromedio(){
        Double suma = 0.0;
        int total = 0;
        for (int i = 0; i <= parqueos.size(); i++)
        {
            if (parqueos.get(i).getVehiculo() != null)
            {
                suma += parqueos.get(i).getVehiculo().getTiempo();
                total++;
            }
        }
        Double prom = suma / total;
        return prom;
    }

    /** 
     * Metodo para obtener el numero de vehiculos rechazados
     * @return int
     */
    public int getRechazados(){
        leerArchivo();
        return rechazados;
    }
    
    /** 
     * Metodo para obtener la marca mas comun en el sistema
     * @return String
     */
    public String getMarca(){
        String marca = "null";
        Integer[] conteo = new Integer[marcas.size()];
            if(marcas.size()>0){
                for(int i=0;i<marcas.size();i++){
                    conteo[i]=Integer.parseInt(marcas.get(i)[1]); 
                }
                Arrays.sort(conteo, Collections.reverseOrder());
                int mayor = conteo[0];
                for(int i=0;i<marcas.size();i++){
                    if(marcas.get(i)[1].equals(Integer.toString(mayor))){
                        marca = marcas.get(i)[0];//busca la marca que tiene dicho contador
                    }
                }
            }
            return marca;
    }

    
    /** 
     * Metodo para obtener el parqueo mas usado
     * @return String
     */
    public String getParqueoUsado(){
        String parqueoUsado="Null";
        Integer[] conteo = new Integer[parqueos.size()];
        if(parqueos.size()>0){
            for(int i=0;i<parqueos.size();i++){
                conteo[i]=parqueos.get(i).getVecesUso();
            }
            Arrays.sort(conteo, Collections.reverseOrder());
            int mayor = conteo[0];
            for(int i=0;i<parqueos.size();i++){
                if(parqueos.get(i).getVecesUso()==mayor){
                    parqueoUsado = Integer.toString(i+1);
                }
            }
        }
        return parqueoUsado;
    }

    public String getCaracteristicasP(){//mostrar las caracteristicas de el parqueo ingresado
        String techo;
        String aereo;
        if(parqueos.get(0).getTecho()){
            techo="si";
        }else{
            techo="no";
        }
        if(parqueos.get(0).getAereo()){
            aereo="si";
        }else{
            aereo="no";
        }
        String carac="Tamano: "+parqueos.get(0).getTamano()+"\nTechado: "+techo+"\nAereo: "+aereo;
        return carac;
    }

    /** 
     * Metodo para sobreescribir el archivo con los nuevos datos
     */
    public void escribirArchivo(){
        int t = parqueos.size();
        String[] lineas = new String[t];
        //Se eliminan los datos viejos
        File archivo = new File("espacios.txt");
        archivo.delete();
        try{
            FileWriter escritor = new FileWriter("espacios.txt");

            //Se escribe linea por linea, puede haber vahiculo o no
            for (int i=0;i<parqueos.size();i++){
                if (parqueos.get(i).getVehiculo() == null){
                    lineas[i] = parqueos.get(i).getTamano() + "," + Boolean.toString( parqueos.get(i).getTecho() ) + "," + Boolean.toString( parqueos.get(i).getAereo() ) + "," + Integer.toString( parqueos.get(i).getVecesUso() ) + ";" + "null";
                }else{
                    lineas[i] = parqueos.get(i).getTamano() + "," + Boolean.toString( parqueos.get(i).getTecho() ) + "," + Boolean.toString( parqueos.get(i).getAereo() ) + "," + Integer.toString( parqueos.get(i).getVecesUso() ) + ";" + Integer.toString( parqueos.get(i).getVehiculo().getTiempo() ) + "," + parqueos.get(i).getVehiculo().getPlaca() + "," + parqueos.get(i).getVehiculo().getMarca() + "," + parqueos.get(i).getVehiculo().getModelo(); 
                }
            }
            //Las lineas se colocan en el archivo     
            for (int i=0;i<parqueos.size();i++){
                escritor.write(lineas[i]);
                escritor.write("\n");
            }

            escritor.close();
        }
        //En caso de no haber archivo
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}