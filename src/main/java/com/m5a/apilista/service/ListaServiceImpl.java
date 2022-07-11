/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.apilista.service;

import com.m5a.apilista.model.Listas;
import com.m5a.apilista.repository.ListaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ListaServiceImpl implements ListaService{

     @Autowired
    private ListaRepository listarepository;
     
    @Override
    public Listas crear(Listas l) {
        return listarepository.save(l);
    }

    @Override
    public Listas findByid(Long id) {
        return listarepository.findById(id).orElse(null);
    }

    @Override
    public List<Listas> finByAll() {
        return listarepository.findAll();
    }

    @Override
    public void delete(Long id) {
        listarepository.deleteById(id);
    }
    
}
