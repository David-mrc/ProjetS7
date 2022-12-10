package fc;

public abstract class Categories {

    private String category;

    @Override
    public String toString() {
        return "category : " + category ;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
