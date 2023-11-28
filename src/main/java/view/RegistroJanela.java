package view;

import controller.CidadaoService;
import model.Cidadao;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;

public class RegistroJanela extends JFrame {
    public RegistroJanela() {

        super("Janela de Cadastro");
        setSize(400, 400);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        panel.setBackground(new Color(240, 240, 240));

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

        JLabel dateLabel = new JLabel("Data de Nascimento: ");
        dateLabel.setBounds(50, 90, 120, 60);
        panel.add(dateLabel);

        MaskFormatter mfdata = null;
        try {
            mfdata = new MaskFormatter("  ## / ## / ####");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JFormattedTextField dateField = new JFormattedTextField(mfdata);
        dateField.setBounds(180, 110, 150, 20);
        panel.add(dateField);

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
        cancelButton.setBackground(new Color(0, 0, 0));
        cancelButton.setForeground(Color.WHITE);
        panel.add(cancelButton);

        JButton finallyButton = new JButton("Finalizar");
        finallyButton.setBounds(280, 300, 100, 30);
        finallyButton.setBackground(new Color(0, 0, 0));
        finallyButton.setForeground(Color.WHITE);
        panel.add(finallyButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaDeLogin();

            }
        });


        finallyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Obter os dados dos campos de texto
                String nome_U = nameField.getText();
                Object value = dateField.getValue();
                String email_U = emailField.getText();
                char[] senha_U = passwordField.getPassword();
                char[] confirmacaoSenha_U = secondPasswordField.getPassword();

                //variáveis para usar nos sets
                String nomeUser = "";
                String emailUser = "";
                int idadeUser = 0;
                try {

                    // Validar se os campos não estão vazios
                    if (nome_U.isEmpty() || value == null || email_U.isEmpty() || senha_U.length == 0 || confirmacaoSenha_U.length == 0) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (nome_U.length() < 2) {
                        throw new Mensagens("O nome deve conter ao menos 2 caracteres.");
                    } else {
                        nomeUser = nameField.getText();
                    }

                    // verificar se o valor do campo de data é uma String
                    LocalDate dataNascimento;
                    if (value instanceof String string) {
                        // tentar converter a String para uma data
                        SimpleDateFormat dateFormat = new SimpleDateFormat("  dd / MM / yyyy");
                        try {
                            Date dataEntrada = dateFormat.parse(string);
                            dataNascimento = dataEntrada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            LocalDate hoje = LocalDate.now();
                            long anos = ChronoUnit.YEARS.between(dataNascimento, hoje);
                            if (anos < 18) {
                                JOptionPane.showMessageDialog(null, "É necessário ter no mínimo 18 anos para se cadastrar.", "Erro", JOptionPane.ERROR_MESSAGE);
                                return;
                            } else {
                                idadeUser = (int) anos;
                            }

                        } catch (ParseException p) {
                            throw new Mensagens("A data de nascimento é inválida.");
                        }
                    } else {
                        throw new Mensagens("A data de nascimento é inválida.");
                    }

                    if (email_U.length() < 5) {
                        throw new Mensagens("Email deve conter ao menos 5 caracteres.");
                    } else {
                        emailUser = emailField.getText();
                    }
                    // Validar se as senhas coincidem
                    if (!Arrays.equals(senha_U, confirmacaoSenha_U)) {
                        JOptionPane.showMessageDialog(null, "As senhas não coincidem.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    //variaveis para usar no DAO
                    Cidadao cidadao = new Cidadao();
                    cidadao.setNome(nomeUser);
                    cidadao.setSenha(new String(senha_U));
                    cidadao.setEmail(emailUser);
                    cidadao.setIdade(idadeUser);
                    cidadao.setData_nascimento(String.valueOf(dataNascimento));
                    CidadaoService cidadaoService = new CidadaoService();
                    int resposta = JOptionPane.showConfirmDialog(null, "Confirma o cadastro?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION && cidadaoService.registraCidadao(cidadao)) {
                        dispose();
                    }else {
                        System.out.println("Erro no registro");
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
