public class Building{

    protected String name;
    protected String address;
    protected int nFloors;
    protected int activeFloor = -1;

    /* Default Constructor */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /* Overloaded constructor with address only */
    public Building(String address){
        this();
        this.address = address;
    }

    /* Overloaded constructor with name and address */
    public Building(String name, String address){
        this(name, address, 1);
    }

    /* Full constructor */
    public Building(String name, String address, int nFloors){
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address;}
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
    * Returns the building name
    * @return name of building (String)
    */
    public String getName(){
        return this.name;
    }

    /**
     * Returns building address
     * @return address of building (String)
     */
    public String getAddress(){
        return this.address;
    }

    /**
     * Returns number of floors
     * @return number of floors in the building (int)
     */
    public int getFloors(){
        return this.nFloors;
    }

    /* Navigation methods */

    public Building enter(){
        if (activeFloor != -1){
            throw new RuntimeException("You are already inside this Building.");
        }
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this; // Return a pointer to the current building
    }

    public Building exit(){
        if (this.activeFloor == -1){
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1){
            throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        this.activeFloor = -1;
        return null;
    }

    public void goToFloor(int floorNum){
        if (this.activeFloor == -1){
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors){
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    public void goUp(){
        this.goToFloor(this.activeFloor + 1);
    }

    public void goDown(){
        this.goToFloor(this.activeFloor - 1);
    }

    public void showOptions(){
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    /*
     * Returns the building's name, address, and number of floors
     */
    public String toString(){
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    public static void main(String[] args){
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
        fordHall.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        fordHall.enter();
        fordHall.goUp();
        fordHall.goDown();
        fordHall.exit();
    }
}