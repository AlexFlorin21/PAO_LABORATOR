package club;

public class StatisticiJucator {
    private int goluri;
    private int asisturi;
    private int cartonaseGalbene;
    private int cartonaseRosii;


    public StatisticiJucator(int goluri, int asisturi, int cartonaseGalbene, int cartonaseRosii) {
        this.goluri = goluri;
        this.asisturi = asisturi;
        this.cartonaseGalbene = cartonaseGalbene;
        this.cartonaseRosii = cartonaseRosii;
    }


    public int getGoluri() {
        return goluri;
    }

    public int getasisturi() {
        return asisturi;
    }

    public int getCartonaseGalbene() {
        return cartonaseGalbene;
    }

    public int getCartonaseRosii() {
        return cartonaseRosii;
    }


    public void setGoluri(int goluri) {
        this.goluri = goluri;
    }

    public void setasisturi(int asisturi) {
        this.asisturi = asisturi;
    }

    public void setCartonaseGalbene(int cartonaseGalbene) {
        this.cartonaseGalbene = cartonaseGalbene;
    }

    public void setCartonaseRosii(int cartonaseRosii) {
        this.cartonaseRosii = cartonaseRosii;
    }


    @Override
    public String toString() {
        return "Goluri: " + goluri + ", asisturi: " + asisturi +
                ", Cartonase Galbene: " + cartonaseGalbene +
                ", Cartonase Rosii: " + cartonaseRosii;
    }
}

