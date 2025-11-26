public class FabricanteService{

private FabricanteDAO  fabricanteDAO =  new FabricanteDAO();
public void eliminarFabricante(Fabricante fabricante) {
        fabricanteDAO.delete(fabricante.getId());
    }
 public List<Fabricante> selectAll(){
        return fabricanteDAO.findAll();
    }
public void crearFabricante(Fabricante fabricante) throws IllegalArgumentException{
fabricanteDAO.insert(fabricante);
}
public void updateFabricante(Fabricante fabricante) throws IllegalArgumentException{
fabricanteDAO.update(fabricante);
}
}
