package club;
import java.util.ArrayList;
import java.util.List;

public class Echipa {
    private String nume;
    private List<Jucator> jucatori;
    private Antrenor antrenor;
    private int victorii;
    private int infrangeri;
    private int egaluri;


    public Echipa(String nume, Antrenor antrenor) {
        this.nume = nume;
        this.antrenor = antrenor;
        this.jucatori = new ArrayList<>();
        this.victorii = 0;
        this.infrangeri = 0;
        this.egaluri = 0;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Jucator> getJucatori() {
        return jucatori;
    }

    public Antrenor getAntrenor() {
        return antrenor;
    }

    public void setAntrenor(Antrenor antrenor) {
        this.antrenor = antrenor;
    }

    public int getVictorii() {
        return victorii;
    }

    public void setVictorii(int victorii) {
        this.victorii = victorii;
    }

    public int getInfrangeri() {
        return infrangeri;
    }

    public void setInfrangeri(int infrangeri) {
        this.infrangeri = infrangeri;
    }

    public int getEgaluri() {
        return egaluri;
    }

    public void setEgaluri(int egaluri) {
        this.egaluri = egaluri;
    }

    public void adaugaJucator(Jucator jucator) {
        this.jucatori.add(jucator);
    }

    public void actualizeazaStatistici(int victorii, int infrangeri, int egaluri) {
        this.victorii += victorii;
        this.infrangeri += infrangeri;
        this.egaluri += egaluri;
    }

    @Override
    public String toString() {
        return "Echipa " + nume + " antrenată de " + antrenor.getNume() +
                " cu " + jucatori.size() + " jucători. Statistici: " +
                victorii + " victorii, " + infrangeri + " înfrângeri, " + egaluri + " egaluri.";
    }
}

