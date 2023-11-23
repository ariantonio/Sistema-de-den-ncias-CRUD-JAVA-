
package view;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class FuncGoverno extends JFrame{
    public FuncGoverno(){
        
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
        
        JLabel orgaoLabel = new JLabel("Orgão pertencente: ");
        orgaoLabel.setBounds(50, 120, 120, 60);
        panel.add(orgaoLabel);
        
        JTextField orgaoField = new JTextField(20);
        orgaoField.setBounds(180, 140, 150, 20);
        panel.add(orgaoField);
        
        JLabel idLabel = new JLabel("Identificação: ");
        idLabel.setBounds(50, 150, 120, 60);
        panel.add(idLabel);
        
        JTextField idField = new JTextField(20);
        idField.setBounds(180, 170, 150, 20);
        panel.add(idField);
        
        JLabel cargoLabel = new JLabel("Cargo: ");
        cargoLabel.setBounds(50, 180, 120, 60);
        panel.add(cargoLabel);
        
        JTextField cargoField = new JTextField(20);
        cargoField.setBounds(180, 200, 150, 20);
        panel.add(cargoField);
        
        JLabel passwordLabel = new JLabel("Crie uma senha: ");
        passwordLabel.setBounds(50, 210, 120, 60);
        panel.add(passwordLabel);
        
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(180, 230, 150, 20);
        panel.add(passwordField);
        
        JLabel secondPasswordLabel = new JLabel("Confirme a senha: ");
        secondPasswordLabel.setBounds(50, 240, 120, 60);
        panel.add(secondPasswordLabel);
        
        JPasswordField secondPasswordField = new JPasswordField(20);
        secondPasswordField.setBounds(180, 260, 150, 20);
        panel.add(secondPasswordField);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela ao clicar em fechar
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
    
        JButton finallyButton = new JButton("Finalizar");
        finallyButton.setBounds(280, 300, 100, 30);
        finallyButton.setBackground(new Color(0,0,0));
        finallyButton.setForeground(Color.WHITE);
        panel.add(finallyButton);
        
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(10, 300, 100, 30);
        cancelButton.setBackground(new Color(0,0,0));
        cancelButton.setForeground(Color.WHITE);
        panel.add(cancelButton);
        
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
            String orgao = orgaoField.getText();
            String identif = idField.getText();
            String cargo = cargoField.getText();
            char[] senha = passwordField.getPassword();
            char[] confirmacaoSenha = secondPasswordField.getPassword();
            
            try{
            // Validar se os campos não estão vazios 
            if (nome.isEmpty() || email.isEmpty() || orgao.isEmpty() || cargo.isEmpty() || senha.length == 0 || confirmacaoSenha.length == 0) {
             JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (nameField.getText().length() < 2) {
                throw new Mensagens("O nome deve conter ao menos 2 caracteres.");
            } else {
                nome = nameField.getText();
            }
            if (emailField.getText().length() < 5) {
                throw new Mensagens("O email deve conter ao menos 5 caracteres.");
            } else {
                email = emailField.getText();
            }
            if(orgaoField.getText().length()<2){
                throw new Mensagens("É necessário ter no mínimo ter 2 caracteres no orgao.");
            }else{
                orgao = orgaoField.getText();
            }
            if (cargoField.getText().length() < 2) {
                throw new Mensagens("Deve conter ao menos 2 caracteres no cargo.");
            } else {
                cargo = cargoField.getText();
            }
            // Validar se as senhas coincidem
            if (!Arrays.equals(senha,confirmacaoSenha)) {
                JOptionPane.showMessageDialog(null, "As senhas não coincidem.", "Erro", JOptionPane.ERROR_MESSAGE);
            }else{
                int resposta = JOptionPane.showConfirmDialog(null, "Confirma o cadastro?", "Confirmação", JOptionPane.YES_NO_OPTION);
                String convertedString = new String(senha); 
                String senhaStr = convertedString;
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
