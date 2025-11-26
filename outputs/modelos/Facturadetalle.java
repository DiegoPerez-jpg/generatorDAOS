

public class Facturadetalle{
private Integer fk_id_factura;
private Integer fk_id_producto;
private Double cantidad;
private Double precio_unitario;
private Double total_linea;

public Facturadetalle( Integer fk_id_factura, Integer fk_id_producto, Double cantidad, Double precio_unitario, Double total_linea )  {
this.fk_id_factura = fk_id_factura;
this.fk_id_producto = fk_id_producto;
this.cantidad = cantidad;
this.precio_unitario = precio_unitario;
this.total_linea = total_linea;
}

public Integer getFk_id_factura() {
    return fk_id_factura;
}
 
public void setFk_id_factura(Integer fk_id_factura) {
    this.fk_id_factura = fk_id_factura;
}
 
public Integer getFk_id_producto() {
    return fk_id_producto;
}
 
public void setFk_id_producto(Integer fk_id_producto) {
    this.fk_id_producto = fk_id_producto;
}
 
public Double getCantidad() {
    return cantidad;
}
 
public void setCantidad(Double cantidad) {
    this.cantidad = cantidad;
}
 
public Double getPrecio_unitario() {
    return precio_unitario;
}
 
public void setPrecio_unitario(Double precio_unitario) {
    this.precio_unitario = precio_unitario;
}
 
public Double getTotal_linea() {
    return total_linea;
}
 
public void setTotal_linea(Double total_linea) {
    this.total_linea = total_linea;
}
 


}