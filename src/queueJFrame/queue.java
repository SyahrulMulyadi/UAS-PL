/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//ini adalah package yang berfungsi untuk mempermudah memaketkan method dalam program
package queueJFrame;

//ini cara untuk mengambil fungsi bawaan pada java yaitu mengambil(import linkedlist)
import java.util.LinkedList;
//ini cara untuk mengambil fungsi bawaan pada java yaitu mengambil(import linkedlist)
import java.util.Queue;
//dan ini cara mengimport dan menggunakan fungsi pane di java swing
import javax.swing.JOptionPane;

/**
 *
 * @author MSI GAMING
 */
//ini adalah class queue yang extends ke kelas utama
public class queue extends javax.swing.JFrame {
    /**
     * Creates new form queue
     */
    
    //proses untuk membuat objek queue baru bernama antrian pada fungsi linkedlist
    Queue<Object> antrian = new LinkedList<>();
    //memberi nilai ke variabel nomor dengan nilai 0
    int nomor = 0;
    
    // disini semua kita menginsialisasikan method yang telah buat
    //jadi method yang ada dipanggil dan diinisialsikan pada acceess modifier public queue
    public queue() {
        //untuk eksekusi perintah pada method initcomponents lansung ketika program dijalankan
        initComponents();
        //ini perintah untuk membuat sebuah judul
        setTitle("Antrian");
        //untuk eksekusi perintah pada method inisialisasi
         inisialisasi();
    }
     //ini adalah method inisialisasi dan hanya berisi text pada variabel text yang ada pada form
    private void inisialisasi(){
         /*pada lbJumlahAntrian berisikan nilai 0 karena ini adalah default ketika tidak ada aktivitas pada program antrian
        jika telah ada maka akan berisi nilai jumlah antrian yang sedang berjalan
        */
        lbJmlAntrian.setText("0");
        /*ini juga berisikan nilai default karena belum ada aktivitas pada program antrian ini, dia akan berubah menjadi nilai 
        yang ada ketika antrian sudah dimulai, contoh sudah ada antrian 1 maka dia akan berubah menjadi total yang ada pada
        atrian*/
        lbTotalAntrian.setText("0");
        lbPanggilAntrian.setText("-----");
        //kode dibawah ini hanya string dan huruf pada tampilan aplikasi
        txtAtas.setText("RS PERMATA HATI");
        txtAtas1.setText("Jl. JENDERAL SUDIRMAN");
        txtAtas2.setText("Kecamatan Mandau, Riau 28784");
        txtAtas3.setText("Senin, 28 Juni 2021");
        txtAtas4.setText("Nomor Antrian");
        txtAtas5.setText("--------");
        txtAtas6.setText("Silahkan menunggu");
        txtAtas7.setText("--------");
    }
    
