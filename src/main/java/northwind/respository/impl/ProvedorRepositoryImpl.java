package northwind.respository.impl;

import northwind.config.DBConfig;
import northwind.model.Provedor;
import northwind.respository.ProvedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@PropertySource("classpath:application.queries.properties")
public class ProvedorRepositoryImpl implements ProvedorRepository {
    //Se inyecta configuracion de la base de datos
    @Autowired
    private DBConfig dbConfig;
    //Objeto que ayuda a cargar configuracion
    @Autowired
    private Environment env;
    //Objeto para crear la conexión
    private Connection connection;
    //Objeto para executar queries
    private Statement stmt;
    //Objeto para prepara un query para ejecución
    PreparedStatement ps;
    // F9 para saltar al siguiente punto de debug
    //F8 para saltar a la siguiente linea de debug
    public List<Provedor> getProvedores() throws Exception {
        //Leo query a ejecutar
        String query = env.getProperty("provedores");
        //Preparo respuesta
        List provedorList = new ArrayList<Provedor>();
        try {
            //Genero conexion
            connection = dbConfig.dataSource().getConnection();
            //Preparo base de datos para una instruccion
            stmt = connection.createStatement();
            //Ejecuto Query
            ResultSet rs = stmt.executeQuery(query);
            //Itero resultado
            while (rs.next()) {
                //Mappeo objetos de la base renglon por renglon
                Provedor provedor = new Provedor(
                        rs.getInt("id_provedor")
                        , rs.getString("nombre_compania")
                        , rs.getString("nombre_contacto")
                        , rs.getString("cargo_contacto")
                        , rs.getString("telefono")
                        , rs.getString("fax")
                        , rs.getString("pagina_provedor")
                        , rs.getInt("id_region"));
                provedor.setCreado(rs.getString("creado"));
                provedor.setCreadoPor(rs.getString("creado_por"));
                //agrego objeto a resultado
                provedorList.add(provedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return provedorList;
    }

    public Provedor getProvedor(Integer idProvedor) throws Exception {
        //Leo query a ejecutar
        String query = env.getProperty("provedor");
        //Preparo respuesta
        Provedor provedor = null;
        try {
            //Genero conexion
            connection = dbConfig.dataSource().getConnection();
            //Preparo base de datos para una instruccion
            ps =  connection.prepareStatement(query);
            ps.setInt(1,idProvedor);
            //Ejecuto Query
            ResultSet rs = ps.executeQuery();
            //Itero resultado
            while (rs.next()) {
                //Mappeo objetos de la base renglon por renglon
                provedor = new Provedor(rs.getInt("id_provedor")
                        , rs.getString("nombre_compania")
                        , rs.getString("nombre_contacto")
                        , rs.getString("cargo_contacto")
                        , rs.getString("telefono")
                        , rs.getString("fax")
                        , rs.getString("pagina_provedor")
                        , rs.getInt("id_region"));
                provedor.setCreado(rs.getString("creado"));
                provedor.setCreadoPor(rs.getString("creado_por"));
                //agrego objeto a resultado
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return provedor;
    }

    public Provedor insertProvedor(Provedor provedor) throws Exception {
        String query = env.getProperty("insertProvedor");
        try {
            connection = dbConfig.dataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1,provedor.getNombreCompania());
            ps.setString(2,provedor.getNombreContacto());
            ps.setString(3,provedor.getCargoContacto());
            ps.setString(4,provedor.getTelefono());
            ps.setString(5,provedor.getFax());
            ps.setString(6,provedor.getPaginaProvedor());
            ps.setInt(7,provedor.getIdRegion());
            ps.setString(8,provedor.getCreadoPor());
            provedor.setIdProvedor(ps.executeUpdate());
            connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return provedor;
    }

    public Provedor updateProvedor(Integer idProvedor, Provedor provedor) throws Exception {
        String query = env.getProperty("updateProvedor");
        try {
            connection = dbConfig.dataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1,provedor.getNombreCompania());
            ps.setString(2,provedor.getNombreContacto());
            ps.setString(3,provedor.getCargoContacto());
            ps.setString(4,provedor.getTelefono());
            ps.setString(5,provedor.getFax());
            ps.setString(6,provedor.getPaginaProvedor());
            ps.setInt(7,provedor.getIdRegion());
            ps.setInt(8,idProvedor);
            ps.executeUpdate();
            connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return provedor;
    }


    public boolean deleteProvedor(Integer idProvedor) throws Exception {
        String query = env.getProperty("deleteProvedor");
        boolean ok = false;
        try {
            connection = dbConfig.dataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1,idProvedor);
            ps.executeUpdate();
            ok = true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ok;
    }
}
