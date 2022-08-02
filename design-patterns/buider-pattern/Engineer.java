package home;

public class Engineer {

    public HouseBuildPlanner houseBuildPlanner;

    public Engineer(HouseBuildPlanner houseBuildPlanner){
        this.houseBuildPlanner=houseBuildPlanner;
    }

    public void ConstructHome(){
        this.houseBuildPlanner.buildBaseMent();
        this.houseBuildPlanner.buildRoof();
        this.houseBuildPlanner.buildInterior();

    }

    public House getHouse(){
        return this.houseBuildPlanner.getHouse();
    }
}
