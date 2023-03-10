import java.io.*;
import java.util.*;
class Main{
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) throws FileNotFoundException{
        boolean loop1 = true;
        while(loop1){
            System.out.println("1.AccountRegistration\n2.AccountLogin\n3.Purchase\n4.Exit");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    AccountRegistration.accountCreation();
                    break;
                case 2:
                    AccountLogin.login();
                    break;
                case 3:
                    Function.purchase();
                    break;
                case 4:
                    loop1 = false;
            }
        }
    }
}