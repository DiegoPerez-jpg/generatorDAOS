public class EntidadService{

private EntidadDAO  entidadDAO =  new EntidadDAO();
public void eliminarEntidad(Entidad entidad) {
        entidadDAO.delete(entidad.getId());
    }
 public List<Entidad> selectAll(){
        return entidadDAO.findAll();
    }
public void crearEntidad(Entidad entidad) throws IllegalArgumentException{
entidadDAO.insert(entidad);
}
public void updateEntidad(Entidad entidad) throws IllegalArgumentException{
entidadDAO.update(entidad);
}
}
