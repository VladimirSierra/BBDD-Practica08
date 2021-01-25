package northwind.web;

import northwind.model.Provedor;
import northwind.service.ProvedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("provedor")
public class ProvedorController {

    @Autowired
    private ProvedorService provedorService;

    @GetMapping
    public List<Provedor> provedores(){
        try {
            return provedorService.getProvedores();
        } catch (Exception exc) {
        throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,"Internal error", exc);
        }
    }

    @PostMapping
    public Provedor insertProvedor(@RequestBody Provedor provedor){
        try{
            return provedorService.insertProvedor(provedor);
        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,"Internal error", exc);
        }
    }

    @GetMapping(value = "/{idProvedor}")
    public Provedor provedor(@PathVariable(value = "idProvedor")Integer idProvedor){
        try{
            return provedorService.getProvedor(idProvedor);
        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,"Internal error", exc);
        }
    }

    @PutMapping(value = "/{idProvedor}")
    public Provedor updateProvedor(@PathVariable("idProvedor") Integer idProvedor,
                                   @RequestBody Provedor provedor){
        try{
            return provedorService.updateProvedor(idProvedor, provedor);
        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,"Internal error", exc);
        }
    }

    @DeleteMapping(value = "/{idProvedor}")
    public boolean deleteProvedor(@PathVariable("idProvedor") Integer idProvedor) {
        try {
            return provedorService.deleteProvedor(idProvedor);
        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,"Internal error", exc);
        }
    }

}
