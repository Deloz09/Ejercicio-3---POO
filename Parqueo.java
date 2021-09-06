/**
 * Clase Parqueo
 * Encargada de generar los espacios individuales de parqueo y sus caracteristicas.
 * 
 * @version 1.0, 5/09/2021
 * @author Diego E. Lemus L. - 21469
 */

public class Parqueo {
    //-----PROPIEDADES-----
    private String tamano;
    private boolean techado;
    private boolean aereo;
    private int vecesUso;
    private Vehiculo vehiculo;

    /** 
     * Propiedades
     */
    public Parqueo(String a, boolean b, boolean c, int d){
        tamano = a;
        techado = b;
        aereo = c;
        vecesUso = d;
        vehiculo = null;
    }

    /** 
     * Situa el vehiculo
     * @param v
     */
    public void setVehiculo(Vehiculo v){
        vehiculo = v;
    }

    /** 
     * Situa que no existe el vehiculo
     */
    public void setNoVehiculo(){
        vehiculo = null;
    }
 
    /** 
     * Devuelve el tamano
     * @return String
     */
    public String getTamano(){
        return tamano;
    }

    /** 
     * Devuelve si tiene techo
     * @return boolean
     */
    public boolean getTecho(){
        return techado;
    }
 
    /** 
     * Devuelve si es aereo
     * @return boolean
     */
    public boolean getAereo(){
        return aereo;
    }
    
    /** 
     * Devuelve el total de usos
     * @return int
     */
    public int getVecesUso(){
        return vecesUso;
    }

    /** 
     * Devuelve el vehiculo
     * @return Vehiculo
     */
    public Vehiculo getVehiculo(){
        return vehiculo;
    }
 
}
