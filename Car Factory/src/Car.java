/**
 * Represents a car with a type, year, color, and mileage.
 *
 * @author Ivan Wang
 */
public class Car {

    private String type;
    private int year;
    private String color;
    private int mileage;

    /**
     * Constructor for Car object with a specified type, year, color, and mileage.
     * @param type the type of car.
     * @param year the year the car was made.
     * @param color the color of the car.
     * @param mileage the mileage of the car.
     */
    public Car(String type, int year, String color, int mileage){
        this.type=type;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
    }

    /**
     * @return The car type.
     */
    public String getType(){
        return type;
    }

    /**
     * @return The year the car was made.
     */
    public int getYear(){
        return year;
    }

    /**
     * @return The color of the car.
     */
    public String getColor() {
        return color;
    }

    /**
     * @return The mileage of the car.
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * Returns a string representation of the Car object with all of its attributes.
     *
     * @return A string representation of the car.
     */
    @Override
    public String toString() {
        return year + " " +
                color + " "+
                type + " with " +
                mileage + " miles.";
    }
}
