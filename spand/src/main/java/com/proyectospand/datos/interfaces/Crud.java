package com.proyectospand.datos.interfaces;

import java.util.List;

public interface Crud<T> {
    public List<T> listar();
    public boolean insertar(T obj);
    public boolean actualizar(T obj);
    public boolean desactivar(int id);
    public boolean activar(int id);
}
