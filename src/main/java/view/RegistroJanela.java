package view;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroJanela extends JFrame{ 
   public RegistroJanela(){
          
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
        
        JLabel ageLabel = new JLabel("Data de nascimento ");
        ageLabel.setBounds(50, 90, 120, 60);
        panel.add(ageLabel);
        
        JTextField ageField = new JTextField(20);
        ageField.setBounds(180, 110, 150, 20);
        panel.add(ageField);
        
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 120, 120, 60);
        panel.add(emailLabel);
                
        JTextField emailField = new JTextField(20);
        emailField.setBounds(180, 140, 150, 20);
        panel.add(emailField);
        
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
        
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(10, 300, 100, 30);
        cancelButton.setBackground(new Color(0,0,0));
        cancelButton.setForeground(Color.WHITE);
        panel.add(cancelButton);
    
        JButton finallyButton = new JButton("Finalizar");
        finallyButton.setBounds(280, 300, 100, 30);
        finallyButton.setBackground(new Color(0,0,0));
        finallyButton.setForeground(Color.WHITE);
        panel.add(finallyButton);
        
        cancelButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                new TelaDeLogin();
                
                }
        });
        
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
   
            
            if (resposta == JOptionPane.YES_OPTION) {

            dispose();
                }
            }
    });
    
    }

     
}
