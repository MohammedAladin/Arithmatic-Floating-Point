
package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class mainFiles {
    public static String read(String path) throws IOException {
        String str="";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                str+=line;
            }

            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return str;
    }
    //write result of compression---> file name: Compressed
    public static void write_result(double s) throws IOException {
        FileWriter writer = new FileWriter("D:\\Compressed.txt");
        writer.write(String.valueOf(s));
        writer.close();
    }

    //Write number of characters in a file ----> file name:Number of Characters
    public static void write_length(int Length) throws IOException {
        FileWriter writer = new FileWriter("D:\\Number of Characters.txt");
        writer.write(String.valueOf(Length));
        writer.close();
    }

    //write result of decompression----> file name:Decompressed
    public static void write_string(String s) throws IOException {
        FileWriter writer = new FileWriter("D:\\Decompressed.txt");
        writer.write(String.valueOf(s));
        writer.close();
    }

}
