package campionat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import club.Echipa;
import club.Stadion;
public class Meci {
    private Echipa echipaAcasa;
    private Echipa echipaOaspeti;
    private LocalDateTime dataOra;
    private Stadion stadion;
    private Map<String, Integer> scor;


    public Meci(Echipa echipaAcasa, Echipa echipaOaspeti, LocalDateTime dataOra, Stadion stadion) {
        this.echipaAcasa = echipaAcasa;
        this.echipaOaspeti = echipaOaspeti;
        this.dataOra = dataOra;
        this.stadion = stadion;
        this.scor = new HashMap<>();
    }


    public Echipa getEchipaAcasa() {
        return echipaAcasa;
    }

    public void setEchipaAcasa(Echipa echipaAcasa) {
        this.echipaAcasa = echipaAcasa;
    }

    public Echipa getEchipaOaspeti() {
        return echipaOaspeti;
    }

    public void setEchipaOaspeti(Echipa echipaOaspeti) {
        this.echipaOaspeti = echipaOaspeti;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public Stadion getStadion() {
        return stadion;
    }

    public void setStadion(Stadion stadion) {
        this.stadion = stadion;
    }

    public Map<String, Integer> getScor() {
        return scor;
    }

    public void setScor(Map<String, Integer> scor) {
        this.scor = scor;
    }

    // Metode adiționale
    public void adaugaScor(String echipa, Integer goluri) {
        scor.put(echipa, goluri);
    }

    @Override
    public String toString() {
        return "Meci între " + echipaAcasa.getNume() + " și " + echipaOaspeti.getNume() +
                " la data de " + dataOra.toString() + " pe stadionul " + stadion.getNume() +
                ". Scorul actual este: " + scor.toString();
    }
}
