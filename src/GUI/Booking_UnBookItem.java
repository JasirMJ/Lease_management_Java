package GUI;

import BackendCode.Booking;
import BackendCode.Item;
import BackendCode.Customer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;

/**
 *
 * @author @AbdullahShahid01
 */
public class Booking_UnBookItem extends JFrame {

    JButton UnBook_Button, Cancel_Button;
    JLabel ItemID_Label, ItemIDValidity_Label;
    JTextField ItemID_TextField;

    private Item item;

    public Booking_UnBookItem() {
        super("UnBook Item");
        setLayout(new FlowLayout());
        setSize(new Dimension(300, 145));
        setResizable(false);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Parent_JFrame.getMainFrame().setEnabled(true);
                dispose();
            }
        });

        UnBook_Button = new JButton("UnBook");
        Cancel_Button = new JButton("Cancel");

        ItemID_Label = new JLabel("Enter Item ID to be UnBooked");
        ItemIDValidity_Label = new JLabel();
        ItemID_TextField = new JTextField();

        ItemID_TextField.setPreferredSize(new Dimension(240, 22));
        ItemIDValidity_Label.setPreferredSize(new Dimension(415, 9));

        UnBook_Button.setPreferredSize(new Dimension(100, 22));
        Cancel_Button.setPreferredSize(new Dimension(100, 22));

        ItemIDValidity_Label.setForeground(Color.red);

        add(ItemID_Label);
        add(ItemID_TextField);
        add(ItemIDValidity_Label);

        add(UnBook_Button);
        add(Cancel_Button);

        UnBook_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String itemID = ItemID_TextField.getText().trim();
                if (!itemID.isEmpty()) {
                    try {
                        if (Integer.parseInt(itemID) > 0) {
                            ItemIDValidity_Label.setText("");
                            item = Item.SearchByID(Integer.parseInt(itemID));
                            if (item != null) {
                                if (item.isRented()) {
                                    ItemIDValidity_Label.setText("");
                                } else {
                                    item = null;
                                    JOptionPane.showMessageDialog(null, "This item is not booked !");
                                }
                            } else {
                                item = null;
                                JOptionPane.showMessageDialog(null, "Item ID does not exists !");
                            }
                        } else {
                            itemID = null;
                            ItemIDValidity_Label.setText("                                                            "
                                    + "ID cannot be '0' or negative !");
                        }
                    } catch (NumberFormatException ex) {
                        itemID = null;
                        ItemIDValidity_Label.setText("                                                            "
                                + "Invalid ID !");
                    }
                } else {
                    itemID = null;
                    ItemIDValidity_Label.setText("                                                            "
                            + "Enter Item ID !");
                }

                if (itemID != null && item != null) {
                    setEnabled(false);
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to UnBook this Item\n" + item.toString()
                            + "\n Are you sure you want to continue ??", "UnBook Confirmation", OK_CANCEL_OPTION);
                    if (showConfirmDialog == 0) {

                        ArrayList<Booking> booking = Booking.SearchByItemID(Integer.parseInt(itemID));
                        Booking last = booking.get((booking.size() - 1));
                        last.setReturnTime(System.currentTimeMillis());
                        last.Update();

                        int bill = last.calculateBill(); 
                        
                        Customer customer = last.getCustomer();
                        customer.setBill(customer.getBill()+bill);
                        customer.Update();
                        
                        Parent_JFrame.getMainFrame().getContentPane().removeAll();
                        Booking_Details cd = new Booking_Details();
                        Parent_JFrame.getMainFrame().add(cd.getMainPanel());
                        Parent_JFrame.getMainFrame().getContentPane().revalidate();
                        JOptionPane.showMessageDialog(null, "Item Successfully UnBooked !");
                        Parent_JFrame.getMainFrame().setEnabled(true);
                        dispose();
                    } else {
                        setEnabled(true);
                    }
                }
            }
        }
        );
        Cancel_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Parent_JFrame.getMainFrame().setEnabled(true);
                dispose();
            }
        });
    }

}
