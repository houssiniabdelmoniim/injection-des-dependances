package net_info.dao;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("Version Base de données");
        double t = 20;
        return t;
    }
}
