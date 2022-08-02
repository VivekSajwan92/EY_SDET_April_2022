package home;


public class House implements Houseplan {

    String basement;
    String roof;
    String interior;

    @Override
    public void setBasement(String basement) {
       this.basement=basement;
    }

    @Override
    public void setRoof(String roof) {
        this.roof=roof;
    }

    @Override
    public void setInterior(String interior) {
        this.interior=interior;
    }

    @Override
    public String toString(){
        return "the basement of a house is"+basement+", roof is"+roof+", interior is "+interior;
    }

    // set these values in constructor
    // through setters



}
