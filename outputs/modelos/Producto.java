

public class Producto{
private Integer id;
private String codigo;
private String descripcion;
private String descripcion_aux;
private Double precio_coste;
private Double precio_venta;
private String referencia_proveedor;
private Double stock;
private Integer fk_id_proveedor;
private Integer fk_id_fabricante;
private Integer fk_id_tipoiva;

public Producto( Integer id, String codigo, String descripcion, String descripcion_aux, Double precio_coste, Double precio_venta, String referencia_proveedor, Double stock, Integer fk_id_proveedor, Integer fk_id_fabricante, Integer fk_id_tipoiva )  {
this.id = id;
this.codigo = codigo;
this.descripcion = descripcion;
this.descripcion_aux = descripcion_aux;
this.precio_coste = precio_coste;
this.precio_venta = precio_venta;
this.referencia_proveedor = referencia_proveedor;
this.stock = stock;
this.fk_id_proveedor = fk_id_proveedor;
this.fk_id_fabricante = fk_id_fabricante;
this.fk_id_tipoiva = fk_id_tipoiva;
}

public Integer getId() {
    return id;
}
 
public void setId(Integer id) {
    this.id = id;
}
 
public String getCodigo() {
    return codigo;
}
 
public void setCodigo(String codigo) {
    this.codigo = codigo;
}
 
public String getDescripcion() {
    return descripcion;
}
 
public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}
 
public String getDescripcion_aux() {
    return descripcion_aux;
}
 
public void setDescripcion_aux(String descripcion_aux) {
    this.descripcion_aux = descripcion_aux;
}
 
public Double getPrecio_coste() {
    return precio_coste;
}
 
public void setPrecio_coste(Double precio_coste) {
    this.precio_coste = precio_coste;
}
 
public Double getPrecio_venta() {
    return precio_venta;
}
 
public void setPrecio_venta(Double precio_venta) {
    this.precio_venta = precio_venta;
}
 
public String getReferencia_proveedor() {
    return referencia_proveedor;
}
 
public void setReferencia_proveedor(String referencia_proveedor) {
    this.referencia_proveedor = referencia_proveedor;
}
 
public Double getStock() {
    return stock;
}
 
public void setStock(Double stock) {
    this.stock = stock;
}
 
public Integer getFk_id_proveedor() {
    return fk_id_proveedor;
}
 
public void setFk_id_proveedor(Integer fk_id_proveedor) {
    this.fk_id_proveedor = fk_id_proveedor;
}
 
public Integer getFk_id_fabricante() {
    return fk_id_fabricante;
}
 
public void setFk_id_fabricante(Integer fk_id_fabricante) {
    this.fk_id_fabricante = fk_id_fabricante;
}
 
public Integer getFk_id_tipoiva() {
    return fk_id_tipoiva;
}
 
public void setFk_id_tipoiva(Integer fk_id_tipoiva) {
    this.fk_id_tipoiva = fk_id_tipoiva;
}
 


}