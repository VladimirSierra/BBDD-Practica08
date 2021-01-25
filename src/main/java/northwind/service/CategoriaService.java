package northwind.service;

import northwind.model.Categoria;
import northwind.respository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(final CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    /**
     * Obtener todas las categorias
     * @return
     */
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(){
        return categoriaRepository.findAll();
    }

    /**
     * Obtener categoria por id
     */
    @Transactional(readOnly = true)
    public Categoria getCategoria(final Long idCategoria){
        return categoriaRepository.findById(idCategoria)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "No se encontró categoria con id " + idCategoria));
    }

    /**
     * Insertar una nueva Categoria
     */
    @Transactional
    public Categoria insertCategoria(final Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    /**
     * Actualiza una categoria
     * @param idCategoria
     * @param categoria
     * @return
     */
    public Categoria updateCategoria(final Long idCategoria,final Categoria categoria){
        return categoriaRepository.findById(idCategoria)
                .map(categoriaEncontrada -> {
                    categoriaEncontrada.setNombreCategoria(categoria.getNombreCategoria());
                    categoriaEncontrada.setDescripcion(categoria.getDescripcion());
                    categoriaEncontrada.setImagen(categoria.getImagen());
                    return categoriaRepository.save(categoriaEncontrada);
                }).orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "No se encontró categoria con id " + idCategoria));
    }

    /**
     * Elimina categoria por idCategoria
     * @param idCategoria
     */
    @Transactional
    public void deleteCategoria(final Long idCategoria) {
        categoriaRepository.delete(categoriaRepository.findById(idCategoria)
                                    .orElseThrow(() -> new ResponseStatusException(
                                        HttpStatus.NOT_FOUND,
                                        "No se encontró categoria con id " + idCategoria)));
    }

    /**
     * Obtener todas las categorias
     * @return
     */
    @Transactional(readOnly = true)
    public List<Categoria> getCategoriasRangoCreacion(final LocalDate fechaCreacion, final String creadoPor){
        return categoriaRepository
                .findAllByCreadoGreaterThanEqualAndCreadoPorLike(LocalDateTime.of(fechaCreacion, LocalTime.MIN),
                        creadoPor);
        /*
         * SELECT *
         * FROM creacion
         * where creado = ? and creado_por like ?;
         */
    }
}
