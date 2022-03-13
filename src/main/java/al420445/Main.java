package al420445;

import al420445.Persistence.LibraryDao;
import al420445.Persistence.LibraryDaoJPA;
import al420445.Service.AdminService;
import al420445.Service.ClientService;
import al420445.models.Library.Livre;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        final LibraryDaoJPA dao = new LibraryDaoJPA();
        ClientService cs = new ClientService(dao);
        AdminService as = new AdminService(dao);
        long book1id = as.addBookToLibrary("Le chat dans le chapeau", "Dr.Seuss", "Random House", 3, 1957, 125, "Etude");
        long clientId = cs.createClient("John Doe", "123 Java Rd");
        long empruntId = cs.borrowBookWithId(book1id, clientId);

        Livre l = cs.getLivreWithTitle("%chat%");
        System.out.println(book1id);
        System.out.println(clientId);
        System.out.println(empruntId);
        System.out.println(l.toString());
    }
}
