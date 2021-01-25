package northwind.model;

public class Empleado {
    private Integer idEmpleado;
    private String nombre;
    private String apellido;
    private String titulo;
    private String tituloDeCortesia;
    private String fechaNacimiento;
    private String fechaContratacion;
    private String telefonoCasa;
    private String extension;
    private String email;
    private String foto;
    private String notas;
    private int reportaAEmpleado;
    private String pathFoto;
    private Region region;


    public Empleado(Integer idEmpleado, String apellido, String nombre, String titulo, String tituloDeCortesia, String fecha_nacimiento, String fechaContratacion, String telefonoCasa, String extension, String foto, String notas, int reportaAEmpleado, String pathFoto, String email, Region region) {
        this.idEmpleado = idEmpleado;
        this.apellido = apellido;
        this.nombre = nombre;
        this.titulo = titulo;
        this.tituloDeCortesia = tituloDeCortesia;
        this.fechaNacimiento = fecha_nacimiento;
        this.fechaContratacion = fechaContratacion;
        this.telefonoCasa = telefonoCasa;
        this.extension = extension;
        this.foto = foto;
        this.notas = notas;
        this.reportaAEmpleado = reportaAEmpleado;
        this.pathFoto = pathFoto;
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

    public String getTituloDeCortesia() {
        return tituloDeCortesia;
    }

    public void setTituloDeCortesia(String tituloDeCortesia) {
        this.tituloDeCortesia = tituloDeCortesia;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fecha_nacimiento) {
        this.fechaNacimiento = fecha_nacimiento;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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

    public int getReportaAEmpleado() {
        return reportaAEmpleado;
    }

    public void setReportaAEmpleado(int reportaAEmpleado) {
        this.reportaAEmpleado = reportaAEmpleado;
    }

    public String getPathFoto() {
        return pathFoto;
    }

    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
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
