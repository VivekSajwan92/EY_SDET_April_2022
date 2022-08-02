package home;

public class Builder {

    public static void main(String[] args) {

        HouseBuildPlanner modernHouse = new ModernHouse();
        HouseBuildPlanner tailedRoofHouse = new TailedRoofHouse();
        Engineer engineer = new Engineer(modernHouse);
        engineer.ConstructHome();

        House house = engineer.getHouse();
        System.out.println(house);
    }
}
