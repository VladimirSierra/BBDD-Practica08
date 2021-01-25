package northwind.web;

import northwind.model.Empleado;
import northwind.model.Provedor;
import northwind.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> empleados(){
        try {
            return empleadoService.getEmpleados();
        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,"Internal error", exc);
        }
    }


    @GetMapping(value = "/{idEmpleado}")
    public Empleado provedor(@PathVariable(value = "idEmpleado")Integer idEmpleado){
        try{
            return empleadoService.getEmpleado(idEmpleado);
        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,"Internal error", exc);
        }
    }
}
