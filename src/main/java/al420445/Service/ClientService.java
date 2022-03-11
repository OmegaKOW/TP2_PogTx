package al420445.Service;

import al420445.Persistence.LibraryDao;

public class ClientService {

    private LibraryDao dao;

    public long createClient(String name, String address) {
        return dao.createClient(name, address);
    }
}
