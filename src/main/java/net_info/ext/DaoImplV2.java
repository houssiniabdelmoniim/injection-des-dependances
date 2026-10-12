package net_info.ext;

import net_info.dao.IDao;
import org.springframework.stereotype.Component;

@Component("d2")
public class DaoImplV2 implements IDao {
    @Override
    public double getData(){
        System.out.println("Version capteurs ...");
        double t = 20;
        return t ;
    }
}
