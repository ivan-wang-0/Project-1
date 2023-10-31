import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class Factory {


    /**
     * Generates a specified number of random cars.
     *
     * @param count The number of cars to generate.
     * @return A list of randomly generated cars.
     */
    public static ArrayList<Car> generator(int count){
        ArrayList<Car> assembly = new ArrayList<>();
        Random gen = new Random();
        String[] types = {"Sedan", "Sedan", "SUV", "Minivan", "Truck"};
        String[] colors = {"Red","Red","White","Blue","Grey","Silver"};
        int maxMileage = 250000;
        int yearRange = 50;
        int startYear = 1973;

        for (int i = 0; i < count; i++){
            String type = types[gen.nextInt(types.length)];
            int year = startYear + gen.nextInt(yearRange + 1);
            String color = colors[gen.nextInt(colors.length)];
            int miles = gen.nextInt(maxMileage + 1);
            //https://stackoverflow.com/questions/2432866/add-objects-with-different-name-through-for-loop
            assembly.add(new Car(type, year, color, miles));
        }

        return assembly;
    }

    /**
     * Exports a list of cars to a specified CSV file.
     *
     * @param assembly The list of cars to be exported.
     * @param outputName The name of the CSV file to export to.
     */
    public static void exporter(ArrayList<Car> assembly, String outputName){
        try {
            //found the Writer chunk from blog.gitnux.com/code/java-csv-write/
            FileWriter fW = new FileWriter(outputName);
            BufferedWriter bW = new BufferedWriter(fW);

            String header = "CarType,Year,Color,Mileage";
            bW.write(header);
            bW.newLine();

            for (Car car : assembly) {
                bW.write(car.getType() + "," + car.getYear() + "," + car.getColor() + "," + car.getMileage());
                bW.newLine();
            }
            bW.close();
        }
         catch (IOException e) {
             System.out.println("Error exporting cars");
             e.printStackTrace();
            }
    }

    /**
     * Imports cars from a specified CSV file.
     * https://stackoverflow.com/questions/31156551/split-comma-separated-file-per-line-into-array
     * @param filename The name of the CSV file to import.
     * @return An ArrayList of cars imported from the CSV file.
     * @throws FileNotFoundException If the specified CSV file is not found.
     */
    public static ArrayList<Car> importer(String filename) throws FileNotFoundException {
        ArrayList<Car> cars = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            br.readLine(); // Skip headers

            // https://stackoverflow.com/questions/5585779/how-do-i-convert-a-string-to-an-int-in-java

            for (String line; ((line = br.readLine()) != null);){
                String[] carDetails = line.split(",");
                cars.add(new Car(carDetails[0],
                        Integer.parseInt(carDetails[1]),
                        carDetails[2],
                        Integer.parseInt(carDetails[3])));
            }

            br.close();
        } catch (IOException e){
            System.out.println("Error importing the file");
            e.printStackTrace();
        }

        return cars;
    }
}
