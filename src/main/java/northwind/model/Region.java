package northwind.model;

public class Region {
    private Integer idRegion;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private String region;
    private String pais;

    /**
     * Metodo constructor
     * @param idRegion id de la region
     * @param direccion direccion
     * @param ciudad ciudad de la region
     * @param codigoPostal codigo postal de la region
     * @param region nombre de la region
     * @param pais pais de la region
     */
    public Region(Integer idRegion, String direccion, String ciudad, String codigoPostal, String region, String pais) {
        this.idRegion = idRegion;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.region = region;
        this.pais = pais;
    }

    /**
     * Metodo para obtener el id de region
     * @return id de la region
     */
    public Integer getIdRegion() {
        return idRegion;
    }

    /**
     * Metodo para asignar un valor al id de la revion
     * @param idRegion id a asignar
     */
    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    /**
     * Metodo para obtener la direccion de la region
     * @return direccion de la region
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Metodo para asignar una direccion a la region
     * @param direccion direccion a asignar
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo para obtener la ciudad de la region
     * @return Nombre de la ciudad de la region
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Metodo para asignar una ciudad a una region
     * @param ciudad a asignar para la region
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Metodo para obtener el codigo postal de la reigon
     * @return codigo postal de la ciudad
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Metodo para asignar un codigo postal a la region
     * @param codigoPostal a asiganr
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Metodo para obtener el nombre de la region
     * @return nombre de la ciudad
     */
    public String getRegion() {
        return region;
    }

    /**
     * Metodo para asignar un nombre a la region
     * @param region nombre a asignar
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Metodo para obtener el nombre del pais de la region
     * @return nombre del pais de la region
     */
    public String getPais() {
        return pais;
    }

    /**
     * Metodo para asignar el pais a una region
     * @param pais nombre del pais a asignar a la region
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
}
