package club;

public class Jucator extends Persoana {
    private String pozitie;
    private int numarTricou;
    private StatisticiJucator statistici;


    public Jucator(String nume, int varsta, String nationalitate, char gen, String pozitie, int numarTricou, StatisticiJucator statistici) {
        super(nume, varsta, nationalitate, gen);
        this.pozitie = pozitie;
        this.numarTricou = numarTricou;
        this.statistici = statistici;
    }

    public Jucator(String pozitie) {
        this.pozitie = pozitie;
    }

    public String getPozitie() {
        return pozitie;
    }

    public void setPozitie(String pozitie) {
        this.pozitie = pozitie;
    }

    public int getNumarTricou() {
        return numarTricou;
    }

    public void setNumarTricou(int numarTricou) {
        this.numarTricou = numarTricou;
    }

    public StatisticiJucator getStatistici() {
        return statistici;
    }

    public void setStatistici(StatisticiJucator statistici) {
        this.statistici = statistici;
    }

    // Metoda toString() suprascrisă
    @Override
    public String toString() {
        return super.toString() + ", Pozitie: " + pozitie + ", Numar Tricou: " + numarTricou + ", Statistici: " + statistici.toString();
    }
}
