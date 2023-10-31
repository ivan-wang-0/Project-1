import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class BirthdayTester {
    public static void main(String[] args) {
        int peopleCount = 10;
        int simCount = 1000;
        double percentage = 100* Birthday.birthdaySimulation(peopleCount, simCount);
        System.out.println("In a group of " + peopleCount +
                " people, the probability that at least two " +
                String.format("people share a birthday is: %.1f", percentage) +
                "% (simulated " + simCount + " times).");
    }
}
