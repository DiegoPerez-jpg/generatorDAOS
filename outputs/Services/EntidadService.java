public class EntidadService{

private Entidad  entidad =  new Entidad();public void eliminarEntidad(Entidad entidad) {
        entidad.delete(entidad.getId());
    } public List<Entidad> selectAll(){
        return Entidad.findAll();
    }public void updateEntidad(Entidad entidad) throws IllegalArgumentException{
entidad.insert(Entidad);
}
public void eliminarEntidad(Entidad entidad) throws IllegalArgumentException{
entidad.update(Entidad);
}
}
