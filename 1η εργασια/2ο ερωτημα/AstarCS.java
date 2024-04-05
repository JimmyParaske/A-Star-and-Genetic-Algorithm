import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class AstarCS {

    private ArrayList<State> metwpo;
    private HashSet<State> closedSet;
    public int N=0;
    public int M=0;
    public int K=0;

    AstarCS(int N, int M,int K){
        this.metwpo = new ArrayList<>();
        this.closedSet = new HashSet<>();
        this.M=M;
        this.N=N;
        this.K=K;
    }

    State AstarClosedSet (State arxikhkatastash){

        int steps_counter = 0;
        if(arxikhkatastash.isSolution()) {
            System.out.println("Number of steps : " + steps_counter);
            return arxikhkatastash;}

        this.metwpo.add(arxikhkatastash);
        while(this.metwpo.size() > 0 && steps_counter<=this.K){
            steps_counter++;
            State twrinhkatastash = this.metwpo.remove(0);
            if (twrinhkatastash.isSolution()){
                System.out.println("Βρήκε λύση");
                Invert(twrinhkatastash);
                System.out.println("Number of steps : " + (steps_counter-1));
                return twrinhkatastash;}

            if(!this.closedSet.contains(twrinhkatastash)){
                this.closedSet.add(twrinhkatastash);

                if (metwpo.isEmpty()){
                    List<State> paidia = twrinhkatastash.createChildren(this.N,this.M);
                    Collections.sort(paidia);
                    this.metwpo.addAll(paidia);
                }
                else{
                    List<State> paidia = twrinhkatastash.createChildren(this.N,this.M);
                    Collections.sort(paidia);
                    int index = 0;
                    for (State p : paidia){
                        if (!this.closedSet.contains(p)){
                            metwpo.add(0 + index, p);
                            index++;}
                    }
                }
                
            }

        }
        if (steps_counter>this.K) System.out.println("Out of steps");
        return null;
    }

    void Invert(State twrinhkatastash){
        int p =0;
        String word="";
        while(twrinhkatastash.getFatherstate()!= null){
            word+= ++p + " " + twrinhkatastash + " ";
            twrinhkatastash = twrinhkatastash.getFatherstate();
        }
        String[] words = word.split(" ");
        for (int i = words.length-1; i>=0; i=i-2){
            System.out.println(words[i] + " " + "Βήμα : " + words[words.length-i-1]);
        }
    }
}
