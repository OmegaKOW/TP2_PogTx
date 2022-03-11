package al420445.Service;

import al420445.Persistence.LibraryDao;
import al420445.models.Library.Document;

public class AdminService {


    private LibraryDao dao;

    public AdminService(LibraryDao dao){this.dao = dao;}


    public long createEmploye(String user, String pass) {
        return dao.createEmploye(user, pass);
    }

    public void addDocToLibrary(String title, String author, String editor,long exemplaires, int release){

    }
}
