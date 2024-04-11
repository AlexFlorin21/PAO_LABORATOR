package club;

public class Stadion {
    private String nume;
    private int capacitate;
    private String locatie;
    private String tipGazon;
    private int anInaugurare;


    public Stadion(String nume, int capacitate, String locatie, String tipGazon, int anInaugurare) {
        this.nume = nume;
        this.capacitate = capacitate;
        this.locatie = locatie;
        this.tipGazon = tipGazon;
        this.anInaugurare = anInaugurare;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getTipGazon() {
        return tipGazon;
    }

    public void setTipGazon(String tipGazon) {
        this.tipGazon = tipGazon;
    }

    public int getAnInaugurare() {
        return anInaugurare;
    }

    public void setAnInaugurare(int anInaugurare) {
        this.anInaugurare = anInaugurare;
    }

    @Override
    public String toString() {
        return "Stadionul " + nume + " se află în " + locatie +
                ", are o capacitate de " + capacitate + " locuri" +
                ", tipul gazonului: " + tipGazon +
                " și a fost inaugurat în anul " + anInaugurare + ".";
    }
}