    //ini nerupakan method tambah Antrian
    /*
    
    jadi pada method ini terdapat proses menambah jumlah antrian pada aplikasi
    
    */
    //disini kita munggunakan access modifier private karena dengan menggunanakan accces ini kita hanya
    //dapat mengakses method ini hanya pada class queue ini saja tidak dapat diakses pada class lainnya
    private void tambahAntrian(){
        //pada kode ini nanti kita akan melakukan perulangan pada nomor antrian 
        //karena setiap ada data yang masuk/data baru yang keluar kode ini akan melakukan perulangan 
        //pada nomor selanjutnya
        nomor++;
        //pada bagian ini kita membuat variabel dengan nama antr yang berisi type data String
        //lalu dimasukkan dengan variable nomor diatas
        String antr = "Antrian "+nomor;
        //pada bagian kode ini kita menambahkan nilai pada variable antr yang sudah dibuat diatas tadi
        //pada bagian kode ini kita menggunakan salah satu bagian dari algortima linkedlist
        //yakni add, jadi add berfungsi untuk menambahkan data pada sebuah nilai variable
        //disini pada variable antr yang sudah dibuat diatas tadi.
        antrian.add(antr);
        //pada bagian kode berikut ini kita membuat sebuah variable lagi dengan nama cvt dengan type data string
        //lalu kita kembalikan nilai yang ada pada antrian sebagai string yang telah ditentukan yang awalnya adalah integer
        //dan mendapat kan panjang string yang telah di convert tadi pada method valueOf
        String cvt = String.valueOf(antrian.size());
        //kode ini akan mengubah secara langsung pada setText nilai jumlah antrian yang didapat tadi
        lbJmlAntrian.setText(cvt);
        //pada kode berikut ini kita akan melihat data teratas dengan menggunakan method bawaan pada queue tersebut yakni 
        //method bawaan peek(untuk meliha data teratas pada sebuah statck)
        /* 
        Jadi pada program ini terdapat beberapa algoritma didalamnya termasuk stack, jadi ketika data yang ada akan di
        cek dengab peek pada sebuah stack maupun queue
        */
        lbPanggilAntrian.setText(""+antrian.peek());
        //kode ini akan mengubah nilai total antrian pada text yang ada pada gui
        lbTotalAntrian.setText(""+nomor);
        //ini merupakah salah satu method dari class StringBuffer yang fungsinya untuk menambahkan nilai
        //pada variable antr sehingga nilai akan terupdate/bertambah setiap ada perubahan penambahan data
        txtAntrian.append(antr + "\n");
        // ini hanya text yang ada pada gui hanya untuk memperbagus tampilan pada gui yang dibuat
        txtAtas3.setText("Senin, 28 Juni 2021");
        txtAtas4.setText("Nomor Antrian");
        txtAtas5.setText("  " + nomor);
        txtAtas6.setText("Silahkan menunggu " + cvt + " Antrian Lagi ");
        txtAtas7.setText("Mohon untuk bersabar");
    }
    
    //sama dengan method sebelumnya, pada method ini digunakan access modified private agar dapat digunakan dalam 
    //satu class yang sama saja, alasan penggunaan access modified ini adalah agar class lain tidak dapat mengakses dan alasan keamanan 
    private void prosesAntrian(){
        //pada kode program ini menggunakan salah satu method pada queue yakni isEmpty disini
        //menggunakan pengecekan data apakah nilai antrian tersebut bernilai null atau kosong
        if(antrian.isEmpty()){
            //jika bernilai kosong/null/empty maka akan menampilkan prompt, berikut ini dapat digunakan
            //karena telah mengimport java swing di awal
            JOptionPane.showMessageDialog(this, "Ambil Nomor antrian terlebih dahulu !");
        }
        //disini terdapat sebuah variable txtAntrian yang bernilai kosong karena 
        //dalam antrian harus bernilai kosong sebelum di inputkan nilai untuk pertama kali tentunya
        txtAntrian.setText("");
        /* 
       poll untuk mengatur banyaknya antrian yang dibuat sehingga dapat mengeksekusi 
        hingga queue antrian yang paling akhir */
        antrian.poll();
        //antrian tadi yang sudah diisi akan dilakukan looping dengan menggunakan forEach loop
        //maka semakin banyak antrian maka akan terjadi looping sebanyak data yang masuk diawal
        antrian.forEach((Object element) -> {
            //pada proses ini akan melooping nilai yang ada di dalam forEach itu sendiri
            //dan pada proses ini akan menambahkan data yang secara otomatis sebanyak nilai antrian/queue yang 
            //dimasukkan, ini masih menggunakan class Buffer untuk menambahkan data dengan keyword append
            txtAntrian.append("" + element + "\n");
        });
        //disini masih terdapat pengecekan apakah antrian tersebut masih kosong dengan method bawaan queue itu
        //yakni empty jika masih kosong
        if(antrian.isEmpty()){
            //jika kosong akan menampilka --- pada jlabel nopanggil
            lbPanggilAntrian.setText("-----");
        }else{
            //jika data tidak kosong maka akan menggunakan fungsi peek kembali
            //untuk mengecek apakah data yang masuk sudah sesuai dengan sistem queue itu sendiri
            //Jadi queue itu yang masuk pertama akan keluar yang pertama juga sesuai dengan prinsip antrian
            lbPanggilAntrian.setText(""+antrian.peek());
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

        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAntrian = new java.awt.TextArea();
        jPanel5 = new javax.swing.JPanel();
        lbTotalAntrian = new javax.swing.JLabel();
        lbPanggilAntrian = new javax.swing.JLabel();
        btnProsesAntrian = new javax.swing.JButton();
        btnAmbilNomorAntrian = new javax.swing.JButton();
        lbJmlAntrian = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtAtas = new javax.swing.JLabel();
        txtAtas1 = new javax.swing.JLabel();
        txtAtas2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtAtas3 = new javax.swing.JLabel();
        txtAtas4 = new javax.swing.JLabel();
        txtAtas5 = new javax.swing.JLabel();
        txtAtas6 = new javax.swing.JLabel();
        txtAtas7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));

