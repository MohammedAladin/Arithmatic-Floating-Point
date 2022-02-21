package com.company;
import java.util.ArrayList;

public class Prop_Range {

    public static void getRange(ArrayList<symbol> symbols1){
        double low=0;
        for(int i = 0; i<symbols1.size(); i++){
            double high=symbols1.get(i).getProbability()+low;
            symbols1.get(i).setLow_range(low);
            symbols1.get(i).setHigh_range(high);
            low=high;
        }
    }

    public  static void getProbability(String data){

        for(int i=0; i<data.length();i++)
        {
            String letter = "" ;
            letter+=data.charAt(i);
            boolean found = false;

            for(int j=0; j<Main.symbols.size(); j++)
            {

                if (Main.symbols.get(j).getLetter().equals(letter))
                {
                    double newProb=Main.symbols.get(j).getProbability()+1;
                    Main.symbols.get(j).setProbability(newProb);
                    found = true;
                    break;

                }
            }
            if (!found)
            {
                Main.symbols.add(new symbol(letter,1,0,0));
            }

        }

        for (int i=0 ; i<Main.symbols.size(); i++){
            double newProp=Main.symbols.get(i).getProbability()/data.length();
            Main.symbols.get(i).setProbability(newProp);
        }
        getRange(Main.symbols);
        for (int i=0; i<Main.symbols.size(); i++){
            System.out.println(Main.symbols.get(i).getLetter());
        }

    }
}
