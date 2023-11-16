
package universidadgrupo69.vistas;

import java.sql.Date;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import universidadgrupo69.accesoADatos.AlumnoData;
import universidadgrupo69.entidades.Alumno;


public class FormularioAlumnos extends javax.swing.JInternalFrame {
    
        //La instancia alumno sera compartida por los eventos Buscar y Eliminar, en ese orden.
        Alumno alumnoGlobal;
        
    public FormularioAlumnos() {
            initComponents();
            
            //Se debe buscar al alumno primeramente para darlo de baja.
            bloqueoBotonEliminar();
            
            //Para distinguir entre Guarar y Modificar.
            alumnoGlobal = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfDniALumno = new javax.swing.JTextField();
        jtfApellidoAlumno = new javax.swing.JTextField();
        jtfNombreAlumno = new javax.swing.JTextField();
        jdcFechaNac = new com.toedter.calendar.JDateChooser();
        jrbDadoDeAlta = new javax.swing.JRadioButton();
        jbBuscarXDni = new javax.swing.JButton();
        jbLimpiarCampos = new javax.swing.JButton();
        jbEliminarAlumno = new javax.swing.JButton();
        jbGuardarObjAlumno = new javax.swing.JButton();
        jbSaliFormAlumnos = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("ALUMNOS");

        jLabel2.setText("Documento");

        jLabel3.setText("Apellido");

        jLabel4.setText("Nombre");

        jLabel5.setText("Estado");

        jLabel6.setText("Fecha de Nacimiento");

        jrbDadoDeAlta.setText("Esta Activo");

        jbBuscarXDni.setText("Buscar");
        jbBuscarXDni.setToolTipText("Ingrese el Dni sin puntos y luego presione Buscar.");
        jbBuscarXDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarXDniActionPerformed(evt);
            }
        });

        jbLimpiarCampos.setText("Limpiar");
        jbLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarCamposActionPerformed(evt);
            }
        });

        jbEliminarAlumno.setText("Eliminar");
        jbEliminarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarAlumnoActionPerformed(evt);
            }
        });

        jbGuardarObjAlumno.setText("Guardar");
        jbGuardarObjAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarObjAlumnoActionPerformed(evt);
            }
        });

        jbSaliFormAlumnos.setText("Salir");
        jbSaliFormAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSaliFormAlumnosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtfDniALumno, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfApellidoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jrbDadoDeAlta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscarXDni)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdcFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbLimpiarCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEliminarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbGuardarObjAlumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSaliFormAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfDniALumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarXDni))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfApellidoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jrbDadoDeAlta))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jdcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpiarCampos)
                    .addComponent(jbEliminarAlumno)
                    .addComponent(jbGuardarObjAlumno)
                    .addComponent(jbSaliFormAlumnos)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSaliFormAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSaliFormAlumnosMouseClicked
            dispose();
    }//GEN-LAST:event_jbSaliFormAlumnosMouseClicked

    private void jbGuardarObjAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarObjAlumnoActionPerformed
        
        //Inicion instanciacion clase tipo Data para comunicacion con BD.
            AlumnoData alumnoData = new AlumnoData();
        //Fin instanciacion clase tipo Data para comunicacion con BD.
        
        //Seleccion entre operacion modificar un alumno existente, o guardar uno nuevo  
        if(alumnoGlobal == null){
            try{
                Alumno alumAGuardar = AlumnoParaGuardar();
                alumnoData.guardarAlumno(alumAGuardar);
                JOptionPane.showMessageDialog(this, "Alumno Guardado.");
            }catch(NullPointerException npE){
                JOptionPane.showMessageDialog(this, "Algo malio sal =(( ");           
            }
        }else{
            try{
                Alumno alumAModificar = AlumnoParaModificar();
                alumnoData.modificarAlumno(alumAModificar);
                JOptionPane.showMessageDialog(this, "Alumno Modificado.");
            }catch(NullPointerException npE){
                JOptionPane.showMessageDialog(this, "Algo malio sal =(( ");           
            }
        }
       /*Aclaracion >>> Si se aprieta Guardar sin que antes se haya hecho una busqueda, se interpreta
        que se desea guardar un alumno, esto es al principio de haber llamado al formularioAlumno, o
        luego de apretar el boton Limpiar.
        Si primero se hace una busqueda y luego, se modifiquen o no uno o mas o todos los campos de 
        disponibles en la vista, se aprieta el boton Guardar se interpreta que se desea enviar una modi-
        ficacion para realizar a una fila existente en BD.
        */ 
    }//GEN-LAST:event_jbGuardarObjAlumnoActionPerformed

    private void jbLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarCamposActionPerformed
        //Bloque para reseteo a vacio y des-seleccion de atributos.
            jtfDniALumno.setText("");
            jtfApellidoAlumno.setText("");
            jtfNombreAlumno.setText("");
            jrbDadoDeAlta.setOpaque(true);
            jrbDadoDeAlta.setSelected(false);
            jdcFechaNac.setDate(null);
        //
            bloqueoBotonEliminar();
        //
            alumnoGlobal = null;
    }//GEN-LAST:event_jbLimpiarCamposActionPerformed

    private void jbBuscarXDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarXDniActionPerformed
        //Inicio bloque de validacion.  
        try{
            Integer.parseInt(jtfDniALumno.getText());
        }catch(NumberFormatException nfE){
            JOptionPane.showMessageDialog(this, ">>>Campo Dni requiere valor numerico sin puntos<<<");
            return;
        }
        //Fin bloque de validacion.
        
        //Inicio bloque obtencion de parametro para busqueda.
            int dni = Integer.parseInt(jtfDniALumno.getText());
        //Din bloque obtencion de parametro para busqueda.
        
        //Inicio creacio de instancia Data para consulta en BD e Alumno p/almacenar la respuesta.
            AlumnoData alumnoData = new AlumnoData();
            alumnoGlobal = new Alumno();
            alumnoGlobal = (Alumno) alumnoData.buscarAlumnoXdni(dni);
        //Fin creacio de instancia Data para consulta en BD e Alumno p/almacenar la respuesta.
         
        //Inicio presentacion datos en vista FormularioAlumnos.
            jtfDniALumno.setText(alumnoGlobal.getDni()+"");
            jtfApellidoAlumno.setText(alumnoGlobal.getApellido());
            jtfNombreAlumno.setText(alumnoGlobal.getNombre()+"");
            if(alumnoGlobal.isEstado()){
                jrbDadoDeAlta.setOpaque(false);
            }else{
                jrbDadoDeAlta.setOpaque(true);
            }
            jrbDadoDeAlta.setSelected(alumnoGlobal.isEstado());
            jdcFechaNac.setDate(Date.valueOf(alumnoGlobal.getFechaNac()));
        //Fin presentacion datos en vista FormularioAlumnos.
        
        //Se activa la opcion de dar de baja (en BD) al alumno presentado en vista.
            desbloqueoBotonEliminar();
            
    }//GEN-LAST:event_jbBuscarXDniActionPerformed

    private void jbEliminarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarAlumnoActionPerformed
       /*Para eliminar un alumno si o si es necesario buscarlo por el DNI primero;
         pues en la busqueda por DNI se crea un alumno y se setea su valor de idAlumno,
         el cual no se presenta en ninguno de los campos de la vista formularioAlumno.
        */
        
        //Validacion para antes de actualizacion en BD (el alumnos debe estar activo).
        if(alumnoGlobal.isEstado()){
        //Inicio creacion de instancia Data para modificacion en BD.
        AlumnoData alumnoData = new AlumnoData();
        alumnoData.eliminarAlumno(alumnoGlobal.getIdAlumno());
        //Fin creacion de instancia Data para modificacion en BD.
        }else{
            JOptionPane.showMessageDialog(this, "El alumno ya se encuentra dado de baja!");
            bloqueoBotonEliminar();
            return;
        }
        //Se desactiva nuevamente la opcion Eliminar.
        bloqueoBotonEliminar();
        
    }//GEN-LAST:event_jbEliminarAlumnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbBuscarXDni;
    private javax.swing.JButton jbEliminarAlumno;
    private javax.swing.JButton jbGuardarObjAlumno;
    private javax.swing.JButton jbLimpiarCampos;
    private javax.swing.JButton jbSaliFormAlumnos;
    private com.toedter.calendar.JDateChooser jdcFechaNac;
    private javax.swing.JRadioButton jrbDadoDeAlta;
    private javax.swing.JTextField jtfApellidoAlumno;
    private javax.swing.JTextField jtfDniALumno;
    private javax.swing.JTextField jtfNombreAlumno;
    // End of variables declaration//GEN-END:variables

    private void bloqueoBotonEliminar(){
        jbEliminarAlumno.setEnabled(false);
    }
    
    private void desbloqueoBotonEliminar(){
        jbEliminarAlumno.setEnabled(true);
    }  
    
    private Alumno AlumnoParaModificar(){
        //Inicio bloque de validacion.               
        try{
            Integer.parseInt(jtfDniALumno.getText());
        }catch(NumberFormatException nfE){
            JOptionPane.showMessageDialog(this, "Campo Dni requiere valor numerico sin puntos");
            return null;
        }
        
        if(jtfApellidoAlumno.getText().isEmpty()||jtfNombreAlumno.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "No debe haber campos vacios.");
            return null;
        }
        
        try{
            jdcFechaNac.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();          
        }catch(NullPointerException npE){
            JOptionPane.showMessageDialog(this, "Fecha de nacimiento no puede\nquedar vacio.");
            return null;
        }
        //Fin bloque de validacion.
        
        //Bloque de asignacion a Instancia de clase Alumno()           
                   alumnoGlobal.setApellido(jtfApellidoAlumno.getText());
                   alumnoGlobal.setDni(Integer.parseInt(jtfDniALumno.getText()));
                   alumnoGlobal.setNombre(jtfNombreAlumno.getText());
                   alumnoGlobal.setEstado(jrbDadoDeAlta.isSelected());
                   alumnoGlobal.setFechaNac(jdcFechaNac.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        //Fin bloque asignacion a Instancia de clase Alumno()
        
        return alumnoGlobal;
    }
    
    private Alumno AlumnoParaGuardar(){
        //Inicio bloque de validacion.               
        try{
            Integer.parseInt(jtfDniALumno.getText());
        }catch(NumberFormatException nfE){
            JOptionPane.showMessageDialog(this, "Campo Dni requiere valor numerico sin puntos");
            return null;
        }
        
        if(jtfApellidoAlumno.getText().isEmpty()||jtfNombreAlumno.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "No debe haber campos vacios.");
            return null;
        }
        
        try{
            jdcFechaNac.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();          
        }catch(NullPointerException npE){
            JOptionPane.showMessageDialog(this, "Fecha de nacimiento no puede\nquedar vacio.");
            return null;
        }
        //Fin bloque de validacion.
        
        //Bloque de asignacion a Instancia de clase Alumno()
                   alumnoGlobal = new Alumno(); 
                   alumnoGlobal.setApellido(jtfApellidoAlumno.getText());
                   alumnoGlobal.setDni(Integer.parseInt(jtfDniALumno.getText()));
                   alumnoGlobal.setNombre(jtfNombreAlumno.getText());
                   alumnoGlobal.setEstado(jrbDadoDeAlta.isSelected());
                   alumnoGlobal.setFechaNac(jdcFechaNac.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        //Fin bloque asignacion a Instancia de clase Alumno()
        
        return alumnoGlobal;
    }
}