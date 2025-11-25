public class DireccionService{

private Direccion  direccion =  new Direccion();public void eliminarDireccion(Direccion direccion) {
        direccion.delete(direccion.getId());
    } public List<Direccion> selectAll(){
        return Direccion.findAll();
    }public void updateDireccion(Direccion direccion) throws IllegalArgumentException{
direccion.insert(Direccion);
}
public void eliminarDireccion(Direccion direccion) throws IllegalArgumentException{
direccion.update(Direccion);
}
}
