package com.ipvc.projeto2Final.services;

import com.ipvc.projeto2Final.models.Quartogerente;
import com.ipvc.projeto2Final.models.QuartogerenteId;
import com.ipvc.projeto2Final.repositories.QuartogerenteRepositories;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuartogerenteService {
    private final QuartogerenteRepositories quartoGerenteRepository;

    public QuartogerenteService(QuartogerenteRepositories quartoGerenteRepository) {
        this.quartoGerenteRepository = quartoGerenteRepository;
    }

    public List<Quartogerente> getAllQuartogerentes() {
        return quartoGerenteRepository.findAll();
    }

    public Optional<Quartogerente> findById(QuartogerenteId id) {
        return quartoGerenteRepository.findById(id);
    }

    public Quartogerente save(Quartogerente quartoGerente) {
        return quartoGerenteRepository.save(quartoGerente);
    }

    public void delete(QuartogerenteId id) {
        quartoGerenteRepository.deleteById(id);
    }
}
