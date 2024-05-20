package com.jrs.LocadoraSpring.controller;

import com.jrs.LocadoraSpring.entity.Cliente;
import com.jrs.LocadoraSpring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAllClientes() {
        List<Cliente> clientes = service.findAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findClienteById(@PathVariable Long id){
        Cliente cliente = service.findClienteById(id);
        if(cliente != null){
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente not found with id: " +id);
        }
    }

    @PostMapping
    public ResponseEntity<String> saveCliente(@RequestBody Cliente cliente){
        try{
            service.createCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body("CLiente saved successfully");
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body("Failed to save Cliente");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(Long id){
        boolean isDeleted = service.deleteById(id);
        if(isDeleted) {
            return ResponseEntity.ok("Cliente deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<String> updateCliente(@RequestBody Cliente cliente){
        boolean isUpdate = service.updateCliente(cliente);
        if(isUpdate){
        return ResponseEntity.ok("Cliente updated successfuly");
        } else {
            return ResponseEntity.badRequest().body("Failed to update Cliente");
        }
    }
}
