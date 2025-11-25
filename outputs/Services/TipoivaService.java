public class TipoivaService{

private Tipoiva  tipoiva =  new Tipoiva();public void eliminarTipoiva(Tipoiva tipoiva) {
        tipoiva.delete(tipoiva.getId());
    } public List<Tipoiva> selectAll(){
        return Tipoiva.findAll();
    }public void updateTipoiva(Tipoiva tipoiva) throws IllegalArgumentException{
tipoiva.insert(Tipoiva);
}
public void eliminarTipoiva(Tipoiva tipoiva) throws IllegalArgumentException{
tipoiva.update(Tipoiva);
}
}
