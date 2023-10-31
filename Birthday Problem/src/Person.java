import java.util.Random;

/**
 * Represents a person with a specific birthday.
 *
 * Author: Ivan Wang
 */
public class Person {
    /** Month of the birthday (1-12). */
    private int month;

    /** The day of the birthday (1-31, depending on the month, and assuming no leap years). */
    private int day;

    /**
     * Default constructor. Initializes the object without a specific date.
     */
    public Person() {
        month = 0;
        day = 0;
    }

    /**
     * Generates a random birthday for the person.
     */
    public void scramble(){
        Random gen = new Random();
        month = gen.nextInt(12)+1;
        if (month == 1 || month == 3 || month ==5 || month == 7 || month == 8 || month == 10 || month == 12)
            day = gen.nextInt(31)+1;
        else if (month == 4 || month == 6 || month ==9 || month == 11)
            day = gen.nextInt(30) + 1;
        else if (month == 2)
            day = gen.nextInt(28)+1;
    }

    /**
     * @return the month of the birthday.
     */
    public int getMonth(){
        return month;
    }

    /**
     * @return the day of the birthday.
     */
    public int getDay(){
        return day;
    }
}
