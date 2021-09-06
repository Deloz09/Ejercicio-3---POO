/**
 * Clase Vehiculo
 * Encargada de generar los vehiculos y sus caracteristicas.
 * 
 * @version 1.0, 5/09/2021
 * @author Diego E. Lemus L. - 21469
 */

 public class Vehiculo {
    //-----PROPIEDADES-----
    private String placa;
    private String marca;
    private String modelo;
    private int tiempo;

    /** 
     * Constructor
     */
    public Vehiculo(String pl, String ma, String mo, int ti){
        placa = pl;
        marca = ma;
        modelo = mo;
        tiempo = ti;
    }

    /** 
     * Devuelve la placa
     * @return String
     */
    public String getPlaca(){
        return placa;
    }
   
    /** 
     * Devuelve la marca
     * @return String
     */
    public String getMarca(){
        return marca;
    }
  
    /** 
     * Devuelbe el modelo.
     * @return String
     */
    public String getModelo(){
        return modelo;
    }
 
    /** 
     * Devuelve el tiempo de uso.
     * @return int
     */
    public int getTiempo(){
        return tiempo;
    }
}
