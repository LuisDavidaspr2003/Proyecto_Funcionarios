package controller;

import data.FuncionarioDao;
import domain.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {   
    

    private FuncionarioDao funcionarioDao;
    
    public FuncionarioController() {
        funcionarioDao = new FuncionarioDao();
    }    
     public List<Funcionario> obtenerFuncionarios() throws SQLException {
        return funcionarioDao.obtenerFuncionario();
    }
    
     public void crear(Funcionario funcionario) throws SQLException {
        funcionarioDao.crear(funcionario);
    }
    
     public Funcionario obtenerFuncionario(int funcionarioid) throws SQLException {
        return funcionarioDao.obtenerFuncionario(funcionarioid);
    }
     public void actualizarFuncionario(int funcionarioid, Funcionario funcionario) throws SQLException {
        funcionarioDao.actualizarFuncionario(funcionarioid, funcionario);
    }
    
    public void eliminarFuncionario(int funcionarioid) throws SQLException {
        funcionarioDao.eliminarFuncionario(funcionarioid);
    }
    
}
