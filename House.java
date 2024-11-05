import java.util.ArrayList;

public class House extends Building{
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Constructs House by getting its name, address, floor numbers, and hasDining (whether it has a dining hall or not); Initializes name, address, floor numbers using a super class
   * @param name name of the resident (String)
   * @param address house address (String)
   * @param floor number of floors (String)
   * @param hasDining has dining or not (Boolean)
   */
  public House(String name, String address, int floor, boolean hasDining, boolean hasElevator){
    super(name, address, floor);
    residents = new ArrayList<>();
    this.hasDiningRoom = hasDining;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Constructs a house with just one floor & default sets hasElevator to false and floor to 1
   * @param name house name (String)
   * @param address house address (String)
   * @param hasDining T/F if house has dining room (boolean)
   */
  public House(String name, String address, boolean hasDining){
    super(name, address, 1);
    residents = new ArrayList<>();
    this.hasDiningRoom = hasDining;
    this.hasElevator = false;
    System.out.println("You have built a house: 🏠");
  }

  /** edit
   * Constructs a house with address and hasDining
   * @param address house address (String)
   * @param hasDining T/F if the house has a dining room (boolean)
   */
  public House(String address, boolean hasDining){
    super(address);
    this.hasDiningRoom = hasDining;
    this.hasElevator = false;
  }

  /**
   * Determines whether the House has dining hall or not
   * @return T/F if house has dining hall or not (Boolean)
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Determines if house has an elevator
   * @return T/F if house has elevator (boolean)
   */
  public boolean hasElevator(){
    return this.hasElevator();
  }

  /**
   * The number of residents in the house
   * @return the count of number of residents in the house (int)
   */
  public int nResidents(){
    return residents.size();
  }

  /**
   * Throws an exception when the resident is already in the house; if not, it adds the resident to the house
   * @param name resident name (String)
   */
  public void moveIn(String name){
    if (residents.contains(name)){
      throw new RuntimeException(name + " is already in the house");
    }
    else {
      this.residents.add(name);
    }
  }

  /**
   * Throws an exception when the resident is not in name; if not, this removes the resident
   * @param name resident name (String)
   * @return resident name who moved out (String)
   */
  public String moveOut(String name){
    if (!residents.contains(name)){
      throw new RuntimeException(name + " is not in the house");
    }
    else {
      this.residents.remove(name);
      return name;
    }
  }

  /**
   * Determines if a person is a resident in the House or not
   * @param person String name of resident
   * @return true/false if resident lives in the house or not
   */
  public boolean isResident(String person){
    if(this.residents.contains(person)){
      return true;
    }
    else{
      return false;
    }
  }
  
  /**
   * Prints out methods users can use in the House class
   */
  public void showOptions(){
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n moveIn(n) \n moveOut(n) \n nResident() \n isResident(n)");
  }
  

  public void goToFloor(int floorNum){
    if (this.activeFloor == -1){
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors){
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if(!hasElevator){
      if((this.activeFloor) + 1 == floorNum || this.activeFloor -1 == floorNum){
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
      }
      else{
        throw new RuntimeException("You can only go one floor at a time by stairs");
      }
    }
    else{
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
    }
  }

  public static void main(String[] args){
    House home = new House("Northrop", "Elm St.", 6, true, true);
    home.moveIn("Rya");
    home.moveIn("Joanne");
    home.moveIn("Maneeta");

    home.isResident("Rya");
    home.isResident("Jasmin");
  }
}