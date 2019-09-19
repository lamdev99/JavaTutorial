package InOutJava;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileObjects implements Serializable {
    //private List<Nguoi> list;
    public static void main(String[] args) throws IOException {
        List<Nguoi> list =  new ArrayList<>();
        list.add(new Nguoi("Lam",20));
        list.add(new Nguoi("Dan",20));
        list.add(new Nguoi("Nam",20));
        Obwrite(list);
        List<Nguoi> kqNguoi = new ArrayList<>();
        kqNguoi = readObject();
        for(Nguoi ng : kqNguoi){
            System.out.println(ng);
        }
//
//        ObjectOutputStream oos = null;
//        try {
//            oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
//            Nguoi nguoi = new Nguoi("Lam",20);
//            oos.writeObject(nguoi);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            oos.close();
//        }
    }
    public static void Obwrite(List<Nguoi> arrayList){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("objectarray.dat"));
            oos.writeObject(arrayList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Nguoi> readObject(){
        ObjectInputStream ois = null;
        List <Nguoi> arrayFake = new ArrayList<>();
        try {
            ois = new ObjectInputStream(new FileInputStream("objectarray.dat"));
            try {
                arrayFake = (List<Nguoi>) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayFake;
    }
}
