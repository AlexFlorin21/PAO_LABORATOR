package club;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import campionat.Meci;
import java.util.Comparator;
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
        System.out.println("Jucatorul " + nume + " a fost adaugat cu succes.");
    }

    //  cautarea unui jucator dupa nume
    public Jucator cautaJucator(String nume) {
        for (Jucator jucator : jucatori) {
            if (jucator.getNume().equalsIgnoreCase(nume)) {
                return jucator;
            }
        }
        System.out.println("Jucatorul cu numele " + nume + " nu a fost gasit.");
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
        System.out.println("Echipa " + numeEchipa + " a fost creata cu succes.");
    }
    //calcul puncte echipa
    public int calculeazaPuncteEchipa(String numeEchipa) {
        for (Echipa echipa : echipe) {
            if (echipa.getNume().equalsIgnoreCase(numeEchipa)) {

                int puncte = echipa.getVictorii() * 3 + echipa.getEgaluri();
                return puncte;
            }
        }
        System.out.println("Echipa cu numele " + numeEchipa + " nu a fost găsită.");
        return -1;
    }
    public void clasamentEchipe() {

        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < echipe.size() - 1; i++) {
                Echipa echipa1 = echipe.get(i);
                Echipa echipa2 = echipe.get(i + 1);
                int puncteEchipa1 = calculeazaPuncteEchipa(echipa1.getNume());
                int puncteEchipa2 = calculeazaPuncteEchipa(echipa2.getNume());

                if (puncteEchipa1 > puncteEchipa2) {

                    echipe.set(i, echipa2);
                    echipe.set(i + 1, echipa1);
                    swapped = true;
                }
            }
        } while (swapped);

        // Afisare clasamentul echipei
        System.out.println("Clasament Echipe:");
        for (Echipa echipa : echipe) {
            int puncte = calculeazaPuncteEchipa(echipa.getNume());
            System.out.println(echipa.getNume() + ": " + puncte + " puncte");
        }
    }
    public void actualizeazaJucator(String nume, int varsta, String nationalitate, char gen, String pozitie, int numarTricou, int goluri, int cartonaseGalbene, int cartonaseRosii) {
        for (Jucator jucator : jucatori) {
            if (jucator.getNume().equalsIgnoreCase(nume)) {
                jucator.setVarsta(varsta);
                jucator.setNationalitate(nationalitate);
                jucator.setGen(gen);
                jucator.setPozitie(pozitie);
                jucator.setNumarTricou(numarTricou);
                jucator.getStatistici().setGoluri(goluri);
                jucator.getStatistici().setCartonaseGalbene(cartonaseGalbene);
                jucator.getStatistici().setCartonaseRosii(cartonaseRosii);
                System.out.println("Datele jucatorului " + nume + " au fost actualizate.");
                return;
            }
        }
        System.out.println("Jucatorul cu numele " + nume + " nu a fost gasit.");
    }

    public Jucator cautaJucatorDupaNume(String nume) {
        for (Jucator jucator : jucatori) {
            if (jucator.getNume().equalsIgnoreCase(nume)) {
                return jucator;
            }
        }
        return null;
    }
    public void listeazaMeciuri() {
        if (meciuri.isEmpty()) {
            System.out.println("Nu exista meciuri programate.");
            return;
        }

        System.out.println("Meciuri programate:");
        for (Meci meci : meciuri) {
            String detaliiMeci = String.format("Echipa gazda: %s vs. Echipa oaspete: %s | Data: %s | Stadion: %s",
                    meci.getEchipaAcasa().getNume(),
                    meci.getEchipaOaspeti().getNume(),
                    meci.getDataOra().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                    meci.getStadion().getNume());
            System.out.println(detaliiMeci);
        }
    }


    public void listeazaMeciuriSortateDupaEchipaAcasa() {
        if (meciuri.isEmpty()) {
            System.out.println("Nu exista meciuri programate.");
            return;
        }

        meciuri.sort(Comparator.comparing(m -> m.getEchipaAcasa().getNume()));

        System.out.println("Meciuri programate, sortate dupa echipa gazda:");
        for (Meci meci : meciuri) {
            String detaliiMeci = String.format("Echipa gazda: %s vs. Echipa oaspete: %s | Data: %s | Stadion: %s",
                    meci.getEchipaAcasa().getNume(),
                    meci.getEchipaOaspeti().getNume(),
                    meci.getDataOra().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                    meci.getStadion().getNume());
            System.out.println(detaliiMeci);
        }
    }

    public void interogareStatisticiJucator(String numeJucator) {
        for (Jucator jucator : jucatori) {
            if (jucator.getNume().equalsIgnoreCase(numeJucator)) {
                StatisticiJucator statistici = jucator.getStatistici();
                if (statistici != null) {
                    System.out.println("Statistici pentru jucatorul " + jucator.getNume() + ": " + statistici.toString());
                } else {
                    System.out.println("Nu exista statistici pentru jucatorul " + jucator.getNume() + ".");
                }
                return;
            }
        }
        System.out.println("Jucatorul cu numele " + numeJucator + " nu a fost gasit.");
    }
    public Echipa gasesteEchipaDupaNume(String numeEchipa) {
        for (Echipa echipa : echipe) {
            if (echipa.getNume().equals(numeEchipa)) {
                return echipa;
            }
        }
        return null;
    }

    // Transfer jucator
    public void transferJucator(Jucator jucator, Echipa echipaSursa, Echipa echipaDestinatie) {
        if (echipaSursa.getJucatori().remove(jucator)) {
            echipaDestinatie.adaugaJucator(jucator);
            System.out.println("Jucatorul " + jucator.getNume() + " a fost transferat de la " + echipaSursa.getNume() + " la " + echipaDestinatie.getNume() + ".");
        } else {
            System.out.println("Transferul jucatorului " + jucator.getNume() + " nu a reusit.");
        }
    }

    // Interogare statistici jucator
    public void interogareStatisticiJucator(Jucator jucator) {
        StatisticiJucator statistici = jucator.getStatistici();
        System.out.println("Statistici pentru jucatorul " + jucator.getNume() + ": " + statistici.toString());
    }

    // Programare meci
    public void programareMeci(Echipa echipaAcasa, Echipa echipaOaspeti, LocalDateTime dataOra, Stadion stadion) {
        Meci nouMeci = new Meci(echipaAcasa, echipaOaspeti, dataOra, stadion);
        meciuri.add(nouMeci);
        System.out.println("Meciul dintre " + echipaAcasa.getNume() + " și " + echipaOaspeti.getNume() + " a fost programat pentru " + dataOra.toString() + " pe stadionul " + stadion.getNume() + ".");
    }
}

