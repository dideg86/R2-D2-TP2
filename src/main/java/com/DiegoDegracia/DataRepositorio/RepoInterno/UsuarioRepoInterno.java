package com.DiegoDegracia.DataRepositorio.RepoInterno;

import com.DiegoDegracia.Modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepoInterno {
    private static String OBTENER_TODAS = "SELECT * FROM usuario";
    private static String OBTENER_POR_ID = "SELECT * FROM usuario WHERE atr_id = ?";
    private static String CREAR_USUARIO = """
            INSERT INTO usuario(usr_nom, usr_cod_ave, usr_pres, usr_tie_dis)
            VALUES (?,?,?,?)""";

    public static Usuario Obtener(int usuarioId, Connection conn){
        Usuario ret = null;

        try{
            PreparedStatement stm = conn.prepareStatement(OBTENER_POR_ID);
            stm.setInt(1, usuarioId);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("usr_id");
                String nombre = rs.getString("usr_nom");
                int preferencia = rs.getShort("usr_cod_ave");
                int presupuesto = rs.getInt("usr_pres");
                double tiempoDisponible = rs.getDouble("usr_tie_dis");

                ret = new Usuario(id, nombre, preferencia, presupuesto, tiempoDisponible);
            }

            stm.close();
        }catch (SQLException e){
            if(conn != null){
                try{
                    conn.close();
                }catch (SQLException ex){
                    throw  new Error(ex);
                }
            }
            throw  new Error(e);
        }

        return ret;
    }
    public static List<Usuario> Obtener(Connection conn){
        List<Usuario> ret = new ArrayList<Usuario>();

        try{
            PreparedStatement stm = conn.prepareStatement(OBTENER_TODAS);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usr_id");
                String nombre = rs.getString("usr_nom");
                int preferencia = rs.getShort("usr_cod_ave");
                int presupuesto = rs.getInt("usr_pres");
                double tiempoDisponible = rs.getDouble("usr_tie_dis");

                Usuario atr = new Usuario(id, nombre, preferencia, presupuesto, tiempoDisponible);
                ret.add(atr);
            }

            stm.close();
        }catch (SQLException e){
            if(conn != null){
                try{
                    conn.close();
                }catch (SQLException ex){
                    throw  new Error(ex);
                }
            }
            throw  new Error(e);
        }

        return ret;
    }
    public static void Crear(Usuario usuario, Connection conn){
        try{
            PreparedStatement stm = conn.prepareStatement(CREAR_USUARIO);
            stm.setString(1, usuario.getNombre());
            stm.setInt(2, (short) usuario.getPreferencia());
            stm.setDouble(3, usuario.getPresupuesto());
            stm.setDouble(4, usuario.getTiempoDisponible());

            stm.execute();
        }catch (SQLException e){
            throw new Error(e);
        }
    }
}
