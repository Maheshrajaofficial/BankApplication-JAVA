import java.io.*;
import java.util.*;
public class AccountRegistration {
    static Scanner sc = new Scanner(System.in);
    static String[] files = {"Customer1.txt","Customer2.txt","Customer3.txt"};
    static int k ; 
    static int number;

    public static String encryption(String password){
        String encryptedPassword = "";
        for(int i = 0; i < password.length(); i++)encryptedPassword +=(char)(password.charAt(i)+1);
        return encryptedPassword;
    }


    public static void fileStoring(String id , String password , String amount) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter(files[k++]);
        writer.write(id);
        writer.write(",");
        writer.write(password);
        writer.write(",");
        writer.write(amount);
        writer.close();
        System.out.println("Data stored Successfully");
    }

    public static void accountCreation() throws FileNotFoundException{
        if(k == files.length){
            System.out.println("No files available");
            return;
        }
        System.out.println("Create id:");
        String id = sc.next();
        System.out.println("create password:");
        String password = sc.next();
        System.out.println("Add a amount:");
        String amount = sc.next();
        int number = k;
        password = encryption(password);
        fileStoring(id , password , amount);
        
    }
}
