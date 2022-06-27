package Dao;

import Dao.custom.impl.ReserveDaoImpl;
import Dao.custom.impl.RoomsDaoImpl;
import Dao.custom.impl.StudentDaoImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDaoFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes {
        STUDENT,ROOMS,RESERVE
    }

    public SuperDao getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDaoImpl();
            case ROOMS:
                    return new RoomsDaoImpl();
            case RESERVE:
                return new ReserveDaoImpl();
            default:
                return null;
        }
    }
}

