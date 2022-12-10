package fc;

public  class CategorieRestrictions {
    private int cardId;
    private String category;

    @Override
    public String toString() {
        return "cardId : " + cardId + " ; category : " + category ;
    }
    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



}
