import java.io.*;
import java.util.*;
public class AccountLogin {
    static Scanner sc = new Scanner(System.in);
    static public  ArrayList<GiftCard> list= new ArrayList<>();
    static public  int amount ; 
    
    public static boolean fileReading(String id , String password) throws FileNotFoundException{
        try (BufferedReader reader = new BufferedReader(new FileReader(AccountRegistration.files[0]))) {
            String currentLine;
            while((currentLine = reader.readLine()) != null){
                String[] words = currentLine.split(",");
                if(words[0].equals(id) && words[1].equals(password)){
                    amount = Integer.parseInt(words[2]);
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void login() throws FileNotFoundException{
        System.out.println("Enter id:");
        String id = sc.next();
        System.out.println("Enter password:");
        String password = sc.next();
        password = AccountRegistration.encryption(password);
        if(fileReading(id , password)){
            boolean loop2 = true;
            while(loop2){
                System.out.println("1.Create Gift Card\n2.TopUp\n3.Transaction History\n4.Block\n5.Logout");
                int choice =sc.nextInt();
                switch(choice){
                    case 1:
                        GiftCard card = new GiftCard();
                        System.out.println("GiftCard Created!!!! CardNumber:"+card.getCardNumber()+"||Pinnumber:"+card.getPinnumber());
                        list.add(card);
                        break;
                    case 2:
                        System.out.println("enter the card number to topup and its pinnumber");
                        int cardnumber = sc.nextInt();
                        int pinnumber =sc.nextInt();
                        GiftCard current1 = Function.find(cardnumber, pinnumber);
                        if(current1 != null && !current1.blocked){
                            System.out.println("Card logged in:");
                            Function.Topup(current1);
                        }
                        else{
                            System.out.println("ivalid pinnumber or cardnumber!!!! or card may be blocked");
                        }
                        break;
                    case 3:
                        System.out.println("Transaction Details which card:");
                        System.out.println("cardnumber?");
                        int cardno = sc.nextInt();
                        System.out.println("Pinnumber?");
                        int pinnum = sc.nextInt();
                        GiftCard current2=Function.find(cardno, pinnum);
                        System.out.println(current2.transactionDetails);
                        break;
                    case 4:
                        System.out.println("which card to block?");
                        System.out.println("cardnumber?");
                        int blockcard = sc.nextInt();
                        System.out.println("Pinnumber?");
                        int blockpin = sc.nextInt();
                        GiftCard current3=Function.find(blockcard, blockpin);
                        if(current3 != null){
                            current3.blocked = true;
                            amount +=current3.cardbalance;
                            System.out.println("blocked Succesfully");
                        }
                        break;
                    case 5:
                        System.out.println("logging out!");
                        loop2 = false;
                        break;
                }
            }

        }
        else{
            System.out.println("invalid credentials");
        }
    }
    
}
