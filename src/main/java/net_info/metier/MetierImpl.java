package net_info.metier;

import net_info.dao.DaoImpl;
import net_info.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{
    private IDao dao;

    public MetierImpl(@Qualifier("d2") IDao dao) {
        this.dao = dao;
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
