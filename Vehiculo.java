public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int tiempo;

    public Vehiculo(String pl, String ma, String mo, int ti){
        placa = pl;
        marca = ma;
        modelo = mo;
        tiempo = ti;
    }

    public String getPlaca(){
        return placa;
    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public int getTiempo(){
        return tiempo;
    }
}
