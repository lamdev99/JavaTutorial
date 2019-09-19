package InOutJava;

import java.io.*;

public class BinaryFileIO {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("test.dat");
            //ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i = 0; i < 99; i++)
                fos.write(i);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
