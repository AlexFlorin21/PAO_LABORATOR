package club;

public abstract class Persoana {
    protected String nume;
    protected int varsta;
    protected String nationalitate;
    protected char gen;

    // Constructor

    public Persoana() {
    }

    public Persoana(String nume, int varsta, String nationalitate, char gen) {
        this.nume = nume;
        this.varsta = varsta;
        this.nationalitate = nationalitate;
        this.gen = gen;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getNationalitate() {
        return nationalitate;
    }

    public void setNationalitate(String nationalitate) {
        this.nationalitate = nationalitate;
    }

    public char getGen() {
        return gen;
    }

    public void setGen(char gen) {
        this.gen = gen;
    }


}
