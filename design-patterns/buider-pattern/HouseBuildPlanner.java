package home;

public interface HouseBuildPlanner {

    public void buildBaseMent();
    public void buildRoof();
    public void buildInterior();

    // return the house object
    public House getHouse();
}
