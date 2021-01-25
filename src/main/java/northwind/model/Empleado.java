package northwind.model;

public class Empleado {
    private Integer idEmpleado;
    private String apellido;
    private String nombre;
    private String titulo;
    private String titulo_de_cortesia;
    private String fecha_nacimiento;
    private String fecha_contratacion;
    private String telefono_casa;
    private String extendion;
    private String foto;
    private String notas;
    private int reporta_a_empleado;
    private String path_foto;
    private String email;
    private Region region;


    public Empleado(Integer idEmpleado, String apellido, String nombre, String titulo, String titulo_de_cortesia, String fecha_nacimiento, String fecha_contratacion, String telefono_casa, String extendion, String foto, String notas, int reporta_a_empleado, String path_foto, String email, Region region) {
        this.idEmpleado = idEmpleado;
        this.apellido = apellido;
        this.nombre = nombre;
        this.titulo = titulo;
        this.titulo_de_cortesia = titulo_de_cortesia;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_contratacion = fecha_contratacion;
        this.telefono_casa = telefono_casa;
        this.extendion = extendion;
        this.foto = foto;
        this.notas = notas;
        this.reporta_a_empleado = reporta_a_empleado;
        this.path_foto = path_foto;
        this.email = email;
        this.region = region;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo_de_cortesia() {
        return titulo_de_cortesia;
    }

    public void setTitulo_de_cortesia(String titulo_de_cortesia) {
        this.titulo_de_cortesia = titulo_de_cortesia;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(String fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public String getTelefono_casa() {
        return telefono_casa;
    }

    public void setTelefono_casa(String telefono_casa) {
        this.telefono_casa = telefono_casa;
    }

    public String getExtendion() {
        return extendion;
    }

    public void setExtendion(String extendion) {
        this.extendion = extendion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public int getReporta_a_empleado() {
        return reporta_a_empleado;
    }

    public void setReporta_a_empleado(int reporta_a_empleado) {
        this.reporta_a_empleado = reporta_a_empleado;
    }

    public String getPath_foto() {
        return path_foto;
    }

    public void setPath_foto(String path_foto) {
        this.path_foto = path_foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
