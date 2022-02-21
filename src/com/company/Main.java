package com.company;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    static String compData="";
    static ArrayList < symbol > symbols  = new ArrayList <symbol>(); // array b5zn feeh el 7rof bel probablity wel ranges fel compression


    public static symbol search_item (char x , ArrayList <symbol> arr)
    {
        String item = "";
        item+=x ;
        symbol result = new symbol () ;

        for (int i=0 ; i<arr.size() ; i++)
        {
            if (arr.get(i).getLetter().equals(item))
            {
                result = arr.get(i);
                break;
            }
        }
        return result ;
    }

    public static void compress() throws IOException{
        compData=mainFiles.read("D:\\compData.txt");
        Prop_Range.getProbability(compData);

        for (int i=0; i<symbols.size();i++){
            System.out.println(symbols.get(i)+"\n");
        }

        double lower=0;
        double upper=1;

        double oldLower=0;
        double oldUpper=1;

        for(int i=0; i<compData.length(); i++){

            symbol cur = search_item(compData.charAt(i), symbols);

            lower  = oldLower + (oldUpper - oldLower)*cur.getLow_range();
            upper  = oldLower + (oldUpper - oldLower )*cur.getHigh_range();

            oldLower = lower ;
            oldUpper = upper ;

        }

        double rand_num = (lower + upper)/2;
        mainFiles.write_result(rand_num);

        System.out.println(compData.length());


    }

    public static void decompress() throws IOException{
        int iterations= compData.length();
        double CompressionCode=Double.parseDouble( mainFiles.read("D:\\Compressed.txt"));

        String stream = "";
        double lower=0;
        double upper=1;

        double oldLower=0;
        double oldUpper=1;



        for (int i=0 ; i<iterations ; i++)
        {
            double cur_code = (CompressionCode - oldLower) / (oldUpper - oldLower) ;  // b7sb el code lel iteration li na feha

            for (int j=0 ; j<symbols.size() ; j++)
            {   // check in which  range
                if ( (cur_code > symbols.get(j).getLow_range()) && ( cur_code < symbols.get(j).getHigh_range()))
                {
                    stream += symbols.get(j).getLetter(); // bgeeb el 7arf el mokabel lel range dah

                    lower = oldLower + (oldUpper - oldLower)*symbols.get(j).getLow_range(); //expand
                    upper = oldLower + (oldUpper - oldLower)*symbols.get(j).getHigh_range();

                    oldLower = lower ;
                    oldUpper = upper ;

                    break;
                }

            }

            System.out.println(stream);
        }

        mainFiles.write_string(stream);
    }

    public static void main(String[] args) throws IOException {

        compress();
        decompress();

    }

}