import java.util.Hashtable;

public class Library extends Building{

    /** edit
     * This is a collection which tracks titles and checks out the status
     * hasElevator returns T/F whether the library has elevator or not
     **/
    private Hashtable<String, Boolean> collection;
    private boolean hasElevator;

    /**
     * Constructs a Library
     * @param library library name (String)
     * @param address library address (String)
     * @param numOfFloors number of floors in the library (int)
     **/
    public Library(String name, String address, int floors, boolean hasElevator){
      super(name, address, floors);
      this.hasElevator = hasElevator;
      this.collection = new Hashtable<>();
      System.out.println("Yay! Library built!");
    }
    
    /**
     * Adds title to collection of titles; this throws an exception when title is in collection
     * @param title name of book and author (String)
     **/
    public void addTitle(String title){
      if (this.collection.containsKey(title)){
        throw new RuntimeException("Unable to add in the collection");
      }
      else {
        this.collection.put(title, true);
      }
    }

    /** Overloaded method
     * Adds two books to system; checks if titles are in the system already, if the titles are same or not, or if one of books is has been added and before adding the titles to the system
     * @param title1 String title of first book added
     * @param title2 String title of second book
     **/
    public void addTitle(String title1, String title2) {
      if(this.collection.containsKey(title1) && this.collection.containsKey(title2)){
        throw new RuntimeException("Already in the system");
      }
      else if (title1.equals(title2)){
        throw new RuntimeException("Can only add different books to the system");
      }
      else if (this.collection.containsKey(title1)){
          this.collection.put(title2, true);
          throw new RuntimeException(title2 + " is added to collection." + title1 + " is a copy");
      }
      else if(this.collection.containsKey(title1)){
         this.collection.put(title2, true);
         throw new RuntimeException(title2 + " is added to collection." + title1 + " is a copy");
      }
      else{
        this.collection.put(title1, true);
        this.collection.put(title2, true);
      }
    } 

    /**
     * Throws an exception when title is not in collection; if not, this removes the title from the collection
     * @param title name of book and author (String)
     * @return title which was removed (String)
     */
    public String removeTitle(String title){
      if (!this.collection.containsKey(title)){
        throw new RuntimeException("Unable to view in the system");
      }
      this.collection.remove(title);
      return title;
    }

    /**
     * Throws an exception when value is false; if not, this sets value to false
     * @param title book and author (String)
     **/
    public void checkOut(String title){
      if (!this.collection.get(title)){
        throw new RuntimeException("Unable to check out");
      }
      else {
        this.collection.replace(title, false);
      }
    }

    /**
     * Throws an exception when the title is in collection; if not, the value becomes true
     * @param title String name of book and author
     **/
    public void returnBook(String title) {
      if (this.collection.containsKey(title)) {
        throw new RuntimeException("Found in the system"); 
      }
      else {
        this.collection.replace(title, true); 
      }
    }

    /**Overloaded method
     * Makes sures that both books are not returned yet or either has not been returned or not
     * @param title1 book title and author returned (String)
     * @param title2 book title and author returned (String)
     **/
    public void returnBook(String book1, String book2){
      if(this.collection.containsKey(book1) && this.collection.containsKey(book2)){
        throw new RuntimeException("Both books are already returned.");
      }
      else if(book1.equals(book2)) {
        throw new RuntimeException("Same books.");
      }
      else if(this.collection.containsKey(book1)) {
        this.collection.replace(book2, true);
        throw new RuntimeException(book2 + " has been added to the system. \n" + book1 + " is already in the system.");
      }
      else if(this.collection.containsKey(book2)){
        this.collection.replace(book2, true);
        throw new RuntimeException(book1 + " has been added to the system.\n" + book2 + "is already in the system.");
      }
      else {
        this.collection.replace(book1, true);
        this.collection.replace(book2, true);
      }
    }

    /**
     * Returns a Boolean when the collection has a title
     * @param title name of book (String)
     * @return T/F if collection has a title (boolean)
     **/
    public boolean containsTitle(String title) {
      return this.collection.containsKey(title); 
    }

    /**
     * Returns a value if the title is in the collection
     * @param title name of title and book (String)
     * @return T/F value if the title is currently available, false otherwise
     **/
    public boolean isAvailable(String title) {
      return this.collection.get(title); 
    }

    /**
     * Prints out the collection
     **/
    public void printCollection() {
      System.out.println(this.collection.toString());
    }

    /**
     * Prints out methods for users to use
     **/
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n addTitle(t) \n removeTitle(t) \n checkOut(t) \n returnBook(t)\n containsTitle(t) \n isAvailable(t) \n printCollection()");
    }

    /**
     * If there is an elevator, this changes activefloor to floorNum; if not, this checks that the individual is in the building and checks if the floor is valid.
     **/
    public void goToFloor(int floorNum) {
      if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Not valid floor number. Valid range:" + this.nFloors +".");
      }
      if(!hasElevator){
        if((this.activeFloor) + 1 == floorNum || this.activeFloor -1 == floorNum) {
          System.out.println("You are now on floor #" + floorNum + " in the building " + this.name);
          this.activeFloor = floorNum;
        }
        else{
          throw new RuntimeException("No elevator. You can only use stairs. Sorry."); 
        }
      }
      else{
        System.out.println("You are now on floor #" + floorNum + " in the building " + this.name);
        this.activeFloor = floorNum;
      }
    }

    public static void main(String[] args) {
      Library NeilsonLibrary = new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4, true);
      
      NeilsonLibrary.addTitle("Book Lovers by Emily Henry");
      NeilsonLibrary.addTitle("One Last Stop by Casey McQuiston");
      NeilsonLibrary.addTitle("The Seven Husbands of Evelyn Hugo by Taylor Jenkins Reid");

      NeilsonLibrary.checkOut("The Seven Husbands of Evelyn Hugo by Taylor Jenkins Reid");
      NeilsonLibrary.printCollection();
    }
  }