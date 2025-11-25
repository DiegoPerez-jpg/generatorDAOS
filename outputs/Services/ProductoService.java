public class ProductoService{

private Producto  producto =  new Producto();public void eliminarProducto(Producto producto) {
        producto.delete(producto.getId());
    } public List<Producto> selectAll(){
        return Producto.findAll();
    }public void updateProducto(Producto producto) throws IllegalArgumentException{
producto.insert(Producto);
}
public void eliminarProducto(Producto producto) throws IllegalArgumentException{
producto.update(Producto);
}
}
