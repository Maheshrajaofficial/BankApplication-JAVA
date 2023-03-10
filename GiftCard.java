import java.util.*;
public class GiftCard {
    private int cardnumber;
    private int pinnumber;
    public  int cardbalance;
    public  int rewardpoints;
    public  String transactionDetails;
    public boolean blocked;
    public GiftCard(){
        cardnumber =randomcardfunction();
        pinnumber = randompinfunction();
        rewardpoints = 0;
        cardbalance = 0;
        blocked = false;
        transactionDetails += "";
    }
    public static int randomcardfunction(){
        Random random = new Random();
        int randomNumber = random.nextInt(90000) + 10000;
        return randomNumber;
    }
    public static int randompinfunction(){
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;
        return randomNumber;
    }
    public int getPinnumber(){
        return pinnumber;
    }
    public int getCardNumber(){
        return cardnumber;
    }
}
