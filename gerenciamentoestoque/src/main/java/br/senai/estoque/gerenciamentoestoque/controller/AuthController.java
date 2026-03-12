package br.senai.estoque.gerenciamentoestoque.controller;

import br.senai.estoque.gerenciamentoestoque.model.funcionario;
import br.senai.estoque.gerenciamentoestoque.repository.FuncionarioAutenticadoRepository;
import br.senai.estoque.gerenciamentoestoque.repository.FuncionarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private FuncionarioRepository funcionarioRepo;

    @Autowired
    private FuncionarioAutenticadoRepository autenticadoRepo;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String nif, 
                        @RequestParam String senha, 
                        HttpSession session, 
                        Model model) {
        
        var funcionarioOpt = funcionarioRepo.findByNif(nif);

        if (funcionarioOpt.isPresent() && funcionarioOpt.get().getSenha().equals(senha)) {
            session.setAttribute("usuarioLogado", true);
            session.setAttribute("nif", nif);
            return "redirect:/app";
        }

        model.addAttribute("erro", "NIF ou senha inválidos.");
        return "auth/login";
    }

    @GetMapping("/cadastro")
    public String cadastroPage() {
        return "auth/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastro(@RequestParam String nome, 
                           @RequestParam String nif, 
                           @RequestParam String senha, 
                           Model model) {
        
        // 1. Verifica se já existe conta
        if (funcionarioRepo.existsByNif(nif)) {
            model.addAttribute("erro", "Este NIF já possui uma conta cadastrada.");
            return "auth/cadastro";
        }

        // 2. Verifica se está autorizado na "lista branca"
        if (!autenticadoRepo.existsByNifAndNomeAndAtivoTrue(nif, nome)) {
            model.addAttribute("erro", "Dados não autorizados. Verifique seu NIF e Nome.");
            return "auth/cadastro";
        }

        // 3. Salva o novo funcionário
        funcionario novo = new funcionario();
        novo.setNome(nome);
        novo.setNif(nif);
        novo.setSenha(senha);
        funcionarioRepo.save(novo);

        model.addAttribute("sucesso", "Conta criada com sucesso! Faça seu login.");
        return "auth/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}