public class ProveedorService{

private Proveedor  proveedor =  new Proveedor();public void eliminarProveedor(Proveedor proveedor) {
        proveedor.delete(proveedor.getId());
    } public List<Proveedor> selectAll(){
        return Proveedor.findAll();
    }public void updateProveedor(Proveedor proveedor) throws IllegalArgumentException{
proveedor.insert(Proveedor);
}
public void eliminarProveedor(Proveedor proveedor) throws IllegalArgumentException{
proveedor.update(Proveedor);
}
}
