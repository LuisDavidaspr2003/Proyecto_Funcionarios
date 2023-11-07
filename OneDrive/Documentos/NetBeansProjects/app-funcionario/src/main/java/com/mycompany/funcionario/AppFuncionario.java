package com.mycompany.funcionario;

import controller.FuncionarioController;
import domain.Funcionario;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;    

public class AppFuncionario { 

    public static void crear(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite Tipo Identificacion");
            String tipoidentificacion = sc.nextLine();
            System.out.println("La tipo identificacion es = " + tipoidentificacion);
            System.out.println("_________________________________ ");

            System.out.println("Digite EL numero identificacion");
            String numeroidentificacion = sc.nextLine();
            System.out.println("EL numero identificacion es = " + numeroidentificacion);
            System.out.println("_________________________________ ");

            System.out.println("Digite El nombres");
            String nombres = sc.nextLine();
            System.out.println("El nombres es = " + nombres);
            System.out.println("_________________________________ ");

            System.out.println("Digiteapellidos");
            String apellidos = sc.nextLine();
            System.out.println("El apellidos es = " + apellidos);
            System.out.println("_________________________________ ");

            System.out.println("Digite estado civil");
            String estadocivil = sc.nextLine();
            System.out.println("estado civil es = " + estadocivil);
            System.out.println("_________________________________ ");

            System.out.println("Digite genero");
            String sexo = sc.nextLine();
            System.out.println("EL genero es = " + sexo);
            System.out.println("_________________________________ ");

            System.out.println("Digite La direccion");
            String direccion = sc.nextLine();
            System.out.println("La direccion es = " + direccion);
            System.out.println("_________________________________ ");

            System.out.println("Digite El telefono");
            String telefono = sc.nextLine();
            System.out.println("El telefono es = " + telefono);
            System.out.println("_________________________________ ");

            System.out.println("Digite fechaNacimiento");
            String fechaNacimiento = sc.nextLine();
            System.out.println("La fechaNacimiento es = " + fechaNacimiento);
            System.out.println("_________________________________ ");

            Funcionario funcionario = new Funcionario();
            funcionario.setTipoidentificacion(tipoidentificacion);
            funcionario.setNumeroidentificacion(numeroidentificacion);
            funcionario.setNombres(nombres);
            funcionario.setApellidos(apellidos);
            funcionario.setEstadocivil(estadocivil);
            funcionario.setSexo(sexo);
            funcionario.setDireccion(direccion);
            funcionario.setTelefono(telefono);
            funcionario.setFechaNacimiento(fechaNacimiento);
            funcionarioController.crear(funcionario);

            System.out.println("funcionario agregado con éxito ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    
     public static void obtenerFuncionario(FuncionarioController funcionarioController) {
        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                System.out.println("No hay funcionarios Registrados ");
            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("funcionarioid: " + funcionario.getFuncionarioid());
                    System.out.println("tipoidentificacion: " + funcionario.getTipoidentificacion());
                    System.out.println("numeroidentificacion: " + funcionario.getNumeroidentificacion());
                    System.out.println("nombres: " + funcionario.getNombres());
                    System.out.println("apellidos: " + funcionario.getApellidos());
                    System.out.println("estadocivil: " + funcionario.getEstadocivil());
                    System.out.println("sexo: " + funcionario.getSexo());
                    System.out.println("direccion: " + funcionario.getDireccion());
                    System.out.println("telefono: " + funcionario.getTelefono());
                    System.out.println("fechaNacimiento: " + funcionario.getFechaNacimiento());
                    
                    
                    
                    
                    
                    
                    
                    
                    System.out.println("___________________________________________ ");
                    System.out.println("___________________________________________ ");
                    System.out.println("___________________________________________ ");
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    
    
    public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();
        crear(funcionarioController);
        obtenerFuncionario(funcionarioController);
    }
}
    
    


