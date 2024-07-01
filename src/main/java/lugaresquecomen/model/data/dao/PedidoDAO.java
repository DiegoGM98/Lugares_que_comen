package lqc.lugaresquecomen.model.data.dao;

import lqc.lugaresquecomen.model.Pedido;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Table;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class PedidoDAO {

    public static void registrarPedido(DSLContext query, Pedido pedido){
        Table tablaPedido = table(name("Pedido"));
        Field[] columnas = tablaPedido.fields("nombre","correo","numero","direccion","mensaje");
        query.insertInto(tablaPedido, columnas[0], columnas[1],columnas[2],columnas[3],columnas[4])
                .values(pedido.getNombre(),pedido.getDireccion(),pedido.getNumero(),pedido.getCorreo(),pedido.getMensaje())
                .execute();

    }
}
