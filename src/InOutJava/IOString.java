package InOutJava;

import java.io.*;

public class IOString {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("OUT.txt");
            fileWriter.write("Lam");
            fileWriter.write("Long");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader = new FileReader("OUT.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s = "";
            boolean cont = true;
            while(cont){
                s = bufferedReader.readLine();
                if(s!=null) System.out.println(s);
                else cont = false;
            }
        } catch (Exception e) {

        }
    }
}
