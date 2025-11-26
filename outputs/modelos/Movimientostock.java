

public class Movimientostock{
private Integer id;
private Integer fk_id_producto;
private LocalDate fecha;
private Double cantidad;
private String motivo;
private String tipo;

public Movimientostock( Integer id, Integer fk_id_producto, LocalDate fecha, Double cantidad, String motivo, String tipo )  {
this.id = id;
this.fk_id_producto = fk_id_producto;
this.fecha = fecha;
this.cantidad = cantidad;
this.motivo = motivo;
this.tipo = tipo;
}

public Integer getId() {
    return id;
}
 
public void setId(Integer id) {
    this.id = id;
}
 
public Integer getFk_id_producto() {
    return fk_id_producto;
}
 
public void setFk_id_producto(Integer fk_id_producto) {
    this.fk_id_producto = fk_id_producto;
}
 
public LocalDate getFecha() {
    return fecha;
}
 
public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
}
 
public Double getCantidad() {
    return cantidad;
}
 
public void setCantidad(Double cantidad) {
    this.cantidad = cantidad;
}
 
public String getMotivo() {
    return motivo;
}
 
public void setMotivo(String motivo) {
    this.motivo = motivo;
}
 
public String getTipo() {
    return tipo;
}
 
public void setTipo(String tipo) {
    this.tipo = tipo;
}
 


}