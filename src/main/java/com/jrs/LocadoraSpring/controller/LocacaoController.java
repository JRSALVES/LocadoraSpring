package com.jrs.LocadoraSpring.controller;

import com.jrs.LocadoraSpring.entity.Locacao;
import com.jrs.LocadoraSpring.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locacao")
public class LocacaoController {

    @Autowired
    LocacaoService service;

    @GetMapping
    public ResponseEntity<List<Locacao>> findAllLocacao() {
        List<Locacao> locacoes = service.findAllLocacao();
        return new ResponseEntity<>(locacoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findLocacaoById(@PathVariable Long id) {
        Locacao locacao = service.findLocacaoById(id);
        if (locacao != null) {
            return ResponseEntity.ok(locacao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Locacao not found with id: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<String> saveLocacao(@RequestBody Locacao locacao) {
        try {
            service.createLocacao(locacao);
            return ResponseEntity.status(HttpStatus.OK).body("Locacao saved successfully");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Failed to save Locacao");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        boolean isDeleted = service.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Locacao deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<String> updateLocacao(@RequestBody Locacao locacao) {
        boolean isUpdated = service.updateLocacao(locacao);
        if (isUpdated) {
            return ResponseEntity.ok("Locacao updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update Locacao");
        }
    }
}
