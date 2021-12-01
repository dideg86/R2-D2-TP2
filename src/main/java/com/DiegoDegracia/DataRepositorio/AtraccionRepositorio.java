package com.DiegoDegracia.DataRepositorio;

import com.DiegoDegracia.DataRepositorio.Connection.ConexionSQLlite;
import com.DiegoDegracia.DataRepositorio.RepoInterno.AtraccionRepoInterno;
import com.DiegoDegracia.Modelos.Atraccion;
import com.DiegoDegracia.Modelos.Repositorios.IAtraccionRepositorio;

import java.sql.Connection;
import java.util.List;

public class AtraccionRepositorio implements IAtraccionRepositorio {

    @Override
    public List<Atraccion> Obtener() {
        Connection conn = ConexionSQLlite.NuevaConexion();
        return AtraccionRepoInterno.Obtener(conn);
    }

    @Override
    public Atraccion Obtener(int atraccionID) {
        Connection conn = ConexionSQLlite.NuevaConexion();
        return AtraccionRepoInterno.Obtener(atraccionID, conn);
    }

    @Override
    public void Crear(Atraccion atraccion) {
        Connection conn = ConexionSQLlite.NuevaConexion();
        AtraccionRepoInterno.Crear(atraccion, conn);
    }

    @Override
    public void Actualizar(Atraccion atraccion) {

    }
}
