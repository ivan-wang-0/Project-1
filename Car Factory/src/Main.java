//Writer class. 'Construct' cars.
//        Randomly generate a carType (select from a few)
//        Year (withinj last 50 years)
//        Color (Set of colors you pick. MAKE RED SLIGHTLY MORE POPULAR)
//        Miles between 0-250,000
//Generate 1000 cars. Store it in a data structure
//        Write them out as a CSV
//        Look up bufferedReader to scan file.
//        Demonstrate that the loading worked
//Use Excel to generate some graphs representing the data.

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        int carCount = 1000; // The number of cars to generate.
        String filename = "assembly.csv";

        ArrayList<Car> generatedCars = Factory.generator(carCount); //Generates count number of cars.

        displayCars("Here are the first 5 cars before exporting.", generatedCars, 5);

        Factory.exporter(generatedCars, filename); // Exports the count number of cars into a .csv file.

        ArrayList<Car> importedCars = Factory.importer(filename); // Imports file to ArrayList

        displayCars("Here are the first 5 cars after importing:", importedCars, 5);
    }


    private static void displayCars(String message, ArrayList<Car> cars, int count){
        System.out.println(message);
        int limit = Math.min(count, cars.size());
        for (int i = 0; i < limit; i++){
            System.out.println(cars.get(i));
        }
        System.out.println(); // New line
    }

}

