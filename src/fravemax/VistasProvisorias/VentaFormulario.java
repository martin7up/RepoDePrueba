
package fravemax.VistasProvisorias;

import fravemax.AccesoADatos.ClienteData;
import fravemax.AccesoADatos.VentaData;
import fravemax.Entidades.Cliente;
import fravemax.Entidades.Venta;
import fravemax.EnumCamposBD;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VentaFormulario extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int fila, int columna){
            
            return false;
        }
    };
    private DefaultTableModel modelo1 = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int fila, int columna){
            if((columna==1||columna==2) && jrSeVaACorregir.isSelected()){//Id cliente y fechaVenta solamente son editables.
                return true;
            }
            return false;
        }
    };

    private ClienteData clData = new ClienteData();
    private VentaData veData = new VentaData();
    private Venta venta;
    private Cliente cliente;
    
    public VentaFormulario() {
        
        initComponents();
        cargarComboBox();
        armarCabeceraTabla();
        armarCabeceraTabla1();
        refrescarTabla();
        refrescarTabla1();
        //Por defecto se cargaran todas las ventas de manera descendente segun idCliente.
        jrXidCliente.setSelected(true);
        jrDescendente.setSelected(true);
        cargarTablaTodasLasVentas("idCliente", "DESC");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdcSeleccionFecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jrbFechaActual = new javax.swing.JRadioButton();
        jcbClientesRegistrados = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jlFechaActual = new javax.swing.JLabel();
        jbRegistrarVenta = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVentasDe1Cliente = new javax.swing.JTable();
        jbLimpiarYResetear = new javax.swing.JButton();
        jlFormato = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtTodasLasVentas = new javax.swing.JTable();
        jrSeVaACorregir = new javax.swing.JRadioButton();
        jrXdni = new javax.swing.JRadioButton();
        jrXidVenta = new javax.swing.JRadioButton();
        jrXidCliente = new javax.swing.JRadioButton();
        jrXFecha = new javax.swing.JRadioButton();
        jrXnombre = new javax.swing.JRadioButton();
        jrXapellido = new javax.swing.JRadioButton();
        jrDescendente = new javax.swing.JRadioButton();

        jdcSeleccionFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jdcSeleccionFechaMouseClicked(evt);
            }
        });

        jLabel1.setText("Fecha del dia de la Venta.");

        jrbFechaActual.setText("Utilizar fecha actual.");
        jrbFechaActual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbFechaActualMouseClicked(evt);
            }
        });

        jcbClientesRegistrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClientesRegistradosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Formulario Venta");

        jbRegistrarVenta.setText("Registrar Venta");
        jbRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarVentaActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jtVentasDe1Cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtVentasDe1Cliente);

        jbLimpiarYResetear.setText("Limpiar Datos y Botones");
        jbLimpiarYResetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarYResetearActionPerformed(evt);
            }
        });

        jtTodasLasVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jtTodasLasVentas);

        jrSeVaACorregir.setText("Corregir en lista.");
        jrSeVaACorregir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrSeVaACorregirMouseClicked(evt);
            }
        });

        jrXdni.setText("por Dni");
        jrXdni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrXdniMouseClicked(evt);
            }
        });

        jrXidVenta.setText("por Id Venta");
        jrXidVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrXidVentaMouseClicked(evt);
            }
        });

        jrXidCliente.setText("por Id Cliente");
        jrXidCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrXidClienteMouseClicked(evt);
            }
        });

        jrXFecha.setText("por Fecha");
        jrXFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrXFechaMouseClicked(evt);
            }
        });

        jrXnombre.setText("por Nombre");
        jrXnombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrXnombreMouseClicked(evt);
            }
        });

        jrXapellido.setText("por Apellido");
        jrXapellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrXapellidoMouseClicked(evt);
            }
        });

        jrDescendente.setText("Mayor a Menor.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jrbFechaActual)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jrSeVaACorregir)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jrDescendente)
                                                .addGap(19, 19, 19))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addComponent(jbLimpiarYResetear, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jbRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jrXdni)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrXidVenta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrXidCliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrXFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrXnombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrXapellido)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)
                                .addComponent(jlFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jdcSeleccionFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(jcbClientesRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jdcSeleccionFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jcbClientesRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlFechaActual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jrbFechaActual, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jlFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrXdni)
                            .addComponent(jrXidVenta)
                            .addComponent(jrXidCliente)
                            .addComponent(jrXFecha)
                            .addComponent(jrXnombre)
                            .addComponent(jrXapellido)
                            .addComponent(jrDescendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrSeVaACorregir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbRegistrarVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbLimpiarYResetear))
                            .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        clData = null;
        veData = null;
        cliente = null;
        venta = null;
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed
//Borrar este Evento./////////////////////////////////////////////////////////////
    private void jdcSeleccionFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdcSeleccionFechaMouseClicked
        jdcSeleccionFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }//GEN-LAST:event_jdcSeleccionFechaMouseClicked
