public class FacturadetalleService{

private FacturadetalleDAO  facturadetalleDAO =  new FacturadetalleDAO();
public void eliminarFacturadetalle(Facturadetalle facturadetalle) {
        facturadetalleDAO.delete(facturadetalle.getId());
    }
 public List<Facturadetalle> selectAll(){
        return facturadetalleDAO.findAll();
    }
public void crearFacturadetalle(Facturadetalle facturadetalle) throws IllegalArgumentException{
facturadetalleDAO.insert(facturadetalle);
}
public void updateFacturadetalle(Facturadetalle facturadetalle) throws IllegalArgumentException{
facturadetalleDAO.update(facturadetalle);
}
}
