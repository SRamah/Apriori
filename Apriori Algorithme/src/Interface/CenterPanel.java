/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author salaheddine
 */
public class CenterPanel extends javax.swing.JPanel {

    /**
     * Creates new form CenterPanel
     */
    
    
    public JPanel visionBody1 = new JPanel();
    public JPanel visionBody2 = new JPanel();
    
    
    public JPanel addBodyPanel1 = new JPanel();
    public JPanel addBodyPanel2 = new JPanel();
    
    
    public CenterPanel() {
        initComponents();
    }

    
    public JPanel CenterPanel(JPanel p) {
        initComponents();
        CenterBodyPanel1();
        CenterBodyPanel2();
        
        jPanelBody.add(visionBody1, java.awt.BorderLayout.CENTER);
        jPanelBody.revalidate();
        
        p.add("Center", this);
        return p;
    }
    
    
    
    public void CenterBodyPanel1(){
        
        
        addBodyPanel1.setVisible(true);
        
        
        addBodyPanel1.setLayout(new BorderLayout());
       
        
        /////***** Creation d'un Objet de type classe JPanel ******//////
        BodyPanel1 addbody = new BodyPanel1();
        /////***** Appel au Constricteur Surcharger de la classe JPanal et le REVALIDER *****//////
        addbody.BodyPanel1(addBodyPanel1).revalidate();
        
        /////***** Fixé la taille du Zone où le nouveau JPanel sera placer dans JFrame *****//////
        
        visionBody1.setLayout(new BorderLayout());
        visionBody1.add(addBodyPanel1, java.awt.BorderLayout.CENTER);
	/////***** Refaire le dessin de la JFrame ******//////
        this.repaint();
        /////***** Afficher la JFrame ******//////
        setVisible(true);
    
    }
    
    
    public void CenterBodyPanel2(){
        
       
        addBodyPanel2.setVisible(true);
        
        addBodyPanel2.setLayout(new BorderLayout());
       
        
        /////***** Creation d'un Objet de type classe JPanel ******//////
        BodyPanel2 addbody = new BodyPanel2();
        /////***** Appel au Constricteur Surcharger de la classe JPanal et le REVALIDER *****//////
        addbody.BodyPanel2(addBodyPanel2).revalidate();
        
        /////***** Fixé la taille du Zone où le nouveau JPanel sera placer dans JFrame *****//////
        
        visionBody2.setLayout(new BorderLayout());
        visionBody2.add(addBodyPanel2, java.awt.BorderLayout.CENTER);
	/////***** Refaire le dessin de la JFrame ******//////
        this.repaint();
        /////***** Afficher la JFrame ******//////
        setVisible(true);
    
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCenter = new javax.swing.JPanel();
        jPanelBody = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanelCenter.setLayout(new java.awt.BorderLayout());

        jPanelBody.setPreferredSize(new java.awt.Dimension(877, 498));
        jPanelBody.setLayout(new java.awt.BorderLayout());
        jPanelCenter.add(jPanelBody, java.awt.BorderLayout.CENTER);

        jPanelMenu.setBackground(new java.awt.Color(98, 183, 232));
        jPanelMenu.setPreferredSize(new java.awt.Dimension(100, 498));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Algo. Apriori");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("About");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(370, Short.MAX_VALUE))
        );

        jPanelCenter.add(jPanelMenu, java.awt.BorderLayout.WEST);

        add(jPanelCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        visionBody2.setVisible(false);
        visionBody1.setVisible(true);
        jPanelBody.add(visionBody1, java.awt.BorderLayout.CENTER);
        jPanelBody.revalidate();
        this.repaint();
        setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        visionBody1.setVisible(false);
        visionBody2.setVisible(true);
        jPanelBody.add(visionBody2, java.awt.BorderLayout.CENTER);
        jPanelBody.revalidate();
         this.repaint();
        setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelCenter;
    private javax.swing.JPanel jPanelMenu;
    // End of variables declaration//GEN-END:variables
}
