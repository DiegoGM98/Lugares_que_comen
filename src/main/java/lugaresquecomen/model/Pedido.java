package lqc.lugaresquecomen.model;

public class Pedido {

    private String nombre, correo, direccion, mensaje;
    private int numero;

    public Pedido(String nombre, String correo, int numero, String direccion, String mensaje) {
        this.nombre = nombre;
        this.correo = correo;
        this.numero = numero;
        this.direccion = direccion;
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
