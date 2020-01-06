package main;

import java.text.ParseException;
import util.HibernateUtil;
import view.BoletosAVencer;
import view.Menu;

public class Principal {

    public static void main(String[] args) throws ParseException {
        HibernateUtil.getFabricaDeSessoes().openSession();

        Menu menu = new Menu();
        menu.setVisible(true);
        
        BoletosAVencer bav = new BoletosAVencer();
        bav.setVisible(true);
        
        
    }

}
