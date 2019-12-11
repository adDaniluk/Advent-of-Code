package Day_2;

import java.io.File;
import java.util.*;

public class _1202_Program_Alarm_task_1 {

    public static void main(String[] args) throws Exception {

        List<Integer> inputList = codeList();


        //print(inputList);
        code(inputList);
        //print(inputList);
    }

    public static List codeList() throws Exception {
        File file = new File(System.getProperty("user.dir")+"\\src\\Day_2\\input.txt");
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

    public static void code(List<Integer> list){
        int i = 0;
        print(list);
        while(i <= list.size()){
            int intSequence = list.get(i);
            if(intSequence == 1){
                list.set(list.get(i+3),add(list.get(list.get(i+1)),list.get(list.get(i+2))));
                i+=4;
                print(list);
            }
            else if(intSequence == 2){
                list.set(list.get(i+3),multiple(list.get(list.get(i+1)),list.get(list.get(i+2))));
                i+=4;
                print(list);

            }
            else if(intSequence == 99) {
                System.out.println("end of program");
                print(list);
                break;
            }
            System.out.println(i);

        }

    }
    public static int add(int one, int two){
        return (one+two);
    }
    public static int multiple(int one, int two){
        return (one*two);
    }
    public static void print(List<Integer> list){
        for(int x : list){
            System.out.print(x+ " ");
        }
            System.out.println();
    }
}
