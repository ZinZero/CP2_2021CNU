import java.io.*;

public class FileinputExample {
    public static void main(String args[]){
        try{
            FileInputStream input = new FileInputStream("input.txt");

            System.out.println("Data in the file");

            int i =0;
            while ((i = input.read()) != -1){
                System.out.print((char) i);
            }

            input = new FileInputStream("input.txt");

            while ((i = input.read()) != -1){
                System.out.print(i + " ");
                //Reads next byte from the file
            }
            input.close();
        }

        catch (Exception e){
            e.getStackTrace();
        }
    }
}
