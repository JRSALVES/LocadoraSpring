package com.jrs.LocadoraSpring.controller;

import com.jrs.LocadoraSpring.entity.Modelo;
import com.jrs.LocadoraSpring.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    ModeloService service;

    @GetMapping
    public ResponseEntity<List<Modelo>> findAllModelos() {
        List<Modelo> modelos = service.findAllModelos();
        return new ResponseEntity<>(modelos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findModeloById(@PathVariable Long id) {
        Modelo modelo = service.findModeloById(id);
        if (modelo != null) {
            return ResponseEntity.ok(modelo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo not found with id: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<String> saveModelo(@RequestBody Modelo modelo){
        try{
            service.createModelo(modelo);
            return ResponseEntity.status(HttpStatus.CREATED).body("Modelo saved successfully");
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body("Failed to save Modelo");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        boolean isDeleted = service.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Modelo deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<String> updateModelo(@RequestBody Modelo modelo) {
        boolean isUpdated = service.updateModelo(modelo);
        if (isUpdated) {
            return ResponseEntity.ok("Modelo updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update Modelo");
        }
    }
}
