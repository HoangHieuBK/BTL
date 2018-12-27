/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.CauHoi;
import models.CauHoiTracNghiem;
import models.CauHoiTuLuan;
import models.DapAn;
import models.MonHoc;

/**
 *
 * @author DANG TRUNG ANH
 */
public class SoanCauHoi extends javax.swing.JFrame {
    
    //-----Các model để set các danh sách-------
    private DefaultComboBoxModel modelDanhSachChuong = new DefaultComboBoxModel();
    private DefaultTableModel modelCauHoi = new DefaultTableModel();
    private DefaultListModel modelDapAn;
    
    //-----Danh sách các câu hỏi trắc nghiệm, tự luận hiện tại, cần lưu ra file------
    private ArrayList<CauHoiTracNghiem> listTracNghiem = new ArrayList<>();
    private ArrayList<CauHoiTuLuan> listTuLuan = new ArrayList<>();
    private int sizeOfArrayTracNghiem = 0; //----Kích thước của danh sách các câu trắc nghiệm
    
    //----Loại câu hỏi, vị trí câu hỏi đang được chọn------
    private CauHoi selectedCauHoi; //Đánh dấu
    
    //----Thông tin đáp án đang được chọn (câu hỏi trắc nghiệm) -----
//    private String selectedDapAn;
    private int selectedIndexDapAn;
    
    //
    private boolean chonThemCauHoi; //Đánh dấu khi ấn button "thêm câu hỏi"
    private CauHoiTracNghiem tempTracNghiem; // Đánh dấu câu trắc nghiệm tạm thời chưa lưu
    private CauHoiTuLuan tempTuLuan; // Đánh dấu câu tự luận tạm thời chưa lưu
    
    //Danh sách các đáp án tạm thời chưa lưu, đang được cập nhật
    private ArrayList<DapAn> dsDapAn = new ArrayList<>();
    
    MonHoc monHocSelected;
    private ArrayList<MonHoc> listMonHoc = new ArrayList<>();
    
    //==========================
    /**
     * Creates new form SoanCauHoi
     */
    public SoanCauHoi(MonHoc monHocSelected) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Soạn câu hỏi");
        this.monHocSelected = monHocSelected;
        readDanhSachMonHoc();
        createData();
        hienThiDanhSachCauHoi();
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        WindowAdapter adapter = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Press Window Closing");
                int result = JOptionPane.showConfirmDialog(SoanCauHoi.this,
                        "Nếu chưa ấn OK, kết quả sẽ không được lưu, tiếp tục thoát?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        };
        addWindowListener(adapter);
        //--------------------------------
        this.setResizable(false);
        danhSachDoKho.setSelectedIndex(0);
        danhSachChuong.setSelectedIndex(0);
        danhSachDapAn.setSelectionMode(DefaultListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // thiết lập chế độ chọn được nhiều giá trị cùng 1 lúc
        
    }
    
    public SoanCauHoi() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Soạn câu hỏi");
    }
    
