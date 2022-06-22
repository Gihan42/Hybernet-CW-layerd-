package Dao;

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
        STUDENT,ROOMS
    }

    public SuperDao getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDaoImpl();
            case ROOMS:
                    return new RoomsDaoImpl();

            default:
                return null;
        }
    }
}

