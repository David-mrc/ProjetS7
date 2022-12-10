package fc;

public class SubscriptionCard extends Cards{
    private int CardId;
    private float balance;
    private int getAgeRestriction;
    private int getUserId;


    public int getUserId() {
        return getUserId;
    }

    public void setUserId(int getUserId) {
        this.getUserId = getUserId;
    }
    public int getAgeRestriction() {
        return getAgeRestriction;
    }

    public void setAgeRestriction(int getAgeRestriction) {
        this.getAgeRestriction = getAgeRestriction;
    }

    public int getCardId() {
        return CardId;
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
