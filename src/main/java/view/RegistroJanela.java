package view;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;
import model.Usuario;

public class RegistroJanela extends JFrame{ 
    
   private DefaultTableModel tableModel;
   private JTable table;
   
   public RegistroJanela(DefaultTableModel model){
          
        super("Janela de Cadastro");
        this.tableModel = model;
        this.table = new JTable(tableModel);
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
        
        JLabel ageLabel = new JLabel("Idade: ");
        ageLabel.setBounds(50, 90, 120, 60);
        panel.add(ageLabel);
        
        JTextField ageField = new JTextField(20);
        ageField.setBounds(180, 110, 150, 20);
        panel.add(ageField);
        
        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setBounds(50, 120, 120, 60);
        panel.add(emailLabel);
                
        JTextField emailField = new JTextField(20);
        emailField.setBounds(180, 140, 150, 20);
        panel.add(emailField);
        
        JLabel passwordLabel = new JLabel("Crie uma senha: ");
        passwordLabel.setBounds(50, 150, 120, 60);
        panel.add(passwordLabel);
        
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(180, 170, 150, 20);
        panel.add(passwordField);
        
        JLabel secondPasswordLabel = new JLabel("Confirme a senha: ");
        secondPasswordLabel.setBounds(50, 180, 120, 60);
        panel.add(secondPasswordLabel);
        
        JPasswordField secondPasswordField = new JPasswordField(20);
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
            String nome_U = nameField.getText();
            String idadeStr = ageField.getText();
            int idadeTest = 0;
            String email_U = emailField.getText();
            char[] senha_U = passwordField.getPassword();
            char[] confirmacaoSenha_U = secondPasswordField.getPassword();
            
            //variáveis para usar nos sets
            String nomeUser = "";
            int idadeUser = 0;
            String emailUser = "";
           
            try {
                
            // Validar se os campos não estão vazios 
            if (nome_U.isEmpty() || idadeStr.isEmpty() || email_U.isEmpty() || senha_U.length == 0 || confirmacaoSenha_U.length == 0) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }    
            if (nome_U.length() < 2) {
                throw new Mensagens("O nome deve conter ao menos 2 caracteres.");
            } else {
               nomeUser = nameField.getText();
            }

            idadeTest = Integer.parseInt(idadeStr);
            if (idadeTest <18){
                throw new Mensagens("É necessário ter no mínimo 18 anos para se cadastrar.");
            }else{
               idadeUser = idadeTest; 
            }
            
            if (email_U.length() < 5) {
                throw new Mensagens("Email deve conter ao menos 5 caracteres.");
            } else {
               emailUser = emailField.getText();
            }
            // Validar se as senhas coincidem
            if (!Arrays.equals(senha_U,confirmacaoSenha_U)) {
                JOptionPane.showMessageDialog(null, "As senhas não coincidem.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                
                //variaveis para usar no DAO
                Usuario usuario = new Usuario();
                usuario.setNome(nomeUser);
                usuario.setSenha(new String(senha_U));
                usuario.setEmail(emailUser);
                usuario.setIdade(idadeUser);
                
                int resposta = JOptionPane.showConfirmDialog(null, "Confirma o cadastro?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
             
                        dispose();
                        
                    }
            }
             } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
             } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número na idade.");
             }
            
            }
    });
        
        
    }

     
}
