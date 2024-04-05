import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GenetikosAlgorithmos {


    ArrayList<Xrwmoswma> plhthysmos;
    ArrayList<Integer> occurrences;

    GenetikosAlgorithmos(){

        this.plhthysmos = null;
        this.occurrences = null;

    }

    Xrwmoswma run(int size, double metallaksh_pithanotita, int maxsteps, int minfit, int queensize){


        this.arxikopoihshPlhthysmou(size, queensize);
        Random rand = new Random();
        for (int i=0; i< maxsteps; i++){

            ArrayList<Xrwmoswma> new_plhthysmos = new ArrayList<>();
            for (int j=0 ; j < size/2; j++){


                int Xpos = this.occurrences.get(rand.nextInt(this.occurrences.size()));
                Xrwmoswma Xgoneas = this.plhthysmos.get(Xpos);

                int Ypos = this.occurrences.get(rand.nextInt(this.occurrences.size()));

                while (Xpos == Ypos) {

                    Ypos = this.occurrences.get(rand.nextInt(this.occurrences.size()));
                }

                Xrwmoswma Ygoneas = this.plhthysmos.get(Ypos);

                Xrwmoswma paidia[] = this.anaparagwgh(Xgoneas, Ygoneas, queensize);

                if(rand.nextDouble() < metallaksh_pithanotita)
                {
                    paidia[0].metallaksh(queensize);
                    paidia[1].metallaksh(queensize);
                }

                new_plhthysmos.add(paidia[0]);
                new_plhthysmos.add(paidia[1]);


            }

            this.plhthysmos = new ArrayList<>(new_plhthysmos);

            this.plhthysmos.sort(Collections.reverseOrder());

            if(this.plhthysmos.get(0).getFit() >= minfit) return this.plhthysmos.get(0);

            this.updateOccurrences();

        }

        return plhthysmos.get(0);

    }

    void arxikopoihshPlhthysmou(int size, int queensize){

        this.plhthysmos = new ArrayList<>();
        for (int i =0 ; i < size ; i++){

            plhthysmos.add(new Xrwmoswma(queensize));
        }

        this.updateOccurrences();
    }


    void updateOccurrences(){

        this.occurrences = new ArrayList<>();

        for(int i =0; i< plhthysmos.size(); i++){

            for( int j =0 ; j < plhthysmos.get(i).getFit(); j++){


                this.occurrences.add(i);
            }
        }

    }


    Xrwmoswma[] anaparagwgh(Xrwmoswma x, Xrwmoswma y, int queensize){



        Random rand = new Random();
        int diaxwrismos = rand.nextInt(queensize);
        int[] prwtopaidi = new int[x.getGonidia().length]; //!!!!!!!!!!!!!!!!!
        int[] deuteropaidi = new int[y.getGonidia().length]; //!!!!!!!!!!!!!!!


        for(int i=0; i< diaxwrismos; i++){

            prwtopaidi[i] = x.getGonidia()[i];
            deuteropaidi[i] = y.getGonidia()[i];
        }

        for(int i = diaxwrismos; i < prwtopaidi.length; i++)
        {
            prwtopaidi[i] = y.getGonidia()[i];
            deuteropaidi[i] = x.getGonidia()[i];
        }

        return new Xrwmoswma[] {new Xrwmoswma(prwtopaidi), new Xrwmoswma(deuteropaidi)};
    }




}
