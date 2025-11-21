

public class Factura{
private Integer id;
private Integer fk_id_empresa;
private Integer fk_id_cliente;
private String numero;
private LocalDate fecha_emision;
private LocalDate fecha_servicio;
private String concepto;
private Double base_imponible;
private Double iva_total;
private Double total_factura;
private String estado;
private String observaciones;
private String tipo;

public Factura( Integer id, Integer fk_id_empresa, Integer fk_id_cliente, String numero, LocalDate fecha_emision, LocalDate fecha_servicio, String concepto, Double base_imponible, Double iva_total, Double total_factura, String estado, String observaciones, String tipo )  {
this.id = id;
this.fk_id_empresa = fk_id_empresa;
this.fk_id_cliente = fk_id_cliente;
this.numero = numero;
this.fecha_emision = fecha_emision;
this.fecha_servicio = fecha_servicio;
this.concepto = concepto;
this.base_imponible = base_imponible;
this.iva_total = iva_total;
this.total_factura = total_factura;
this.estado = estado;
this.observaciones = observaciones;
this.tipo = tipo;
}

public Integer getId() {
    return id;
}
 
public void setId(Integer id) {
    this.id = id;
}
 
public Integer getFk_id_empresa() {
    return fk_id_empresa;
}
 
public void setFk_id_empresa(Integer fk_id_empresa) {
    this.fk_id_empresa = fk_id_empresa;
}
 
public Integer getFk_id_cliente() {
    return fk_id_cliente;
}
 
public void setFk_id_cliente(Integer fk_id_cliente) {
    this.fk_id_cliente = fk_id_cliente;
}
 
public String getNumero() {
    return numero;
}
 
public void setNumero(String numero) {
    this.numero = numero;
}
 
public LocalDate getFecha_emision() {
    return fecha_emision;
}
 
public void setFecha_emision(LocalDate fecha_emision) {
    this.fecha_emision = fecha_emision;
}
 
public LocalDate getFecha_servicio() {
    return fecha_servicio;
}
 
public void setFecha_servicio(LocalDate fecha_servicio) {
    this.fecha_servicio = fecha_servicio;
}
 
public String getConcepto() {
    return concepto;
}
 
public void setConcepto(String concepto) {
    this.concepto = concepto;
}
 
public Double getBase_imponible() {
    return base_imponible;
}
 
public void setBase_imponible(Double base_imponible) {
    this.base_imponible = base_imponible;
}
 
public Double getIva_total() {
    return iva_total;
}
 
public void setIva_total(Double iva_total) {
    this.iva_total = iva_total;
}
 
public Double getTotal_factura() {
    return total_factura;
}
 
public void setTotal_factura(Double total_factura) {
    this.total_factura = total_factura;
}
 
public String getEstado() {
    return estado;
}
 
public void setEstado(String estado) {
    this.estado = estado;
}
 
public String getObservaciones() {
    return observaciones;
}
 
public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
}
 
public String getTipo() {
    return tipo;
}
 
public void setTipo(String tipo) {
    this.tipo = tipo;
}
 


}