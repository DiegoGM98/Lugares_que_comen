package lqc.lugaresquecomen.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lqc.lugaresquecomen.model.Pedido;
import lqc.lugaresquecomen.model.data.DBGenerator;
import lqc.lugaresquecomen.model.data.dao.PedidoDAO;
import org.jooq.DSLContext;

import java.util.List;

@WebServlet(name = "ordenarPedido", value = "/ordenarPedido")
public class ordenarPedidoServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("LugaresQueComen");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/ordenarPedido.jsp");
        respuesta.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException {
        if (req.getParameter("nombre").length() == 0 || req.getParameter("correo").length() == 0 || req.getParameter("numero").length() == 0 || req.getParameter("direccion").length() == 0 || req.getParameter("mensaje").length() == 0) {
            RequestDispatcher respuesta = req.getRequestDispatcher("/ordenErronea.jsp");
            respuesta.forward(req, resp);
        } else {
            String nombre = req.getParameter("nombre");
            String correo = req.getParameter("correo");
            int numero = Integer.parseInt(req.getParameter("numero"));
            String direccion = req.getParameter("direccion");
            String mensaje = req.getParameter("mensaje");
            Pedido pedido = new Pedido(nombre, correo, numero, direccion, mensaje);
            try{
                registrarPedido(pedido);
            }catch(ClassNotFoundException e){
                throw new RuntimeException(e);
            }


        }
    }


    public static void registrarPedido(Pedido pedido) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("LugaresQueComen");
        PedidoDAO.registrarPedido(query, pedido);
    }

}
