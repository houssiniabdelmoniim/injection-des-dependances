package net_info.metier;

import net_info.dao.DaoImpl;
import net_info.dao.IDao;

public class MetierImpl implements IMetier{
    private IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    public MetierImpl() {
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 2 + (t * t)/3 ;
        return res;
    }

    public void setDao(IDao dao){
        this.dao = dao;
    }
}
