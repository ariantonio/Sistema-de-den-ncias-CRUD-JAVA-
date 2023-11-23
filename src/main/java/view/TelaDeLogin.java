package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.table.DefaultTableModel;

public class TelaDeLogin extends JFrame{
    
     public TelaDeLogin(){
        
        JFrame frame = new JFrame("Tela de Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setShape(new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 30, 30));
        
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        // Cor de fundo do painel
        panel.setBackground(new Color(240, 240, 240));

        JLabel titleLabel = new JLabel("Bem-Vindo!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(190, 20, 200, 30);
        panel.add(titleLabel);

        JLabel usernameLabel = new JLabel("Nome de Usuário:");
        usernameLabel.setBounds(50, 60, 120, 60);
        panel.add(usernameLabel);

        JTextField usernameField = new JTextField(20);
        usernameField.setBounds(180, 80, 150, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(50, 100, 120, 60);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(180, 120, 150, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(200, 160, 110, 30);
        // Cores de fundo e texto do botão
        loginButton.setBackground(new Color(0, 128, 255)); // Azul
        loginButton.setForeground(Color.WHITE);
        panel.add(loginButton);
        
        JButton exitButton = new JButton("Sair");
        exitButton.setBounds(390, 420, 100, 30);
        exitButton.setBackground(new Color(0,0,0));
        exitButton.setForeground(Color.WHITE);
        panel.add(exitButton);
        
        JButton registerButton = new JButton("Cadastre-se");
        registerButton.setBounds(200, 200, 110, 20);
        registerButton.setForeground(Color.GRAY);
        panel.add(registerButton);
        
        JButton govButton = new JButton("Sou funcionário do governo");
        govButton.setBounds(10,420, 190, 30);
        govButton.setBackground(new Color(0,0,0));
        govButton.setForeground(Color.WHITE);
        panel.add(govButton);
        
    
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                // Faça a validação aqui (substitua isso pela lógica real de autenticação)
                if (username.isEmpty() || password.length == 0){
                JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");
            }
                if (username.equals("usuario") && String.valueOf(password).equals("senha")) {
                    JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Nome de usuário ou senha incorretos.");
                }
                usernameField.setText("");
                passwordField.setText("");
               
            }
        });
        
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
            });
        
        registerButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               DefaultTableModel tableModel = new DefaultTableModel();
               RegistroJanela cadastro = new RegistroJanela(tableModel);        
        }
        });
        
        govButton.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e){
               frame.dispose();
               FuncGoverno funcionario = new FuncGoverno();
           }
        });

        frame.setVisible(true);
    }
     public static void main(String[] args){

    TelaDeLogin login = new TelaDeLogin();
}
}
