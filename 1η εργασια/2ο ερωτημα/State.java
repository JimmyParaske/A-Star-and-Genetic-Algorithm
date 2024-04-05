import java.util.ArrayList;
import java.util.List;

enum Position {left, right};


public class State implements Comparable<State>{

    private int canniballeft;
    private int cannibalright;
    private int missionaryleft;
    private int missionaryright;
    private Position boat;
    final int apostasiH = 0;
    private int score;

    public State fatherstate;

    public State(int canniballeft, int missionaryleft, Position boat, int cannibalright, int missionaryright){

        this.setCanniballeft(canniballeft);
        this.setCannibalright(cannibalright);
        this.setMissionaryleft(missionaryleft);
        this.setMissionaryright(missionaryright);
        if (boat == Position.right) this.goRight();
        else this.goLeft();

    }


    public Boolean isSolution(){

        return this.getCanniballeft() == 0 && this.getMissionaryleft() == 0;
    }


    public boolean Periorismoi(int M){

        if (this.getMissionaryleft() >= 0 && this.getMissionaryright() >= 0 && this.getCanniballeft() >= 0 && this.getCannibalright() >= 0 && (this.getMissionaryleft() == 0 || this.getMissionaryleft() >= this.getCanniballeft())
                && (this.getMissionaryright() == 0 || this.getMissionaryright() >= this.getCannibalright())){
                    if((isright()&& Math.abs((this.getCannibalright()+this.getMissionaryright())-(this.getFatherstate().getCannibalright()+this.getFatherstate().getMissionaryright()))<= M )||(isleft() && Math.abs((this.getCanniballeft()+this.getMissionaryleft())-(this.getFatherstate().getCanniballeft()+this.getFatherstate().getMissionaryleft()))<= M )) 
                        return true;
        }
        return false;
    }

    public List<State>  createChildren(int N,int M){


        List<State> children = new ArrayList<State>();

        if (boat == Position.left) {
            for(int i = 0; i<N ; i++){
                testandadd(children, new State(this.getCanniballeft()-i, this.getMissionaryleft()-(M-i), Position.right, this.getCannibalright() + i, this.getMissionaryright()+ (M-i)), M);
                
                if(i>=1 && i<M){
                    testandadd(children, new State(this.getCanniballeft()-(M-i), this.getMissionaryleft()-(M-i), Position.right, this.getCannibalright() + (M-i), this.getMissionaryright()+ (M-i)),M);
                    testandadd(children, new State(this.getCanniballeft()-(M-i), this.getMissionaryleft(), Position.right, this.getCannibalright()+(M-i), this.getMissionaryright()),M);
                    testandadd(children, new State(this.getCanniballeft(), this.getMissionaryleft()-(M-i), Position.right, this.getCannibalright(), this.getMissionaryright()+(M-i)),M);}
            }
        }
        else{
            for(int i = 0; i<N ; i++){
                testandadd(children, new State(this.getCanniballeft()+i, this.getMissionaryleft()+(M-i), Position.left, this.getCannibalright() - i, this.getMissionaryright()- (M-i)),M);
                
                if(i>=1 && i<M){
                    
                    testandadd(children, new State(this.getCanniballeft()+ (M-i), this.getMissionaryleft()+(M-i), Position.left, this.getCannibalright() - (M -i), this.getMissionaryright()- (M-i)),M);
                    testandadd(children, new State(this.getCanniballeft(), this.getMissionaryleft()+(M-i), Position.left, this.getCannibalright(), this.getMissionaryright()- (M-i)),M);
                    testandadd(children, new State(this.getCanniballeft()+(M-i), this.getMissionaryleft(), Position.left, this.getCannibalright() - (M-i), this.getMissionaryright()),M);}
            }

        }
        
        return children;
    }

    int getScore() {return this.score;}

    void setScore(int score) {this.score = score;}



    private void testandadd(List<State> children, State neakatastash,int M){
            neakatastash.setFatherState(this);
            if (neakatastash.Periorismoi(M)) {
                neakatastash.setScore(neakatastash.identifier());
                children.add(neakatastash);
            }

    }


    public int getCanniballeft(){

        return canniballeft;
    }

    public int getCannibalright(){

        return cannibalright;
    }

    public int getMissionaryleft(){

        return missionaryleft;
    }

    public int getMissionaryright(){

        return missionaryright;
    }

    public void setCanniballeft(int canniballeft){

        this.canniballeft = canniballeft;
    }

    public void setCannibalright(int cannibalright){

        this.cannibalright = cannibalright;
    }

    public void setMissionaryleft(int missionaryleft){

        this.missionaryleft = missionaryleft;
    }


    public void setMissionaryright(int missionaryright){

        this.missionaryright = missionaryright;
    }

    public void goLeft(){

        boat = Position.left;
    }

    public void goRight(){

        boat = Position.right;
    }

    public boolean isleft(){

        return boat == Position.left;
    }

    public boolean isright(){

        return boat == Position.right;
    }

    public State getFatherstate(){

        return fatherstate;
    }


    public void setFatherState(State fatherstate){

        this.fatherstate = fatherstate;

    }

    
    public int hashCode(){

        return this.identifier();
    }

    public int identifier(){
            return this.getCanniballeft() + this.getMissionaryleft() ;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof State)) {
            return false;
        }
        State s = (State) obj;
        return (s.canniballeft == canniballeft && s.missionaryleft == missionaryleft
                && s.boat == boat && s.cannibalright == cannibalright
                && s.missionaryright == missionaryright);
    }

    @Override
    public int compareTo(State s)
    {
        return Double.compare(this.score, s.score); // compare based on the heuristic score.
    }

}