import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void day1() {
        try {
            File myObj = new File(String.valueOf(Paths
                    .get("C:\\Users\\danie\\IdeaProjects\\adventOfCode-2023\\src\\resources\\day1.txt")));
            Scanner myReader = new Scanner(myObj);
            int total = 0;


            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                char[] charArray = data.toCharArray();

                ArrayList<Integer> intList = new ArrayList<>();

                for (char forEachChar : charArray) {
                    boolean isDigit = Character.isDigit(forEachChar);

                    if (isDigit) {
                        intList.add(Character.getNumericValue(forEachChar));
                    }

                }

                String lineTotal;
                if (intList.size() == 1) {
                    lineTotal = intList.get(0) + String.valueOf(intList.get(0));
                } else {
                    lineTotal = intList.get(0) + String.valueOf(intList.get(intList.size() - 1));
                }
                total += Integer.parseInt(lineTotal);

            }
            System.out.println(total);
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
