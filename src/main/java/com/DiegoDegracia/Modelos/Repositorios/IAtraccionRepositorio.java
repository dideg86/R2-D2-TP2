package com.DiegoDegracia.Modelos.Repositorios;

import com.DiegoDegracia.Modelos.Atraccion;

import java.util.List;

public interface IAtraccionRepositorio {
    public List<Atraccion> Obtener();
    public Atraccion Obtener(int atraccionID);
    public void Crear(Atraccion atraccion);
    public void Actualizar(Atraccion atraccion);
}
