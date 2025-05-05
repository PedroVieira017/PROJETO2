package com.ipvc.projeto2Final.repositories;

import com.ipvc.projeto2Final.models.Quartogerente;
import com.ipvc.projeto2Final.models.QuartogerenteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartogerenteRepositories extends JpaRepository<Quartogerente, QuartogerenteId> {
}
