import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please give chromosome size , mutation probability, max steps, minimum fitness, queen number:");
        int size = sc.nextInt();
        double mut_prob = sc.nextDouble();
        int steps = sc.nextInt();
        int minimumfit = sc.nextInt();
        int queensize = sc.nextInt();

        long start = System.currentTimeMillis();

        GenetikosAlgorithmos algorithmosBerwthma = new GenetikosAlgorithmos();

        Xrwmoswma lysh = algorithmosBerwthma.run(size, mut_prob, steps, minimumfit, queensize);
        long end = System.currentTimeMillis();
        lysh.print();

        System.out.println((end-start) + " milliseconds");
    }
}
