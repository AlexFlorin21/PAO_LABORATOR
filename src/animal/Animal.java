package animal;

public class Animal {
    private String name;
    private int noOfLegs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfLegs() {
        return noOfLegs;
    }

    public void setNoOfLegs(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }
    public Animal(String name, int noOfLegs){
        this.name=name;
        this.noOfLegs=noOfLegs;
    }
    public Animal(){}


    public void move(){
        System.out.println("aichenmuv!");

    }
    public void eat(){
        System.out.println("ineedsomethingtoeat");
    }

    public void eat(String food){

    }


}

class Ape extends Animal {
    private String size;

    public Ape(String name, int noOfLegs, String size) {
        super(name, noOfLegs);
        this.size = size;
    }




}

class Bird extends Animal {
private String colour;

    public Bird(String name, int noOfLegs, String colour) {
        super(name, noOfLegs);
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
class Duck extends Bird {
    private int length;

    public Duck(String name, int noOfLegs, String colour, int length) {
        super(name, noOfLegs, colour);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public void eat(String food) {
        super.eat(food);
    }


}