        jLabel4.setText("Daftar Antrian");

        jScrollPane2.setViewportView(txtAntrian);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

        lbTotalAntrian.setBackground(new java.awt.Color(255, 255, 255));
        lbTotalAntrian.setForeground(new java.awt.Color(51, 51, 51));
        lbTotalAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotalAntrian.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        lbPanggilAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPanggilAntrian.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        btnProsesAntrian.setForeground(new java.awt.Color(102, 204, 0));
        btnProsesAntrian.setText("Proses Antrian");
        btnProsesAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesAntrianActionPerformed(evt);
            }
        });

        btnAmbilNomorAntrian.setForeground(new java.awt.Color(102, 204, 0));
        btnAmbilNomorAntrian.setText("Ambil Nomor Antrian");
        btnAmbilNomorAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmbilNomorAntrianActionPerformed(evt);
            }
        });

        lbJmlAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbJmlAntrian.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Loket");

        jLabel6.setText("Mesin Antrian");

        jLabel1.setText("Jumlah Antrian");

        jLabel2.setText("Total Antrian");

        jLabel3.setText("Panggilan Nomor Antrian");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtAtas.setText("jLabel10");

        txtAtas1.setText("jLabel11");

        txtAtas2.setText("jLabel12");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAtas1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(txtAtas2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAtas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAtas2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAtas1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtAtas3.setText("jLabel13");

        txtAtas4.setText("jLabel14");

        txtAtas5.setText("jLabel15");

        txtAtas6.setText("jLabel16");

        txtAtas7.setText("jLabel17");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAtas3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAtas4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAtas6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAtas7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAtas5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtAtas3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAtas4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAtas5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAtas6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAtas7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(lbJmlAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(btnAmbilNomorAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbPanggilAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnProsesAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(jLabel3))
                                    .addComponent(lbTotalAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(194, 194, 194)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbJmlAntrian, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTotalAntrian, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(btnAmbilNomorAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPanggilAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnProsesAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProsesAntrianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesAntrianActionPerformed
        prosesAntrian();        // TODO add your handling code here:
    }//GEN-LAST:event_btnProsesAntrianActionPerformed

    private void btnAmbilNomorAntrianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmbilNomorAntrianActionPerformed
        tambahAntrian();        // TODO add your handling code here:
    }//GEN-LAST:event_btnAmbilNomorAntrianActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(queue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(queue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(queue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(queue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new queue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAmbilNomorAntrian;
    private javax.swing.JButton btnProsesAntrian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbJmlAntrian;
    private javax.swing.JLabel lbPanggilAntrian;
    private javax.swing.JLabel lbTotalAntrian;
    private java.awt.TextArea txtAntrian;
    private javax.swing.JLabel txtAtas;
    private javax.swing.JLabel txtAtas1;
    private javax.swing.JLabel txtAtas2;
    private javax.swing.JLabel txtAtas3;
    private javax.swing.JLabel txtAtas4;
    private javax.swing.JLabel txtAtas5;
    private javax.swing.JLabel txtAtas6;
    private javax.swing.JLabel txtAtas7;
    // End of variables declaration//GEN-END:variables
}
