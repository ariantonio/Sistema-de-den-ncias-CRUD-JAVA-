package controller;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;
public class AutenticacaoService {
    private List<Usuario> usuarios;

    public AutenticacaoService() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("usuario", "senha"));
        // Adicione outros usuários, se necessário
    }

    public Usuario autenticar(String nomeUsuario, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }
}
