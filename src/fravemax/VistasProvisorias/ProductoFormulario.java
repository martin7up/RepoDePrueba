
package fravemax.VistasProvisorias;

import fravemax.AccesoADatos.ProductoData;
import fravemax.Entidades.Producto;
import javax.swing.JOptionPane;


public class ProductoFormulario extends javax.swing.JInternalFrame {
    
Producto prod;
ProductoData pData = new ProductoData();

    public ProductoFormulario() {
        
        initComponents();
        limpiarCamposYBotones();
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbRegistrarProd = new javax.swing.JButton();
        jbModificarProd = new javax.swing.JButton();
        jbDiscontinuar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jrbDiscontinuado = new javax.swing.JRadioButton();
        jrbActivo = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jtfIdProd = new javax.swing.JTextField();
        jtfNombreProd = new javax.swing.JTextField();
        jtfDescripcionProd = new javax.swing.JTextField();
        jtfPrecioUnidadProveedor = new javax.swing.JTextField();
        jtfStockProd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbBuscarProd = new javax.swing.JButton();
        jbLimpiarCampos = new javax.swing.JButton();

        jbRegistrarProd.setText("Registrar");
        jbRegistrarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarProdActionPerformed(evt);
            }
        });

        jbModificarProd.setText("Modificar");
        jbModificarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarProdActionPerformed(evt);
            }
        });

        jbDiscontinuar.setText("Discontinuar");
        jbDiscontinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDiscontinuarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario Productos");

        jrbDiscontinuado.setText("No Disponible");
        jrbDiscontinuado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbDiscontinuadoMouseClicked(evt);
            }
        });

        jrbActivo.setText("Disponible");
        jrbActivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbActivoMouseClicked(evt);
            }
        });

        jLabel2.setText("Id Producto");

        jtfIdProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfIdProdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtfIdProdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfIdProdMouseExited(evt);
            }
        });

        jLabel3.setText("Nombre Producto");

        jLabel4.setText("Descripcion");

        jLabel5.setText("Precio desde Prov");

        jLabel6.setText("Stock Ingresado");

        jbBuscarProd.setText("Buscar");
        jbBuscarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarProdActionPerformed(evt);
            }
        });

        jbLimpiarCampos.setText("Limpiar Campos");
        jbLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfNombreProd)
                                            .addComponent(jtfIdProd)
                                            .addComponent(jtfDescripcionProd)
                                            .addComponent(jtfPrecioUnidadProveedor)
                                            .addComponent(jtfStockProd)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbRegistrarProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbBuscarProd, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbModificarProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbDiscontinuar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbLimpiarCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jrbActivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrbDiscontinuado)
                        .addGap(44, 44, 44)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDescripcionProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPrecioUnidadProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfStockProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbActivo)
                    .addComponent(jrbDiscontinuado))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRegistrarProd)
                    .addComponent(jbDiscontinuar)
                    .addComponent(jbBuscarProd)
                    .addComponent(jbModificarProd))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpiarCampos)
                    .addComponent(jbSalir))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarCamposActionPerformed
        limpiarCamposYBotones();
    }//GEN-LAST:event_jbLimpiarCamposActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        prod = null;
        pData = null;
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed
    //Este metodo solamente habilita el boton Buscar y deshabilita el resto de campos.
    private void jtfIdProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfIdProdMouseClicked
        jbBuscarProd.setEnabled(true);
        jtfDescripcionProd.setEnabled(false);
        jtfNombreProd.setEnabled(false);
        jtfPrecioUnidadProveedor.setEnabled(false);
        jtfStockProd.setEnabled(false);
    }//GEN-LAST:event_jtfIdProdMouseClicked
    //Si al salirse del campo Id, este ultimo sigue vacio se deshabilita el boton Buscar.
    private void jtfIdProdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfIdProdMouseExited
        if(jtfIdProd.getText().isEmpty()){
            jbBuscarProd.setEnabled(false);
            jtfDescripcionProd.setEnabled(true);
            jtfNombreProd.setEnabled(true);
            jtfPrecioUnidadProveedor.setEnabled(true);
            jtfStockProd.setEnabled(true);
        }else{
            jbRegistrarProd.setEnabled(false);
        }
    }//GEN-LAST:event_jtfIdProdMouseExited

    private void jbRegistrarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarProdActionPerformed
        //Verificacion de campo ID vacio.
        if(jtfIdProd.getText().equals("")){
            //Verificacion del resto de campos en vista.
            if(comprobarCamposAlGuardar()){
                return;
            }
            //Creacion de Instancia para envio a BD
            prod = instanciarDesdeCampos();
            //Envio de inf hacia BD.
            pData.registrarProducto(prod);
            limpiarCamposYBotones();
            //No se emite ningun aviso aqui, pues registProd... lo hace si resulta exitoso el impacto en BD.
        }else{
            JOptionPane.showMessageDialog(this, "Id producto sera asignado por BD;\ndeje el campo(Id) vacio y reintente nuevamente.");
            limpiarCamposYBotones();
            return;
        }
    }//GEN-LAST:event_jbRegistrarProdActionPerformed
    //Este metodo no permite dar de baja un producto; para ello esta el boton "Discontinuar".
    private void jbModificarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarProdActionPerformed
        //Verificacion de campos.
        if(comprobarCamposAlGuardar()){
            return;
        }else{
            pData.modificarProducto(instanciarDesdeCampos(prod));
        }
        return;  
    }//GEN-LAST:event_jbModificarProdActionPerformed
    //Deshabilita el resto de los campos, para resaltar el hecho de que la busqueda es solo por IdProducto.
    private void jtfIdProdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfIdProdMouseEntered
        jtfDescripcionProd.setEnabled(false);
        jtfNombreProd.setEnabled(false);
        jtfPrecioUnidadProveedor.setEnabled(false);
        jtfStockProd.setEnabled(false);
    }//GEN-LAST:event_jtfIdProdMouseEntered

    private void jbBuscarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarProdActionPerformed
        //Verificacion del campo ID.
        if(verificarSiHayLetras(jtfIdProd.getText())){
            JOptionPane.showMessageDialog(this, "Id productos acepta numeros unicamente\nsin ningun tipo de puntuacion,letrao o espacio en blanco.");
            return;
        }else if(excedeLongitudMax(jtfIdProd.getText(), 11)){
            JOptionPane.showMessageDialog(this, "Demasiados digitos!! Verifique sea correcto el Id introducido.");
            return;
        }
        //Solicitud de informacion a BD, e instanciacion si fuera posible.
        prod = pData.buscarProductoXId(Integer.parseInt(jtfIdProd.getText()+""));
        //Presentacion de la informacion.
        jtfIdProd.setText(prod.getIdProducto()+"");
        jtfDescripcionProd.setText(prod.getDescripcion());
        jtfNombreProd.setText(prod.getNombreProducto());
        jtfPrecioUnidadProveedor.setText(prod.getPrecioActual()+"");
        jtfStockProd.setText(prod.getStock()+"");
        if(prod.isEstado()){
            jrbActivo.setEnabled(true);
            jrbActivo.setSelected(true);
        }else{
            jrbDiscontinuado.setEnabled(true);
            jrbDiscontinuado.setSelected(true);
        }
        //Se bloquea el campo Id para evitar errores al modificar o eliminar.
        jtfIdProd.setEditable(false);
        jtfIdProd.setEnabled(false);
        //Se habilita la modificacion de los demas campos.
        jtfDescripcionProd.setEnabled(true);
        jtfNombreProd.setEnabled(true);
        jtfPrecioUnidadProveedor.setEnabled(true);
        jtfStockProd.setEnabled(true);
        //Se habilitan las opciones de Modificar y Descontinuar.
        jbModificarProd.setEnabled(true);
        jbDiscontinuar.setEnabled(true);
    }//GEN-LAST:event_jbBuscarProdActionPerformed
