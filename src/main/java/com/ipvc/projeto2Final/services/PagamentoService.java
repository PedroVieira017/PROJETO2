package com.ipvc.projeto2Final.services;

import com.ipvc.projeto2Final.models.Pagamento;
import com.ipvc.projeto2Final.repositories.PagamentoRepositories;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {
    private final PagamentoRepositories pagamentoRepository;

    public PagamentoService(PagamentoRepositories pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public List<Pagamento> getAllPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> findById(Integer id) {
        return pagamentoRepository.findById(id);
    }

    public Pagamento save(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public void delete(Integer id) {
        pagamentoRepository.deleteById(id);
    }
}
