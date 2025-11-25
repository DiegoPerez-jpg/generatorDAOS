public class FabricanteService{

private Fabricante  fabricante =  new Fabricante();public void eliminarFabricante(Fabricante fabricante) {
        fabricante.delete(fabricante.getId());
    } public List<Fabricante> selectAll(){
        return Fabricante.findAll();
    }public void updateFabricante(Fabricante fabricante) throws IllegalArgumentException{
fabricante.insert(Fabricante);
}
public void eliminarFabricante(Fabricante fabricante) throws IllegalArgumentException{
fabricante.update(Fabricante);
}
}
