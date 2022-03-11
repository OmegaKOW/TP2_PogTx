package al420445.Service;

import al420445.Persistence.LibraryDao;

public class AdminService {


    private LibraryDao dao;

    public AdminService(LibraryDao dao){this.dao = dao;}


    public long createEmploye(String user, String pass) {
        return dao.createEmploye(user, pass);
    }
}
