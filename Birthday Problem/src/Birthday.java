/**
 * Contains methods for simulating the birthday paradox problem.
 *
 * Author: Ivan Wang
 */
public class Birthday {

    /**
     * Generates an array of Person objects with random birthdays.
     * @param count the number of Person objects to generate.
     * @return an array of Person objects with random birthdays.
     */
    public static Person[] birth(int count){
        Person[] array = new Person[count];
        for (int i = 0; i < count; i++){
            array[i]= new Person();
            array[i].scramble();
        }
        return array;
    }

    /**
     * Compares the birthdays of two Person objects.
     * @param one the first Person object.
     * @param two the second Person object.
     * @return true if they have the same birthday, false otherwise.
     */
    public static boolean compare(Person one,Person two){
        return (one.getDay()==two.getDay() && one.getMonth()==two.getMonth());
    }

    /**
     * Simulates the probability of two people sharing the same birthday in a group of people.
     * @param peopleCount the number of people to simulate
     * @param simCount the number of simulations to run.
     * @return the proportion of simulations where at least two people share a birthday (between 0 and 1).
     */
    public static double birthdaySimulation(int peopleCount, int simCount){
        int count = 0;

        for (int s = 0; s < simCount; s++){
            Person[] list = birth(peopleCount);
            boolean match = false;

            for (int i = 0; i < list.length-1 && !match; i++){
                for (int j = i+1; j < list.length; j++){
                    if (compare(list[i],list[j])){
                        match = true;
                        break;
                    }
                }
            }
            if (match)
                count++;
        }

        return (double)count/simCount;
    }

}
