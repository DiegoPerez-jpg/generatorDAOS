

public class Empresa{
private int id;
private String nombre;
private String web;
private String domiciliofiscal;
private String contacto;
private int fk_id_direccion;
private int fk_id_informacion;

public Empresa( int id, String nombre, String web, String domiciliofiscal, String contacto, int fk_id_direccion, int fk_id_informacion )  {
this.id = id;
this.nombre = nombre;
this.web = web;
this.domiciliofiscal = domiciliofiscal;
this.contacto = contacto;
this.fk_id_direccion = fk_id_direccion;
this.fk_id_informacion = fk_id_informacion;
}

public int getId() {
    return id;
}
 
public void setId(int id) {
    this.id = id;
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
 
public String getDomiciliofiscal() {
    return domiciliofiscal;
}
 
public void setDomiciliofiscal(String domiciliofiscal) {
    this.domiciliofiscal = domiciliofiscal;
}
 
public String getContacto() {
    return contacto;
}
 
public void setContacto(String contacto) {
    this.contacto = contacto;
}
 
public int getFk_id_direccion() {
    return fk_id_direccion;
}
 
public void setFk_id_direccion(int fk_id_direccion) {
    this.fk_id_direccion = fk_id_direccion;
}
 
public int getFk_id_informacion() {
    return fk_id_informacion;
}
 
public void setFk_id_informacion(int fk_id_informacion) {
    this.fk_id_informacion = fk_id_informacion;
}
 


}