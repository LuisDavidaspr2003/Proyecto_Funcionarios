package data;

import com.mycompany.funcionario.util.ConnectionUtil;
import domain.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

   private static final String GET_FUNCIONARIOS = "SELECT * FROM funcionarios";

private static final String CREATE_FUNCIONARIO = "INSERT INTO funcionarios"
    + " (TipoIdentificacion, NumeroIdentificacion, Nombres, Apellidos, EstadoCivil, Sexo, Direccion, Telefono, FechaNacimiento)\n"
    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

private static final String GET_FUNCIONARIO_BY_ID = "SELECT * FROM funcionarios WHERE funcionarioid = ?";

private static final String UPDATE_FUNCIONARIO_ = "UPDATE funcionarios SET TipoIdentificacion = ?, NumeroIdentificacion = ?, Nombres = ?, Apellidos = ?,"
    + "EstadoCivil = ?, Sexo = ?, Direccion = ?, Telefono = ?, FechaNacimiento = ?"
    + " WHERE funcionarioid = ?";

private static final String DELETE_FUNCIONARIO = "DELETE FROM funcionarios WHERE funcionarioid = ?";


    public List<Funcionario> obtenerFuncionario() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Funcionario funcionario = new Funcionario();
                funcionario.setFuncionarioid(resultSet.getInt("funcionarioid"));
                funcionario.setTipoidentificacion(resultSet.getString("tipoidentificacion"));
                funcionario.setNumeroidentificacion(resultSet.getString("numeroidentificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstadocivil(resultSet.getString("estadocivil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                funcionarios.add(funcionario);

            }
            return funcionarios;

        } finally {

            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();

            }
            if (resultSet != null) {
                resultSet.close();

            }
        }
    }

    public void crear(Funcionario funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getTipoidentificacion());
            preparedStatement.setString(2, funcionario.getNumeroidentificacion());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setString(5, funcionario.getEstadocivil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFechaNacimiento());

            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Funcionario obtenerFuncionario(int funcionarioid) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, funcionarioid);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                funcionario = new Funcionario();
                funcionario.setFuncionarioid(resultSet.getInt("funcionarioid"));
                funcionario.setTipoidentificacion(resultSet.getString("tipoidentificacion"));
                funcionario.setNumeroidentificacion(resultSet.getString("numeroidentificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstadocivil(resultSet.getString("estadocivil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
            }
            return funcionario;

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void actualizarFuncionario(int funcionarioid, Funcionario funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIO_);
            preparedStatement.setString(1, funcionario.getTipoidentificacion());
            preparedStatement.setString(2, funcionario.getNumeroidentificacion());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setString(5, funcionario.getEstadocivil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFechaNacimiento());
            preparedStatement.setInt(10, funcionarioid);

            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void eliminarFuncionario(int funcionarioid) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, funcionarioid);
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

}
