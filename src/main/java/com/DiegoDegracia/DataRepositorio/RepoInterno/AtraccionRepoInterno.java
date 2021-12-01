package com.DiegoDegracia.DataRepositorio.RepoInterno;

import com.DiegoDegracia.Modelos.Atraccion;
import com.DiegoDegracia.Modelos.TipoAventura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtraccionRepoInterno {
    private static String OBTENER_TODAS = "SELECT * FROM atracciones";
    private static String OBTENER_POR_ID = "SELECT * FROM atracciones WHERE atr_id = ?";
    private static String CREAR_ATRACCION = """
            INSERT INTO atracciones(atr_nom, atr_cos, atr_tie_prom, atr_cup, atr_cod_ave)
            VALUES (?,?,?,?,?)""";

    public static Atraccion Obtener(int atraccionId, Connection conn){
        Atraccion ret = null;

        try{
            PreparedStatement stm = conn.prepareStatement(OBTENER_POR_ID);
            stm.setInt(1, atraccionId);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("atr_id");
                String nombre = rs.getString("atr_nom");
                int costo = rs.getInt("atr_cos");
                double tiempoPromedio = rs.getDouble("atr_tie_prom");
                int cupo = rs.getInt("atr_cup");
                int tipoAventura = rs.getShort("atr_cod_ave");

                ret = new Atraccion(id, nombre, costo, tiempoPromedio, cupo, TipoAventura.values()[tipoAventura]);
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
    public static List<Atraccion> Obtener(Connection conn){
        List<Atraccion> ret = new ArrayList<Atraccion>();

        try{
            PreparedStatement stm = conn.prepareStatement(OBTENER_TODAS);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("atr_id");
                String nombre = rs.getString("atr_nom");
                int costo = rs.getInt("atr_cos");
                double tiempoPromedio = rs.getDouble("atr_tie_prom");
                int cupo = rs.getInt("atr_cup");
                int tipoAventura = rs.getShort("atr_cod_ave");

                Atraccion atr = new Atraccion(id, nombre, costo, tiempoPromedio, cupo, TipoAventura.values()[tipoAventura]);
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
    public static void Crear(Atraccion atraccion, Connection conn){
        try{
            PreparedStatement stm = conn.prepareStatement(CREAR_ATRACCION);
            stm.setString(1, atraccion.getNombre());
            stm.setInt(2, atraccion.getCosto());
            stm.setDouble(3, atraccion.getTiempoPromedio());
            stm.setInt(4, atraccion.getCupo());
            stm.setShort(5, (short) atraccion.getTipo().ordinal());

            stm.execute();
        }catch (SQLException e){
            throw new Error(e);
        }
    }
}