    private void createData() {
        modelCauHoi.addColumn("Loại câu hỏi");
        modelCauHoi.addColumn("Mã học phần");
        modelCauHoi.addColumn("Chương");
        modelCauHoi.addColumn("Độ khó");
        danhSachCauHoi.setModel(modelCauHoi);
        
        listTracNghiem = monHocSelected.getDsCauHoiTN();
        listTuLuan = monHocSelected.getDsCauHoiTL();
        
        tuLuanRadioButton.setEnabled(false);
        tracNghiemRadioButton.setEnabled(false);
        deBai.setEnabled(false);
        danhSachDapAn.setEnabled(false);
        themDapAn.setEnabled(false);
        chinhSuaDapAn.setEnabled(false);
        xoaDapAn.setEnabled(false);
        coTheXaoTronDuoc.setEnabled(false);
        goiYDapAn.setEnabled(false);
        
        btnSua.setEnabled(false);
        luuCauHoi.setEnabled(false);
        xoaCauHoi.setEnabled(false);
        
        for(int i=1;i<=monHocSelected.getSoChuong();++i) {
            modelDanhSachChuong.addElement("Chương "+i);
        }
        danhSachChuong.setModel(modelDanhSachChuong);

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupTuLuanTracNhiem = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("src\\anh\\soancauhoi.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tuLuanRadioButton = new javax.swing.JRadioButton();
        tracNghiemRadioButton = new javax.swing.JRadioButton();
        txtDeBai = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        deBai = new javax.swing.JTextArea();
        cacLuaChonDapAn = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        danhSachDapAn = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        goiYDapAn = new javax.swing.JTextArea();
        ThemCauHoi = new javax.swing.JButton();
        coTheXaoTronDuoc = new javax.swing.JCheckBox();
        themDapAn = new javax.swing.JButton();
        chinhSuaDapAn = new javax.swing.JButton();
        xoaDapAn = new javax.swing.JButton();
        luuCauHoi = new javax.swing.JButton();
        xoaCauHoi = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        danhSachDoKho = new javax.swing.JComboBox<>();
        danhSachChuong = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        danhSachCauHoi = new javax.swing.JTable();
        txtGoiYDapAn = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        okButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/select.png"))); // NOI18N
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Danh sách câu hỏi:");

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Dạng câu hỏi: ");

        groupTuLuanTracNhiem.add(tuLuanRadioButton);
        tuLuanRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tuLuanRadioButton.setText("Tự luận");
        tuLuanRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuLuanRadioButtonActionPerformed(evt);
            }
        });

        groupTuLuanTracNhiem.add(tracNghiemRadioButton);
        tracNghiemRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tracNghiemRadioButton.setText("Trắc nghiệm");
        tracNghiemRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tracNghiemRadioButtonActionPerformed(evt);
            }
        });

        txtDeBai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDeBai.setForeground(new java.awt.Color(0, 0, 204));
        txtDeBai.setText("Đề bài: ");

        deBai.setColumns(20);
        deBai.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        deBai.setRows(5);
        jScrollPane2.setViewportView(deBai);

        cacLuaChonDapAn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cacLuaChonDapAn.setForeground(new java.awt.Color(0, 0, 204));
        cacLuaChonDapAn.setText("Các lựa chọn đáp án");

        danhSachDapAn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        danhSachDapAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                danhSachDapAnMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(danhSachDapAn);

        goiYDapAn.setColumns(20);
        goiYDapAn.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        goiYDapAn.setRows(5);
        jScrollPane4.setViewportView(goiYDapAn);

        ThemCauHoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ThemCauHoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/them.png"))); // NOI18N
        ThemCauHoi.setText("Thêm");
        ThemCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemCauHoiActionPerformed(evt);
            }
        });

        coTheXaoTronDuoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        coTheXaoTronDuoc.setText("Có thể xáo trộn được");

        themDapAn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        themDapAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/themda.png"))); // NOI18N
        themDapAn.setText("Thêm đáp án");
        themDapAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themDapAnActionPerformed(evt);
            }
        });

        chinhSuaDapAn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chinhSuaDapAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/suada.png"))); // NOI18N
        chinhSuaDapAn.setText("Sửa đáp án");
        chinhSuaDapAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chinhSuaDapAnActionPerformed(evt);
            }
        });

        xoaDapAn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        xoaDapAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/xoada.png"))); // NOI18N
        xoaDapAn.setText("Xóa đáp án");
        xoaDapAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaDapAnActionPerformed(evt);
            }
        });

        luuCauHoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        luuCauHoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/luu.png"))); // NOI18N
        luuCauHoi.setText("Lưu");
        luuCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luuCauHoiActionPerformed(evt);
            }
        });

        xoaCauHoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        xoaCauHoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/delete.png"))); // NOI18N
        xoaCauHoi.setText("Xóa");
        xoaCauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaCauHoiActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Độ khó");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Chương");

        danhSachDoKho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        danhSachDoKho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dễ", "Trung Bình", "Khó" }));
        danhSachDoKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                danhSachDoKhoActionPerformed(evt);
            }
        });

        danhSachChuong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        danhSachCauHoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        danhSachCauHoi.setOpaque(false);
        danhSachCauHoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                danhSachCauHoiMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(danhSachCauHoi);

        txtGoiYDapAn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtGoiYDapAn.setForeground(new java.awt.Color(0, 0, 204));
        txtGoiYDapAn.setText("Gợi ý đáp án");

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/update.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setPreferredSize(new java.awt.Dimension(99, 33));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ThemCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xoaCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(luuCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 39, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGoiYDapAn)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(chinhSuaDapAn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(themDapAn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(xoaDapAn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(coTheXaoTronDuoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
                            .addComponent(cacLuaChonDapAn)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDeBai, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tuLuanRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(tracNghiemRadioButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(danhSachDoKho, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(danhSachChuong, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tuLuanRadioButton)
                    .addComponent(tracNghiemRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDeBai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cacLuaChonDapAn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(themDapAn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chinhSuaDapAn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xoaDapAn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(coTheXaoTronDuoc))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGoiYDapAn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(danhSachDoKho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(danhSachChuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ThemCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(xoaCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(luuCauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tuLuanRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuLuanRadioButtonActionPerformed
        // TODO add your handling code here:
        if (chonThemCauHoi) {
            danhSachDapAn.setEnabled(false);
            cacLuaChonDapAn.setEnabled(false);
            themDapAn.setEnabled(false);
            chinhSuaDapAn.setEnabled(false);
            xoaDapAn.setEnabled(false);
            coTheXaoTronDuoc.setEnabled(false);
            goiYDapAn.setEnabled(true);
            txtGoiYDapAn.setEnabled(true);
        }
    }//GEN-LAST:event_tuLuanRadioButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        monHocSelected.setDsCauHoiTL(listTuLuan);
        monHocSelected.setDsCauHoiTN(listTracNghiem);
        for (MonHoc monHoc : listMonHoc) {
            if (monHoc.getTenMonHoc().equals(monHocSelected.getTenMonHoc())) {
                int index = listMonHoc.indexOf(monHoc);
                listMonHoc.set(index, monHocSelected);
                writeListMonHoc();
                JOptionPane.showMessageDialog(null, "Đã cập nhật thành công !");
            }
        } 
        this.setVisible(false);
        this.dispose();
        this.setVisible(false);
        new GiaoDienChinh();
    }//GEN-LAST:event_okButtonActionPerformed

    private void ThemCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemCauHoiActionPerformed
        // TODO add your handling code here:
        tracNghiemRadioButton.setSelected(true);
        tuLuanRadioButton.setSelected(false);
        tuLuanRadioButton.setEnabled(true);
        tracNghiemRadioButton.setEnabled(true);
        
        danhSachDapAn.setEnabled(true);
        xoaDapAn.setEnabled(true);
        chinhSuaDapAn.setEnabled(true);
        themDapAn.setEnabled(true);
        coTheXaoTronDuoc.setSelected(false);
        coTheXaoTronDuoc.setEnabled(true);
        
        xoaCauHoi.setEnabled(false);
        btnSua.setEnabled(false);
        luuCauHoi.setEnabled(true);
        
        deBai.setEnabled(true);
        deBai.setText("");
        
        goiYDapAn.setText("");
        txtGoiYDapAn.setEnabled(false);
        goiYDapAn.setEnabled(false);
        
        danhSachDoKho.setSelectedIndex(0);
        danhSachChuong.setSelectedIndex(0);
        
        //------Làm mới các danh sách tempListDapAn, modelDapAn, danhSachDapAn khi bấm thêm câu hỏi----
        chonThemCauHoi = true; //Đánh dấu là đã bấm thêm câu hỏi
        dsDapAn = new ArrayList<>(); //----Làm mới danh sách đáp án lưu tạm thời
        modelDapAn = new DefaultListModel();
        danhSachDapAn.setModel(modelDapAn);
        danhSachDapAn.setEnabled(true);
    }//GEN-LAST:event_ThemCauHoiActionPerformed

    private void tracNghiemRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tracNghiemRadioButtonActionPerformed
        // TODO add your handling code here:
        //SỰ kiện khi bấm thêm câu hỏi, mặc định là câu hỏi trắc nghiệm
        if (chonThemCauHoi) {
            danhSachDapAn.setEnabled(true);
            cacLuaChonDapAn.setEnabled(true);
            themDapAn.setEnabled(true);
            chinhSuaDapAn.setEnabled(true);
            xoaDapAn.setEnabled(true);
            coTheXaoTronDuoc.setEnabled(true);
            goiYDapAn.setEnabled(false);
            txtGoiYDapAn.setEnabled(false);
        }
    }//GEN-LAST:event_tracNghiemRadioButtonActionPerformed

    private void xoaDapAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaDapAnActionPerformed
        // TODO add your handling code here:
        if(dsDapAn.size() == 0) {
            JOptionPane.showMessageDialog(null, "Lỗi, không có dữ liệu!");
        }
        else {
            int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?", "Xóa đáp án đã chọn", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION) {
                dsDapAn.remove(selectedIndexDapAn); 
                modelDapAn = new DefaultListModel();
                for(DapAn dapAn : dsDapAn) {
                    modelDapAn.addElement(dapAn);
                }
                danhSachDapAn.setModel(modelDapAn);
                danhSachDapAn.setEnabled(false);
                luuCauHoi.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Xóa đáp án thành công!");
            }  
        }
    }//GEN-LAST:event_xoaDapAnActionPerformed

    private void luuCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luuCauHoiActionPerformed
        // TODO add your handling code here:
        if (chonThemCauHoi) {
            if (deBai.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Không được để trống phần đề bài");
                return;
            }
            if (tuLuanRadioButton.isSelected()) {
                CauHoiTuLuan tuLuan = new CauHoiTuLuan();
                tuLuan.setDeBai(deBai.getText());
                tuLuan.setGoiYDapAn(goiYDapAn.getText());
                tuLuan.setDoKho((String) danhSachDoKho.getSelectedItem());
                tuLuan.setChuong((String) danhSachChuong.getSelectedItem());
                listTuLuan.add(tuLuan);
                //--------------------------------
                JOptionPane.showMessageDialog(null, "Thêm câu hỏi tự luận thành công!");
            } else {
                CauHoiTracNghiem tracNghiem = new CauHoiTracNghiem();
                tracNghiem.setDeBai(deBai.getText());
                tracNghiem.setDapAn(dsDapAn);
                tracNghiem.setCoTheXaoTronDuoc(coTheXaoTronDuoc.isSelected());
                tracNghiem.setDoKho((String) danhSachDoKho.getSelectedItem());
                tracNghiem.setChuong((String) danhSachChuong.getSelectedItem());
                listTracNghiem.add(tracNghiem);
                //--------------------------------
                JOptionPane.showMessageDialog(null, "Thêm câu hỏi trắc nghiệm thành công!");
            }
        }
        else {
            int result = JOptionPane.showConfirmDialog(this, "Chắc chắc muốn sửa câu hỏi đã chọn?", 
                "Thông báo", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION) {
                int index = danhSachCauHoi.getSelectedRow();
                if(index < listTracNghiem.size()) {
                    suaCauTracnghiem(listTracNghiem.get(index),index);
                }
                else {
                    suaCauTuLuan(listTuLuan.get(index - listTracNghiem.size()),index - listTracNghiem.size());
                }
                JOptionPane.showMessageDialog(null, "sửa thành công");
            }
        }
        hienThiDanhSachCauHoi();
        
        luuCauHoi.setEnabled(false);
        themDapAn.setEnabled(false);
        chinhSuaDapAn.setEnabled(false);
        xoaDapAn.setEnabled(false);
        coTheXaoTronDuoc.setEnabled(false);
        tuLuanRadioButton.setEnabled(false);
        tracNghiemRadioButton.setEnabled(false);
        deBai.setEnabled(false);
        danhSachDapAn.setEnabled(false);
        goiYDapAn.setEnabled(false);
        chonThemCauHoi = false;
    }//GEN-LAST:event_luuCauHoiActionPerformed

    private void xoaCauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaCauHoiActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "Chắc chắc muốn xóa câu hỏi đã chọn?", 
                "Thông báo", JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION) {
            int index = danhSachCauHoi.getSelectedRow();
            if(index < listTracNghiem.size()) {
                listTracNghiem.remove(index);
            }
            else {
                listTuLuan.remove(index);
            }
            JOptionPane.showMessageDialog(null, "xóa thành công");
            hienThiDanhSachCauHoi();
        }
    }//GEN-LAST:event_xoaCauHoiActionPerformed

    private void themDapAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themDapAnActionPerformed
        // TODO add your handling code here:
//        if (dsDapAn != null) {
            ThemDapAn themDapAn = new ThemDapAn(-1, dsDapAn, danhSachDapAn, modelDapAn);
            themDapAn.setVisible(true);
//        } else {
//            JOptionPane.showMessageDialog(null, "Lỗi, không có dữ liệu!");
//        }
    }//GEN-LAST:event_themDapAnActionPerformed

    private void danhSachDapAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_danhSachDapAnMouseClicked
        // TODO add your handling code here:
        selectedIndexDapAn = danhSachDapAn.getSelectedIndex();
    }//GEN-LAST:event_danhSachDapAnMouseClicked

    private void chinhSuaDapAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chinhSuaDapAnActionPerformed
        // TODO add your handling code here:
