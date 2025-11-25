public class MovimientostockService{

private Movimientostock  movimientostock =  new Movimientostock();public void eliminarMovimientostock(Movimientostock movimientostock) {
        movimientostock.delete(movimientostock.getId());
    } public List<Movimientostock> selectAll(){
        return Movimientostock.findAll();
    }public void updateMovimientostock(Movimientostock movimientostock) throws IllegalArgumentException{
movimientostock.insert(Movimientostock);
}
public void eliminarMovimientostock(Movimientostock movimientostock) throws IllegalArgumentException{
movimientostock.update(Movimientostock);
}
}
