package al420445.Service;

import al420445.Persistence.LibraryDao;
import al420445.Persistence.LibraryDaoJPA;

public class ClientService {

    private LibraryDao dao;

    public ClientService(LibraryDaoJPA libraryDaoJPA) {
    }

    public long createClient(String name, String address) {
        return dao.createClient(name, address);
    }


}
