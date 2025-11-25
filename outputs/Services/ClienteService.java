public class ClienteService{

private Cliente  cliente =  new Cliente();public void eliminarCliente(Cliente cliente) {
        cliente.delete(cliente.getId());
    } public List<Cliente> selectAll(){
        return Cliente.findAll();
    }public void updateCliente(Cliente cliente) throws IllegalArgumentException{
cliente.insert(Cliente);
}
public void eliminarCliente(Cliente cliente) throws IllegalArgumentException{
cliente.update(Cliente);
}
}
