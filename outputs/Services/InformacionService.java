public class InformacionService{

private InformacionDAO  informacionDAO =  new InformacionDAO();
public void eliminarInformacion(Informacion informacion) {
        informacionDAO.delete(informacion.getId());
    }
 public List<Informacion> selectAll(){
        return informacionDAO.findAll();
    }
public void crearInformacion(Informacion informacion) throws IllegalArgumentException{
if (!informacionDAO.filterByAll(null , informacion.getNif() , null , null ).isEmpty())throw new IllegalArgumentException("El nif ya existe");
informacionDAO.insert(informacion);
}
public void updateInformacion(Informacion informacion) throws IllegalArgumentException{
if (!informacionDAO.filterByAll(null , informacion.getNif() , null , null ).isEmpty())throw new IllegalArgumentException("El nif ya existe");
informacionDAO.update(informacion);
}
}
