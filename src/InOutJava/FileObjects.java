package InOutJava;

import java.io.*;

public class FileObjects implements Serializable {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
            Nguoi nguoi = new Nguoi("Lam",20);
            oos.writeObject(nguoi);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            oos.close();
        }
    }
}
