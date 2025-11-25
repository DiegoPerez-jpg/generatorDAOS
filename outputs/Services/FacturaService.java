public class FacturaService{

private Factura  factura =  new Factura();public void eliminarFactura(Factura factura) {
        factura.delete(factura.getId());
    } public List<Factura> selectAll(){
        return Factura.findAll();
    }public void updateFactura(Factura factura) throws IllegalArgumentException{
factura.insert(Factura);
}
public void eliminarFactura(Factura factura) throws IllegalArgumentException{
factura.update(Factura);
}
}
