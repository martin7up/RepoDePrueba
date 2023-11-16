
package universidadgrupo69.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadgrupo69.accesoADatos.AlumnoData;
import universidadgrupo69.accesoADatos.inscripcionData;
import universidadgrupo69.entidades.Alumno;
import universidadgrupo69.entidades.Inscripcion;
import universidadgrupo69.entidades.Materia;


public class FormularioDeInscripcion extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int fila, int columna){
            
            return false;
        }
    };
    Alumno alumnoSeleccionado;
    Materia materiaSeleccionada;
    
    public FormularioDeInscripcion() {
        initComponents();
        cargarComboBox();
        armarCabeceraTabla();
        jbInscribir.setEnabled(false);
        jbAnularInscripcion.setEnabled(false);
        jrbMatNoInscriptas.setSelected(false);
        jrbMatNoInscriptas.setOpaque(true);
        jrbMatInscriptas.setSelected(true);
        jrbMatInscriptas.setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumnos = new javax.swing.JComboBox<>();
        jrbMatInscriptas = new javax.swing.JRadioButton();
        jrbMatNoInscriptas = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();
        jbInscribir = new javax.swing.JButton();
        jbAnularInscripcion = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setText("Seleccione un Alumno");

        jcbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnosActionPerformed(evt);
            }
        });

        jrbMatInscriptas.setText("Materias Inscriptas");
        jrbMatInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMatInscriptasActionPerformed(evt);
            }
        });

        jrbMatNoInscriptas.setText("Materias no Inscriptas");
        jrbMatNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMatNoInscriptasActionPerformed(evt);
            }
        });

        jLabel3.setText("Listado De Materias");

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMateriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtMaterias);

        jbInscribir.setText("Inscribir");
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        jbAnularInscripcion.setText("Anular Inscripcion");
        jbAnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularInscripcionActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jbInscribir)
                .addGap(76, 76, 76)
                .addComponent(jbAnularInscripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(177, 177, 177))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jrbMatInscriptas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrbMatNoInscriptas)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jcbAlumnos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMatInscriptas)
                    .addComponent(jrbMatNoInscriptas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInscribir)
                    .addComponent(jbAnularInscripcion)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        dispose();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jrbMatInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMatInscriptasActionPerformed
        jrbMatNoInscriptas.setSelected(false);
        jrbMatNoInscriptas.setOpaque(true);
        jbInscribir.setEnabled(false);
        jbAnularInscripcion.setEnabled(true);
    }//GEN-LAST:event_jrbMatInscriptasActionPerformed

    private void jrbMatNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMatNoInscriptasActionPerformed
        jrbMatInscriptas.setSelected(false);
        jrbMatInscriptas.setOpaque(true);
        jbInscribir.setEnabled(true);
        jbAnularInscripcion.setEnabled(false);
    }//GEN-LAST:event_jrbMatNoInscriptasActionPerformed

    private void jcbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnosActionPerformed
        refrescarTabla();
        if(!(jrbMatInscriptas.isSelected()||jrbMatNoInscriptas.isSelected())){
            JOptionPane.showMessageDialog(this, ">>>Seleccione antes la opcion Inscripto o NoIncripto<<<");
            return;
        }
        alumnoSeleccionado = new Alumno();
        alumnoSeleccionado = (Alumno) jcbAlumnos.getSelectedItem();
        inscripcionData inscData = new inscripcionData();
       
        if(jrbMatInscriptas.isSelected()){
           ArrayList<Materia> matInscrip = new ArrayList();
           matInscrip = (ArrayList) inscData.listarMateriasCursadas(alumnoSeleccionado.getIdAlumno());
           for(Materia aux : matInscrip){
               modelo.addRow(new Object[]{aux.getIdMateria(), aux.getNombre(), aux.getAnioMateria(), aux.isActivo()});
           }
        }
        
        if(jrbMatNoInscriptas.isSelected()){
            ArrayList<Materia> matInscrip = new ArrayList();
           matInscrip = (ArrayList) inscData.listarMateriasNoCursadas(alumnoSeleccionado.getIdAlumno());
           for(Materia aux : matInscrip){
               modelo.addRow(new Object[]{aux.getIdMateria(), aux.getNombre(), aux.getAnioMateria(), aux.isActivo()});
           }
        }
    }//GEN-LAST:event_jcbAlumnosActionPerformed

    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
        Inscripcion inscrip = new Inscripcion();
        inscrip.setAlumno(alumnoSeleccionado);
        inscrip.setMateria(materiaSeleccionada);
        inscrip.setNota(-1);
        
        inscripcionData insData = new inscripcionData();
        insData.guardarInscricion(inscrip);
    }//GEN-LAST:event_jbInscribirActionPerformed

    private void jtMateriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMateriasMouseClicked
        if(jtMaterias.getSelectedRow()!= -1){
            materiaSeleccionada = new Materia();
            materiaSeleccionada.setIdMateria((Integer)(jtMaterias.getValueAt(jtMaterias.getSelectedRow(), 0)));
            materiaSeleccionada.setNombre(jtMaterias.getValueAt(jtMaterias.getSelectedRow(), 1)+"");
            materiaSeleccionada.setAnioMateria((Integer)jtMaterias.getValueAt(jtMaterias.getSelectedRow(), 2));
            materiaSeleccionada.setActivo(true);
        }
    }//GEN-LAST:event_jtMateriasMouseClicked

    private void jbAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularInscripcionActionPerformed
        inscripcionData insc = new inscripcionData();
        insc.borrarInscripcionAMateriaDeAlumno(alumnoSeleccionado.getIdAlumno(), materiaSeleccionada.getIdMateria());
    }//GEN-LAST:event_jbAnularInscripcionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAnularInscripcion;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JComboBox<Alumno> jcbAlumnos;
    private javax.swing.JRadioButton jrbMatInscriptas;
    private javax.swing.JRadioButton jrbMatNoInscriptas;
    private javax.swing.JTable jtMaterias;
    // End of variables declaration//GEN-END:variables


    private void cargarComboBox(){
      AlumnoData alData = new AlumnoData();
      List<Alumno> alumnos = new ArrayList();
      alumnos = alData.buscarAlumnos();
      
      for(Alumno aux : alumnos){
          jcbAlumnos.addItem(aux);
      }
      return;
    }
    
    private void armarCabeceraTabla(){
        modelo.addColumn("Id_Materia");
        modelo.addColumn("Nombre_Materia");
        modelo.addColumn("Anio_Materia");
        modelo.addColumn("Estado_Materia");
        jtMaterias.setModel(modelo);
    }
    
    private void refrescarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jtMaterias.getModel();
        int f = jtMaterias.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }
}
/*Para comunicar informacion entre eventos, talvez se puede usar metodos y vbles
    declaradas fuera de los metodos-tipp-eventos.
*/
