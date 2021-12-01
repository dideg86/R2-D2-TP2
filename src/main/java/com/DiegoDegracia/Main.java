package com.DiegoDegracia;

import com.DiegoDegracia.DataRepositorio.AtraccionRepositorio;
import com.DiegoDegracia.DataRepositorio.UsuarioRepositorio;
import com.DiegoDegracia.Modelos.Atraccion;
import com.DiegoDegracia.Modelos.Repositorios.IAtraccionRepositorio;
import com.DiegoDegracia.Modelos.Repositorios.IUsuarioRepositorio;
import com.DiegoDegracia.Modelos.TipoAventura;
import com.DiegoDegracia.Modelos.Usuario;

import java.util.List;

public class Main {
    public static void main(String[] args){
        IAtraccionRepositorio Atracciones = new AtraccionRepositorio();
        IUsuarioRepositorio Usuario = new UsuarioRepositorio();

        // Crear una nueva atracción. El ID me da igual porque no lo voy a usar
        Atraccion atr = new Atraccion(0, "Minas Tirith", 5, 2.5, 25, TipoAventura.PAISAJE);
        Atracciones.Crear(atr);

        // Obtengo TODAS las atracciones
        List<Atraccion> listadoAtracciones = Atracciones.Obtener();
        Atraccion atraccionMordor = Atracciones.Obtener(1);

        // Crear un usuario nuevo
        Usuario usr = new Usuario(0, "Eowyn",TipoAventura.PAISAJE, 10, 8);

        // Obtengo todos los usuarios
        List<Usuario> listadoUsuario = Usuario.Obtener();

        int j = 10;
    }
}
