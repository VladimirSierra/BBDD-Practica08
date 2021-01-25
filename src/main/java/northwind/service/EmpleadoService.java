package northwind.service;

import northwind.model.Empleado;
import northwind.respository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;


    public List<Empleado> getEmpleados() throws Exception {
        return empleadoRepository.getEmpleados();
    }

    public Empleado insertEmpleado(Empleado empleado) throws Exception {
        return empleadoRepository.insertEmpleado(empleado);
    }

    public Empleado getEmpleado(Integer idEmpleado) throws Exception {
        return empleadoRepository.getEmpleado(idEmpleado);
    }

    public Empleado updateEmpleado(Integer idEmpleado, Empleado empleado) throws Exception {
        return empleadoRepository.updateEmpleado(idEmpleado,empleado);
    }

    public boolean deleteEmpleado(Integer idEmpleado) throws Exception {
        return empleadoRepository.deleteEmpleado(idEmpleado);
    }
}
