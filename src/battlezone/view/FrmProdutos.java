
package battlezone.view;

import battlezone.controller.Produto_CRUD;
import battlezone.model.Produtos_model;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Aline Buchino
 */
public class FrmProdutos extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmProdutos
     */
    public FrmProdutos() {
        initComponents();
        setFrameIcon(new ImageIcon(this.getClass().getResource("/imagens/principal/LogoSemBorda.png")));
        
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Irá listar a tabela assim que iniciar a janela Produtos
        limparCampos();
        
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() { // busca informações no banco de dados
            @Override //  sobrescrevendo um método e não criando um novo, ou seja, reescrevendo-o
            public void valueChanged(ListSelectionEvent lse) { // verifica se algum valor foi alterado
               if(tabela.getSelectedRow() != -1){ // se houver na tabela tiver pelo menos 1 registrado alterado, irá mostrar a atualização dos dados
                   atualizarDados(); // Se sim, atualiza a tabela
                   
               }
            }
        });
    }
    
    void atualizarDados(){ 
        
        int linha = tabela.getSelectedRow(); //cria-se uma variável inteira para verificar cada LINHA da tabela recebendo o nome da tabela e a linha que está selecionada
        codigo.setText(tabela.getValueAt(linha, 0).toString()); // pega o valor do campo de texto da tabela de acordo com a sua posição, como é um array, inicia-se com ZERO
        tipo.setSelectedItem(tabela.getValueAt(linha, 1).toString());
        nome.setText(tabela.getValueAt(linha, 2).toString());
        valor.setText(tabela.getValueAt(linha, 3).toString());

    }
    
    void limparCampos(){
        
        if(tabela.getSelectedRow() > -1){ 
           tabela.removeRowSelectionInterval(tabela.getSelectedRow(), tabela.getSelectedRow());
        }
        codigo.setText("");
        nome.setText("");
        tipo.setSelectedItem("TIPO DE PRODUTO");
        valor.setText("");
        Produto_CRUD.listarProduto("");
        Produto_CRUD.gerarId();
        
    }
    
    void selecionarLinha(String id){ // vai receber o ID do último registro que foi inserido
        for (int i = 0; i < tabela.getRowCount(); i++) { 
            if (id.equals(tabela.getValueAt(i, 0))){ // irá percorrer o FOR até que o ID que ele recebeu seja encontrado na tabela
                tabela.setRowSelectionInterval(i, i); // seleciona a posição da linha
                break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        valor = new app.bolivia.swing.JCTextField();
        nome = new app.bolivia.swing.JCTextField();
        codigo = new app.bolivia.swing.JCTextField();
        codigoP = new javax.swing.JLabel();
        nomeP = new javax.swing.JLabel();
        precoP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        registrar = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        limparCAMPOS = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        nomeProd = new javax.swing.JLabel();
        scrollPane1 = new java.awt.ScrollPane();
        tabelaProdutos = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setClosable(true);
        setTitle("PRODUTOS");
        setPreferredSize(new java.awt.Dimension(820, 580));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(820, 580));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(470, 140));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        valor.setBackground(new java.awt.Color(15, 164, 57));
        valor.setBorder(null);
        valor.setForeground(new java.awt.Color(255, 255, 255));
        valor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valor.setOpaque(false);
        valor.setPhColor(new java.awt.Color(255, 255, 255));
        valor.setPlaceholder("PREÇO");
        jPanel2.add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 180, 30));

        nome.setBackground(new java.awt.Color(15, 164, 57));
        nome.setBorder(null);
        nome.setForeground(new java.awt.Color(255, 255, 255));
        nome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nome.setOpaque(false);
        nome.setPhColor(new java.awt.Color(255, 255, 255));
        nome.setPlaceholder("NOME PRODUTO / SERVIÇO");
        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeKeyReleased(evt);
            }
        });
        jPanel2.add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 180, 30));

        codigo.setEditable(false);
        codigo.setBackground(new java.awt.Color(15, 164, 57));
        codigo.setBorder(null);
        codigo.setForeground(new java.awt.Color(255, 255, 255));
        codigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        codigo.setOpaque(false);
        codigo.setPhColor(new java.awt.Color(255, 255, 255));
        codigo.setPlaceholder("CÓDIGO");
        jPanel2.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 180, 30));

        codigoP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/codigoL.png"))); // NOI18N
        jPanel2.add(codigoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        nomeP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/nomeL.png"))); // NOI18N
        jPanel2.add(nomeP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        precoP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        precoP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/precoL.png"))); // NOI18N
        jPanel2.add(precoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/tipoprodutos1.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 50, 60));

        tipo.setBackground(new java.awt.Color(0, 102, 0));
        tipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tipo.setForeground(new java.awt.Color(255, 255, 255));
        tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TIPO DE PRODUTO", "INFORMATICA", "ELETRONICA", "PAPELARIA", "ASSISTENCIA", "ESCRITORIO" }));
        jPanel2.add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 180, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPÇÕES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        registrar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/registrar.png"))); // NOI18N
        registrar.setText("REGISTRAR");
        registrar.setBorder(null);
        registrar.setContentAreaFilled(false);
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registrar.setPreferredSize(new java.awt.Dimension(73, 95));
        registrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/registrar1.png"))); // NOI18N
        registrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        atualizar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/editar1.png"))); // NOI18N
        atualizar.setText("ATUALIZAR");
        atualizar.setBorder(null);
        atualizar.setContentAreaFilled(false);
        atualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        atualizar.setPreferredSize(new java.awt.Dimension(73, 95));
        atualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/editar.png"))); // NOI18N
        atualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        excluir.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/apagar1.png"))); // NOI18N
        excluir.setBorder(null);
        excluir.setContentAreaFilled(false);
        excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluir.setLabel("EXCLUIR");
        excluir.setPreferredSize(new java.awt.Dimension(73, 95));
        excluir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/apagar.png"))); // NOI18N
        excluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        limparCAMPOS.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        limparCAMPOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/limpar1.png"))); // NOI18N
        limparCAMPOS.setText("LIMPAR CAMPOS");
        limparCAMPOS.setBorder(null);
        limparCAMPOS.setContentAreaFilled(false);
        limparCAMPOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limparCAMPOS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        limparCAMPOS.setPreferredSize(new java.awt.Dimension(73, 95));
        limparCAMPOS.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/limpar.png"))); // NOI18N
        limparCAMPOS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        limparCAMPOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCAMPOSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(limparCAMPOS, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(limparCAMPOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(excluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setBackground(new java.awt.Color(15, 164, 57));
        buscar.setBorder(null);
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscar.setOpaque(false);
        buscar.setPhColor(new java.awt.Color(255, 255, 255));
        buscar.setPlaceholder("CÓDIGO / NOME");
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });
        jPanel4.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 190, 50));

        nomeProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/buscarL.png"))); // NOI18N
        jPanel4.add(nomeProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "TIPO PRODUTO", "NOME", "PREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProdutos.setViewportView(tabela);

        scrollPane1.add(tabelaProdutos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addGap(18, 18, 18)
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparCAMPOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCAMPOSActionPerformed
        limparCampos();
    }//GEN-LAST:event_limparCAMPOSActionPerformed

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
          buscar.setText(buscar.getText().toUpperCase()); // deixar tudo maiusculo
          Produto_CRUD.listarProduto(buscar.getText()); // listar usuarios do BD
    }//GEN-LAST:event_buscarKeyReleased

    private void nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyReleased
          nome.setText(nome.getText().toUpperCase());
    }//GEN-LAST:event_nomeKeyReleased
    
    boolean selecionarRegistro = false; // Começa com FALSE porque se selecionarRegistro for TRUE é pq já existe aquele registro
    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        if (selecionarRegistro){ // faz a verificação
           JOptionPane.showMessageDialog(this, "O código: " + this.codigo.getText() + "\n já está registrado.", "Usuários", 0,
           new ImageIcon (getClass().getResource("/imagens/principal/info.png"))); 
        }else{
           if (codigo.getText().equals("") || tipo.getSelectedItem().equals("TIPO DE PRODUTO") || nome.getText().equals("") || valor.equals("")){
              JOptionPane.showMessageDialog(this, "Todos os campos \n são obrigatórios", "Produtos", 0,
              new ImageIcon (getClass().getResource("/imagens/principal/info.png")));
           } else{
               Produtos_model us = new Produtos_model();
               us.setPrimaryKey(codigo.getText()); // recebe o que tiver no campo de Código
               us.setTipo(tipo.getSelectedItem().toString());
               us.setNome(nome.getText());
               us.setValor(valor.getText());
               
               int op = Produto_CRUD.registrarProduto(us); // verifica as opções dentro da classe CRUD para saber se obteve resultado ou não e executa a função registrarUsuario 
               if (op != 0){ // se sim é porque fez o registro
                   String id = codigo.getText();              
                   selecionarLinha(id);
                   JOptionPane.showMessageDialog(this, "Produto inserido com sucesso", "Produtos", 0,
                   new ImageIcon (getClass().getResource("/imagens/principal/info.png")));
                   limparCampos();
               }
           } 
        }
    }//GEN-LAST:event_registrarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        if (tabela.getRowCount()>0){ // faz a verificação para ver SE EXISTE algum registro na tabela usuário
            if(tabela.getSelectedRowCount()>0){ // se tiver algum registro que esteja SELECIONADO
                if (tipo.getSelectedItem().equals("TIPO DE PRODUTO") || nome.getText().equals("") // verificar que não há nenhum campo vazio
                        || valor.equals("")){
                JOptionPane.showMessageDialog(this, "Preencha os campos", "Produtos", 0,
                new ImageIcon (getClass().getResource("/imagens/principal/info.png")));
              
                }else if(JOptionPane.showConfirmDialog(this, "Deseja alterar o registro?", "Produto", JOptionPane.YES_NO_OPTION,0, 
                         new ImageIcon (getClass().getResource("/imagens/principal/info.png"))) == JOptionPane.YES_OPTION) {
                Produtos_model us = new Produtos_model(); 
                
                us.setPrimaryKey(codigo.getText()); 
                us.setTipo(tipo.getSelectedItem().toString());
                us.setNome(nome.getText());
                us.setValor(valor.getText());

               int opc = Produto_CRUD.atualizarProduto(us); // verifica as opções dentro da classe CRUD para saber se obteve resultado ou não e executa a função atualizarUsuario 
               if (opc != 0){ // se sim é porque atualizou
                   String id = codigo.getText();
                   selecionarLinha(id);
                   JOptionPane.showMessageDialog(this, "Registro atualizado com sucesso", "Produtos", 0,
                   new ImageIcon (getClass().getResource("/imagens/principal/info.png")));
                   limparCampos();
                }
            }
        }else{
               JOptionPane.showMessageDialog(this, "Selecione um registro", "Produtos", 0,
               new ImageIcon (getClass().getResource("/imagens/principal/info.png"))); 
            }     
        }                           
    }//GEN-LAST:event_atualizarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        if(tabela.getRowCount()>0){ // faz a verificação para ver SE EXISTE algum registro na tabela usuário
            if(tabela.getSelectedRowCount()>0){ // se tiver algum registro que esteja SELECIONADO
                if(JOptionPane.showConfirmDialog(this, "Deseja excluir o registro?", "Produto", JOptionPane.YES_NO_OPTION,0, 
                     new ImageIcon (getClass().getResource("/imagens/principal/info.png"))) == JOptionPane.YES_OPTION) {
                    
                        int linha = tabela.getSelectedRow(); // captura a linha seleciona
                        String id = tabela.getValueAt(linha, 0).toString(); // extrai o id do campo selecionado e o 0 corresponde a primeira coluna
                        int elimina = Produto_CRUD.eliminarProduto(id); // verifica as opções dentro da classe CRUD para saber se obteve resultado ou não e executa a função eliminarUsuario 
                        if(elimina !=0){ // se sim é porque excluiu
                            limparCampos();
                            JOptionPane.showMessageDialog(this, "Exclusão realizada com sucesso", "Produtos", 0,
                            new ImageIcon (getClass().getResource("/imagens/principal/info.png")));
                        }
                }
            }else{
               JOptionPane.showMessageDialog(this, "Selecione um registro", "Produtos", 0,
               new ImageIcon (getClass().getResource("/imagens/principal/info.png"))); 
            }   
        }
    }//GEN-LAST:event_excluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private app.bolivia.swing.JCTextField buscar;
    public static app.bolivia.swing.JCTextField codigo;
    private javax.swing.JLabel codigoP;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton limparCAMPOS;
    private app.bolivia.swing.JCTextField nome;
    private javax.swing.JLabel nomeP;
    private javax.swing.JLabel nomeProd;
    private javax.swing.JLabel precoP;
    private javax.swing.JButton registrar;
    private java.awt.ScrollPane scrollPane1;
    public static javax.swing.JTable tabela;
    private javax.swing.JScrollPane tabelaProdutos;
    private javax.swing.JComboBox<String> tipo;
    private app.bolivia.swing.JCTextField valor;
    // End of variables declaration//GEN-END:variables
}