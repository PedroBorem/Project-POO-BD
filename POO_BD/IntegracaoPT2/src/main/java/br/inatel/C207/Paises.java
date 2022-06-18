package br.inatel.C207;

public class Paises {

    public int idPaises;
    public int Continente_idContinente;
    private String nome;
    private double longitude; //Expresse números "N" e "E" com sinal positivo e números "S" e "W" com sinal negativo.
    private double latitude;

    public Paises(String nome, double longG, double longM,double longS, double latiG, double latiM, double latiS) {
        this.nome = nome;
        this.longitude = Math.toRadians(longG + (longM/60)+ (longS/3600));
        this.latitude = Math.toRadians(latiG + (latiM/60) + (latiS/3600));
    }

    public Paises(String nome, double latitude, double longitude) {
        this.nome = nome;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Paises(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
