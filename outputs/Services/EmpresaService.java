public class EmpresaService{

private EmpresaDAO  empresaDAO =  new EmpresaDAO();
public void eliminarEmpresa(Empresa empresa) {
        empresaDAO.delete(empresa.getId());
    }
 public List<Empresa> selectAll(){
        return empresaDAO.findAll();
    }
public void crearEmpresa(Empresa empresa) throws IllegalArgumentException{
empresaDAO.insert(empresa);
}
public void updateEmpresa(Empresa empresa) throws IllegalArgumentException{
empresaDAO.update(empresa);
}
}
