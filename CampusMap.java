import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     **/
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     **/
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        System.out.println(myMap);
        myMap.addBuilding(new Building("Burton Hall", "46 College Ln, Northampton, MA 01063", 4)); 
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("McConnell Hall", "2 Tyler Ct, Northampton, MA 01060", 4)); 

        myMap.addBuilding(new Cafe("Ana Bandeira", "48 Main St., Northampton, MA 01060", 1, 1000, 500, 500, 500)); 
        myMap.addBuilding(new Cafe("Cafe Balagan", "241 Main St., Northampton, MA 01060", 1, 1000, 500, 500, 500));
        myMap.addBuilding(new Cafe("Iconica", "1 Amber Ln, Northampton, MA 01060", 2, 1000, 500, 500, 500));

        myMap.addBuilding(new House ("Chase House", "45 Elm St., Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new House("Gillet House", "47 Elm St., Northampton, MA 01060", 5, true, true));
        myMap.addBuilding(new House("Haynes House", "1 Mandelle Rd, Northampton, MA 01603", 5,true, true)); 
        myMap.addBuilding(new House("Washburn House", "4 Seelye Dr, Northampton, MA 01060", 4, false, false)); 

        myMap.addBuilding(new Library("Forbes Library", "20 West St., Northampton, MA 01060", 3, true));
        myMap.addBuilding(new Library("Hillyer Art Library", "22 Elm St., Northampton, MA 01063", 1, false));
    }
    
}