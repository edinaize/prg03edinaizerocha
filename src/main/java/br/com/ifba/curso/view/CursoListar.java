package br.com.ifba.curso.view;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoService;
import java.awt.HeadlessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@org.springframework.stereotype.Component
public class CursoListar extends javax.swing.JFrame {

    @Autowired
     CursoService service;

    @Autowired
    private ApplicationContext context;

    public CursoListar() {
        initComponents();
    }

    @jakarta.annotation.PostConstruct
    public void init() {
        configurarTabela();
        adicionarEventos();
        carregarCursos();
    }

    private void configurarTabela() {
        jTable1.getTableHeader().setBackground(new java.awt.Color(10,25,50));
        jTable1.getTableHeader().setForeground(java.awt.Color.WHITE);
        jTable1.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));

        jTable1.getColumnModel().getColumn(5).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setText("");
                try {
                    label.setIcon(new ImageIcon(getClass().getResource("/imagens/edit.png")));
                } catch(Exception e) {}
                label.setHorizontalAlignment(SwingConstants.CENTER);
                return label;
            }
        });

        jTable1.getColumnModel().getColumn(5).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {

                JLabel label = (JLabel) super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                label.setText("");
                label.setIcon(new ImageIcon(getClass().getResource("/imagens/edit.png")));
                label.setHorizontalAlignment(SwingConstants.CENTER);

                return label;
            }
        });


        jTable1.getColumnModel().getColumn(4).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {

                JLabel label = (JLabel) super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                label.setText("");
                label.setIcon(new ImageIcon(getClass().getResource("/imagens/trash.png")));
                label.setHorizontalAlignment(SwingConstants.CENTER);

                return label;
            }
        });
        
        jTable1.getColumnModel().getColumn(6).setMinWidth(0);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(6).setWidth(0);
    }

    private void adicionarEventos() {

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int row = jTable1.rowAtPoint(evt.getPoint());
                int col = jTable1.columnAtPoint(evt.getPoint());

                if (row < 0) return;

                Long id = Long.valueOf(jTable1.getValueAt(row, 6).toString());

                // EDITAR
                if (col == 5) {
                    Curso curso = buscarCursoPorId(id);
                    if (curso != null) abrirEdicao(curso);
                }

                // REMOVER
                if (col == 4) {

                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Deseja remover este curso?",
                            "Confirmação",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (confirm == JOptionPane.YES_OPTION) {
                        removerCurso(id, row);
                    }
                }
            }
        });
    }

    void carregarCursos() {
        List<Curso> cursos = service.findAll();
        preencherTabela(cursos);
    }    

    private void buscarCursos() {
        try {
            String termo = TextBuscar.getText().trim();

            List<Curso> lista;

            if (termo.isEmpty() || termo.equals("Digite aqui...")) {
                lista = service.findAll();
            } else {
                lista = service.findByNome(termo);
            }

            preencherTabela(lista);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar: " + ex.getMessage());
        }
    }

    private void preencherTabela(List<Curso> cursos) {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Curso c : cursos) {
            model.addRow(new Object[]{
                    c.getNome(),
                    c.getCargaHoraria(),
                    c.getDescricao(),
                    c.getProfessor(),
                    "",
                    "",
                    c.getId()
            });
        }
    }

    private Curso buscarCursoPorId(Long id) {
        try {
            return service.findById(id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            return null;
        }
    }

    private void abrirEdicao(Curso curso) {
        CursoSave tela = context.getBean(CursoSave.class);
    tela.configurarEdicao(this, curso);
    tela.setLocationRelativeTo(null);
    tela.setVisible(true);
    }

    private void removerCurso(Long id, int row) {
        try {
            service.delete(id);
            ((DefaultTableModel) jTable1.getModel()).removeRow(row);
            JOptionPane.showMessageDialog(this, "Removido com sucesso!");
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jPanel1 = new javax.swing.JPanel();
        TextBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBuscar = new javax.swing.JButton();
        jBtcadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(4, 61, 90));

        TextBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextBuscar.setText("Digite aqui...");
        TextBuscar.addActionListener(this::TextBuscarActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, "", "", null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NOME", "CARGA HORÁRIA", "DESCRIÇÃO", "PROFESSOR(a)", "REMOVER", "EDITAR", "ID"
            }
        ));
        jTable1.setRowHeight(35);
        jTable1.setShowGrid(false);
        jTable1.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(jTable1);

        jBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search.png"))); // NOI18N
        jBuscar.setText("Buscar");
        jBuscar.addActionListener(this::jBuscarActionPerformed);

        jBtcadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtcadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/plus.png"))); // NOI18N
        jBtcadastrar.setText("Cadastrar Novo");
        jBtcadastrar.addActionListener(this::jBtcadastrarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtcadastrar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtcadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextBuscarActionPerformed
       buscarCursos();
    }//GEN-LAST:event_TextBuscarActionPerformed

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed
       buscarCursos();
    }//GEN-LAST:event_jBuscarActionPerformed

    private void jBtcadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtcadastrarActionPerformed
       CursoSave telaSave = context.getBean(CursoSave.class);
        telaSave.setVisible(true);
    }//GEN-LAST:event_jBtcadastrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CursoListar().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextBuscar;
    private javax.swing.JButton jBtcadastrar;
    private javax.swing.JButton jBuscar;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
