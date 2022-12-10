package IHM;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdapteurSouris extends MouseAdapter {
        public AdapteurSouris(){

        }

    @Override
        public void mousePressed(MouseEvent e){
            System.out.println("login pressed");
        }
}
