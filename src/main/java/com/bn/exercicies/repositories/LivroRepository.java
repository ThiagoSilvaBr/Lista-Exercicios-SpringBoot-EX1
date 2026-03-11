package com.bn.Exercicies.repositories;

import com.bn.Exercicies.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
