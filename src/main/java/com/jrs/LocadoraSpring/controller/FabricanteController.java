package com.jrs.LocadoraSpring.controller;

import com.jrs.LocadoraSpring.entity.Fabricante;
import com.jrs.LocadoraSpring.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fabricante")
public class FabricanteController {

    @Autowired
    FabricanteService service;

    @GetMapping
    public ResponseEntity<List<Fabricante>> findAllFabricantes() {
        List<Fabricante> fabricantes = service.findAllFabricantes();
        return new ResponseEntity<>(fabricantes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findFabricanteById(@PathVariable Long id) {
        Fabricante fabricante = service.findFabricanteById(id);
        if (fabricante != null) {
            return ResponseEntity.ok(fabricante);
        } else {
            return ResponseEntity.status(400).body("Fabricante not found with id: " + id);
        }
    }


    @PostMapping
    public ResponseEntity<String> saveFabicante(@RequestBody Fabricante fabricante) {
        try {
            service.insertFabricante(fabricante.getNome());
            return ResponseEntity.status(HttpStatus.CREATED).body("Fabricante save successfully");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Failed to save Fabricante");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        boolean isDeleted = service.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Fabricante deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Fabricante fabricante) {
        boolean isUpdated = service.updateFabricante(fabricante);
        if (isUpdated) {
            return ResponseEntity.ok("Fabricante updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update Fabricante");
        }
    }
}


