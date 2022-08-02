package home;

public class TailedRoofHouse implements HouseBuildPlanner{

    private House house;

    public TailedRoofHouse(){
       this.house=new House();
    }

    @Override
    public void buildBaseMent() {

        this.house.setBasement("This is the tailed roof house's basement");
    }

    @Override
    public void buildRoof() {

        this.house.setRoof("This is the tailed roof house's roof");
    }

    @Override
    public void buildInterior() {

        this.house.setInterior("This is the tailed roof house's interior");
    }

    @Override
    public home.House getHouse() {
        return this.house;
    }
}