//        if (dsDapAn != null) {
            ThemDapAn themDapAn = new ThemDapAn(selectedIndexDapAn, dsDapAn, danhSachDapAn, modelDapAn);
            themDapAn.setVisible(true);
//        } else {
//            JOptionPane.showMessageDialog(null, "Lỗi, không có dữ liệu!");
//        }
    }//GEN-LAST:event_chinhSuaDapAnActionPerformed

    private void danhSachCauHoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_danhSachCauHoiMouseClicked
        // TODO add your handling code here:
        xoaCauHoi.setEnabled(true);
        btnSua.setEnabled(true);
        chonThemCauHoi = false;
        int index = danhSachCauHoi.getSelectedRow();
        if(index < listTracNghiem.size()) {
            selectedCauHoi = listTracNghiem.get(index);
            layDuLieuCauTracNghiem((CauHoiTracNghiem) selectedCauHoi);
        }
        else {
            selectedCauHoi = listTuLuan.get(index - listTracNghiem.size());
            layDuLieuCauTuLuan((CauHoiTuLuan) selectedCauHoi);
        }
    }//GEN-LAST:event_danhSachCauHoiMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        deBai.setEnabled(true);
        luuCauHoi.setEnabled(true);
        int index = danhSachCauHoi.getSelectedRow();
        if(index < listTracNghiem.size()) {
            goiYDapAn.setEnabled(false);
            danhSachDapAn.setEnabled(true);
            danhSachDapAn.setEnabled(true);
            themDapAn.setEnabled(true);
            chinhSuaDapAn.setEnabled(true);
            xoaDapAn.setEnabled(true);
            coTheXaoTronDuoc.setEnabled(true);
        }
        else {
            goiYDapAn.setEnabled(true);
            danhSachDapAn.setEnabled(false);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void danhSachDoKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_danhSachDoKhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_danhSachDoKhoActionPerformed

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
            java.util.logging.Logger.getLogger(SoanCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SoanCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SoanCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SoanCauHoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SoanCauHoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ThemCauHoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JLabel cacLuaChonDapAn;
    private javax.swing.JButton chinhSuaDapAn;
    private javax.swing.JCheckBox coTheXaoTronDuoc;
    private javax.swing.JTable danhSachCauHoi;
    private javax.swing.JComboBox<String> danhSachChuong;
    private javax.swing.JList<DapAn> danhSachDapAn;
    private javax.swing.JComboBox<String> danhSachDoKho;
    private javax.swing.JTextArea deBai;
    private javax.swing.JTextArea goiYDapAn;
    private javax.swing.ButtonGroup groupTuLuanTracNhiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton luuCauHoi;
    private javax.swing.JButton okButton;
    private javax.swing.JButton themDapAn;
    private javax.swing.JRadioButton tracNghiemRadioButton;
    private javax.swing.JRadioButton tuLuanRadioButton;
    private javax.swing.JLabel txtDeBai;
    private javax.swing.JLabel txtGoiYDapAn;
    private javax.swing.JButton xoaCauHoi;
    private javax.swing.JButton xoaDapAn;
    // End of variables declaration//GEN-END:variables

    private ArrayList<DapAn> copy(ArrayList<DapAn> listDapAn) {
        ArrayList<DapAn> result = new ArrayList<>();
        for (int i = 0; i < listDapAn.size(); i++) {
            DapAn dapAn = new DapAn();
            dapAn.setNoiDung(listDapAn.get(i).getNoiDung());
            dapAn.setDapAnDung(listDapAn.get(i).isDapAnDung());
            result.add(dapAn);
        }
        return result;
    }

    private void hienThiDanhSachCauHoi() {
        modelCauHoi.setRowCount(0); // reset lại số lượng hàng ở trong bảng
        for (CauHoiTracNghiem tracNghiem : listTracNghiem) {
            Vector<Object> vec = new Vector<Object>();
            vec.add("Trắc nghiệm");
            vec.add(monHocSelected.getMaHocPhan());
            vec.add(tracNghiem.getChuong());
            vec.add(tracNghiem.getDoKho());
            modelCauHoi.addRow(vec);
        }
        
        for (CauHoiTuLuan tuLuan : listTuLuan) {
            Vector<Object> vec = new Vector<Object>();
            vec.add("Tự luận");
            vec.add(monHocSelected.getMaHocPhan());
            vec.add(tuLuan.getChuong());
            vec.add(tuLuan.getDoKho());
            modelCauHoi.addRow(vec);
        }
        
        danhSachCauHoi.setModel(modelCauHoi);
    }

    private void writeListMonHoc() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("DanhSachMonHoc.dat",false);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(listMonHoc);
            outputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private void readDanhSachMonHoc() {
        try {
            FileInputStream fileReader = new FileInputStream("DanhSachMonHoc.dat");
            ObjectInputStream inputStream = new ObjectInputStream(fileReader);
            listMonHoc = (ArrayList<MonHoc>) inputStream.readObject();
            inputStream.close();
            fileReader.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(QuanLyMonHoc.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(QuanLyMonHoc.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void suaCauTracnghiem(CauHoiTracNghiem tracNghiem, int index) {
        if (deBai.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Không được để trống phần đề bài");
            return;
        }
        tracNghiem.setDeBai(deBai.getText());
        tracNghiem.setDapAn(dsDapAn);
        tracNghiem.setCoTheXaoTronDuoc(coTheXaoTronDuoc.isSelected());
        tracNghiem.setDoKho((String) danhSachDoKho.getSelectedItem());
        tracNghiem.setChuong((String) danhSachChuong.getSelectedItem());
        listTracNghiem.set(index, tracNghiem);
    }

    private void suaCauTuLuan(CauHoiTuLuan tuLuan, int index) {
        if (deBai.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Không được để trống phần đề bài");
            return;
        }
        tuLuan.setDeBai(deBai.getText());
        tuLuan.setGoiYDapAn(goiYDapAn.getText());
        tuLuan.setDoKho((String) danhSachDoKho.getSelectedItem());
        tuLuan.setChuong((String) danhSachChuong.getSelectedItem());
//        listTuLuan.set(index, tuLuan);
    }
    
    private void layDuLieuCauTracNghiem(CauHoiTracNghiem tracNghiem) {
        tracNghiemRadioButton.setSelected(true);
        tuLuanRadioButton.setSelected(false);
        deBai.setText(tracNghiem.getDeBai());
        modelDapAn = new DefaultListModel();
        dsDapAn = tracNghiem.getDapAn();
        for(DapAn dapAn : dsDapAn) {
            modelDapAn.addElement(dapAn);
        }
        danhSachDapAn.setModel(modelDapAn);
        goiYDapAn.setText("");
        danhSachDoKho.setSelectedItem(tracNghiem.getDoKho());
        danhSachChuong.setSelectedItem(tracNghiem.getChuong());
        coTheXaoTronDuoc.setSelected(tracNghiem.isCoTheXaoTronDuoc());
    }

    private void layDuLieuCauTuLuan(CauHoiTuLuan tuLuan) {
        coTheXaoTronDuoc.setSelected(false);
        tracNghiemRadioButton.setSelected(false);
        tuLuanRadioButton.setSelected(true);
        deBai.setText(tuLuan.getDeBai());
        modelDapAn = new DefaultListModel();
        danhSachDapAn.setModel(modelDapAn);
        goiYDapAn.setText(tuLuan.getGoiYDapAn());
        danhSachDoKho.setSelectedItem(tuLuan.getDoKho());
        danhSachChuong.setSelectedItem(tuLuan.getChuong());
    }

}
