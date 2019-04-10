
package muhich_indivproject;

/**
 *
 * @author Alex Jerard Muhich
 */
public class IndivMangaFrame extends javax.swing.JFrame {

    /**
     * Creates new form IndivMangaFrame
     * @param manga
     */
    public IndivMangaFrame(Manga manga) {
        initComponents();
        etISBN1.setText(manga.getIsbn());
        etTitle1.setText(manga.getTitle());
        etAuthor1.setText(manga.getAuthor());
        etVolume1.setText(manga.getVolume());
        etOwn1.setText(manga.getOwnership());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etISBN1 = new javax.swing.JTextField();
        etTitle1 = new javax.swing.JTextField();
        etAuthor1 = new javax.swing.JTextField();
        etVolume1 = new javax.swing.JTextField();
        etOwn1 = new javax.swing.JTextField();
        btnModifyManga = new javax.swing.JButton();
        ownLabel1 = new javax.swing.JLabel();
        volumeLabel1 = new javax.swing.JLabel();
        authorLabel1 = new javax.swing.JLabel();
        titleLabel1 = new javax.swing.JLabel();
        isbnLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("One Listing Found");
        setResizable(false);

        etISBN1.setEditable(false);
        etISBN1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        etISBN1.setText("9781234567890");

        etTitle1.setEditable(false);
        etTitle1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        etTitle1.setText("Dummy Manga Title");

        etAuthor1.setEditable(false);
        etAuthor1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        etAuthor1.setText("Author McAuthorstein");

        etVolume1.setEditable(false);
        etVolume1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        etVolume1.setText("5");

        etOwn1.setEditable(false);
        etOwn1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        etOwn1.setText("Yes");

        btnModifyManga.setText("Modify");
        btnModifyManga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyMangaActionPerformed(evt);
            }
        });

        ownLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ownLabel1.setText("Do I Own This?");

        volumeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volumeLabel1.setText("Volume #");

        authorLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        authorLabel1.setText("Author");

        titleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel1.setText("Title");

        isbnLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        isbnLabel1.setText("ISBN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ownLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etISBN1)
                    .addComponent(etTitle1)
                    .addComponent(etAuthor1)
                    .addComponent(etVolume1)
                    .addComponent(etOwn1)
                    .addComponent(volumeLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(authorLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(isbnLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(btnModifyManga, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(isbnLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etISBN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authorLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etAuthor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volumeLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etVolume1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ownLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etOwn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnModifyManga)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Allows the user to modify/save the values for the manga
     * @param evt 
     */
    private void btnModifyMangaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyMangaActionPerformed
        //determine what action is being taken based on the text of the button
        switch(btnModifyManga.getText()){
            case "Modify":
                //set the TextFields to be editable
                etISBN1.setEditable(true);
                etTitle1.setEditable(true);
                etAuthor1.setEditable(true);
                etVolume1.setEditable(true);
                etOwn1.setEditable(true);
                //change the text property of the button to Save
                btnModifyManga.setText("Save");
                break;
            case "Save":
                //set the Textfields to be uneditable
                etISBN1.setEditable(false);
                etTitle1.setEditable(false);
                etAuthor1.setEditable(false);
                etVolume1.setEditable(false);
                etOwn1.setEditable(false);
                btnModifyManga.setText("Modify");
                //TODO: update the database with the changes
                break;
        }
        
        
        
    }//GEN-LAST:event_btnModifyMangaActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException |
                 InstantiationException |
                 IllegalAccessException | 
                 javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndivMangaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new IndivMangaFrame(new Manga(null, null, null, null, null)).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel1;
    private javax.swing.JButton btnModifyManga;
    private javax.swing.JTextField etAuthor1;
    private javax.swing.JTextField etISBN1;
    private javax.swing.JTextField etOwn1;
    private javax.swing.JTextField etTitle1;
    private javax.swing.JTextField etVolume1;
    private javax.swing.JLabel isbnLabel1;
    private javax.swing.JLabel ownLabel1;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JLabel volumeLabel1;
    // End of variables declaration//GEN-END:variables
}
