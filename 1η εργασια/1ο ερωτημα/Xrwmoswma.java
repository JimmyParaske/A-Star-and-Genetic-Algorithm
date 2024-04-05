import java.util.Random;

public class Xrwmoswma implements Comparable<Xrwmoswma> {

    public int[] gonidia;

    public int fitness;

    Xrwmoswma(int queensize){
        Random rand = new Random();
        int N = rand.nextInt(queensize);
       // this.gonidia = new int[N];

        this.gonidia = new int[queensize];


        for(int i =0; i<this.gonidia.length; i++){

//            this.gonidia[i] = rand.nextInt(N);
            this.gonidia[i] = rand.nextInt(queensize);
        }

        this.calcfit();
    }

    Xrwmoswma(int[] gonidia){

        this.gonidia = new int[gonidia.length];

        for(int i = 0; i < this.gonidia.length; i++)
        {
            this.gonidia[i] = gonidia[i];
        }

        this.calcfit();

    }

    void calcfit(){

        int oxi_apeilh = 0;
        for(int i = 0; i < this.gonidia.length; i++)
        {
            for(int j = i+1; j < this.gonidia.length; j++)
            {
                if((this.gonidia[i] != this.gonidia[j]) &&
                        (Math.abs(i - j) != Math.abs(this.gonidia[i] - this.gonidia[j])))
                {
                    oxi_apeilh++;
                }
            }
        }

        this.fitness = oxi_apeilh;
    }

    void metallaksh(int queensize){

        Random rand = new Random();
        this.gonidia[rand.nextInt(queensize)] = rand.nextInt(queensize);
        this.calcfit();


    }

    public int[] getGonidia() {
        return this.gonidia;
    }

    public void setGonidia(int[] gonidia) {
        this.gonidia = gonidia;
    }

    public int getFit() {
        return this.fitness;
    }

    public void setFit(int fitness) {
        this.fitness = fitness;
    }

    void print()
    {
        System.out.print("Chromosome : |");
        for(int i = 0; i < this.gonidia.length; i++)
        {
            System.out.print(this.gonidia[i]);
            System.out.print("|");
        }
        System.out.print(", Fitness : ");
        System.out.println(this.fitness);

        System.out.println("------------------------------------");
        for(int i = 0; i < this.gonidia.length; i++)
        {
            for(int j=0; j < this.gonidia.length; j++)
            {
                if(this.gonidia[j] == i)
                {
                    System.out.print("|Q");
                }
                else
                {
                    System.out.print("| ");
                }
            }
            System.out.println("|");
        }
        System.out.println("------------------------------------");
    }


    @Override
    public int compareTo(Xrwmoswma x)
    {
        return this.fitness - x.fitness;
    }

}
