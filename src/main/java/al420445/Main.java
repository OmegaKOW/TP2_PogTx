package al420445;

import al420445.Persistence.LibraryDaoJPA;
import al420445.Service.LibraryService;

public class Main {

    public static void main(String[] args) {


        LibraryService service = new LibraryService(new LibraryDaoJPA());
        service.createClient("John Doe", "123 Java Rd");
        service.createDocument();
        service.createDocument();
        service.createEmploye("Matt", "password");

    }
}
