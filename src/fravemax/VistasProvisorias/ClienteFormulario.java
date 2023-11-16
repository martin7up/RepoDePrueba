
package fravemax.VistasProvisorias;

import fravemax.AccesoADatos.ClienteData;
import fravemax.Entidades.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ClienteFormulario extends javax.swing.JInternalFrame {
    //Definicion del modelo empleado por jtClientesRegistrados.
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int fila, int columna){
            
            return false;
        }
    };
    
    //Declaracion del Objeto contenerdor de datos de cliente y su referencia.
    Cliente cl;
    
    //Instanciar clase de servicio.
    ClienteData clData = new ClienteData();

    public ClienteFormulario() {
        
        initComponents();
        limpiarCamposYBotones(); 
        
        //Metodos para cargar la tabla de Clientes desde BD.
        armarCabeceraTabla();
        refrescarTabla();
        mostrarClientesRegistrados();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbSalir = new javax.swing.JButton();
        jbGuardarNuevoCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfDniCliente = new javax.swing.JTextField();
        jtfApellidoCliente = new javax.swing.JTextField();
        jtfNombreCliente = new javax.swing.JTextField();
        jtfTelefonoCliente = new javax.swing.JTextField();
        jtfDireccionCliente = new javax.swing.JTextField();
        jbEliminarCliente = new javax.swing.JButton();
        jbModificarCliente = new javax.swing.JButton();
        jbBuscarCliente = new javax.swing.JButton();
        jbLimpiarCampos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientesRegistrados = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jbDeFilaACampos = new javax.swing.JButton();
        jtfIdCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbGuardarNuevoCliente.setText("Guardar");
        jbGuardarNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarNuevoClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("DNI  :");

        jLabel2.setText("Apellido  : ");

        jLabel3.setText("Nombre  :");

        jLabel4.setText("Telefono  : ");

        jLabel5.setText("Direccion  : ");

        jbEliminarCliente.setText("Eliminar");

        jbModificarCliente.setText("Modificar");
        jbModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarClienteActionPerformed(evt);
            }
        });

        jbBuscarCliente.setText("Buscar");
        jbBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarClienteActionPerformed(evt);
            }
        });

        jbLimpiarCampos.setText("Limp y Act");
        jbLimpiarCampos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarCamposActionPerformed(evt);
            }
        });

        jtClientesRegistrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtClientesRegistrados);

        jLabel6.setText("E-Mail  : ");

        jbDeFilaACampos.setText("Hacia Campos");
        jbDeFilaACampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeFilaACamposActionPerformed(evt);
            }
        });

        jtfIdCliente.setEditable(false);

        jLabel7.setText("Id  :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jbBuscarCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbModificarCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(jbEliminarCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbGuardarNuevoCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(26, 26, 26))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfDniCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(jtfApellidoCliente)
                                    .addComponent(jtfNombreCliente)
                                    .addComponent(jtfTelefonoCliente)
                                    .addComponent(jtfDireccionCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField1)
                                    .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbLimpiarCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbDeFilaACampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 323, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jbLimpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscarCliente)
                    .addComponent(jbModificarCliente)
                    .addComponent(jbEliminarCliente)
                    .addComponent(jbGuardarNuevoCliente)
                    .addComponent(jbDeFilaACampos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
       
        //Se deja el objeto en condicion de ser eliminado al fin del prog.
        cl = null;
        clData = null;   
        dispose();
        
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarCamposActionPerformed
        
        limpiarCamposYBotones();
        
    }//GEN-LAST:event_jbLimpiarCamposActionPerformed

    private void jbBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarClienteActionPerformed
        
        //Verificacion de campos.
        
        if(comprobarCamposAlBuscar()){
            //Si la condicion de arriba resulta true, es porque VERDADERAMENTE algo salio mal.
            return;
            
        }else{
        
            //Instanciar Cliente desde BD.
       
                cl = clData.buscarCliente(Long.parseLong(jtfDniCliente.getText()));
          
            //Mostrar Campos.
            
            try{
                
                jtfApellidoCliente.setText(cl.getApellido());
                jtfNombreCliente.setText(cl.getNombre());
                jtfDireccionCliente.setText(cl.getDomicilio());
                jtfTelefonoCliente.setText(cl.getTelefono());
                jtfIdCliente.setText(cl.getIdCliente()+"");
                
            }catch(NullPointerException npE){
                
                JOptionPane.showMessageDialog(this, "... para el dni : "+jtfDniCliente.getText()+", no existe cliente registrado.");
                return;
                
            }
            
            //Se habilitan otras dos operaciones.
            
            jbModificarCliente.setEnabled(true);//Solo se permite modificar luego de buscar.
            jbEliminarCliente.setEnabled(true);//Solo se permite eliminar luego de buscar.
            JOptionPane.showMessageDialog(this, "Para modificar datos del cliente, altere los campos necesarios,\n"+
                                            "y por ultimo presione el boton <modificar>.");
            
        }
        
        //Se refrezca la tabla de Clientes y se marca el buscado.
        refrescarTabla();
        mostrarClientesRegistrados();
        marcarEnTabla();
        
        //Se libera el objeto Cliente.
        cl = null;
    }//GEN-LAST:event_jbBuscarClienteActionPerformed

    private void jbGuardarNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarNuevoClienteActionPerformed
        
        //Verificacion de campos.
        if(comprobarCamposAlGuardOModif()){
            //Si la condicion de arriba resulta true, es porque VERDADERAMENTE algo salio mal.
            return;
            
        }else{
            
            //Instanciar Cliente Nuevo.
            cl = instanciarDesdeCampos();

            //Envio de datos a BD.
            clData.agregarCliente(cl);
            
        }
        
        //Se refrezca la tabla de Clientes y se marca el agregado.
        refrescarTabla();
        mostrarClientesRegistrados();
        marcarEnTabla();
        
        //Se libera el objeto Cliente.
        cl = null;
    }//GEN-LAST:event_jbGuardarNuevoClienteActionPerformed

    private void jbModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarClienteActionPerformed
        
        //Verificacion de campos.
        
        if(comprobarCamposAlGuardOModif()){
            //Si la condicion de arriba resulta true, es porque VERDADERAMENTE algo salio mal.
            
            return;
            
        }else{
        
            //Instanciar Cliente Modificado.
            cl = instanciarDesdeCampos();
            cl.setIdCliente(Long.parseLong(jtfIdCliente.getText()));//Id se requiere para enviar actualizacion a BD.

            //Envio de modificaciones a BD.
            clData.modificarCliente(cl);
            
        }
     
        //Se inhabilitan otras dos operaciones.
        jbModificarCliente.setEnabled(false);//Solo se permite modificar luego de buscar.
        jbEliminarCliente.setEnabled(false);//Solo se permite eliminar luego de buscar.
        
        //Se refrezca la tabla de Clientes y se marca el modificado.
        refrescarTabla();
        mostrarClientesRegistrados();
        marcarEnTabla();
        
        //Se libera el objeto Cliente.
        cl = null;
    }//GEN-LAST:event_jbModificarClienteActionPerformed
    
    //Este evento es una forma alternativa de buscar datos de un cliente; ya desde una tabla precargada.
    private void jbDeFilaACamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeFilaACamposActionPerformed
        
        if(jtClientesRegistrados.getSelectedRowCount()!=1){
            JOptionPane.showMessageDialog(this, "...debe seleccionar una, y solo un fila de la tabla.");
            return;
        }
        
        try{
        
            //Se intenta pasar los datos de la fila en tabla a los campos.    
            jtfIdCliente.setText(jtClientesRegistrados.getValueAt(jtClientesRegistrados.getSelectedRow(), 0)+"");
            jtfDniCliente.setText(jtClientesRegistrados.getValueAt(jtClientesRegistrados.getSelectedRow(), 1)+"");
            jtfApellidoCliente.setText(jtClientesRegistrados.getValueAt(jtClientesRegistrados.getSelectedRow(), 2)+"");
            jtfNombreCliente.setText(jtClientesRegistrados.getValueAt(jtClientesRegistrados.getSelectedRow(), 3)+"");
            jtfDireccionCliente.setText(jtClientesRegistrados.getValueAt(jtClientesRegistrados.getSelectedRow(), 4)+"");
            jtfTelefonoCliente.setText(jtClientesRegistrados.getValueAt(jtClientesRegistrados.getSelectedRow(), 5)+"");

            JOptionPane.showMessageDialog(this, "Para modificar datos del cliente, altere los campos necesarios,\n"+
                                                "y por ultimo presione el boton <modificar>.");

            //Se habilitan las opciones de modificar y eliminar sobre el cliente.
            jbModificarCliente.setEnabled(true);
            jbEliminarCliente.setEnabled(true);
        
        }catch(NullPointerException npE){
            
            JOptionPane.showMessageDialog(this, "...debe seleccionar una, y solo un fila de la tabla.");
            return;
            
        }
        
    }//GEN-LAST:event_jbDeFilaACamposActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbBuscarCliente;
    private javax.swing.JButton jbDeFilaACampos;
    private javax.swing.JButton jbEliminarCliente;
    private javax.swing.JButton jbGuardarNuevoCliente;
    private javax.swing.JButton jbLimpiarCampos;
    private javax.swing.JButton jbModificarCliente;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTable jtClientesRegistrados;
    private javax.swing.JTextField jtfApellidoCliente;
    private javax.swing.JTextField jtfDireccionCliente;
    private javax.swing.JTextField jtfDniCliente;
    private javax.swing.JTextField jtfIdCliente;
    private javax.swing.JTextField jtfNombreCliente;
    private javax.swing.JTextField jtfTelefonoCliente;
    // End of variables declaration//GEN-END:variables
    
    private void limpiarCamposYBotones(){
        
        //Limpieza de botones.
        jbBuscarCliente.setEnabled(true);
        jbEliminarCliente.setEnabled(false);
        jbGuardarNuevoCliente.setEnabled(true);
        jbModificarCliente.setEnabled(false);
        
        //Limpieza de campos.
        jtfApellidoCliente.setText("");
        jtfNombreCliente.setText("");
        jtfDireccionCliente.setText("");
        jtfDniCliente.setText("");
        jtfTelefonoCliente.setText("");
        jtfIdCliente.setText("");
        
        //Limpieza de tabla.
        refrescarTabla();
        mostrarClientesRegistrados();
        jtClientesRegistrados.clearSelection();
        
    }
    
    private boolean verificarCamposVacios(){
        
        return (jtfApellidoCliente.getText().equals("") || jtfNombreCliente.getText().equals("") ||
                    jtfDniCliente.getText().equals("") || jtfDireccionCliente.getText().equals("") ||
                        jtfTelefonoCliente.getText().equals(""));  
        
    }
    
    //Esta funcion busca si hay un numero en un String que se supone no debe tener numeros.
    private boolean verificarSiHayNumeros(String cadena){//Esta funcion busca si hay un numero en un String que se supone no debe tener numeros.
        
        for(int i=0; i<cadena.length(); i++){
            
            try{
                Integer.parseInt(cadena.charAt(i)+"");
                return true;
            }catch(NumberFormatException nfE){//Si no se puede parsear entonces el caracter es el adecuado.
                }//Continua el ciclo.
            
        }
        return false; 
        //Reemplazar por >>> Char.caracter.isAlpha(); || Char.caracter.isDigit();
    }
    
    private boolean verificarSiHayLetras(String cadena){
        
        try{
            long num = Long.parseLong(cadena);
        }catch(NumberFormatException nfE){
            return true;
        }
        return false;
        
    }
    
    private boolean excedeLongitudMax(String cadena, int dimMax){
        
        return cadena.length()>dimMax;
        
    }
    
    //Si no hay inconsistencias en los campos la func retorna false.
    private boolean comprobarCamposAlGuardOModif(){
        
        if(excedeLongitudMax((jtfDniCliente.getText()+""), 11)||excedeLongitudMax(jtfApellidoCliente.getText(), 60)||
                excedeLongitudMax(jtfNombreCliente.getText(), 60)||excedeLongitudMax(jtfDireccionCliente.getText(), 100)||
                    excedeLongitudMax(jtfTelefonoCliente.getText(), 20)){
            
            JOptionPane.showMessageDialog(this, "...mmm, alguno de los campos excede la longitud permitida.");
            return true;//en jtfDniCliente hay un comportamiento inesperado en Java si se superan los 10 digitos.
        }// conviene usar Long.parseLong() en lugar de Integer.parseInt()
        
        if(verificarCamposVacios()){
            JOptionPane.showMessageDialog(this, "...mmm, ha dejado algun campo vacio.");
            return true;
        }
        
        if(verificarSiHayNumeros(jtfApellidoCliente.getText())||verificarSiHayNumeros(jtfNombreCliente.getText())){
            JOptionPane.showMessageDialog(this, "...mmm, parece que hay numeros en los campos Apellido y/o Nombre.");
            return true;
        }
        
        if(verificarSiHayLetras(jtfDniCliente.getText())||verificarSiHayLetras(jtfTelefonoCliente.getText())){
            JOptionPane.showMessageDialog(this, "...mmm, parece que hay letras y/o simbolos, en el campo DNI y/o Telefono.");
            return true;
        }
        
        return false;
        
    }
    
    private boolean comprobarCamposAlBuscar(){//Si no hay inconsistencias en los campos la func retorna false.
        
        
        
        /*El siguiente bloque unicamente informa que no debe rellenarse ningun otro campo que el Dni
            al momento de realizar una busqueda de un cliente.
        */
        if(!jtfApellidoCliente.getText().isEmpty()||!jtfDireccionCliente.getText().isEmpty()||
                !jtfNombreCliente.getText().isEmpty()||!jtfTelefonoCliente.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "...mmm, las busquedas solo se hace por Dni.");
            jtfApellidoCliente.setText("");
            jtfNombreCliente.setText("");
            jtfDireccionCliente.setText("");
            jtfTelefonoCliente.setText("");
        }
        
        if(excedeLongitudMax((jtfDniCliente.getText()+""), 11)){
            JOptionPane.showMessageDialog(this, "...mmm, dni excede la longitud permitida.");
            return true;
        }
        
        if(jtfDniCliente.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "...mmm, ha dejado el campo dni vacio.");
            return true;
        }
        
        if(verificarSiHayLetras(jtfDniCliente.getText())){
           JOptionPane.showMessageDialog(this, "...mmm, el campo dni no lleva letras ni puntos"+
                   "y tampoco espacios, solo numeros.");
            return true;
        }
        
        return false;
        
    }
    
    private Cliente instanciarDesdeCampos(){
        
        Cliente cli = new Cliente();

        cli.setDni(Long.parseLong(jtfDniCliente.getText()));
        cli.setApellido(jtfApellidoCliente.getText().toLowerCase());
        cli.setNombre(jtfNombreCliente.getText().toLowerCase());
        cli.setDomicilio(jtfDireccionCliente.getText().toLowerCase());
        cli.setTelefono(jtfTelefonoCliente.getText().toLowerCase());     
        
        return cli;
        
    }
    
    private void mostrarClientesRegistrados(){
        
        ArrayList<Cliente> clientes = (ArrayList) clData.listarClientes();
        try{
        for(Cliente cl : clientes){
            modelo.addRow(new Object[]{cl.getIdCliente(), cl.getDni(), cl.getApellido(),
                                        cl.getNombre(),cl.getDomicilio(),cl.getTelefono()});
        }
        }catch(NullPointerException npE){
            JOptionPane.showMessageDialog(this, "...parece que no tienes clientes registrados!");
            npE.printStackTrace();
        }
        return;
    }
    
    private void armarCabeceraTabla(){
        
        modelo.addColumn("Id_Cli");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Domicilio");
        modelo.addColumn("Telefono");
        
        jtClientesRegistrados.setModel(modelo);
        
    }
    
    private void refrescarTabla(){
        
        DefaultTableModel modelo = (DefaultTableModel) jtClientesRegistrados.getModel();

        int f = jtClientesRegistrados.getRowCount() - 1;
        
        if(f==0)return;//En caso de que no haya clientes registrados.
        
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
        
    }
    
    private void marcarEnTabla(){
        //Toma el valor en el campo dni y marca a quien le corresponda en tabla clientes.
        if(jtfDniCliente.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "...no se pudo marcar en tabla al cliente.");
            return;
        }
            for(int i = 0; i<jtClientesRegistrados.getRowCount(); i++){
                long j = (long) jtClientesRegistrados.getValueAt(i, 1);
                if( j == (Long.parseLong(jtfDniCliente.getText()))){
                    jtClientesRegistrados.getSelectionModel().setSelectionInterval(i, i);
                    break;
                }
            }            
    }   
}