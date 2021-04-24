package GUI;

import BackendCode.Booking;
import BackendCode.Item;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author @AbdullahShahid01
 */
public class Parent_JFrame {

    private static JFrame MainFrame;
    private final JMenuBar menu_Bar;
    private final JMenu File, ItemMenu, CustomerMenu,  HelpMenu;
    private final JMenuItem Exit, addItem, updateItem, removeItem, ViewUnbookedItems, ViewbookedItems,
            addCustomer, updateCustomer, removeCustomer,
            ViewJavaDoc, ViewDocumentation, About;

    public Parent_JFrame() {
        MainFrame = new JFrame("Lease-A-Item Management System");
        MainFrame.setSize(1366, 730);
        MainFrame.setVisible(true);

                
        MainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        MainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to terminate the program.\n"
                        + " Are you sure you want to continue ?", "Close Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
                if (showConfirmDialog == 0) {
                    System.exit(0);
                }
            }
        });

        menu_Bar = new JMenuBar();

        File = new JMenu("File");
        ItemMenu = new JMenu("Items");
        CustomerMenu = new JMenu("Customer");
        HelpMenu = new JMenu("Help");

        Exit = new JMenuItem("Exit");
        addItem = new JMenuItem("Add Item");
        updateItem = new JMenuItem("Update Item");
        removeItem = new JMenuItem("Remove Item");
        ViewbookedItems = new JMenuItem("View booked Items");
        ViewUnbookedItems = new JMenuItem("View Unbooked Items");

        addCustomer = new JMenuItem("Add Customer");
        updateCustomer = new JMenuItem("Update Customer");
        removeCustomer = new JMenuItem("Remove  Customer");

        ViewJavaDoc = new JMenuItem("View JavaDoc");
        ViewDocumentation = new JMenuItem("View Documentation");
        About = new JMenuItem("About");

        File.add(Exit);
        ItemMenu.add(addItem);
        ItemMenu.add(updateItem);
        ItemMenu.add(removeItem);
        ItemMenu.add(ViewbookedItems);
        ItemMenu.add(ViewUnbookedItems);

        CustomerMenu.add(addCustomer);
        CustomerMenu.add(updateCustomer);
        CustomerMenu.add(removeCustomer);

        HelpMenu.add(ViewJavaDoc);
        HelpMenu.add(ViewDocumentation);
        HelpMenu.add(About);

        menu_Bar.add(File);
        menu_Bar.add(ItemMenu);
        menu_Bar.add(CustomerMenu);
        menu_Bar.add(HelpMenu);

        MainFrame.setJMenuBar(menu_Bar);

        Exit.addActionListener(new Parent_JFrame_ActionListner());
        addItem.addActionListener(new Parent_JFrame_ActionListner());
        updateItem.addActionListener(new Parent_JFrame_ActionListner());
        removeItem.addActionListener(new Parent_JFrame_ActionListner());
        ViewbookedItems.addActionListener(new Parent_JFrame_ActionListner());
        ViewUnbookedItems.addActionListener(new Parent_JFrame_ActionListner());

        addCustomer.addActionListener(new Parent_JFrame_ActionListner());
        updateCustomer.addActionListener(new Parent_JFrame_ActionListner());
        removeCustomer.addActionListener(new Parent_JFrame_ActionListner());

        ViewJavaDoc.addActionListener(new Parent_JFrame_ActionListner());
        ViewDocumentation.addActionListener(new Parent_JFrame_ActionListner());
        About.addActionListener(new Parent_JFrame_ActionListner());

    }

    public static JFrame getMainFrame() {
        return MainFrame;
    }

    private class Parent_JFrame_ActionListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Exit": {
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to terminate the program.\n"
                            + " Are you sure you want to continue ?", "Close Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
                    if (showConfirmDialog == 0) {
                        System.exit(0);
                    }
                }
                break;
                case "Add Item": {
                    Parent_JFrame.getMainFrame().setEnabled(false);
                    Item_Add ac = new Item_Add();
                    ac.setVisible(true);
                }
                break;
                case "Update Item": {
                    Parent_JFrame.getMainFrame().setEnabled(false);
                    Item_Update ac = new Item_Update();
                    ac.setVisible(true);
                }
                break;
                case "Remove Item": {
                    Parent_JFrame.getMainFrame().setEnabled(false);
                    Item_Remove ac = new Item_Remove();
                    ac.setVisible(true);
                }
                break;
                case "View booked Items": {
                    ArrayList<Item> SearchBookedItems_Array = Booking.getBookedItems();
                    String result = "";
                    if (!SearchBookedItems_Array.isEmpty()) {
                        for (int i = 0; i < SearchBookedItems_Array.size(); i++) {
                            result += (i + 1) + " : " + SearchBookedItems_Array.get(i) + "\n";
                        }
                    } else {
                        result = "No Items are Booked !";
                    }
                    JOptionPane.showMessageDialog(null, result);
                }
                break;
                case "View Unbooked Items": {
                    ArrayList<Item> SearchUnBookedItems_Array = Booking.getUnbookedItems();
                    String result = "";
                    if (!SearchUnBookedItems_Array.isEmpty()) {
                        for (int i = 0; i < SearchUnBookedItems_Array.size(); i++) {
                            result += (i + 1) + " : " + SearchUnBookedItems_Array.get(i) + "\n";
                        }
                    } else {
                        result = "No UnBooked Items are available !";
                    }
                    JOptionPane.showMessageDialog(null, result);
                }
                break;
                case "Add Customer": {
                    Parent_JFrame.getMainFrame().setEnabled(false);
                    Customer_Add aco = new Customer_Add();
                    aco.frame.setVisible(true);
                }
                break;
                case "Update Customer": {
                    Parent_JFrame.getMainFrame().setEnabled(false);
                    new Customer_Update().frame.setVisible(true);
                }
                break;
                case "Remove  Customer": {
                    Parent_JFrame.getMainFrame().setEnabled(false);
                    new Customer_Remove().frame.setVisible(true);
                }
                break;

                case "View JavaDoc": {
                    if (Desktop.isDesktopSupported()) {
                        try {
                            File myFile = new File("JavaDoc_Documentation_About.pdf");
                            if (myFile.exists()) {
                                Desktop.getDesktop().open(myFile);
                            } else {
                                JOptionPane.showMessageDialog(null, "JavaDoc not found !");
                            }
                        } catch (IOException ex) {

                        }
                    }
                }
                break;
                case "View Documentation": {
                    if (Desktop.isDesktopSupported()) {
                        try {
                            File myFile = new File("JavaDoc_Documentation_About.pdf");
                            if (myFile.exists()) {
                                Desktop.getDesktop().open(myFile);
                            } else {
                                JOptionPane.showMessageDialog(null, "JavaDoc not found !");
                            }
                        } catch (IOException ex) {

                        }
                    }
                }
                break;
                case "About": {
                    JOptionPane.showMessageDialog(null, "THIS PROGRAM IS WRITTEN AS AN ASSIGNMENT OF OBJECT ORIENTED PROGRAMMING PROGRAMMIG!");
                }
                break;

            }
        }
    }
}
