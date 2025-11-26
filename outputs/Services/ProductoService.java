public class ProductoService{

private ProductoDAO  productoDAO =  new ProductoDAO();
public void eliminarProducto(Producto producto) {
        productoDAO.delete(producto.getId());
    }
 public List<Producto> selectAll(){
        return productoDAO.findAll();
    }
public void crearProducto(Producto producto) throws IllegalArgumentException{
productoDAO.insert(producto);
}
public void updateProducto(Producto producto) throws IllegalArgumentException{
productoDAO.update(producto);
}
}
