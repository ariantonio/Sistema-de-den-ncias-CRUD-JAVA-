/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.JavaCRUD;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.UserDAO;
import model.User;
/**
 *
 * @author arian
 */
public class RegistroPolitico extends JFrame{
    public RegistroPolitico(){
        super("Janela de Cadastro");
        setSize(400, 400);
        
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);
        
        panel.setBackground(new Color(240,240,240));
        
        JLabel titleLabel = new JLabel("Cadastre-se!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(150, 20, 200, 30);
        panel.add(titleLabel);
        
        JLabel nameLabel = new JLabel("Nome:");
        nameLabel.setBounds(50, 60, 120, 60);
        panel.add(nameLabel);
             
        JTextField nameField = new JTextField(20);
        nameField.setBounds(180, 80, 150, 20);
        panel.add(nameField);
        
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 90, 120, 60);
        panel.add(emailLabel);
                
        JTextField emailField = new JTextField(20);
        emailField.setBounds(180, 110, 150, 20);
        panel.add(emailField);
        
        JLabel filiacaoLabel = new JLabel("Partido filiado: ");
        filiacaoLabel.setBounds(50, 120, 120, 60);
        panel.add(filiacaoLabel);
        
        JTextField filiacaoField = new JTextField(20);
        filiacaoField.setBounds(180, 140, 150, 20);
        panel.add(filiacaoField);
        
        JLabel passwordLabel = new JLabel("Crie uma senha: ");
        passwordLabel.setBounds(50, 150, 120, 60);
        panel.add(passwordLabel);
        
        JTextField passwordField = new JTextField(20);
        passwordField.setBounds(180, 170, 150, 20);
        panel.add(passwordField);
        
        JLabel secondPasswordLabel = new JLabel("Confirme a senha: ");
        secondPasswordLabel.setBounds(50, 180, 120, 60);
        panel.add(secondPasswordLabel);
        
        JTextField secondPasswordField = new JTextField(20);
        secondPasswordField.setBounds(180, 200, 150, 20);
        panel.add(secondPasswordField);
        
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela ao clicar em fechar
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
    
        JButton finallyButton = new JButton("Finalizar");
        finallyButton.setBounds(280, 300, 100, 30);
        finallyButton.setBackground(new Color(0,0,0));
        finallyButton.setForeground(Color.WHITE);
        panel.add(finallyButton);
        
        finallyButton.addActionListener(new ActionListener(){
        
         @Override
            public void actionPerformed(ActionEvent e){
               // Obter os dados dos campos de texto
            String nome = nameField.getText();
            String email = emailField.getText();
            String senha = passwordField.getText();
            String confirmacaoSenha = secondPasswordField.getText();
            
            // Validar se os campos não estão vazios 
            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmacaoSenha.isEmpty()) {
             JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar se as senhas coincidem
            if (!senha.equals(confirmacaoSenha)) {
            JOptionPane.showMessageDialog(null, "As senhas não coincidem.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
            }
            int resposta = JOptionPane.showConfirmDialog(null, "Confirma o cadastro?", "Confirmação", JOptionPane.YES_NO_OPTION);
            
            UserDAO userDAO = new UserDAO();
            // Configurar os dados no objeto User
            User user = new User();
            user.setNome(nome);
            user.setEmail(email);
            user.setSenha(senha);
            
            if (resposta == JOptionPane.YES_OPTION) {
                
            userDAO.save(user);    
            // Fechar a janela
            dispose();
                }
            }
    });
    
    }

     
}
        

