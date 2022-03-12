package al420445.Service;

import al420445.Persistence.LibraryDao;
import al420445.models.Library.Document;
import al420445.models.Library.Livre;

public class AdminService {


    private LibraryDao dao;

    public AdminService(LibraryDao dao){this.dao = dao;}


    public long createEmploye(String user, String pass) {
        return dao.createEmploye(user, pass);
    }

    public long addDocToLibrary(String title, String author, String editor,long exemplaires, int release){
        return dao.addDocToLibrary(title,author,editor,exemplaires,release);
    }

    public Livre getLivreWithTitle(String title){
        return dao.getLivreWithTitle(title);
    }

    public Livre getLivreWithAuthor(String author){
        return dao.getLivreWithAuthor(author);
    }

    public Livre getLivreWithGenre(String genre){
        return dao.getLivreWithGenre(genre);
    }
}
