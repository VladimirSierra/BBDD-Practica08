package northwind.web;

import northwind.model.Categoria;
import northwind.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(final CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> categorias(){
        return categoriaService.getCategorias();
    }

    @GetMapping(value = "/{idCategoria}")
    public Categoria provedor(@PathVariable(value = "idCategoria") final Long idCategoria){
        return categoriaService.getCategoria(idCategoria);
    }

    @PostMapping
    public Categoria insertCategoria(@RequestBody final Categoria categoria){
        return categoriaService.insertCategoria(categoria);
    }

    @PutMapping(value = "/{idCategoria}")
    public Categoria updateCategoria(@PathVariable("idCategoria") final Long idCategoria,
                                   @RequestBody final Categoria provedor){
        return categoriaService.updateCategoria(idCategoria, provedor);
    }

    @DeleteMapping(value = "/{idCategoria}")
    public void deleteCategoria(@PathVariable("idCategoria") final Long idCategoria) {
        categoriaService.deleteCategoria(idCategoria);
    }

    @GetMapping("filtrar")
    public List<Categoria> categoriasRangoFecha(@RequestParam(value = "fechaCreacion") final String fechaCreacion,
                                                @RequestParam(value = "creadoPor") final String creadoPor){
        return categoriaService.getCategoriasRangoCreacion(LocalDate.parse(fechaCreacion),creadoPor);
    }
}
