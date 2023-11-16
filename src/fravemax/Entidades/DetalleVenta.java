
package fravemax.Entidades;


public class DetalleVenta {
    private int idDetalleVenta;
    private int cantidad;
    private Venta venta;
    private double precioVenta;//,por unidad...
    private Producto producto;

    public DetalleVenta() {}

    public DetalleVenta(int cantidad, Venta venta, double precioVenta, Producto producto) {
        this.cantidad = cantidad;
        this.venta = venta;
        this.precioVenta = precioVenta;
        this.producto = producto;
    }

    public DetalleVenta(int idDetalleVenta, int cantidad, Venta venta, double precioVenta, Producto producto) {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidad = cantidad;
        this.venta = venta;
        this.precioVenta = precioVenta;
        this.producto = producto;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public double getPrecioVenta() {
        this.precioVenta=producto.getPrecioActual()*this.cantidad;
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return (" Prod : "+this.getProducto().getPrecioActual()+" Cantiad : "+this.getCantidad()+
                " Precio tot : "+this.getPrecioVenta()+" Fecha : "+this.getVenta().getFechaVenta());
    }  
}