

public class Relacionfactura{
private int fk_id_factura;
private int fk_id_producto;
private double cantidad;

public Relacionfactura( int fk_id_factura, int fk_id_producto, double cantidad )  {
this.fk_id_factura = fk_id_factura;
this.fk_id_producto = fk_id_producto;
this.cantidad = cantidad;
}

public int getFk_id_factura() {
    return fk_id_factura;
}
 
public void setFk_id_factura(int fk_id_factura) {
    this.fk_id_factura = fk_id_factura;
}
 
public int getFk_id_producto() {
    return fk_id_producto;
}
 
public void setFk_id_producto(int fk_id_producto) {
    this.fk_id_producto = fk_id_producto;
}
 
public double getCantidad() {
    return cantidad;
}
 
public void setCantidad(double cantidad) {
    this.cantidad = cantidad;
}
 


}