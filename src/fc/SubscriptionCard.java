package fc;

public class SubscriptionCard extends Cards{
    private int CardId;
    private float balance;
    private int getUserId;

    public String getType(){return "Subscription";}
    @Override
    public String toString() {
        return "CardId : " + CardId + " ; balance : " + balance + " ; getUserId : " + getUserId;
    }

    public int getUserId() {
        return getUserId;
    }

    public void setUserId(int getUserId) {
        this.getUserId = getUserId;
    }

    public int getCardId() {
        return CardId;
    }
    public int getID(){
        return getCardId();
    }

    public void setCardId(int cardId) {
        CardId = cardId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

}
