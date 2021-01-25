package northwind.respository.impl;

import northwind.config.DBConfig;
import northwind.model.Empleado;
import northwind.model.Region;
import northwind.respository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@PropertySource("classpath:application.queries.properties")

public class EmpleadoRepositoryImpl implements EmpleadoRepository {
    //Se inyecta configuracion de la base de datos
    @Autowired
    private DBConfig dbConfig;
    //Objeto que ayuda a cargar configuracion
    @Autowired
    private Environment env;


    //Objeto para crear la conexión
    private Connection connection;
    private Connection connection2;
    //Objeto para executar queries
    private Statement stmt;
    //Objeto para prepara un query para ejecución
    PreparedStatement ps;
    //private RegionRepositoryImpl regionRep = new RegionRepositoryImpl();

    public List<Empleado> getEmpleados() throws Exception {
        //Leo query a ejecutar
        String query = env.getProperty("empleados");

        //Preparo respuesta
        List empleadoList = new ArrayList<Empleado>();
        try {
            //Genero conexion
            connection = dbConfig.dataSource().getConnection();
            //Preparo base de datos para una instruccion
            stmt = connection.createStatement();
            //Ejecuto Query
            ResultSet rs = stmt.executeQuery(query);

            String queryRegion = env.getProperty("region");
            //Itero resultado
            while (rs.next()) {


                //Mappeo objetos de la base renglon por renglon
                Empleado empleado = new Empleado(
                        rs.getInt("id_empleado")
                        , rs.getString("apellido")
                        , rs.getString("nombre")
                        , rs.getString("titulo")
                        , rs.getString("titulo_de_cortesia")
                        , rs.getString("fecha_nacimiento")
                        , rs.getString("fecha_contratacion")
                        , rs.getString("telefono_casa")
                        , rs.getString("extension")
                        , rs.getString("foto")
                        , rs.getString("notas")
                        , rs.getInt("reporta_a_empleado")
                        , rs.getString("path_foto")
                        , rs.getString("email")
                        , null );

                //copiamos el id de region
                int region_id = rs.getInt("id_region");

                // Buscamos el objeto region que corresponde al usuario
                Region region = null;

                ps =  connection.prepareStatement(queryRegion);
                ps.setInt(1,region_id);
                ResultSet rsRegion = ps.executeQuery();

                if(rsRegion.next() ) {
                    //Mappeo objetos de la base renglon por renglon
                    region = new Region(rsRegion.getInt("id_region")
                            , rsRegion.getString("direccion")
                            , rsRegion.getString("ciudad")
                            , rsRegion.getString("codigo_postal")
                            , rsRegion.getString("region")
                            , rsRegion.getString("pais") );
                }

                // Asignamos la region al empleado.
                empleado.setRegion(region);

                //agrego objeto a resultado
                empleadoList.add(empleado);
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
        return empleadoList;
    }

    public Empleado getEmpleado(Integer idEmpleado) throws Exception {

        String query = env.getProperty("empleado");
        String queryRegion = env.getProperty("region");

        //Preparo respuesta
        Empleado empleado = null;

        try {
            //Genero conexion
            connection = dbConfig.dataSource().getConnection();

            ps =  connection.prepareStatement(query);
            ps.setInt(1,idEmpleado);
            ResultSet rs = ps.executeQuery();
            //Itero resultado
            if(rs.next()) {
                //Mappeo objetos de la base renglon por renglon
                empleado = new Empleado(
                        rs.getInt("id_empleado")
                        , rs.getString("apellido")
                        , rs.getString("nombre")
                        , rs.getString("titulo")
                        , rs.getString("titulo_de_cortesia")
                        , rs.getString("fecha_nacimiento")
                        , rs.getString("fecha_contratacion")
                        , rs.getString("telefono_casa")
                        , rs.getString("extension")
                        , rs.getString("foto")
                        , rs.getString("notas")
                        , rs.getInt("reporta_a_empleado")
                        , rs.getString("path_foto")
                        , rs.getString("email")
                        , null );

                //copiamos el id de region
                int region_id = rs.getInt("id_region");

                // Buscamos el objeto region que corresponde al usuario
                Region region = null;

                ps =  connection.prepareStatement(queryRegion);
                ps.setInt(1,region_id);
                ResultSet rsRegion = ps.executeQuery();

                if(rsRegion.next() ) {
                    //Mappeo objetos de la base renglon por renglon
                    region = new Region(rsRegion.getInt("id_region")
                            , rsRegion.getString("direccion")
                            , rsRegion.getString("ciudad")
                            , rsRegion.getString("codigo_postal")
                            , rsRegion.getString("region")
                            , rsRegion.getString("pais") );
                }

                // Asignamos la region al empleado.
                empleado.setRegion(region);
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
        return empleado;
    }

    public Empleado insertEmpleado(Empleado empleado) throws Exception {
        String query = env.getProperty("insertEmpleado");
        String queryRegion = env.getProperty("insertRegion");

        try {
            connection = dbConfig.dataSource().getConnection();
            // Insertamos a la region
            ps = connection.prepareStatement(queryRegion);
            Region region = empleado.getRegion();

            ps.setString(1, region.getDireccion() );
            ps.setString(2, region.getCiudad() );
            ps.setString(3, region.getCodigo_postal() );
            ps.setString(4, region.getRegion());
            ps.setString(5, region.getPais() );
            region.setIdRegion(ps.executeUpdate());
            connection.createStatement();

            // Insertamos al empleado
            ps = connection.prepareStatement(query);
            ps.setString(1, empleado.getApellido() );
            ps.setString(2, empleado.getNombre() );
            ps.setString(3, empleado.getTitulo() );
            ps.setString(4, empleado.getTitulo_de_cortesia());
            ps.setDate(5, Date.valueOf(empleado.getFecha_nacimiento() ));
            ps.setDate(6, Date.valueOf( empleado.getFecha_contratacion()));
            ps.setString(7, empleado.getTelefono_casa());
            ps.setString(8, empleado.getExtendion());
            ps.setBytes(9, empleado.getFoto().getBytes(StandardCharsets.UTF_8) );
            ps.setString(10, empleado.getNotas());
            ps.setInt(11, empleado.getReporta_a_empleado());
            ps.setString(12, empleado.getPath_foto());
            ps.setInt(13, region.getIdRegion()) ;
            ps.setString(14, empleado.getEmail() );
            empleado.setIdEmpleado(ps.executeUpdate());
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
        return empleado;
    }

    public Empleado updateEmpleado(Integer idEmpleado, Empleado empleado) throws Exception {
        return null;
    }


    public boolean deleteEmpleado(Integer idEmpleado) throws Exception {
        String query = env.getProperty("deleteEmpleado");
        boolean ok = false;
        try {
            connection = dbConfig.dataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1,idEmpleado);
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
