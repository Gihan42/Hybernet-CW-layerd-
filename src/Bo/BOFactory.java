package Bo;

import Bo.custom.Iimpl.ProcessBoImpl;
import Bo.custom.Iimpl.RoomsBoImpl;
import Bo.custom.Iimpl.StudentBoImpl;

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
        STUDENT,ROOM,PROCESS
    }
    public SuperBo getBo(BoTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentBoImpl();
            case ROOM:
                return new RoomsBoImpl();
            case PROCESS:
                return new ProcessBoImpl();
            default:
                return null;
        }

    }
}
