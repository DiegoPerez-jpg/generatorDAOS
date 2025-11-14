

public class Cliente{
private int id;
private int fk_id_entidad;

public Cliente( int id, int fk_id_entidad )  {
this.id = id;
this.fk_id_entidad = fk_id_entidad;
}

public int getId() {
    return id;
}
 
public void setId(int id) {
    this.id = id;
}
 
public int getFk_id_entidad() {
    return fk_id_entidad;
}
 
public void setFk_id_entidad(int fk_id_entidad) {
    this.fk_id_entidad = fk_id_entidad;
}
 


}