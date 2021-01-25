package northwind.respository;

import northwind.model.Empleado;

import java.util.List;

public interface EmpleadoRepository {

    /**
     * Obten todos los registros de la tabla Empleado
     * @return Lista de objetos Empleado en la db.
     */
    List<Empleado> getEmpleados() throws Exception;

    /**
     * Obtiene la informacion de un Empleado
     * @param idEmpleado
     * @return indormacion del empleado con el id dado
     */
    Empleado getEmpleado(Integer idEmpleado) throws Exception;

    /**
     * Inserta una nuevo provedor a la base de datos
     * @param empleado
     * @return
     */
    Empleado insertEmpleado(Empleado empleado) throws Exception;

    /**
     * Actualiza un empleado a la base de datos
     * @param empleado
     * @return
     */
    Empleado updateEmpleado(Integer empleadoId, Empleado empleado) throws Exception;

    /**
     * Elimina un empleado de la base de datos
     * @param empleadoId
     * @return
     */
    boolean deleteEmpleado(Integer empleadoId) throws Exception;
}
