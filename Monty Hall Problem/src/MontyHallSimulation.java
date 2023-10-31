import java.util.Random;

/**
 * This class represents a simulation of the Monty Hall Problem.
 * In the game, a contestant chooses one of three doors.
 * Behind one door is a prize and behind the other two are goats.
 * After the contestant makes an initial choice, one of the other two doors with a goat is revealed.
 * The contestant then has the option to either stick with their initial choice or switch with the other unopened door.
 *
 * This simulation demonstrates the results of switching and not switching.
 */

public class MontyHallSimulation {

    /**
     * Runs the Monty Hall simulation for a given number of times and prints the results.
     * It simulates:
     * 1. The contestant stays with their original choice.
     * 2. The contestant switches their choice after a goat is revealed.
     *
     * @param times Number of times the simulation should run.
     */
    public static void play(int times){
        int u_wins = 0;
        int c_wins = 0;
        Random pick = new Random();

        // Simulating the scenario where the contestant stays with their original choice.
        for (int i = 0; i < times; i++){
            int user = pick.nextInt(1,4);
            int pc = pick.nextInt(1,4);

            if (user == pc)
                u_wins++;
        }

        // Simulating the scenario where the contestant switches their choice after a goat is revealed,
        for (int i = 0; i < times; i++){

            int user = pick.nextInt(1,4);
            int prize = pick.nextInt(1,4);

            if (user != prize)
                c_wins++;

        }

        // Printing the win percentages for both scenarios.
        System.out.println("stay win %: "  + (100 * ((double)u_wins) / times) + ", switch win %: " + (100 * ((double)c_wins) / times));
    }

}