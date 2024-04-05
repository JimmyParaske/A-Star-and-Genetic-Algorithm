import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the number N of missionaries and cannibals");
        int N = scanner.nextInt();
        System.out.println("Give the number M of people allowed in the boat");
        int M = scanner.nextInt();
        System.out.println("Give the number K of acceptable steps");
        int K = scanner.nextInt();
        State initialstate = new State(N,N,Position.left,0,0);
        AstarCS AstarAlgorithm = new AstarCS(N,M,K);
        scanner.close();
        long start = System.currentTimeMillis();

        State terminalstate = AstarAlgorithm.AstarClosedSet(initialstate);

        long end = System.currentTimeMillis();

        if(terminalstate == null) System.out.println("Could not find a solution.");
        System.out.println((end-start) + " milliseconds");
    }
}
