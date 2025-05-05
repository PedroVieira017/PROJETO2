package com.ipvc.projeto2Final.services;

import com.ipvc.projeto2Final.models.Gerente;
import com.ipvc.projeto2Final.repositories.GerenteRepositories;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {
    private final GerenteRepositories gerenteRepository;

    public GerenteService(GerenteRepositories gerenteRepository) {
        this.gerenteRepository = gerenteRepository;
    }

    public List<Gerente> getAllGerentes() {
        return gerenteRepository.findAll();
    }

    public Optional<Gerente> findById(Integer id) {
        return gerenteRepository.findById(id);
    }

    public Gerente save(Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    public void delete(Integer id) {
        gerenteRepository.deleteById(id);
    }
}
