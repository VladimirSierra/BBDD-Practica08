package northwind.web;

import northwind.model.Empleado;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("empleado")
public class EmpleadoController {

    @PostMapping
    public Empleado empleado(@RequestBody Empleado empleado){
       return empleado;
    }
}
