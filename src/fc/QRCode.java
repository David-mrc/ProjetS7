package fc;

public class QRCode extends Support{

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public int getWeeklyRentals() {
        return 0; // DAO spéciale à implémenter
    }

    @Override
    public int getMonthlyRentals() {
        return 0; //DAO Spéciale à implémenter
    }
}
