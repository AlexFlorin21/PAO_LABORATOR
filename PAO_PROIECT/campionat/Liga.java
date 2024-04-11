package campionat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import club.Echipa;

public class Liga {
    private String nume;
    private List<Echipa> echipe;
    private List<Meci> meciuri;


    public Liga(String nume) {
        this.nume = nume;
        this.echipe = new ArrayList<>();
        this.meciuri = new ArrayList<>();
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Echipa> getEchipe() {
        return echipe;
    }

    public List<Meci> getMeciuri() {
        return meciuri;
    }


    public void adaugaEchipa(Echipa echipa) {
        if (!echipe.contains(echipa)) {
            echipe.add(echipa);
        }
    }

    public void adaugaMeci(Meci meci) {
        if (!meciuri.contains(meci)) {
            meciuri.add(meci);
        }
    }

    // Sorteaza echipele în funcție de numarul total de puncte
    public void sorteazaEchipe() {
        Collections.sort(echipe, new Comparator<Echipa>() {
            @Override
            public int compare(Echipa e1, Echipa e2) {
                return Integer.compare(e2.getVictorii() - e2.getInfrangeri(), e1.getVictorii() - e1.getInfrangeri()); // Exemplu simplu de sortare
            }
        });
    }

    @Override
    public String toString() {
        return "Liga: " + nume + " cu " + echipe.size() + " echipe.";
    }
}
