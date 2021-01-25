package northwind.model;

public class Provedor {

    private Integer idProvedor;
    private String nombreCompania;
    private String nombreContacto;
    private String cargoContacto;
    private String telefono;
    private String fax;
    private String paginaProvedor;
    private Integer idRegion;
    private String creado;
    private String creadoPor;

    public Provedor(Integer idProvedor, String nombreCompania, String nombreContacto, String cargoContacto,
                    String telefono, String fax, String paginaProvedor, Integer idRegion) {
        this.idProvedor = idProvedor;
        this.nombreCompania = nombreCompania;
        this.nombreContacto = nombreContacto;
        this.cargoContacto = cargoContacto;
        this.telefono = telefono;
        this.fax = fax;
        this.paginaProvedor = paginaProvedor;
        this.idRegion = idRegion;
    }

    public Integer getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(Integer idProvedor) {
        this.idProvedor = idProvedor;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getCargoContacto() {
        return cargoContacto;
    }

    public void setCargoContacto(String cargoContacto) {
        this.cargoContacto = cargoContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPaginaProvedor() {
        return paginaProvedor;
    }

    public void setPaginaProvedor(String paginaProvedor) {
        this.paginaProvedor = paginaProvedor;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public String getCreado() {
        return creado;
    }

    public void setCreado(String creado) {
        this.creado = creado;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

}
