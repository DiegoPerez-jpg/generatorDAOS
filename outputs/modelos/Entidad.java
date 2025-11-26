

public class Entidad{
private Integer id;
private Integer codigo;
private String nombre;
private Integer fk_id_informacion;
private Integer fk_id_direccion;

public Entidad( Integer id, Integer codigo, String nombre, Integer fk_id_informacion, Integer fk_id_direccion )  {
this.id = id;
this.codigo = codigo;
this.nombre = nombre;
this.fk_id_informacion = fk_id_informacion;
this.fk_id_direccion = fk_id_direccion;
}

public Integer getId() {
    return id;
}
 
public void setId(Integer id) {
    this.id = id;
}
 
public Integer getCodigo() {
    return codigo;
}
 
public void setCodigo(Integer codigo) {
    this.codigo = codigo;
}
 
public String getNombre() {
    return nombre;
}
 
public void setNombre(String nombre) {
    this.nombre = nombre;
}
 
public Integer getFk_id_informacion() {
    return fk_id_informacion;
}
 
public void setFk_id_informacion(Integer fk_id_informacion) {
    this.fk_id_informacion = fk_id_informacion;
}
 
public Integer getFk_id_direccion() {
    return fk_id_direccion;
}
 
public void setFk_id_direccion(Integer fk_id_direccion) {
    this.fk_id_direccion = fk_id_direccion;
}
 


}