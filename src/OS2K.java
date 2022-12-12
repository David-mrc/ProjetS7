import fc.interfaces.CyberVideoInterface;
import fc.interfaces.DBInterface;
import fc.interfaces.FCInterface;
import ui.Window;

public class OS2K {
    public static void main(String[] args) {
        Window.launch(new FCInterface(new CyberVideoInterface(), new DBInterface()));
    }
}
