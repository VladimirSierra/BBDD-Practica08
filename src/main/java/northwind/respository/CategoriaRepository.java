package northwind.respository;

import northwind.model.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria,Long> {
    /**
     * Obtener todas las categorias
     * @return
     */
    List<Categoria> findAll();

    /**
     * Obtener categoria por id_categoria
     * @param id
     * @return
     */
    Optional<Categoria> findById(final Long id);

    /**
     * Guardar categoria
     * @param categia
     * @return
     */
    Categoria save(final Categoria categia);

    /**
     * Eliminar categoria
     * @param categoria
     */
    void delete(final Categoria categoria);

    /**
     * Obtener todas las categorias filtrados por fecha de creación
     * @return
     */
    List<Categoria> findAllByCreadoGreaterThanEqualAndCreadoPorLike(LocalDateTime fechaInicio,String creadoPor);
}
