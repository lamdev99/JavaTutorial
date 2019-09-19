package TestCuoiKi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ObjectsOutputStreamEx {
    private Sach sach;
    private List<Sach> listAll;
    public ObjectsOutputStreamEx(Sach sach) {
        listAll = new ArrayList<>();
        listAll.add(sach);
        this.sach = sach;

    }
    public void add(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("SACH.DAT"));
            for(Sach sa: listAll)
                oos.writeObject(sa);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void show(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("SACH.DAT"));
            try {
                //while(ois.readBoolean()){
                    Sach sa = (Sach) ois.readObject();
                    //listAll.add(sa);

//                for(Sach sa: listAll) System.out.println(sa);
                ois.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