//Este metodo hace que jrb se comporte como si fuera no editable.
    private void jrbActivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbActivoMouseClicked
        if(jrbActivo.isSelected()){
            jrbActivo.setSelected(false);
        }else{
            jrbActivo.setSelected(true);
        }
    }//GEN-LAST:event_jrbActivoMouseClicked
//Este metodo hace que jrb se comporte como si fuera no editable.
    private void jrbDiscontinuadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbDiscontinuadoMouseClicked
         if(jrbDiscontinuado.isSelected()){
            jrbDiscontinuado.setSelected(false);
        }else{
            jrbDiscontinuado.setSelected(true);
        }
    }//GEN-LAST:event_jrbDiscontinuadoMouseClicked

    private void jbDiscontinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDiscontinuarActionPerformed
        //Se emplea la instancia generada por el boton Buscar, de la misma se obtiene IdProducto.
        //Se verifica primeramente la instancia traida no esté ya dada de baja.
        if(!prod.isEstado()){
            JOptionPane.showMessageDialog(this, "El probucto ya fue dado de baja con anterioridad.");
            return;
        }else{
            //Envio de solicitud de baja a BD.
            pData.eliminarProducto(prod.getIdProducto());
        }
        return;
    }//GEN-LAST:event_jbDiscontinuarActionPerformed

        //jrbActivo no esta disponible para modificacion por el usuario. Solamente_
        //_informa si el producto está o no activo.
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbBuscarProd;
    private javax.swing.JButton jbDiscontinuar;
    private javax.swing.JButton jbLimpiarCampos;
    private javax.swing.JButton jbModificarProd;
    private javax.swing.JButton jbRegistrarProd;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrbActivo;
    private javax.swing.JRadioButton jrbDiscontinuado;
    private javax.swing.JTextField jtfDescripcionProd;
    private javax.swing.JTextField jtfIdProd;
    private javax.swing.JTextField jtfNombreProd;
    private javax.swing.JTextField jtfPrecioUnidadProveedor;
    private javax.swing.JTextField jtfStockProd;
    // End of variables declaration//GEN-END:variables

    private void limpiarCamposYBotones(){
        jbBuscarProd.setEnabled(false);
        jbDiscontinuar.setEnabled(false);
        jbRegistrarProd.setEnabled(true);
        jbModificarProd.setEnabled(false);
        jrbActivo.setEnabled(false);
        jrbDiscontinuado.setEnabled(false);
        //
        jtfIdProd.setEditable(true);
        jtfIdProd.setEnabled(true);
        jtfDescripcionProd.setEnabled(true);
        jtfNombreProd.setEnabled(true);
        jtfPrecioUnidadProveedor.setEnabled(true);
        jtfStockProd.setEnabled(true);
        //
        jtfDescripcionProd.setText("");
        jtfNombreProd.setText("");
        jtfIdProd.setText("");
        jtfPrecioUnidadProveedor.setText("");
        jtfStockProd.setText("");
    }
    
    private boolean verificarSiHayLetras(String cadena){//Esta funcion busca si hay letras en un String que se supone no debe tener letras.
        try{
            int num = Integer.parseInt(cadena);
        }catch(NumberFormatException nfE){
            return true;
        }
        return false;
    }
        
    private boolean excedeLongitudMax(String cadena, int dimMax){
        return cadena.length()>dimMax;
    }
    
    private boolean verificarCamposVacios(){//Este tipo de metodos deberia de trabajar con una coleccion de String instanciado desde los campos.
        return (jtfNombreProd.getText().equals("") || jtfDescripcionProd.getText().equals("") ||
                    jtfPrecioUnidadProveedor.getText().equals("") || jtfStockProd.getText().equals(""));     
    }
    
    private boolean comprobarCamposAlGuardar(){//Mal! Se deben verificar los campos segun el orden que_ 
        if(verificarCamposVacios()){
            JOptionPane.showMessageDialog(this, "...mmm, ha dejado uno o mas campos vacios.");
            return true;
        }
        if(excedeLongitudMax(jtfNombreProd.getText(), 60)||//_aparecen en la vista, para que la correccion_
                excedeLongitudMax(jtfDescripcionProd.getText(), 100)||//_sea intuitiva.
                    excedeLongitudMax(jtfPrecioUnidadProveedor.getText(), 11)||
                        excedeLongitudMax(jtfStockProd.getText(), 11)){
            JOptionPane.showMessageDialog(this, "...mmm, alguno/os de los campos excede la longitud permitida.");
            return true;
        }
        if(verificarSiHayLetras(jtfStockProd.getText())||(Integer.parseInt(jtfStockProd.getText()) == 0)){
            JOptionPane.showMessageDialog(this, "...mmm, parece que hay letras, donde no deberia; o el stock ingresado es cero.");
            return true;
        }
        try{
            Double.parseDouble(jtfPrecioUnidadProveedor.getText()+"");
        }catch(NumberFormatException nfE){
            JOptionPane.showMessageDialog(this, "...mmm, el unico caracter admitido para la parte fraccionaria es el ( . )");
            return true;
        }
        return false;
    }

    private Producto instanciarDesdeCampos(){
        Producto prodx = new Producto();
        prodx.setNombreProducto(jtfNombreProd.getText().toLowerCase());
        prodx.setDescripcion(jtfDescripcionProd.getText().toLowerCase());
        prodx.setPrecioActual(Double.parseDouble(jtfPrecioUnidadProveedor.getText()));
        prodx.setStock(Integer.parseInt(jtfStockProd.getText()+""));
        prodx.setEstado(true);//En este caso no se solicita, pues se supone se va a registrar un producto disponible p/la venta.    
        return prodx;
    }
    
    private Producto instanciarDesdeCampos(Producto producto){
        Producto prodx = new Producto();
        prodx.setIdProducto(producto.getIdProducto());
        prodx.setNombreProducto(jtfNombreProd.getText().toLowerCase());
        prodx.setDescripcion(jtfDescripcionProd.getText().toLowerCase());
        prodx.setPrecioActual(Double.parseDouble(jtfPrecioUnidadProveedor.getText()));
        prodx.setStock(Integer.parseInt(jtfStockProd.getText()+""));
        prodx.setEstado(true);//En este caso no se solicita, pues se supone se va a registrar un producto disponible p/la venta.    
        return prodx;
    }
    
}
    //Hacer un metodo que verifique un campo no esté compuesto solo por espacios.