package al420445.Persistence;

import al420445.models.Library.Livre;

public interface LibraryDao {

    <T> void save(T t);
    <T> void merge(T t);
    long createClient(String name, String address);
    long createEmploye(String user, String pass);
    long addDocToLibrary(String title, String author, String editor, long exemplaires, int release);

    Livre getLivre(long livreId);

    Livre getLivreWithTitle(String title);

    Livre getLivreWithAuthor(String author);

    Livre getLivreWithGenre(String genre);

    Livre getLivreWithYear(long year);

    long borrowBook(long id);
}
