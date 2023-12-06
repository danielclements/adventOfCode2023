import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void day2 () {
        //Pass condition is a max of 12 red, 13 green and 14 blue
        try {
            File myObj = new File(String.valueOf(Paths
                    .get("C:\\Users\\danie\\IdeaProjects\\adventOfCode-2023\\src\\resources\\day2.txt")));
            Scanner myReader = new Scanner(myObj);
            Integer total = 0;


            while (myReader.hasNextLine()) {
                String currentLine = myReader.nextLine();
                boolean passState = true;

                String id = currentLine.split(":")[0].split(" ")[1];
                ArrayList<String> sets = new ArrayList<>(Arrays.asList(currentLine.split(":")[1].split(";")));

                for (String forEachSet : sets){
                    ArrayList<String> dice = new ArrayList<>(Arrays.asList(forEachSet.split(",")));

                    for (String diceSplit : dice){
                       ArrayList<String> diceSplitArray = new ArrayList<>(Arrays.asList(diceSplit.split(" ")));

                       switch(diceSplitArray.get(2)){
                            case "red":
                                if(Integer.parseInt(diceSplitArray.get(1)) > 12){
                                    passState = false;
                                }
                                break;

                           case "green":
                               if(Integer.parseInt(diceSplitArray.get(1)) > 13){
                                   passState = false;
                               }
                               break;

                           case "blue":
                               if(Integer.parseInt(diceSplitArray.get(1)) > 14){
                                   passState = false;
                               }
                               break;
                        }

                    }


                }



               if (passState) {
                    total += Integer.parseInt(id);
                }
            }
            System.out.println(total);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
