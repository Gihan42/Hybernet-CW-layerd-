package Dao;

import Dao.custom.impl.ReserveDaoImpl;
import Dao.custom.impl.RoomsDaoImpl;
import Dao.custom.impl.StudentDaoImpl;
import Dao.custom.impl.UserDaoImpl;

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
        STUDENT,ROOMS,RESERVE,USER
    }

    public SuperDao getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDaoImpl();
            case ROOMS:
                    return new RoomsDaoImpl();
            case RESERVE:
                return new ReserveDaoImpl();
            case USER:
                return new UserDaoImpl();
            default:
                return null;
        }
    }
}

