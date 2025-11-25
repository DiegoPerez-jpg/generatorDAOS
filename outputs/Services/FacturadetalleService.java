public class FacturadetalleService{

private Facturadetalle  facturadetalle =  new Facturadetalle();public void eliminarFacturadetalle(Facturadetalle facturadetalle) {
        facturadetalle.delete(facturadetalle.getId());
    } public List<Facturadetalle> selectAll(){
        return Facturadetalle.findAll();
    }public void updateFacturadetalle(Facturadetalle facturadetalle) throws IllegalArgumentException{
facturadetalle.insert(Facturadetalle);
}
public void eliminarFacturadetalle(Facturadetalle facturadetalle) throws IllegalArgumentException{
facturadetalle.update(Facturadetalle);
}
}
