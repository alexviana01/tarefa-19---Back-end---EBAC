

package main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroSwing {
    private JFrame frame;
    private JTextField nomeField, cpfField, modeloField, placaField;
    private JTable table;
    private DefaultTableModel tableModel;

    public CadastroSwing() {
        frame = new JFrame("Cadastro de Clientes e Carros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField(15);
        panel.add(nomeField);

        panel.add(new JLabel("CPF:"));
        cpfField = new JTextField(11);
        panel.add(cpfField);

        panel.add(new JLabel("Modelo:"));
        modeloField = new JTextField(10);
        panel.add(modeloField);

        panel.add(new JLabel("Placa:"));
        placaField = new JTextField(6);
        panel.add(placaField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrar();
            }
        });
        panel.add(cadastrarButton);

        JButton excluirButton = new JButton("Excluir Cadastro");
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirCadastro();
            }
        });
        panel.add(excluirButton);

        frame.add(panel, BorderLayout.NORTH);

        // Modelo de tabela
        tableModel = new DefaultTableModel(new String[]{"Nome", "CPF", "Modelo", "Placa"}, 0);
        table = new JTable(tableModel);
       JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void cadastrar() {
        String nome = nomeField.getText();
        String cpf = cpfField.getText();
        String modelo = modeloField.getText();
        String placa = placaField.getText();

        if (nome.isEmpty() || cpf.isEmpty() || modelo.isEmpty() || placa.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cpf.length() > 11) {
            JOptionPane.showMessageDialog(frame, "CPF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (placa.length() > 7) {
            JOptionPane.showMessageDialog(frame, "Placa inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Adicionando o cadastro à tabela
        Object[] row = {nome, cpf, modelo, placa};
        tableModel.addRow(row);

        nomeField.setText("");
        cpfField.setText("");
        modeloField.setText("");
        placaField.setText("");
    }

    private void excluirCadastro() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow); // Remove a linha selecionada
        } else {
            JOptionPane.showMessageDialog(frame, "Selecione uma linha para excluir!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroSwing());
    }
}
