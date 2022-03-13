package al420445.Persistence;

import al420445.models.Library.Dette;
import al420445.models.Library.Document;
import al420445.models.Library.Emprunt;
import al420445.models.Library.Livre;
import al420445.models.Users.Client;
import al420445.models.Users.Employe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class LibraryDaoJPA implements LibraryDao{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");

    @Override
    public <T> void save(T t){
        final EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public <T> void merge(T t) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(t);

        em.getTransaction().commit();
        em.close();
    }


    @Override
    public long createClient(String name, String address) {

        final Client client= Client.builder().clientName(name).clientAddress(address).build();
        save(client);
        return client.getClientID();
    }

    @Override
    public long createEmploye(String user, String pass) {

        final Employe employe = Employe.builder().user(user).password(pass).build();
        save(employe);
        return employe.getId();

    }
    @Override
    public long addBookToLibrary(String title, String author, String editor, long exemplaires, int release, int nbPages, String genre){
        final Livre doc = (Livre) Livre.builder().title(title).author(author).editor(editor).exemplaires(exemplaires).releaseYear(release).nbPages(nbPages).genre(genre).build();
        save(doc);
        return doc.getDocumentID();
    }


    @Override
    public Livre getLivre(long livreId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Livre livre = em.find(Livre.class, livreId);

        em.getTransaction().commit();
        em.close();
        return livre;
    }

    @Override
    public Client getClient(long clientId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Client client = em.find(Client.class, clientId);

        em.getTransaction().commit();
        em.close();
        return client;
    }

    @Override
    public Livre getLivreWithTitle(String title) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Livre> query = em.createQuery(
                "select l from Livre l where l.title like :livreTitle"
        ,Livre.class);
        query.setParameter("livreTitle", title);
        final Livre livre = query.getSingleResult();

        em.getTransaction().commit();
        em.close();
        return livre;
    }

    @Override
    public Livre getLivreWithAuthor(String author) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Livre> query = em.createQuery(
                "select l from Livre l where l.author like :livreAuthor"
                ,Livre.class);
        query.setParameter("livreAuthor", author);
        final Livre livre = query.getSingleResult();

        em.getTransaction().commit();
        em.close();
        return livre;
    }

    @Override
    public Livre getLivreWithGenre(String genre) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Livre> query = em.createQuery(
                "select l from Livre l where l.genre like :livreGenre"
                ,Livre.class);
        query.setParameter("livreGenre", genre);
        final Livre livre = query.getSingleResult();

        em.getTransaction().commit();
        em.close();
        return livre;
    }

    @Override
    public Livre getLivreWithYear(long year) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Livre> query = em.createQuery(
                "select l from Livre l where l.releaseYear = :releaseYear"
                ,Livre.class);
        query.setParameter("releaseYear", (int) year);
        final Livre livre = query.getSingleResult();

        em.getTransaction().commit();
        em.close();
        return livre;
    }

    @Override
    public long borrowBook(long bookId, long clientId){
        final Client client = getClientWithEmpruntsAndDettes(clientId);
        final Document document = getLivre(bookId);
        final Emprunt emprunt = client.borrowBook(document);
        if(emprunt != null){
            save(emprunt);
        }
        return emprunt.getId();
    }

    private Client getClientWithEmpruntsAndDettes(long clientId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Client> query = em.createQuery(
                "select c from Client c left join fetch c.emprunts ce left join fetch c.dettes where c.id = :clientId"
                , Client.class);
        query.setParameter("clientId", clientId);
        final Client client = query.getSingleResult();

        em.getTransaction().commit();
        em.close();
        return client;
    }

    @Override
    public Emprunt getEmpruntWithBookIdAndClientId(long bookId, long clientId){

        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Emprunt> query = em.createQuery(
                "select e from Emprunt e left join fetch e.client ec left join fetch e.doc ed where ec.clientID = :clientId and ed.id = :bookId"
                , Emprunt.class);
        query.setParameter("clientId", clientId);
        query.setParameter("bookId", bookId);
        final Emprunt emprunt = query.getSingleResult();

        em.getTransaction().commit();
        em.close();
        return emprunt;

    }

    @Override
    public Dette getDettesWithClientId(long clientId){
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Dette> query = em.createQuery(
                "select d from Dette d where d.client.id = :clientId"
                ,Dette.class);
        query.setParameter("clientId", clientId);
        final Dette dette = query.getSingleResult();

        em.getTransaction().commit();
        em.close();
        return dette;
    }


    @Override
    public void returnBook(long bookId, long clientId) {
        final Client client = getClientWithEmpruntsAndDettes(clientId);
        final Livre livre = getLivre(bookId);
        final Dette dette = client.returnBook(livre);
        if(dette != null){
            dette.getEmpruntsEndettes().add(getEmpruntWithBookIdAndClientId(bookId,clientId));
            save(dette);
        }

    }

    @Override
    public List<Emprunt> getEmpruntsWithDateRetours(long clientId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Emprunt> query = em.createQuery(
                "select e from Emprunt e where e.client.id = :clientId"
                ,Emprunt.class);
        query.setParameter("clientId", clientId);
        final List<Emprunt> emprunts = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return emprunts;
    }


}
