package fc;

import java.sql.Date;

public class Rental {
    private int id;
    private Date startDate;
    private Date endDate;
    private float price;
    private int userid;
    private int supportid;

    @Override
    public String toString() {
        return "id : " + id + " ; startDate : " + startDate + " ; endDate : " + endDate + " ; price : " + price + " ; userid : " + userid + " ; supportid : " + supportid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getSupportid() {
        return supportid;
    }

    public void setSupportid(int supportid) {
        this.supportid = supportid;
    }
}
