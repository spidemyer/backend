package br.senai.estoque.gerenciamentoestoque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.estoque.gerenciamentoestoque.model.funcionario;

public interface FuncionarioRepository extends JpaRepository<funcionario, Long> {
    Optional<funcionario>findByNif(String nif);
    boolean existsByNif(String nif);
    
}
