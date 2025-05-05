package com.ipvc.projeto2Final.services;

import com.ipvc.projeto2Final.models.Promocao;
import com.ipvc.projeto2Final.repositories.PromocaoRepositories;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PromocaoService {
    private final PromocaoRepositories promocaoRepository;

    public PromocaoService(PromocaoRepositories promocaoRepository) {
        this.promocaoRepository = promocaoRepository;
    }

    public List<Promocao> getAllPromocoes() {
        return promocaoRepository.findAll();
    }

    public Optional<Promocao> findById(Integer id) {
        return promocaoRepository.findById(id);
    }

    public Promocao save(Promocao promocao) {
        return promocaoRepository.save(promocao);
    }

    public void delete(Integer id) {
        promocaoRepository.deleteById(id);
    }
}
