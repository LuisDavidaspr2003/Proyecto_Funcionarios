/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.funcionario;

import controller.FuncionarioController;
import domain.Funcionario;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;   

/**
 *
 * @author Usuario
 */
public class Main extends javax.swing.JFrame { 
    
    
    private final FuncionarioController funcionarioController;
    private final static String[] COLUMNS = {"ID", "TIPOIDENTIFICACON", "NUMEROIDENTIFCACION", "NOMBRES", 
        "APELLIDOS", "ESTADOCIIVL", "SEXO", "DIRECCION", "TELEFONO", "FECHANACIMIENTO"};
    
     private final static  String SELECCIONE = "--SELECCIONE--";
             

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents(); 
        txtFuncionarioID.setEditable(false);
        funcionarioController = new FuncionarioController();
        listFuncionario();
        addListener();
        
    }
    
    private void listFuncionario (){
        
        cbxFuncionarios.removeAllItems();
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNumeroidentificacion(SELECCIONE);
        funcionario1.setNombres("");
        cbxFuncionarios.addItem(funcionario1);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNS) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblFuncionarios.setModel(defaultTableModel);
        tblFuncionarios.setRowHeight(30); // Ajusta la altura de las filas a 30
        tblFuncionarios.setShowGrid(true); // Muestra las líneas de la cuadrícula
        tblFuncionarios.setGridColor(Color.black); // Establece el color de las líneas de la cuadrícula


        
        try {
            List<Funcionario> funcnarios = funcionarioController.obtenerFuncionarios();
          if  (funcnarios.isEmpty()) {
              return;
          
          } 
          
          defaultTableModel.setRowCount((funcnarios.size()));
          int row = 0;
          for (Funcionario funcionario : funcnarios) {
              defaultTableModel.setValueAt(funcionario.getFuncionarioid(), row, 0);
              defaultTableModel.setValueAt(funcionario.getTipoidentificacion(), row, 1);
              defaultTableModel.setValueAt(funcionario.getNumeroidentificacion(), row, 2);
              defaultTableModel.setValueAt(funcionario.getNombres(), row, 3);
              defaultTableModel.setValueAt(funcionario.getApellidos(), row, 4);
              defaultTableModel.setValueAt(funcionario.getEstadocivil(), row, 5);
              defaultTableModel.setValueAt(funcionario.getSexo(), row, 6);
              defaultTableModel.setValueAt(funcionario.getDireccion(), row, 7);
              defaultTableModel.setValueAt(funcionario.getTelefono(), row, 8);
              defaultTableModel.setValueAt(funcionario.getFechaNacimiento(), row, 9);
              row++;
              
              cbxFuncionarios.addItem(funcionario);
              
              
              
          
          }
          
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        
    
    
    
    }
    
    
    private void addListener(){
        cbxFuncionarios.addItemListener(event -> {
            Funcionario seletedFuncionario = (Funcionario) event.getItem();
            if (seletedFuncionario.getNumeroidentificacion().equals(SELECCIONE)) {
                txtFuncionarioID.setText("");
                txtBrandEdit.setText("");
                txtNumeroIdentificacionEdit.setText("");
                txtNombreEdit.setText("");
                txtApellidoEdit.setText("");
                txtEstadoCivlEdit.setText("");
                txtSexoEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");
                
         
            }else{
                txtFuncionarioID.setText(String.valueOf(seletedFuncionario.getFuncionarioid()));
                txtBrandEdit.setText(seletedFuncionario.getTipoidentificacion());
                txtNumeroIdentificacionEdit.setText(seletedFuncionario.getNumeroidentificacion());
                txtNombreEdit.setText(seletedFuncionario.getNombres());
                txtApellidoEdit.setText(seletedFuncionario.getApellidos());
                txtEstadoCivlEdit.setText(seletedFuncionario.getEstadocivil());
                txtSexoEdit.setText(seletedFuncionario.getSexo());
                txtDireccionEdit.setText(seletedFuncionario.getDireccion());
                txtTelefonoEdit.setText(seletedFuncionario.getTelefono());
                txtFechaNacimientoEdit.setText(seletedFuncionario.getFechaNacimiento());
                
               
            }
        
        });
    
    
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTPanels = new javax.swing.JTabbedPane();
        jPFun1 = new javax.swing.JPanel();
        jPFuncionario = new javax.swing.JPanel();
        lblBrand = new javax.swing.JLabel();
        lblNumeroidentificacion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblEstadocivil = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblFechadenacimiento = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        txtNuneroidentificacion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEstadocivil = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtFechadenacimiento = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        jPFun2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxFuncionarios = new javax.swing.JComboBox<>();
        lblFuncionarioId = new javax.swing.JLabel();
        txtFuncionarioID = new javax.swing.JTextField();
        lblBrandEdit = new javax.swing.JLabel();
        lblNumeroidentificacionEdit = new javax.swing.JLabel();
        lblNombreEdit = new javax.swing.JLabel();
        lblApellidoEdit = new javax.swing.JLabel();
        lblEstadocivilEdit = new javax.swing.JLabel();
        lblSexoEdit = new javax.swing.JLabel();
        lblTelefonoEdit = new javax.swing.JLabel();
        lblDireccionEdit = new javax.swing.JLabel();
        lblFechaNacimientoEdit = new javax.swing.JLabel();
        txtEstadoCivlEdit = new javax.swing.JTextField();
        txtSexoEdit = new javax.swing.JTextField();
        txtTelefonoEdit = new javax.swing.JTextField();
        txtDireccionEdit = new javax.swing.JTextField();
        txtFechaNacimientoEdit = new javax.swing.JTextField();
        txtApellidoEdit = new javax.swing.JTextField();
        txtNombreEdit = new javax.swing.JTextField();
        txtNumeroIdentificacionEdit = new javax.swing.JTextField();
        txtBrandEdit = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("APP FUNCIONARIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        jPFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite Los siguientes Datos"));

        lblBrand.setText("TIPO IDENTIFICACION");

        lblNumeroidentificacion.setText("NUMERO IDENTIFICACION");

        lblNombre.setText("NOMBRE");

        lblApellido.setText("APELLIDOS");

        lblEstadocivil.setText("ESTADO CIVIL");

        lblSexo.setText("SEXO");

        lblDireccion.setText("DIRECCION");

        lblTelefono.setText("TELEFONO");

        lblFechadenacimiento.setText("FECHA NACIMIENTO");

        txtBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrandActionPerformed(evt);
            }
        });

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        btnCrear.setText("Guardar");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPFuncionarioLayout = new javax.swing.GroupLayout(jPFuncionario);
        jPFuncionario.setLayout(jPFuncionarioLayout);
        jPFuncionarioLayout.setHorizontalGroup(
            jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPFuncionarioLayout.createSequentialGroup()
                        .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBrand)
                            .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSexo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addComponent(txtBrand, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPFuncionarioLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtNuneroidentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPFuncionarioLayout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPFuncionarioLayout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(lblNumeroidentificacion)))
                                .addGap(13, 13, 13))))
                    .addGroup(jPFuncionarioLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lblSexo)
                        .addGap(156, 156, 156)
                        .addComponent(lblDireccion)
                        .addGap(24, 24, 24)))
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPFuncionarioLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblNombre)
                        .addGap(121, 121, 121)
                        .addComponent(lblApellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEstadocivil)
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPFuncionarioLayout.createSequentialGroup()
                        .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPFuncionarioLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPFuncionarioLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(btnCrear)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPFuncionarioLayout.createSequentialGroup()
                                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(71, 71, 71)
                                        .addComponent(txtEstadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPFuncionarioLayout.createSequentialGroup()
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(txtFechadenacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(lblFechadenacimiento)))
                        .addGap(80, 80, 80))))
        );
        jPFuncionarioLayout.setVerticalGroup(
            jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrand)
                    .addComponent(lblNumeroidentificacion)
                    .addComponent(lblNombre)
                    .addComponent(lblApellido)
                    .addComponent(lblEstadocivil))
                .addGap(27, 27, 27)
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNuneroidentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(lblTelefono)
                    .addComponent(lblFechadenacimiento)
                    .addComponent(lblSexo))
                .addGap(29, 29, 29)
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechadenacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrear))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout jPFun1Layout = new javax.swing.GroupLayout(jPFun1);
        jPFun1.setLayout(jPFun1Layout);
        jPFun1Layout.setHorizontalGroup(
            jPFun1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFun1Layout.createSequentialGroup()
                .addGroup(jPFun1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPFun1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPFun1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPFun1Layout.setVerticalGroup(
            jPFun1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPFun1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTPanels.addTab("Crear Nuevo Funcionario", jPFun1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Edite Los siguientes Datos"));

        jLabel2.setText("FUNCIONARIOS");

        lblFuncionarioId.setText("Funcionario ID");

        lblBrandEdit.setText("Tipo Identificacion");

        lblNumeroidentificacionEdit.setText("    Numero Identificacion");

        lblNombreEdit.setText("Nombre");

        lblApellidoEdit.setText("Apellido");

        lblEstadocivilEdit.setText("    Estado Civil");

        lblSexoEdit.setText("Sexo");

        lblTelefonoEdit.setText("Telefono");

        lblDireccionEdit.setText("  Direccion");

        lblFechaNacimientoEdit.setText("Fecha Nacimiento");

        txtBrandEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrandEditActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtEstadoCivlEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(lblEstadocivilEdit))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lblFuncionarioId))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtFuncionarioID, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(lblBrandEdit))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(txtBrandEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtTelefonoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNumeroIdentificacionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNumeroidentificacionEdit))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(lblSexoEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTelefonoEdit)
                                .addGap(74, 74, 74)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(lblFechaNacimientoEdit))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNombreEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellidoEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaNacimientoEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(lblNombreEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblApellidoEdit)
                        .addGap(30, 30, 30)))
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(btnActualizar)
                .addGap(66, 66, 66)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionarioId)
                    .addComponent(lblBrandEdit)
                    .addComponent(lblNumeroidentificacionEdit)
                    .addComponent(lblNombreEdit)
                    .addComponent(lblApellidoEdit))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFuncionarioID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroIdentificacionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrandEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadocivilEdit)
                    .addComponent(lblSexoEdit)
                    .addComponent(lblTelefonoEdit)
                    .addComponent(lblDireccionEdit)
                    .addComponent(lblFechaNacimientoEdit))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstadoCivlEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimientoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout jPFun2Layout = new javax.swing.GroupLayout(jPFun2);
        jPFun2.setLayout(jPFun2Layout);
        jPFun2Layout.setHorizontalGroup(
            jPFun2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFun2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPFun2Layout.setVerticalGroup(
            jPFun2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFun2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTPanels.addTab("Editar Funcionario", jPFun2);

        getContentPane().add(jTPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1010, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBrandActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        if (txtBrand.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite El Tipo de su Identificacion");
            txtBrand.requestFocus();
            return;
        }

        if (txtNuneroidentificacion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite El Numero De Su Identificacion");
            txtNuneroidentificacion.requestFocus();
            return;
        }

        if (txtNombre.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Su Nombre");
            txtNombre.requestFocus();
            return;
        }

        if (txtApellidos.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Su Apellido");
            txtApellidos.requestFocus();
            return;
        }

        if (txtEstadocivil.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Su Estado Civil Actual");
            txtEstadocivil.requestFocus();
            return;
        }

        if (txtSexo.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Su Sexo");
            txtSexo.requestFocus();
            return;
        }

        if (txtDireccion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Su Direccion");
            txtDireccion.requestFocus();
            return;
        }

        if (txtTelefono.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Su Numero De Telefono");
            txtTelefono.requestFocus();
            return;
        }

        if (txtFechadenacimiento.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Su Fecha De Nacimiento"
                    + "   Ejemplo 2000-07-27");
            txtFechadenacimiento.requestFocus();
            return;
        }
        try {

            Funcionario funcionario = new Funcionario();
            funcionario.setTipoidentificacion(txtBrand.getText().trim());
            funcionario.setNumeroidentificacion(txtNuneroidentificacion.getText().trim());
            funcionario.setNombres(txtNombre.getText().trim());
            funcionario.setApellidos(txtApellidos.getText().trim());
            funcionario.setEstadocivil(txtEstadocivil.getText().trim());
            funcionario.setSexo(txtSexo.getText().trim());
            funcionario.setDireccion(txtDireccion.getText().trim());
            funcionario.setTelefono(txtTelefono.getText().trim());
            funcionario.setFechaNacimiento(txtFechadenacimiento.getText().trim());

            funcionarioController.crear(funcionario);
            txtBrand.setText("");
            txtNuneroidentificacion.setText("");
            txtNombre.setText("");
            txtApellidos.setText("");
            txtEstadocivil.setText("");
            txtSexo.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            txtFechadenacimiento.setText("");
            listFuncionario();
            JOptionPane.showMessageDialog(null, "Funcionario Registrado Con Exito");
            
        } catch (SQLException ex) {
            ex.printStackTrace();

        }


    }//GEN-LAST:event_btnCrearActionPerformed

    private void txtBrandEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrandEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBrandEditActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        if (txtFuncionarioID.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un Funcionario");
            txtFuncionarioID.requestFocus();
            return;
        }

        if (txtBrandEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite El Tipo de su Identificacion");
            txtBrandEdit.requestFocus();
            return;
        }

        if (txtNumeroIdentificacionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite El Numero De Su Identificacion");
            txtNumeroIdentificacionEdit.requestFocus();
            return;
        }

        if (txtNombreEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Su Nombre");
            txtNombreEdit.requestFocus();
            return;
        }

        if (txtApellidoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Su Apellido");
            txtApellidoEdit.requestFocus();
            return;
        }

        if (txtEstadoCivlEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Su Estado Civil Actual");
            txtEstadoCivlEdit.requestFocus();
            return;
        }

        if (txtSexoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Su Sexo");
            txtSexoEdit.requestFocus();
            return;
        }

        if (txtDireccionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Su Direccion");
            txtDireccionEdit.requestFocus();
            return;
        }

        if (txtTelefonoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Su Numero De Telefono");
            txtTelefonoEdit.requestFocus();
            return;
        }

        if (txtFechaNacimientoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite Su Fecha De Nacimiento"
                    + "   Ejemplo 2000-07-27");
            txtFechaNacimientoEdit.requestFocus();
            return;
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setTipoidentificacion(txtBrandEdit.getText().trim());
        funcionario.setNumeroidentificacion(txtNumeroIdentificacionEdit.getText().trim());
        funcionario.setNombres(txtNombreEdit.getText().trim());
        funcionario.setApellidos(txtApellidoEdit.getText().trim());
        funcionario.setEstadocivil(txtEstadoCivlEdit.getText().trim());
        funcionario.setSexo(txtSexoEdit.getText().trim());
        funcionario.setDireccion(txtDireccionEdit.getText().trim());
        funcionario.setTelefono(txtTelefonoEdit.getText().trim());
        funcionario.setFechaNacimiento(txtFechaNacimientoEdit.getText().trim());

        int opt = JOptionPane.showConfirmDialog(null, "Desea Actualizar Este Funcionario",
                "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        try {
            funcionarioController.actualizarFuncionario(Integer.parseInt(txtFuncionarioID.getText()), funcionario);
            txtBrandEdit.setText("");
            txtNumeroIdentificacionEdit.setText("");
            txtNombreEdit.setText("");
            txtApellidoEdit.setText("");
            txtEstadoCivlEdit.setText("");
            txtSexoEdit.setText("");
            txtDireccionEdit.setText("");
            txtTelefonoEdit.setText("");
            txtFechaNacimientoEdit.setText("");
            listFuncionario();
            JOptionPane.showMessageDialog(null, "Actualizacion De Funcionario Exitosa");

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (txtFuncionarioID.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un Funcionario");
            txtFuncionarioID.requestFocus();
            return;
        }
        int opt = JOptionPane.showConfirmDialog(null, "Esta Seguro De Elimiar Este Funcionario",
                "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == 0) {

            try {
                funcionarioController.eliminarFuncionario(Integer.parseInt(txtFuncionarioID.getText()));
                txtBrandEdit.setText("");
                txtNumeroIdentificacionEdit.setText("");
                txtNombreEdit.setText("");
                txtApellidoEdit.setText("");
                txtEstadoCivlEdit.setText("");
                txtSexoEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");
                listFuncionario();
                JOptionPane.showMessageDialog(null, "Eliminacion De Funcionario Exitosa");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<Funcionario> cbxFuncionarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPFun1;
    private javax.swing.JPanel jPFun2;
    private javax.swing.JPanel jPFuncionario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTPanels;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellidoEdit;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblBrandEdit;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccionEdit;
    private javax.swing.JLabel lblEstadocivil;
    private javax.swing.JLabel lblEstadocivilEdit;
    private javax.swing.JLabel lblFechaNacimientoEdit;
    private javax.swing.JLabel lblFechadenacimiento;
    private javax.swing.JLabel lblFuncionarioId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreEdit;
    private javax.swing.JLabel lblNumeroidentificacion;
    private javax.swing.JLabel lblNumeroidentificacionEdit;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexoEdit;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefonoEdit;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtApellidoEdit;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtBrandEdit;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionEdit;
    private javax.swing.JTextField txtEstadoCivlEdit;
    private javax.swing.JTextField txtEstadocivil;
    private javax.swing.JTextField txtFechaNacimientoEdit;
    private javax.swing.JTextField txtFechadenacimiento;
    private javax.swing.JTextField txtFuncionarioID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEdit;
    private javax.swing.JTextField txtNumeroIdentificacionEdit;
    private javax.swing.JTextField txtNuneroidentificacion;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtSexoEdit;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoEdit;
    // End of variables declaration//GEN-END:variables

   
}
