
package universidadgrupo69.vistas;

import javax.swing.JOptionPane;
import universidadgrupo69.accesoADatos.MateriaData;
import universidadgrupo69.entidades.Materia;


public class FormularioMaterias extends javax.swing.JInternalFrame {


    public FormularioMaterias() {
            initComponents();

            //Bloqueo al inicio de vista.
            bloqueoBotonEliminar();
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbLimpiarCampos = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jrbEstaActivo = new javax.swing.JRadioButton();
        jtfAnioDeCursado = new javax.swing.JTextField();
        jtfNombreMateria = new javax.swing.JTextField();
        jtfCodigoMateria = new javax.swing.JTextField();
        jbBuscarMateriaXCodigo = new javax.swing.JButton();

        jLabel1.setText("Formulario Materias");

        jLabel2.setText("Codigo");

        jLabel3.setText("Nombre");

        jLabel4.setText("Anio");

        jLabel5.setText("Estado");

        jbLimpiarCampos.setText("Limpiar");
        jbLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarCamposActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSalirMouseClicked(evt);
            }
        });

        jrbEstaActivo.setText("Activo");

        jbBuscarMateriaXCodigo.setText("Buscar");
        jbBuscarMateriaXCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarMateriaXCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jbLimpiarCampos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(72, 72, 72)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(58, 58, 58)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbEstaActivo)
                            .addComponent(jtfAnioDeCursado, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfNombreMateria)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jtfCodigoMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(28, 28, 28)
                                    .addComponent(jbBuscarMateriaXCodigo))))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfCodigoMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarMateriaXCodigo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfNombreMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfAnioDeCursado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jrbEstaActivo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpiarCampos)
                    .addComponent(jbEliminar)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalirMouseClicked
            dispose();
    }//GEN-LAST:event_jbSalirMouseClicked

    private void jbBuscarMateriaXCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarMateriaXCodigoActionPerformed
        
        //Validacion del campo argumento en vista.
        try{
            Integer.parseInt(jtfCodigoMateria.getText());
        }catch(NumberFormatException nfE){
            JOptionPane.showMessageDialog(this, "Debe ingresar un numero\nconsecutivo de nomas de\n"+
                    "11 digitos sin espacios\nni caracteres especiales.");
            return;
        }
        //Fin validacion
        
        //Creacion de instancia para consulta en BD, e instancia p/almacenar respuesta desde BD. 
            MateriaData matData = new MateriaData();
            Materia materia = new Materia();
            materia = matData.buscarMateriaXid((int)Integer.parseInt(jtfCodigoMateria.getText()));
        //Fin de instanciacion.
        
        //Presentacion de datos en vista.
            jtfAnioDeCursado.setText(materia.getAnioMateria()+"");
            jtfNombreMateria.setText(materia.getNombre());
            jrbEstaActivo.setSelected(materia.isActivo());
        //Fin presentacion.
        
        //Habilitacion de la opcion Eliminar.
            desbloqueoBotonEliminar();
    }//GEN-LAST:event_jbBuscarMateriaXCodigoActionPerformed

    private void jbLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarCamposActionPerformed
            limpiarCampos();
            bloqueoBotonEliminar();
    }//GEN-LAST:event_jbLimpiarCamposActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
            bloqueoBotonEliminar();
            
        if(jtfCodigoMateria.getText().isEmpty()){//Si se va a guardar una materia, el id se lo da la BdD.
        
            if(jtfNombreMateria.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "A excepcion del Codigo, no deben de haber campos vacios.");
            }
           
            try{
                Integer.parseInt(jtfAnioDeCursado.getText());
                jtfNombreMateria.getText();
            }catch(NumberFormatException nfE){
                JOptionPane.showMessageDialog(this, "Debe especificar un numero entero y mayor a cero.");
                return;
            }
        
            
        
                Materia mat = new Materia();
                        mat.setNombre(jtfNombreMateria.getText());
                        mat.setAnioMateria(Integer.parseInt(jtfAnioDeCursado.getText()));
                        mat.setActivo(true);//Se asigna true pues se supone que siempre que se agrege
                                            // una materia esta sera agregada como activa.
                MateriaData matDat = new MateriaData();
                matDat.guardarMateria(mat);
        }else{//Si se va a modificar una materia existente, se tiene que especificar cual, a traves del IdMateria.
            Materia mat = new Materia();
            
            mat.setNombre(jtfNombreMateria.getText());
            mat.setAnioMateria(Integer.parseInt(jtfAnioDeCursado.getText()));
            mat.setActivo(jrbEstaActivo.isSelected());
            mat.setIdMateria(Integer.parseInt(jtfCodigoMateria.getText()));
            
            MateriaData matDat = new MateriaData();
            matDat.modificarMateria(mat);
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        MateriaData matDat = new MateriaData();
        matDat.eliminarMateria(Integer.parseInt(jtfCodigoMateria.getText()));
    }//GEN-LAST:event_jbEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbBuscarMateriaXCodigo;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiarCampos;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrbEstaActivo;
    private javax.swing.JTextField jtfAnioDeCursado;
    private javax.swing.JTextField jtfCodigoMateria;
    private javax.swing.JTextField jtfNombreMateria;
    // End of variables declaration//GEN-END:variables

     private void bloqueoBotonEliminar(){
        jbEliminar.setEnabled(false);
    }
    
    private void desbloqueoBotonEliminar(){
        jbEliminar.setEnabled(true);
    }
    
    private void limpiarCampos(){
        jtfCodigoMateria.setText("");
        jtfNombreMateria.setText("");
        jtfAnioDeCursado.setText("");
        jrbEstaActivo.setOpaque(true);
        jrbEstaActivo.setSelected(false);
    }
    
}
// ARGUMENTO != PARAMETRO != ATRIBUTO