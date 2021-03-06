package al420445.Service;

import al420445.Persistence.LibraryDao;
import al420445.models.Library.Document;
import al420445.models.Library.Emprunt;
import al420445.models.Library.Livre;

public class AdminService {


    private LibraryDao dao;

    public AdminService(LibraryDao dao){this.dao = dao;}


    public long createEmploye(String user, String pass) {
        return dao.createEmploye(user, pass);
    }

    public long addBookToLibrary(String title, String author, String editor,long exemplaires, int release, int nbPages, String genre){
        return dao.addBookToLibrary(title,author,editor,exemplaires,release, nbPages, genre);
    }

    public Livre getLivreWithTitle(String title){
        return dao.getLivreWithTitle(title);
    }

    public Livre getLivreWithAuthor(String author){
        return dao.getLivreWithAuthor(author);
    }

    public Livre getLivreWithYear(long year){
        return dao.getLivreWithYear(year);
    }

    public Livre getLivreWithGenre(String genre){
        return dao.getLivreWithGenre(genre);
    }

    public Emprunt getEmprunt(long bookId, long clientId){
        return dao.getEmpruntWithBookIdAndClientId(bookId, clientId);
    }


}
