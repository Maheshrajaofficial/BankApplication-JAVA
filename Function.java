import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class Function {
    static Scanner sc = new Scanner(System.in);
    
    public static void Topup(GiftCard current){
        System.out.println("How much to topup?");
        int rechargeAmount = sc.nextInt();
        if(rechargeAmount >  AccountLogin.amount){
            System.out.println("insufficient balance");
            return;
        }
        else{
            AccountLogin.amount -=rechargeAmount;
            current.cardbalance +=rechargeAmount;
            System.out.println(rechargeAmount+" debited from mainaccount and main acnt balance "+AccountLogin.amount+" and the cardbalance is "+current.cardbalance);
            return;
        }
    }


    public static GiftCard find(int cardnumber , int pinnumber){
        GiftCard current = null;
        for(GiftCard k : AccountLogin.list){
            if(k.getCardNumber()==cardnumber && k.getPinnumber()==pinnumber){
                current = k;
                break;
            }
        }
        return current;
    }
    public static void writing(String str) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter(AccountRegistration.files[AccountRegistration.number]);
        writer.append(str);
        writer.close();
    }


    public static void purchase() throws FileNotFoundException{
        System.out.println("enter the purchase amount:");
        int purchaseAmount = sc.nextInt();
        System.out.println("Enter the cardnumber?");
        int cardnumber = sc.nextInt();
        System.out.println("Enter the pinnumber");
        int pinnumber = sc.nextInt();
        GiftCard current = find(cardnumber, pinnumber);
        if(current != null){
            if(purchaseAmount > current.cardbalance){
                System.out.println("insufficient card balance");
                return;
            }
            else{
                if(purchaseAmount >= 100) {
                    current.rewardpoints +=purchaseAmount/100;
                    if(current.rewardpoints >= 10){
                        current.cardbalance +=current.rewardpoints;
                        current.rewardpoints = 0;
                    }
                }
                current.cardbalance -=purchaseAmount;
                current.transactionDetails +="CardNumber:"+current.getCardNumber()+"||PurchasedAmount:"+purchaseAmount+"||CardBalance:"+current.cardbalance+"\n";
                writing(current.transactionDetails);
                System.out.println("Purchase Successfull PurchasedAmount:"+purchaseAmount+"||CardBalance:"+current.cardbalance);
            }
        }
    }
    
}
