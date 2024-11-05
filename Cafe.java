/* This is a stub for the Cafe class */
public class Cafe extends Building {

    /**
     * nCoffeeOunces is int, nnumber of ounces of coffee remaining in inventory 
     * nSugarPackets is int, number of sugar packets in inventory
     * nCreams is int, number of splashes of cream in inventory 
     * nCups is int, the number of cups remaining in inventory
     */
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructs name, address, and number of floors
     * Constructs Cafe with name, address, number of floors, number of coffee ounces remaining, number of sugar packets remaining, number of "splashes" of cream remaining, and number of cups remaining in inventory
     * @param name name of cafe (String)
     * @param address address of the cafe (String)
     * @param numOfFloors number of floors in the cafe building (int)
     * @param nCoffeeOunces number of coffee ounces remaining in inventory (int)
     * @param nSugarPackets number of sugar packets remaining in inventory (int)
     * @param nCreams number of creams remaining in inventory (int)
     * @param nCups number of cups remaining in inventory (int)
     */
    public Cafe(String name, String address, int floors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, floors); 
        this.nCoffeeOunces = nCoffeeOunces;  
        this.nSugarPackets = nSugarPackets; 
        this.nCreams = nCreams; 
        this.nCups = nCups; 
        System.out.println("Yay! Cafe built!");
    }
    
    /**
     * Throws an exception when the coffee ounces, the sugar packets, and the creams run out; if not, the number decreases
     * @param numCoffeeOunces number of coffee ounces (int)
     * @param nSugarPackets number of sugar packets (int)
     * @param nCreams number of creams (int)
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if(nCoffeeOunces - size <= 0 || this.nSugarPackets - nSugarPackets <= 0 || this.nCreams - nCreams <= 0) {
            throw new RuntimeException("No more remaining"); 
        }
        else {
            nCoffeeOunces -= size; 
            this.nSugarPackets -= nSugarPackets; 
            this.nCreams -= nCreams; 
            this.nCups -= nCups;  
        }
    }

    /**
     * Sells coffee
     * @param size coffee size (int)
     */
    public void sellCoffee(int size) {
        if(nCoffeeOunces - size <= 0) {
            throw new RuntimeException("No more remaining"); 
        }
        else {
            this.nCups -= nCups; 
            this.nCoffeeOunces -= size;
        }
    }
    

    /**
     * Adds coffee ounces, sugar packets, creams, cups to inventory
     * @param nCoffeeOunces number of coffee ounces (int)
     * @param nSugarPackets number of sugar packets (int)
     * @param nCreams number of creams (int)
     * @param nCups number of cups (int)
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Void method which restocks sugar packets and creams
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
    }

    /**
     * Prints out methods users can use
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + sellCoffee() \n + restock(nOunces) \n + nSugar \n + nCream \n + nCups)");
    }
    
    /**
     * Throws a new runtime exception if the cafe only has one floor
     */
    public void goToFloor(int floorNum) {
        throw new RuntimeException("The cafe is a one story building.");
    }
    

    public static void main(String[] args) {
        Cafe CC = new Cafe("Compass Cafe in Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 1, 10, 30, 40, 2);
        CC.restock(100, 100, 500, 1000);
        
    }
    
}