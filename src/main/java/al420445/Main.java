package al420445;

import al420445.Persistence.LibraryDaoJPA;
import al420445.Service.ClientService;

public class Main {

    public static void main(String[] args) {


        ClientService cs = new ClientService(new LibraryDaoJPA());
        cs.createClient("John Doe", "123 Java Rd");

    }
}
