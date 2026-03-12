package br.senai.estoque.gerenciamentoestoque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.estoque.gerenciamentoestoque.model.FuncionarioAutenticado;


public interface FuncionarioAutenticadoRepository extends JpaRepository<FuncionarioAutenticado, Long> {
    Optional<FuncionarioAutenticado> findByNifAndAtivoTrue(String nif);
    boolean existsByNifAndNomeAndAtivoTrue(String nif, String nome);
}
