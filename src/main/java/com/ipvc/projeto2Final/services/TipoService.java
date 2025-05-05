package com.ipvc.projeto2Final.services;

import com.ipvc.projeto2Final.models.Tipo;
import com.ipvc.projeto2Final.repositories.TipoRepositories;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TipoService {
    private final TipoRepositories tipoRepository;

    public TipoService(TipoRepositories tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    public List<Tipo> getAllTipos() {
        return tipoRepository.findAll();
    }

    public Optional<Tipo> findById(Integer id) {
        return tipoRepository.findById(id);
    }

    public Tipo save(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    public void delete(Integer id) {
        tipoRepository.deleteById(id);
    }
}
