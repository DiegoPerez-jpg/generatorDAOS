

public class Producto{
private int id;
private String codigo;
private String descripcion;
private double precio_coste;
private double precio_venta;
private double stock;
private int fk_id_entidad;
private int fk_id_tipoiva;

public Producto( int id, String codigo, String descripcion, double precio_coste, double precio_venta, double stock, int fk_id_entidad, int fk_id_tipoiva )  {
this.id = id;
this.codigo = codigo;
this.descripcion = descripcion;
this.precio_coste = precio_coste;
this.precio_venta = precio_venta;
this.stock = stock;
this.fk_id_entidad = fk_id_entidad;
this.fk_id_tipoiva = fk_id_tipoiva;
}

public int getId() {
    return id;
}
 
public void setId(int id) {
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
 
public double getPrecio_coste() {
    return precio_coste;
}
 
public void setPrecio_coste(double precio_coste) {
    this.precio_coste = precio_coste;
}
 
public double getPrecio_venta() {
    return precio_venta;
}
 
public void setPrecio_venta(double precio_venta) {
    this.precio_venta = precio_venta;
}
 
public double getStock() {
    return stock;
}
 
public void setStock(double stock) {
    this.stock = stock;
}
 
public int getFk_id_entidad() {
    return fk_id_entidad;
}
 
public void setFk_id_entidad(int fk_id_entidad) {
    this.fk_id_entidad = fk_id_entidad;
}
 
public int getFk_id_tipoiva() {
    return fk_id_tipoiva;
}
 
public void setFk_id_tipoiva(int fk_id_tipoiva) {
    this.fk_id_tipoiva = fk_id_tipoiva;
}
 


}