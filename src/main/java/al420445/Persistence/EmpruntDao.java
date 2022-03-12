package al420445.Persistence;

public interface EmpruntDao {
    <T> void save(T t);

    <T> void merge(T t);

    long createEmprunt(long livreId, long clientId);
}
