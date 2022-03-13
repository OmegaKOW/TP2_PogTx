package al420445;

import al420445.Persistence.LibraryDao;
import al420445.Persistence.LibraryDaoJPA;
import al420445.Service.AdminService;
import al420445.Service.ClientService;
import al420445.models.Library.Dette;
import al420445.models.Library.Emprunt;
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
        Livre l2 = cs.getLivreWithAuthor("%Dr.Seuss%");
        Livre l3 = cs.getLivreWithGenre("%Etude%");
        Livre l4 = cs.getLivreWithYear(1957);
        //TEST D'UN EMPRUNT IMPOSSIBLE
        // long emprunt2 = cs.borrowBookWithId(book2id, clientId);
        // long book2id = as.addBookToLibrary("Maca", "Thomas", "Marsh", 0, 1957, 125, "Etude");
        // Emprunt emprunt = as.getEmprunt(book2id, clientId);

        //LE TEST A FONCTIONNÉ
        // System.out.println(emprunt.toString());

        cs.returnBook(book1id, clientId);
        System.out.println(book1id);
        System.out.println(clientId);
        System.out.println(empruntId);

        System.out.println(l.toString());
        System.out.println(l2.toString());
        System.out.println(l3.toString());
        System.out.println(l4.toString());

    }
}
