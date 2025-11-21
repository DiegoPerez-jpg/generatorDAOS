

public class Empresa{
private Integer id;
private Integer codigo;
private String nombre;
private String web;
private Integer fk_id_direccion;
private Integer fk_id_informacion;

public Empresa( Integer id, Integer codigo, String nombre, String web, Integer fk_id_direccion, Integer fk_id_informacion )  {
this.id = id;
this.codigo = codigo;
this.nombre = nombre;
this.web = web;
this.fk_id_direccion = fk_id_direccion;
this.fk_id_informacion = fk_id_informacion;
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
 
public String getWeb() {
    return web;
}
 
public void setWeb(String web) {
    this.web = web;
}
 
public Integer getFk_id_direccion() {
    return fk_id_direccion;
}
 
public void setFk_id_direccion(Integer fk_id_direccion) {
    this.fk_id_direccion = fk_id_direccion;
}
 
public Integer getFk_id_informacion() {
    return fk_id_informacion;
}
 
public void setFk_id_informacion(Integer fk_id_informacion) {
    this.fk_id_informacion = fk_id_informacion;
}
 


}