//////////////////////////////////////////////////////////////////////////////////////
    private void jrbFechaActualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbFechaActualMouseClicked
        if(jrbFechaActual.isSelected()){
            jdcSeleccionFecha.setEnabled(false); 
            jlFormato.setText("aaaa-mm-dd");
            jlFechaActual.setText(LocalDate.now(ZoneId.systemDefault())+"");
        }else{
            jdcSeleccionFecha.setEnabled(true);
            jlFechaActual.setText("");
            jlFormato.setText("");
        }
    }//GEN-LAST:event_jrbFechaActualMouseClicked

    private void jcbClientesRegistradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClientesRegistradosActionPerformed
        //Obtencion del objeto Cliente.
        cliente = jcbClientesRegistrados.getItemAt(jcbClientesRegistrados.getSelectedIndex());
        //Carga de ventas anteriores del cliente seleccionado.
        refrescarTabla();
        ArrayList<Venta> ventas = (ArrayList) veData.listarVentasDeUnCliente(cliente.getIdCliente());
           for(Venta aux : ventas){
               modelo.addRow(new Object[]{aux.getIdVenta(), aux.getFechaVenta()});
           }
    }//GEN-LAST:event_jcbClientesRegistradosActionPerformed

    private void jbRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarVentaActionPerformed

            if(jtTodasLasVentas.getSelectedRow()!=-1){
                //Modificacion de una venta ya existente.
                cliente = new Cliente();
                venta = new Venta();
                //Captura desde tabla del idVenta que servira de condicion en la sentencia de actualizacion enviada a BD.
                venta.setIdVenta(Integer.parseInt(jtTodasLasVentas.getValueAt(jtTodasLasVentas.getSelectedRow(), 0)+""));
                //Captura desde tabla del idCliente(modificado o no).
                cliente.setIdCliente(Long.parseLong(jtTodasLasVentas.getValueAt(jtTodasLasVentas.getSelectedRow(), 1)+""));
                //Captura desde tabla de la fecha(modificada o no).
                venta.setFechaVenta((Date.valueOf(jtTodasLasVentas.getValueAt(jtTodasLasVentas.getSelectedRow(), 2)+"")).toLocalDate());
                //Asignacion de la instancia cliente, con el valor idCliente modificado o no, a la instancia venta.
                venta.setCliente(cliente);
                //Envio de solicitud de modificacion hacia BD.
                veData.modificarVenta(venta);
            }else{
                //Guardado de Venta nueva.
                //Creacion del objeto Venta.
                venta = new Venta();
                venta.setCliente(cliente);
                if(jrbFechaActual.isSelected()){
                    venta.setFechaVenta(LocalDate.now(ZoneId.systemDefault()));
                }else{
                    venta.setFechaVenta(jdcSeleccionFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                }
                veData.registraVenta(venta);
            }
    }//GEN-LAST:event_jbRegistrarVentaActionPerformed

    private void jrSeVaACorregirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrSeVaACorregirMouseClicked
        if(jrSeVaACorregir.isSelected()){
        JOptionPane.showMessageDialog(this, "Puede modificar la fecha o el idCliente, o ambos."+
                "\nPrimero presione el boton <Limpiar Datos y Botones>."+
                "\nModifique manualmente los valores en la tabla."+
                "\nLuego para asentar la modificacion presione el boton <Registrar venta>."+
                "\n(form fecha aaaa-mm-dd >>> respete los guiones medios.)");
        }
    }//GEN-LAST:event_jrSeVaACorregirMouseClicked

    private void jrXdniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrXdniMouseClicked
        refrescarTabla1();
        if(jrXdni.isSelected()){
            //Se refresca la tabla.
            refrescarTabla1();
            //Se desmarcan el resto de los jrb p/criterio de ordenamiento.
            jrXFecha.setSelected(false);
            jrXapellido.setSelected(false);
            jrXidCliente.setSelected(false);
            jrXnombre.setSelected(false);
            jrXidVenta.setSelected(false);
            //Se verifica si esta marcado el ordenamiento descendente y se carga s/corresponda.
            if(jrDescendente.isSelected()){
                cargarTablaTodasLasVentas("dni", "DESC");
            }else{
                cargarTablaTodasLasVentas("dni", "ASC");
            }
        }
    }//GEN-LAST:event_jrXdniMouseClicked

    private void jrXidVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrXidVentaMouseClicked
        refrescarTabla1();
        if(jrXidVenta.isSelected()){
            //Se refresca la tabla.
            refrescarTabla1();
            //Se desmarcan el resto de los jrb p/criterio de ordenamiento.
            jrXFecha.setSelected(false);
            jrXapellido.setSelected(false);
            jrXidCliente.setSelected(false);
            jrXnombre.setSelected(false);
            jrXdni.setSelected(false);
            //Se verifica si esta marcado el ordenamiento descendente y se carga s/corresponda.
            if(jrDescendente.isSelected()){
                cargarTablaTodasLasVentas("idVenta", "DESC");
            }else{
                cargarTablaTodasLasVentas("idVenta", "ASC");
            }
        }
    }//GEN-LAST:event_jrXidVentaMouseClicked

    private void jrXidClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrXidClienteMouseClicked
        refrescarTabla1();
        if(jrXidCliente.isSelected()){
            //Se refresca la tabla.
            refrescarTabla1();
            //Se desmarcan el resto de los jrb p/criterio de ordenamiento.
            jrXFecha.setSelected(false);
            jrXapellido.setSelected(false);
            jrXdni.setSelected(false);
            jrXnombre.setSelected(false);
            jrXidVenta.setSelected(false);
            //Se verifica si esta marcado el ordenamiento descendente y se carga s/corresponda.
            if(jrDescendente.isSelected()){
                cargarTablaTodasLasVentas("idCliente", "DESC");
            }else{
                cargarTablaTodasLasVentas("idCliente", "ASC");
            }
        }
    }//GEN-LAST:event_jrXidClienteMouseClicked

    private void jbLimpiarYResetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarYResetearActionPerformed
        
        cliente = null;
        venta = null;
        cargarComboBox();
        refrescarTabla();
        refrescarTabla1();
        jrXidCliente.setSelected(true);
        jrDescendente.setSelected(true);
        jrXFecha.setSelected(false);
        jrXapellido.setSelected(false);
        jrXdni.setSelected(false);
        jrXnombre.setSelected(false);
        jrXidVenta.setSelected(false);
        cargarTablaTodasLasVentas("idCliente", "DESC");
        jdcSeleccionFecha.setEnabled(true);
        jlFechaActual.setText("");
        jlFormato.setText("");
        jrbFechaActual.setSelected(false);
        
    }//GEN-LAST:event_jbLimpiarYResetearActionPerformed

    private void jrXFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrXFechaMouseClicked
        refrescarTabla1();
        if(jrXFecha.isSelected()){
            //Se refresca la tabla.
            refrescarTabla1();
            //Se desmarcan el resto de los jrb p/criterio de ordenamiento.
            jrXidCliente.setSelected(false);
            jrXapellido.setSelected(false);
            jrXdni.setSelected(false);
            jrXnombre.setSelected(false);
            jrXidVenta.setSelected(false);
            //Se verifica si esta marcado el ordenamiento descendente y se carga s/corresponda.
            if(jrDescendente.isSelected()){
                cargarTablaTodasLasVentas("fechaVenta", "DESC");
            }else{
                cargarTablaTodasLasVentas("fechaVenta", "ASC");
            }
        }
    }//GEN-LAST:event_jrXFechaMouseClicked

    private void jrXnombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrXnombreMouseClicked
        refrescarTabla1();
        if(jrXnombre.isSelected()){
            //Se refresca la tabla.
            refrescarTabla1();
            //Se desmarcan el resto de los jrb p/criterio de ordenamiento.
            jrXFecha.setSelected(false);
            jrXapellido.setSelected(false);
            jrXdni.setSelected(false);
            jrXidCliente.setSelected(false);
            jrXidVenta.setSelected(false);
            //Se verifica si esta marcado el ordenamiento descendente y se carga s/corresponda.
            if(jrDescendente.isSelected()){
                cargarTablaTodasLasVentas("nombre", "DESC");
            }else{
                cargarTablaTodasLasVentas("nombre", "ASC");
            }
        }
    }//GEN-LAST:event_jrXnombreMouseClicked

    private void jrXapellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrXapellidoMouseClicked
        refrescarTabla1();
        if(jrXapellido.isSelected()){
            //Se refresca la tabla.
            refrescarTabla1();
            //Se desmarcan el resto de los jrb p/criterio de ordenamiento.
            jrXFecha.setSelected(false);
            jrXidCliente.setSelected(false);
            jrXdni.setSelected(false);
            jrXnombre.setSelected(false);
            jrXidVenta.setSelected(false);
            //Se verifica si esta marcado el ordenamiento descendente y se carga s/corresponda.
            if(jrDescendente.isSelected()){
                cargarTablaTodasLasVentas("apellido", "DESC");
            }else{
                cargarTablaTodasLasVentas("apellido", "ASC");
            }
        }
    }//GEN-LAST:event_jrXapellidoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbLimpiarYResetear;
    private javax.swing.JButton jbRegistrarVenta;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Cliente> jcbClientesRegistrados;
    private com.toedter.calendar.JDateChooser jdcSeleccionFecha;
    private javax.swing.JLabel jlFechaActual;
    private javax.swing.JLabel jlFormato;
    private javax.swing.JRadioButton jrDescendente;
    private javax.swing.JRadioButton jrSeVaACorregir;
    private javax.swing.JRadioButton jrXFecha;
    private javax.swing.JRadioButton jrXapellido;
    private javax.swing.JRadioButton jrXdni;
    private javax.swing.JRadioButton jrXidCliente;
    private javax.swing.JRadioButton jrXidVenta;
    private javax.swing.JRadioButton jrXnombre;
    private javax.swing.JRadioButton jrbFechaActual;
    private javax.swing.JTable jtTodasLasVentas;
    private javax.swing.JTable jtVentasDe1Cliente;
    // End of variables declaration//GEN-END:variables

    private void cargarComboBox(){
        
        ArrayList<Cliente> clientes;
        clientes = (ArrayList)clData.listarClientes();
        
      for(Cliente aux : clientes){
          jcbClientesRegistrados.addItem(aux);
      }
      return;
      
    }
    
    private void cargarTablaTodasLasVentas(String campo, String orden){
        
        ArrayList<Venta> bentas;
        bentas = (ArrayList) veData.listarTodasLasVentas(campo, orden);
        
      for(Venta aux : bentas){
               modelo1.addRow(new Object[]{aux.getIdVenta(), 
                   aux.getCliente().getIdCliente(), aux.getFechaVenta(), 
                    aux.getCliente().getDni(), aux.getCliente().getApellido(), 
                     aux.getCliente().getNombre()});
        }
        return;
        
    }
         
    private void armarCabeceraTabla(){
        
        modelo.addColumn("Id_vta.");
        modelo.addColumn("Fecha_vta.");
        modelo.addColumn("Concretada_vta");
        jtVentasDe1Cliente.setModel(modelo);
        
    }
    
    private void armarCabeceraTabla1(){
        
        modelo1.addColumn("Id_vta.");
        modelo1.addColumn("Id_clt.");
        modelo1.addColumn("Fecha_vta.");
        modelo1.addColumn("Dni_clt.");
        modelo1.addColumn("Apellido_clt.");
        modelo1.addColumn("Nombre_clt.");
        modelo1.addColumn("Concretada_vta");
        jtTodasLasVentas.setModel(modelo1);
        
    }
    
    private void refrescarTabla(){
        
        DefaultTableModel modelo = (DefaultTableModel) jtVentasDe1Cliente.getModel();
        int f = jtVentasDe1Cliente.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
        
    }
    
    private void refrescarTabla1(){
        
        DefaultTableModel modelo1 = (DefaultTableModel) jtTodasLasVentas.getModel();
        int f = jtTodasLasVentas.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo1.removeRow(f);
        }
        
    }
}