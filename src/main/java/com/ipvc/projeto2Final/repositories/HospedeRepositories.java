package com.ipvc.projeto2Final.repositories;

import com.ipvc.projeto2Final.models.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HospedeRepositories extends JpaRepository<Hospede, Integer> {
    Optional<Hospede> findByEmail(String email);   // 👈 novo
}
