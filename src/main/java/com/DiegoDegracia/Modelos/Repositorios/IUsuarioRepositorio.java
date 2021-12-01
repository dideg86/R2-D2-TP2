package com.DiegoDegracia.Modelos.Repositorios;

import com.DiegoDegracia.Modelos.Usuario;

import java.util.List;

public interface IUsuarioRepositorio {
    public List<Usuario> Obtener();
    public Usuario Obtener(int usuarioID);
    public void Crear(Usuario usuario);
    public void Actualizar(Usuario usuario);
}
