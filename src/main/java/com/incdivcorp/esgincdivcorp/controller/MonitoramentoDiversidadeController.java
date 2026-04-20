package com.incdivcorp.esgincdivcorp.controller;

import com.incdivcorp.esgincdivcorp.model.MonitoramentoDiversidade;
import com.incdivcorp.esgincdivcorp.service.MonitoramentoDiversidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/diversidade/registro")
public class MonitoramentoDiversidadeController {

    @Autowired
    private MonitoramentoDiversidadeService service;

    @PostMapping
    public ResponseEntity<MonitoramentoDiversidade> criarRegistro(
            @Valid @RequestBody MonitoramentoDiversidade registro) {
        MonitoramentoDiversidade novoRegistro = service.salvarRegistro(registro);
        return ResponseEntity.status(201).body(novoRegistro);
    }

    @GetMapping
    public List<MonitoramentoDiversidade> listarTodos() {
        return service.buscarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonitoramentoDiversidade> atualizarRegistro(@PathVariable Long id,
            @Valid @RequestBody MonitoramentoDiversidade registro) {
        MonitoramentoDiversidade atualizado = service.atualizarRegistro(id, registro);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRegistro(@PathVariable Long id) {
        service.deletarRegistro(id);
        return ResponseEntity.noContent().build();
    }
}