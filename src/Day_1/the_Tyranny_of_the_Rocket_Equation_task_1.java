package Day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class the_Tyranny_of_the_Rocket_Equation_task_1 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(System.getProperty("user.dir")+"\\src\\Day_1\\input_mass.txt");
        System.out.print(fuelSum(file));
    }

    public static int singleMass(int mass){
        int singleFuel = ((int)(Math.floor(mass/3))-2);
        return singleFuel;
    }

    public static int fuelSum(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int fuel = 0;
        while(scanner.hasNext()){
            int mass = Integer.parseInt((scanner.nextLine()));
            fuel += singleMass(mass);
            }
        return fuel;
    }
}
