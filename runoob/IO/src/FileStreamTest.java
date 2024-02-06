import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {
    public static void main(String[] args) {
        try{
            byte bWrite[] ={11,21,3,40,5};
            FileOutputStream os = new FileOutputStream("test.txt");
            for (int x=0;x<bWrite.length;x++){
                os.write(bWrite[x]);
            }
            os.close();

            FileInputStream is = new FileInputStream("test.txt");
            int size = is.available();
            for (int i = 0; i < size; i++) {
                System.out.println((char) is.read()+" ");
            }
            is.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
