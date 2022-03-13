package al420445;

import al420445.Persistence.LibraryDao;
import al420445.Persistence.LibraryDaoJPA;
import al420445.Service.AdminService;
import al420445.Service.ClientService;

public class Main {

    public static void main(String[] args) {

        final LibraryDaoJPA dao = new LibraryDaoJPA();
        ClientService cs = new ClientService(dao);
        AdminService as = new AdminService(dao);
        long book1id = as.addBookToLibrary("Le chat dans le chapeau", "Dr.Seuss", "Random House", 3, 1957);
        long clientId = cs.createClient("John Doe", "123 Java Rd");
        cs.borrowBookWithId(book1id, clientId);
    }
}
