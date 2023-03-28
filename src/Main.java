import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Nation> listNation = new ArrayList<>();
        FileReader fr = new FileReader("nation.csv");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            line= line.replaceAll("\"","");
            String[] arr = line.split(",");
            listNation.add(new Nation(Integer.parseInt(arr[0]),arr[1],arr[2]));
        }
        for (Nation na: listNation) {
            System.out.println(na);
        }
        // ghi ra file dưới dạng object
        File file = new File("obj.txt");
        if(file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos =new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(listNation);

        // đọc file object
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream  ois = new ObjectInputStream(fis);
        List<Nation> listObject = (List<Nation>) ois.readObject();
        System.out.println("dữ liệu đọc từ filed obj");
        for (Nation na: listObject) {
            System.out.println(na);
        }

    }
}