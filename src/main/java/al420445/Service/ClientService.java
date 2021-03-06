package al420445.Service;

import al420445.Persistence.LibraryDao;
import al420445.Persistence.LibraryDaoJPA;
import al420445.models.Library.Dette;
import al420445.models.Library.Emprunt;
import al420445.models.Library.Livre;

import java.util.List;

public class ClientService {

    private LibraryDao dao;

    public ClientService(LibraryDaoJPA libraryDaoJPA) {
        this.dao = libraryDaoJPA;
    }

    public long createClient(String name, String address) {
        return dao.createClient(name, address);
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

    public long borrowBookWithId(long bookId, long clientId){
        return dao.borrowBook(bookId, clientId);
    }

    public void returnBook(long bookId, long clientId){
        dao.returnBook(bookId, clientId);
    }

    public Dette getDettesWithClientId(long clientId){
        return dao.getDettesWithClientId(clientId);
    }

    public List<Emprunt> getEmpruntsWithDateRetours(long clientId){
        return dao.getEmpruntsWithDateRetours(clientId);
    }
}
