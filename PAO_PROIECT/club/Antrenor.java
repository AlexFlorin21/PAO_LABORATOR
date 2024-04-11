package club;
import java.util.ArrayList;
import java.util.List;
public class Antrenor extends Persoana {
    private String specializare;
    private int aniExperienta;
    private List<String> echipeAntrenate;


    public Antrenor(String specializare, int aniExperienta, List<String> echipeAntrenate) {
        this.specializare = specializare;
        this.aniExperienta = aniExperienta;
        this.echipeAntrenate = new ArrayList<>(echipeAntrenate);
    }
    public Antrenor() {

        this.nume = "Necunoscut";
        this.aniExperienta = 0;
        this.echipeAntrenate = new ArrayList<>();
    }
    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public int getAniExperienta() {
        return aniExperienta;
    }

    public void setAniExperienta(int aniExperienta) {
        this.aniExperienta = aniExperienta;
    }

    public List<String> getEchipeAntrenate() {
        return echipeAntrenate;
    }



    @Override
    public String toString() {
        return "Antrenor{" +
                "specializare='" + specializare + '\'' +
                ", aniExperienta=" + aniExperienta +
                ", echipeAntrenate=" + echipeAntrenate +
                '}';
    }
}
