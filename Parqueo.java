import java.util.ArrayList;

public class Parqueo {
    private String tamano;
    private boolean techado;
    private boolean aereo;
    private int vecesUso;
    private Vehiculo vehiculo;
    
    ///Vehiculo vehiculo = new Vehiculo(String a, String b, String c);
    
    public Parqueo(String a, boolean b, boolean c, int d){
        tamano = a;
        techado = b;
        aereo = c;
        vecesUso = d;
        vehiculo = null;
    }

    public void setVehiculo(Vehiculo v){
        vehiculo = v;
    }

    public void setNoVehiculo(){
        vehiculo = null;
    }

    public String getTamano(){
        return tamano;
    }

    public boolean getTecho(){
        return techado;
    }

    public boolean getAereo(){
        return aereo;
    }

    public int getVecesUso(){
        return vecesUso;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }
 
}
