package UI;

import Controller.storeOperations;
import Entity.Store;
import Service.StoreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class TabTest {

    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTabbedPane storeTab;
    private JList list_storeName;
    private JButton btn_deleteStore;
    private JButton btn_editStoreTap;
    private JButton btn_selectStore;
    private JButton btn_newStoreTab;
    private JTextField tf_storeNew_storeName;
    private JTextField tf_storeNew_Name;
    private JTextField tf_storeNew_Family;
    private JTextField tf_storeNew_Tell;
    private JTextField tf_storeNew_Mail;
    private JButton btn_insertNewStore;
    private JTextField tf_storeEdit_storeName;
    private JTextField tf_storeEdit_Name;
    private JTextField tf_storeEdit_Family;
    private JTextField tf_storeEdit_Tell;
    private JTextField tf_storeEdit_Mail;
    private JButton btn_editStore;
    private JPanel storeTabEdit;
    private JPanel storeTabNew;
    private JPanel storeTabSelect;
    private JLabel lbl_storeEdit_storeName;
    private JLabel lbl_storeEdit_Name;
    private JLabel lbl_storeEdit_Family;
    private JLabel lbl_storeEdit_Tell;
    private JLabel lbl_storeEdit_Mail;
    private JLabel lbl_storeNew_storeName;
    private JLabel lbl_storeNew_Name;
    private JLabel lbl_storeNew_Family;
    private JLabel lbl_storeNew_Tell;
    private JLabel lbl_storeNew_Mail;
    private JButton انصرافButton;
    private JButton انصرافButton1;


    private int storeEditId;
    private List<String> storeName;

    private TabTest() {

        setTabIconAndTextPosition();

        list_storeName.setCellRenderer(new DefaultListCellRenderer() {
            public int getHorizontalAlignment() {
                return RIGHT;
            }
        });


        ApplicationContext ctx = new AnnotationConfigApplicationContext(Dao.JPAconfig.class);
        StoreService storeService = ctx.getBean(StoreService.class);


        storeOperations storeOperations = new storeOperations();


        list_storeName.setModel(storeOperations.showStoreName());

        list_storeName.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!list_storeName.isSelectionEmpty()) {
                    btn_deleteStore.setEnabled(true);
                    btn_editStoreTap.setEnabled(true);
                    btn_selectStore.setEnabled(true);
                }
            }
        });

        btn_deleteStore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                storeOperations.Delete(list_storeName.getSelectedValue().toString());
                list_storeName.setModel(storeOperations.showStoreName());
            }
        });


        btn_editStoreTap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Store storeEdit = storeOperations.editStore(list_storeName.getSelectedValue().toString());
                storeEditId = storeEdit.getId();
                tf_storeEdit_storeName.setText(storeEdit.getStoreName());
                tf_storeEdit_Name.setText(storeEdit.getName());
                tf_storeEdit_Family.setText(storeEdit.getFamily());
                tf_storeEdit_Tell.setText(storeEdit.getTell());
                tf_storeEdit_Mail.setText(storeEdit.getMail());
                storeTab.setEnabledAt(2, true);
                storeTab.setSelectedIndex(2);
                storeName = storeService.getAllStoreName();

            }
        });


        btn_editStore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                boolean storeNameIsEmpty = tf_storeEdit_storeName.getText().isEmpty();
                boolean storeNameIsRepetitive = storeName.contains(tf_storeEdit_storeName.getText());
                boolean NameIsEmpty = tf_storeEdit_Name.getText().isEmpty();
                boolean FamilyIsEmpty = tf_storeEdit_Family.getText().isEmpty();
                boolean TellIsEmpty = tf_storeEdit_Tell.getText().isEmpty();
                boolean TellIsWrong = !(tf_storeEdit_Tell.getText().matches("^09+[1-3]{1}+[0-9]{8}$"));
                boolean MailIsEmpty = tf_storeEdit_Mail.getText().isEmpty();
                boolean MailIsWrong = !(tf_storeEdit_Mail.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,6}$"));


                lbl_storeEdit_storeName.setText((storeNameIsEmpty) ? "نام فروشگاه را وارد کنید" : "");
                lbl_storeEdit_storeName.setText((!storeNameIsEmpty && storeNameIsRepetitive) ? "نام فروشگاه تکراری است" : lbl_storeEdit_storeName.getText());

                lbl_storeEdit_Name.setText((NameIsEmpty) ? "نام را وارد کنید" : "                                        ");

                lbl_storeEdit_Family.setText((FamilyIsEmpty) ? "نام خانوادگی را وارد کنید" : "                                        ");

                lbl_storeEdit_Tell.setText((TellIsEmpty) ? "شماره تماس را وارد کنید" : "                                        ");
                lbl_storeEdit_Tell.setText((!TellIsEmpty && TellIsWrong) ? "شماره تماس به درستی وارد نشده است" : lbl_storeEdit_Tell.getText());

                lbl_storeEdit_Mail.setText((MailIsEmpty) ? "ایمیل را وارد کنید" : "                                        ");
                lbl_storeEdit_Mail.setText((!MailIsEmpty && MailIsWrong) ? "ایمیل به درستی وارد نشده است" : lbl_storeEdit_Mail.getText());


                if (!storeNameIsEmpty && !storeNameIsRepetitive && !NameIsEmpty && !FamilyIsEmpty && !TellIsEmpty && !TellIsWrong && !MailIsEmpty && !MailIsWrong) {
                    System.out.println(storeEditId);
                    Store t = storeService.getSoreById(storeEditId);
                    t.setStoreName(tf_storeEdit_storeName.getText());
                    t.setName(tf_storeEdit_Name.getText());
                    t.setFamily(tf_storeEdit_Family.getText());
                    t.setTell(tf_storeEdit_Tell.getText());
                    t.setMail(tf_storeEdit_Mail.getText());

                    storeOperations.Update(t);


                    list_storeName.setModel(storeOperations.showStoreName());
                    lbl_storeEdit_storeName.setText("                                        ");
                    lbl_storeEdit_Name.setText("                                        ");
                    lbl_storeEdit_Family.setText("                                        ");
                    lbl_storeEdit_Tell.setText("                                        ");
                    lbl_storeEdit_Mail.setText("                                        ");
                    storeTab.setSelectedIndex(0);
                }

            }
        });

        btn_newStoreTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                storeTab.setSelectedIndex(1);
                storeName = storeService.getAllStoreName();
            }
        });
        btn_insertNewStore.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                boolean storeNameIsEmpty = tf_storeNew_storeName.getText().isEmpty();
                boolean storeNameIsRepetitive = storeName.contains(tf_storeNew_storeName.getText());
                boolean NameIsEmpty = tf_storeNew_Name.getText().isEmpty();
                boolean FamilyIsEmpty = tf_storeNew_Family.getText().isEmpty();
                boolean TellIsEmpty = tf_storeNew_Tell.getText().isEmpty();
                boolean TellIsWrong = !(tf_storeNew_Tell.getText().matches("^09+[1-3]{1}+[0-9]{8}$"));
                boolean MailIsEmpty = tf_storeNew_Mail.getText().isEmpty();
                boolean MailIsWrong = !(tf_storeNew_Mail.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,6}$"));


                lbl_storeNew_storeName.setText((storeNameIsEmpty) ? "نام فروشگاه را وارد کنید" : "");
                lbl_storeNew_storeName.setText((!storeNameIsEmpty && storeNameIsRepetitive) ? "نام فروشگاه تکراری است" : lbl_storeNew_storeName.getText());

                lbl_storeNew_Name.setText((NameIsEmpty) ? "نام را وارد کنید" : "                                        ");

                lbl_storeNew_Family.setText((FamilyIsEmpty) ? "نام خانوادگی را وارد کنید" : "                                        ");

                lbl_storeNew_Tell.setText((TellIsEmpty) ? "شماره تماس را وارد کنید" : "                                        ");
                lbl_storeNew_Tell.setText((!TellIsEmpty && TellIsWrong) ? "شماره تماس به درستی وارد نشده است" : lbl_storeNew_Tell.getText());

                lbl_storeNew_Mail.setText((MailIsEmpty) ? "ایمیل را وارد کنید" : "                                        ");
                lbl_storeNew_Mail.setText((!MailIsEmpty && MailIsWrong) ? "ایمیل به درستی وارد نشده است" : lbl_storeNew_Mail.getText());


                if (!storeNameIsEmpty && !storeNameIsRepetitive && !NameIsEmpty && !FamilyIsEmpty && !TellIsEmpty && !TellIsWrong && !MailIsEmpty && !MailIsWrong) {
                    storeOperations.Add(tf_storeNew_storeName.getText(),
                            tf_storeNew_Name.getText(),
                            tf_storeNew_Family.getText(),
                            tf_storeNew_Tell.getText(),
                            tf_storeNew_Mail.getText());

                    list_storeName.setModel(storeOperations.showStoreName());
                    lbl_storeNew_storeName.setText("                                        ");
                    lbl_storeNew_Name.setText("                                        ");
                    lbl_storeNew_Family.setText("                                        ");
                    lbl_storeNew_Tell.setText("                                        ");
                    lbl_storeNew_Mail.setText("                                        ");
                    storeTab.setSelectedIndex(0);
                }
            }
        });
        storeTab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                storeName = storeService.getAllStoreName();
            }
        });
    }

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        JFrame frame = new JFrame("myApp");
        frame.setContentPane(new TabTest().panel1);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.isLocationByPlatform();


    }

    private void setTabIconAndTextPosition() {
        JLabel storeTabSelectlbl = new JLabel();
        storeTabSelectlbl.setText("لیست فروشگاه ها");
//        storeTab2.setFont(new Font(null , Font.PLAIN, 16));   // set font and size for label
        storeTabSelectlbl.setHorizontalTextPosition(SwingConstants.LEFT);
        storeTabSelectlbl.setIcon(new ImageIcon("src/Image/List-tab-Light.png"));
        storeTabSelectlbl.setIconTextGap(10);
        storeTab.setTabComponentAt(0, storeTabSelectlbl);

        JLabel storeTabNewlbl = new JLabel();
        storeTabNewlbl.setText("ثبت فروشگاه جدید");
        storeTabNewlbl.setHorizontalTextPosition(SwingConstants.LEFT);
        storeTabNewlbl.setIcon(new ImageIcon("src/Image/Add-tab-Light.png"));
        storeTabNewlbl.setIconTextGap(10);
        storeTab.setTabComponentAt(1, storeTabNewlbl);

        JLabel storeTabEditlbl = new JLabel();
        storeTabEditlbl.setText("ویرایش");
        storeTabEditlbl.setHorizontalTextPosition(SwingConstants.LEFT);
        storeTabEditlbl.setIcon(new ImageIcon("src/Image/Edit-tab-Light.png"));
        storeTabEditlbl.setIconTextGap(10);
        storeTab.setTabComponentAt(2, storeTabEditlbl);
    }
}