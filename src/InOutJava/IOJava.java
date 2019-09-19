package InOutJava;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Man implements Serializable {
    private String name;
    private int tuoi;

    public Man(String name, int tuoi) {
        this.name = name;
        this.tuoi = tuoi;
    }

    public Man() {
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", tuoi=" + tuoi +
                '}';
    }
}

public class IOJava {
    public static void main(String[] args) {

        //In vao file
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("SV.OUT"));
            oos.writeObject(new Man("Lam",20));
            oos.writeObject(new Man("Nam",20));
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("SV.OUT");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean cont = true;
        try {
            ObjectInputStream input = new ObjectInputStream(fis);
            while (cont) {
                Man obj = (Man) input.readObject();
                if (obj != null)
                    System.out.println(obj);
                else
                    cont = false;
            }
        } catch (Exception e) {
            //System.out.println(e.printStackTrace());
        }
    }
}
