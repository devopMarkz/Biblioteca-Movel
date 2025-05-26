package io.github.devopMarkz.library_system.repositories;

import io.github.devopMarkz.library_system.model.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {
}
