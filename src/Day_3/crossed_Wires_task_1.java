package Day_3;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class crossed_Wires_task_1 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> codeList = fileReader();
        int size = codeList.size();
        String[][] codeTable = new String[size][2];

        for(int x = 0 ; x < size ; x++) {
            String string = codeList.get(x);
            Pattern pattern = Pattern.compile("(\\w)(\\d+)");
            Matcher matcher = pattern.matcher(string);
            matcher.find();
            codeTable[x][0] = matcher.group(1);
            codeTable[x][1] = matcher.group(2);
        }
        Point start = new Point(0,0);
        HashMap<Point, Integer> hashMap = new HashMap<>();
        hashMap.put(start, 0);
        System.out.print(hashMap.containsKey(start));
        for(int instructionCode = 0 ; instructionCode < codeTable.length ; instructionCode++) {
            int countPoints = Integer.parseInt(codeTable[instructionCode][1]);
            switch (codeTable[instructionCode][0]) {
                case "U":
                    for (int ps = 1; ps <= countPoints; ps++) {
                        if(hashMap.containsKey(new Point(start.x, start.y+ps)))
                            hashMap.put(new Point(start.x, start.y+ps), 1);
                        else
                            hashMap.put(new Point(start.x, start.y+ps), 0);
                    }
                    start.setLocation(start.x, start.y+countPoints);
                case "D":
                    for (int ps = 1; ps <= countPoints; ps++) {
                        if(hashMap.containsKey(new Point(start.x, start.y-ps)))
                            hashMap.put(new Point(start.x, start.y-ps), 1);
                        else
                            hashMap.put(new Point(start.x, start.y-ps), 0);
                    }
                    start.setLocation(start.x, start.y-countPoints);
                case "L":
                    for (int ps = 1; ps <= countPoints; ps++) {
                        if(hashMap.containsKey(new Point(start.x-ps, start.y)))
                            hashMap.put(new Point(start.x-ps, start.y), 1);
                        else
                            hashMap.put(new Point(start.x-ps, start.y), 0);
                    }
                    start.setLocation(start.x-countPoints, start.y);
                case "R":
                    for (int ps = 1; ps <= countPoints; ps++) {
                        if(hashMap.containsKey(new Point(start.x+ps, start.y)))
                            hashMap.put(new Point(start.x+ps, start.y), 1);
                        else
                            hashMap.put(new Point(start.x+ps, start.y), 0);
                    }
                    start.setLocation(start.x+countPoints, start.y);

            }
        }
        System.out.print(hashMap.get(new Point(1,1)));
        for (Point i : hashMap.keySet()) {
            System.out.println(hashMap.values());
            ///// ?????????????????
        }
    }

    public static ArrayList<String> fileReader() throws FileNotFoundException {
        File input = new File(System.getProperty("user.dir")+"\\src\\Day_3\\input.txt");

        Scanner scanner = new Scanner(input);
        String string = scanner.next();
        String[] strings = string.split("\\s*,\\s*");

        ArrayList<String> stringArrayList = new ArrayList(Arrays.asList(strings));
        return stringArrayList;
    }

    public static void print(ArrayList<String> list){
        for(String s: list)
            System.out.println(s);
    }

}
