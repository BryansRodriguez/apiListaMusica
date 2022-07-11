/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.apilista.controller;

import com.m5a.apilista.model.Listas;
import com.m5a.apilista.service.ListaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@CrossOrigin(origins =("*"))
@RestController
@RequestMapping("/api/listas")
public class ListaController {
    @Autowired
    ListaService listaservice;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Listas>> listar(){
        return new ResponseEntity<>(listaservice.finByAll(),HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Listas>crear(@RequestBody Listas l){
        return new ResponseEntity<>(listaservice.crear(l),HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Listas>eliminar(@PathVariable Long id){
        listaservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Listas>buscar(@PathVariable Long id){
        return new ResponseEntity<>(buscarLista(id),HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Listas>actualizar(@PathVariable Long id, @RequestBody Listas l){
        Listas li= buscarLista(id);
        if (li == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                li.setName(l.getName());
                li.setDescription(l.getDescription());
                li.setIdSonido(l.getIdSonido());
             
                return new ResponseEntity<>(listaservice.crear(l), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    public Listas buscarLista(Long id){
        return listaservice.findByid(id);
    }
    
    
}
