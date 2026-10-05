import java.util.List;

public interface Repository<T> {

    void add(T item);

    List<T> getAll();

    T findById(int id);
}