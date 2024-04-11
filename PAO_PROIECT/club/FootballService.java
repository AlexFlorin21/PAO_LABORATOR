package club;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import campionat.Meci;
public class FootballService {
    private List<Jucator> jucatori;
    private List<Echipa> echipe;
    private List<Meci> meciuri;

    public FootballService() {
        this.jucatori = new ArrayList<>();
    }
    public FootballService(List<Echipa> echipe, List<Meci> meciuri) {
        this.jucatori = new ArrayList<>();
        this.echipe = echipe;
        this.meciuri = meciuri;
    }

    // Metoda pentru adaugarea unui jucator
    public void adaugaJucatorComplet(String nume, int varsta, String nationalitate, char gen, String pozitie, int numarTricou, int goluri, int asistente, int cartonaseGalbene, int cartonaseRosii) {
        StatisticiJucator statistici = new StatisticiJucator(goluri, asistente, cartonaseGalbene, cartonaseRosii);
        Jucator jucator = new Jucator(nume, varsta, nationalitate, gen, pozitie, numarTricou, statistici);
        jucatori.add(jucator);
        System.out.println("Jucătorul " + nume + " a fost adăugat cu succes.");
    }

    // Metoda pentru cautarea unui jucator dupa nume
    public Jucator cautaJucator(String nume) {
        for (Jucator jucator : jucatori) {
            if (jucator.getNume().equalsIgnoreCase(nume)) {
                return jucator;
            }
        }
        System.out.println("Jucătorul cu numele " + nume + " nu a fost găsit.");
        return null;
    }
    // Creare echipa
    public void creareEchipa(String numeEchipa, String numeAntrenor, int aniExperienta, ArrayList<String> echipeAntrenate, int victorii, int infrangeri, int egaluri) {
        Antrenor antrenor = new Antrenor(numeAntrenor, aniExperienta, echipeAntrenate);
        Echipa echipa = new Echipa(numeEchipa, antrenor);
        echipa.setVictorii(victorii);
        echipa.setInfrangeri(infrangeri);
        echipa.setEgaluri(egaluri);
        echipe.add(echipa);
        System.out.println("Echipa " + numeEchipa + " a fost creată cu succes.");
    }
    public int calculeazaPuncteEchipa(String numeEchipa) {
        for (Echipa echipa : echipe) {
            if (echipa.getNume().equalsIgnoreCase(numeEchipa)) {
                // Calculăm punctele în funcție de victorii, egaluri și înfrângeri
                int puncte = echipa.getVictorii() * 3 + echipa.getEgaluri();
                return puncte;
            }
        }
        System.out.println("Echipa cu numele " + numeEchipa + " nu a fost găsită.");
        return -1; // Sau o altă valoare care indică faptul că echipa nu a fost găsită
    }

    public void interogareStatisticiJucator(String numeJucator) {
        for (Jucator jucator : jucatori) {
            if (jucator.getNume().equalsIgnoreCase(numeJucator)) {
                StatisticiJucator statistici = jucator.getStatistici();
                if (statistici != null) {
                    System.out.println("Statistici pentru jucătorul " + jucator.getNume() + ": " + statistici.toString());
                } else {
                    System.out.println("Nu există statistici pentru jucătorul " + jucator.getNume() + ".");
                }
                return;
            }
        }
        System.out.println("Jucătorul cu numele " + numeJucator + " nu a fost găsit.");
    }
    public Echipa gasesteEchipaDupaNume(String numeEchipa) {
        for (Echipa echipa : echipe) {
            if (echipa.getNume().equals(numeEchipa)) {
                return echipa;
            }
        }
        return null; // sau arunca o exceptie, in functie de cum preferi sa gestionezi
    }

    // Transfer jucator
    public void transferJucator(Jucator jucator, Echipa echipaSursa, Echipa echipaDestinatie) {
        if (echipaSursa.getJucatori().remove(jucator)) {
            echipaDestinatie.adaugaJucator(jucator);
            System.out.println("Jucătorul " + jucator.getNume() + " a fost transferat de la " + echipaSursa.getNume() + " la " + echipaDestinatie.getNume() + ".");
        } else {
            System.out.println("Transferul jucătorului " + jucator.getNume() + " nu a reușit.");
        }
    }

    // Interogare statistici jucator
    public void interogareStatisticiJucator(Jucator jucator) {
        StatisticiJucator statistici = jucator.getStatistici();
        System.out.println("Statistici pentru jucătorul " + jucator.getNume() + ": " + statistici.toString());
    }

    // Programare meci
    public void programareMeci(Echipa echipaAcasa, Echipa echipaOaspeti, LocalDateTime dataOra, Stadion stadion) {
        Meci nouMeci = new Meci(echipaAcasa, echipaOaspeti, dataOra, stadion);
        meciuri.add(nouMeci);
        System.out.println("Meciul dintre " + echipaAcasa.getNume() + " și " + echipaOaspeti.getNume() + " a fost programat pentru " + dataOra.toString() + " pe stadionul " + stadion.getNume() + ".");
    }
}

