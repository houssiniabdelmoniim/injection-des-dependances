package net_info.pres;

import net_info.dao.DaoImpl;
import net_info.metier.MetierImpl;

public class Pres1 {
    public static void main (String[] args){
        DaoImpl d = new DaoImpl();
        MetierImpl metier = new MetierImpl(d);
        //metier.setDao(d);
        System.out.println("RES= " +metier.calcul());
    }
}
