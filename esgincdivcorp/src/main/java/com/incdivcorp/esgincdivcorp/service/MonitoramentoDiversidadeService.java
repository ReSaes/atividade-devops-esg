package com.incdivcorp.esgincdivcorp.service;

import com.incdivcorp.esgincdivcorp.model.MonitoramentoDiversidade;
import com.incdivcorp.esgincdivcorp.repository.MonitoramentoDiversidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MonitoramentoDiversidadeService {

    @Autowired
    private MonitoramentoDiversidadeRepository repository;


    public MonitoramentoDiversidade salvarRegistro(MonitoramentoDiversidade registro) {
        return repository.save(registro);
    }

    public List<MonitoramentoDiversidade> buscarTodos() {
        return repository.findAll();
    }

    public Optional<MonitoramentoDiversidade> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public MonitoramentoDiversidade atualizarRegistro(Long id, MonitoramentoDiversidade registroAtualizado) {
        if (repository.existsById(id)) {
            registroAtualizado.setId(id);
            return repository.save(registroAtualizado);
        }
        return null;
    }

    public void deletarRegistro(Long id) {
        repository.deleteById(id);
    }
}