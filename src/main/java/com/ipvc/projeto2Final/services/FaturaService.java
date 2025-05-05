package com.ipvc.projeto2Final.services;

import com.ipvc.projeto2Final.models.Fatura;
import com.ipvc.projeto2Final.repositories.FaturaRepositories;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FaturaService {
    private final FaturaRepositories faturaRepository;

    public FaturaService(FaturaRepositories faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public List<Fatura> getAllFaturas() {
        return faturaRepository.findAll();
    }

    public Optional<Fatura> findById(Integer id) {
        return faturaRepository.findById(id);
    }

    public Fatura save(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    public void delete(Integer id) {
        faturaRepository.deleteById(id);
    }
}
