package InOutJava;

import java.io.*;

public class Storage {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("abc.txt");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(100);
            fos.close();
            dos.close();
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fis = new FileInputStream("abc.txt");
            DataInputStream dis = new DataInputStream(fis);
            int n = dis.readInt();
            fis.close();
            dis.close();
            System.out.println(n);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
