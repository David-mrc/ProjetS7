import dao.DBInterface;
import fc.interfaces.CyberVideoInterface;
import dao.DBInterface;
import fc.interfaces.FCInterface;
import ui.Window;

public class OS2K {
    public static void main(String[] args) {
        Window.launch(new FCInterface(new CyberVideoInterface(), new DBInterface()));
    }
}
