package net_info.ext;

import net_info.dao.IDao;

public class DaoImplV2 implements IDao {
    @Override
    public double getData(){
        System.out.println("Version capteurs ...");
        double t = 20;
        return t ;
    }
}
