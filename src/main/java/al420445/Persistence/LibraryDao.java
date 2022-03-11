package al420445.Persistence;

public interface LibraryDao {

    <T> void save(T t);
    <T> void merge(T t);
    long createClient(String name, String address);
    long createEmploye(String user, String pass);
    void addDocToLibrary(String title, String author, String editor, long exemplaires, int release);
}
