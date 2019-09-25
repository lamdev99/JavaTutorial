package TestCuoiKi;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ObjectsOutputStreamEx {
    private int maSach = 0;
    private List<Sach> listAll;
    public ObjectsOutputStreamEx(Sach sach) {
        listAll = new ArrayList<>();
        getSach();
        if(maSach==0) maSach = 10000;
        sach.setIdBook(maSach+1);
        listAll.add(sach);
      //  new PanelSach().addToJTable(listAll);
        add();
    //    show();
    }
    public List<Sach> getListAll(){
        return listAll;
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
    public void getSach(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("SACH.DAT");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean cont = true;
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (cont){
                Sach sa = (Sach) ois.readObject();
                if(sa!=null){
                    listAll.add(sa);
                    maSach = sa.getIdBook();
                }
                else cont = false;
            }

        } catch (Exception e) {
            //
        }
    }

}
