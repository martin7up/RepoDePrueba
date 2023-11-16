
package universidadgrupo69.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import universidadgrupo69.accesoADatos.AlumnoData;
import universidadgrupo69.accesoADatos.inscripcionData;
import universidadgrupo69.entidades.Alumno;
import universidadgrupo69.entidades.Inscripcion;

public class ActualizacionDeNotas extends javax.swing.JInternalFrame {
     
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int fila, int columna){
            if(columna == 2){
                return true;
            }
            return false;
        }     
    };

    Alumno alumnoSeleccionado;
    private int idAlumno, idMateria;
    private double nota;
    
    public ActualizacionDeNotas() {
        initComponents();
        cargarComboBox();
        armarCabeceraTabla();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtInscripciones = new javax.swing.JTable();
        jbActualizar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cargar Notas");

        jLabel2.setText("Seleccione un Alumno");

        jcbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnoActionPerformed(evt);
            }
        });

        jtInscripciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtInscripciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtInscripcionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtInscripciones);

        jbActualizar.setText("Guardar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbActualizar)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jcbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnoActionPerformed
        refrescarTabla();
        alumnoSeleccionado =  new Alumno();
        alumnoSeleccionado = (Alumno) jcbAlumno.getSelectedItem();
        inscripcionData inscData = new inscripcionData();
        ArrayList<Inscripcion> inscripciones = new ArrayList();
        inscripciones = (ArrayList) inscData.listarInscripcionesPorAlumno(alumnoSeleccionado.getIdAlumno());
        for(Inscripcion aux : inscripciones){
               modelo.addRow(new Object[]{aux.getMateria().getIdMateria(), aux.getMateria().getNombre(), aux.getNota()});
           }
        
        
    }//GEN-LAST:event_jcbAlumnoActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        idAlumno = alumnoSeleccionado.getIdAlumno();
            inscripcionData inscData = new inscripcionData();
            inscData.actualizarNota(idAlumno, idMateria, nota);
        
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jtInscripcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtInscripcionesMouseClicked

        if(jtInscripciones.getSelectedRow()!= -1){
             idMateria = (Integer) jtInscripciones.getValueAt(jtInscripciones.getSelectedRow(), 0);
             nota = Double.parseDouble(jtInscripciones.getValueAt(jtInscripciones.getSelectedRow(), 2)+"");
         }
    }//GEN-LAST:event_jtInscripcionesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JComboBox<Alumno> jcbAlumno;
    private javax.swing.JTable jtInscripciones;
    // End of variables declaration//GEN-END:variables
    
    private void cargarComboBox(){
      AlumnoData alData = new AlumnoData();
      List<Alumno> alumnos = new ArrayList();
      alumnos = alData.buscarAlumnos();
      
      for(Alumno aux : alumnos){
          jcbAlumno.addItem(aux);
      }
      return;
    }
    
    private void armarCabeceraTabla(){
        modelo.addColumn("Codigo_Materia");
        modelo.addColumn("Nombre_Materia");
        modelo.addColumn("Nota_Inscripcion");
        jtInscripciones.setModel(modelo);
    }
    
    private void refrescarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jtInscripciones.getModel();
        int f = jtInscripciones.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }
     
}
