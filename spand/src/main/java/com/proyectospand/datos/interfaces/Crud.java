package com.proyectospand.datos.interfaces;

import java.util.List;

import com.proyectospand.Entidades.Empleados;

public interface Crud<T> {
    public List<T> listar();
    public boolean insertar(T obj,Empleados empleadoE);
    public boolean actualizar(T obj,Empleados empleadoE);
    public boolean desactivar(int id,Empleados empleadoE);
    public boolean activar(int id);
}
