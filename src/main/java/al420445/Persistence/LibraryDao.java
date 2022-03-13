package al420445.Persistence;

import al420445.models.Library.Dette;
import al420445.models.Library.Emprunt;
import al420445.models.Library.Livre;
import al420445.models.Users.Client;

import java.util.List;

public interface LibraryDao {

    <T> void save(T t);
    <T> void merge(T t);
    long createClient(String name, String address);
    long createEmploye(String user, String pass);

    long addBookToLibrary(String title, String author, String editor, long exemplaires, int release, int nbPages, String genre);

    Livre getLivre(long livreId);

    Client getClient(long clientId);

    Livre getLivreWithTitle(String title);

    Livre getLivreWithAuthor(String author);

    Livre getLivreWithGenre(String genre);

    Livre getLivreWithYear(long year);

    long borrowBook(long bookId, long clientId);

    Emprunt getEmpruntWithBookIdAndClientId(long bookId, long clientId);

    Dette getDettesWithClientId(long clientId);

    void returnBook(long clientId, long id);

    List<Emprunt> getEmpruntsWithDateRetours(long clientId);
}
