/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.apilista.service;

import com.m5a.apilista.model.Listas;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ListaService {
     public Listas crear(Listas l);

    public Listas findByid(Long id);

    public List<Listas> finByAll();

    public void delete(Long id);
}
