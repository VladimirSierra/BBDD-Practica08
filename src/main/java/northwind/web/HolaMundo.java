package northwind.web;

import northwind.model.Mensaje;
import org.springframework.web.bind.annotation.*;

@RestController
public class HolaMundo {
    /**
     * Peticion GET para obtener un hola mundo
     * @return
     */
    @RequestMapping(value = "/holaMundo", method = RequestMethod.GET)
    public String holaMundo(){
        return "Hola mundo!";
    }

    /**
     * Peticion GET para obtener un mensaje
     */
    @RequestMapping(value = "/mensaje", method = RequestMethod.GET)
    public String mensaje(@RequestParam(value = "mensaje") String mensaje){
        return mensaje;
    }

    /**
     * Peticion POST para obtener un hola mundo
     * @return
     */
    @RequestMapping(value = "/holaMundo", method = RequestMethod.POST)
    public String holaMundoPost(){
        return "Hola mundo POST!";
    }

    /**
     * Peticion POST para obtener un mensaje
     */
    @RequestMapping(value = "/mensaje", method = RequestMethod.POST)
    public String mensajePost(@RequestBody Mensaje mensaje){
        return "From: " + mensaje.getRemitente() + "\n" +
                "Asunto: " + mensaje.getAsunto() + "\n" +
                "Cuerpo: " + mensaje.getContenido();
    }
}
