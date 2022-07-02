package Bo;

import Bo.custom.Iimpl.*;
import Bo.custom.UserBo;
import Dao.custom.impl.UserDaoImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        if(boFactory==null){
            boFactory=new BOFactory();
        }
        return  boFactory;
    }
    public enum BoTypes{
        STUDENT,ROOM,PROCESS,RESEVE,USER
    }
    public SuperBo getBo(BoTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentBoImpl();
            case ROOM:
                return new RoomsBoImpl();
            case PROCESS:
                return new ProcessBoImpl();
            case RESEVE:
                return new ReserveBoImpl();
            case USER:
                return new UserBoImpl() {
                };
            default:
                return null;
        }

    }
}
