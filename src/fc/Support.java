package fc;

public abstract class Support {
    private String supportType;
    private int supportID;
    private boolean available;
    private boolean lostDisk;
    private String streamAddress;
    private int MovieID;
    private boolean damagedDisk;

    public boolean isAvailable(){
        return available;
    };
    abstract public int getWeeklyRentals();
    abstract public int getMonthlyRentals();

    public String getSupportType() {
        return supportType;
    }

    public void setSupportType(String supportType) {
        this.supportType = supportType;
    }

    public int getSupportID() {
        return supportID;
    }

    public void setSupportID(int supportID) {
        this.supportID = supportID;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isLostDisk() {
        return lostDisk;
    }

    public void setLostDisk(boolean lostDisk) {
        this.lostDisk = lostDisk;
    }

    public String getStreamAddress() {
        return streamAddress;
    }

    public void setStreamAddress(String streamAddress) {
        this.streamAddress = streamAddress;
    }

    public int getMovieId() {
        return MovieID;
    }

    public void setMovieId(int movieID) {
        MovieID = movieID;
    }
    public boolean isDamagedDisk() {
        return damagedDisk;
    }

    public void setDamagedDisk(boolean damagedDisk) {
        this.damagedDisk = damagedDisk;
    }

    public String toString(){
        return "SUPPORTID : " + supportID + "SUPPORTTYPE : " + supportType + "AVAILABLE : " + available + "READABLEDISK : " +damagedDisk +
                "LOSTDISK : " + lostDisk + "STREAMADDRESS : " + streamAddress + "MOVIEID : " + MovieID;
    }
}
