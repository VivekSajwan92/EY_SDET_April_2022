package home;

public class ModernHouse implements HouseBuildPlanner{

    private House house;

    public ModernHouse(){
       this.house=new House();
    }

    @Override
    public void buildBaseMent() {

        this.house.setBasement("This is the Modern house's basement");
    }

    @Override
    public void buildRoof() {

        this.house.setRoof("This is the Modern house's roof");
    }

    @Override
    public void buildInterior() {

        this.house.setInterior("This is the Modern house's interior");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
