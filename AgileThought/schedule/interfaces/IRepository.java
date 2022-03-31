package interfaces;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IRepository <T> {

    List<T> findAll();

    Optional<? extends T> findOne(Integer id);

    T save(T t) throws IOException;

    void delete(Integer id) throws IOException;
}
