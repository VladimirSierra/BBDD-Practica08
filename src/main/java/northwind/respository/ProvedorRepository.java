package northwind.respository;

import northwind.model.Provedor;

import java.sql.SQLException;
import java.util.List;

public interface ProvedorRepository {

    /**
     * Obten todos los registros de la tabla Provedor
     * @return
     */
    List<Provedor> getProvedores() throws Exception;

    /**
     * Obtiene la informacion de un Provedor
     * @param idProvedor
     * @return
     */
    Provedor getProvedor(Integer idProvedor) throws Exception;

    /**
     * Inserta una nuevo provedor a la base de datos
     * @param provedor
     * @return
     */
    Provedor insertProvedor(Provedor provedor) throws Exception;

    /**
     * Actualiza un provedor a la base de datos
     * @param provedor
     * @return
     */
    Provedor updateProvedor(Integer provedorId, Provedor provedor) throws Exception;

    /**
     * Elimina un provedor de la base de datos
     * @param provedorId
     * @return
     */
    boolean deleteProvedor(Integer provedorId) throws Exception;
}
