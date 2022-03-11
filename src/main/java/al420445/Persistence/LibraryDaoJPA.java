package al420445.Persistence;

import al420445.models.Library.Document;
import al420445.models.Library.Livre;
import al420445.models.Users.Client;
import al420445.models.Users.Employe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
    public long addDocToLibrary(String title, String author, String editor, long exemplaires, int release){
        final Document doc = Document.builder().title(title).author(author).editor(editor).exemplaires(exemplaires).releaseYear(release).build();
        save(doc);
        return doc.getDocumentID();
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


}