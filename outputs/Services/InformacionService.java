public class InformacionService{

private Informacion  informacion =  new Informacion();public void eliminarInformacion(Informacion informacion) {
        informacion.delete(informacion.getId());
    } public List<Informacion> selectAll(){
        return Informacion.findAll();
    }public void updateInformacion(Informacion informacion) throws IllegalArgumentException{
informacion.insert(Informacion);
}
public void eliminarInformacion(Informacion informacion) throws IllegalArgumentException{
informacion.update(Informacion);
}
}
