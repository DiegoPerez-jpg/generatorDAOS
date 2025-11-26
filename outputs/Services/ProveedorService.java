public class ProveedorService{

private ProveedorDAO  proveedorDAO =  new ProveedorDAO();
public void eliminarProveedor(Proveedor proveedor) {
        proveedorDAO.delete(proveedor.getId());
    }
 public List<Proveedor> selectAll(){
        return proveedorDAO.findAll();
    }
public void crearProveedor(Proveedor proveedor) throws IllegalArgumentException{
proveedorDAO.insert(proveedor);
}
public void updateProveedor(Proveedor proveedor) throws IllegalArgumentException{
proveedorDAO.update(proveedor);
}
}
