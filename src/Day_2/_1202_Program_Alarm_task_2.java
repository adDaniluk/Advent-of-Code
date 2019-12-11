package Day_2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _1202_Program_Alarm_task_2 {

    public static void main(String[] args) throws Exception {

        List<Integer> memoryList = loadMemoryFromFile();
        //executeMemory(memoryList);
        memorySearch(memoryList);

    }

    public static List loadMemoryFromFile() throws Exception {
        File file = new File(System.getProperty("user.dir") + "\\src\\Day_2\\input.txt");
        Scanner scanner = new Scanner(file);

        String string = scanner.next();
        String[] values = string.split("\\s*,\\s*");

        List<String> inputList = Arrays.asList(values);
        List<java.lang.Integer> intList = new ArrayList<>();

        for(String s : inputList){
            intList.add(java.lang.Integer.parseInt(s));
        }
        return  intList;
    }

    public static void executeMemory(List<Integer> list){
        List<Integer> memoryList = new ArrayList<>(list);
        int address = 0;
        while(address <= memoryList.size()){
            int intSequence = memoryList.get(address);

            if(intSequence == 1){
                memoryList.set(memoryList.get(address+3),add(memoryList.get(memoryList.get(address+1)),memoryList.get(memoryList.get(address+2))));
                address+=4;
            }
            else if(intSequence == 2){
                memoryList.set(memoryList.get(address+3),multiple(memoryList.get(memoryList.get(address+1)),memoryList.get(memoryList.get(address+2))));
                address+=4;
            }
            else if(intSequence == 99) {
                break;
            }
        }
        //print(memoryList);
        if(memoryList.get(0) == 19690720)
            System.out.println(100*memoryList.get(1)+memoryList.get(2));
    }

    public static int add(int one, int two){
        return (one+two);
    }

    public static int multiple(int one, int two){
        return (one*two);
    }

    public static void print(List<Integer> list){
        for(int x = 0;x <= 4; x++){
            System.out.print(list.get(x) + " ");
        }
        System.out.println();
    }

    public static void setStartParameters(List<Integer> list, int noun, int verb){
        setNounParameter(list, noun);
        setVerbParameter(list, verb);
    }

    public static void setNounParameter(List<Integer> list, int noun){
        list.set(1, noun);
    }

    public static void setVerbParameter(List<Integer> list, int verb){
        list.set(2, verb);
    }

    public static void memorySearch(List<Integer> list){
        List<Integer> mainMemoryList = new ArrayList<>(list);

        for(int noun = 0;noun < 100;noun++){
            List<Integer> firstLevelMemoryList = new ArrayList<>(mainMemoryList);
            setNounParameter(firstLevelMemoryList, noun);
            for(int verb = 0;verb < 100;verb++){
                List<Integer> secondLevelMemoryList = new ArrayList<>(firstLevelMemoryList);
                setVerbParameter(secondLevelMemoryList,verb);
                executeMemory(secondLevelMemoryList);
               // if(secondLevelMemoryList.get(0) == 19690720)
               // System.out.println(noun + " " + verb);
                //print(secondLevelMemoryList);
            }
       }
    }
}
