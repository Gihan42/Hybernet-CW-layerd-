import Dto.StudentDto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.factoryconfiguration;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        transaction.commit();
        session.close();

    }
}
