package GUI;

import BackendCode.Booking;
import BackendCode.Item;
import BackendCode.Customer;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author @AbdullahShahid01
 */
public class Booking_BookItem extends JFrame {

    JButton Book_Button, Cancel_Button;
    JLabel ItemID_Label, ItemIDValidity_Label, CustomerID_Label, CustomerIDValidity_Label;
    JTextField ItemID_TextField, CustomerID_TextField;

    private Item item;
    private Customer customer;

    public Booking_BookItem() {
        super("Book Item");
        setLayout(new FlowLayout());
        setSize(new Dimension(300, 200));
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

        Book_Button = new JButton("Book");
        Cancel_Button = new JButton("Cancel");

        ItemID_Label = new JLabel("Enter Item ID to be Booked");
        ItemIDValidity_Label = new JLabel();
        ItemID_TextField = new JTextField();

        CustomerID_Label = new JLabel("Enter Customer ID");
        CustomerIDValidity_Label = new JLabel();
        CustomerID_TextField = new JTextField();

        ItemID_TextField.setPreferredSize(new Dimension(240, 22));
        ItemIDValidity_Label.setPreferredSize(new Dimension(240, 9));

        CustomerID_TextField.setPreferredSize(new Dimension(240, 22));
        CustomerIDValidity_Label.setPreferredSize(new Dimension(240, 9));

        Book_Button.setPreferredSize(new Dimension(100, 22));
        Cancel_Button.setPreferredSize(new Dimension(100, 22));

        ItemIDValidity_Label.setForeground(Color.red);
        CustomerIDValidity_Label.setForeground(Color.red);

        add(ItemID_Label);
        add(ItemID_TextField);
        add(ItemIDValidity_Label);

        add(CustomerID_Label);
        add(CustomerID_TextField);
        add(CustomerIDValidity_Label);

        add(Book_Button);
        add(Cancel_Button);

        Book_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ItemID = ItemID_TextField.getText().trim();
                if (!ItemID.isEmpty()) {
                    try {
                        if (Integer.parseInt(ItemID) > 0) {
                            ItemIDValidity_Label.setText("");
                            item = Item.SearchByID(Integer.parseInt(ItemID));
                            if (item != null) {
                                if (!item.isRented()) {
                                    ItemIDValidity_Label.setText("");
                                } else {
                                    item = null;
//                                    JOptionPane.showMessageDialog(null, "This item is already booked !");
                                    ItemIDValidity_Label.setText( "This item is already booked !");
                                }
                            } else {
                                ItemID = null;
                                ItemIDValidity_Label.setText("Item ID does not exists !");
                            }
                        } else {
                            ItemID = null;
                            ItemIDValidity_Label.setText("ID cannot be '0' or negative !");
                        }
                    } catch (NumberFormatException ex) {
                        ItemID = null;
                        ItemIDValidity_Label.setText("Invalid ID !");
                    }
                } else {
                    ItemID = null;
                    ItemIDValidity_Label.setText("Enter Item ID !");
                }

                String customerID = CustomerID_TextField.getText().trim();
                if (!customerID.isEmpty()) {
                    try {
                        if (Integer.parseInt(customerID) > 0) {
                            CustomerIDValidity_Label.setText("");
                            customer = Customer.SearchByID(Integer.parseInt(customerID));
                            if (customer != null) {
                                CustomerIDValidity_Label.setText("");
                            } else {
                                customerID = null;
//                                JOptionPane.showMessageDialog(null, "Customer ID does not exists !");
                                CustomerIDValidity_Label.setText("Customer ID does not exists !");
                            }
                        } else {
                            customerID = null;
                            CustomerIDValidity_Label.setText("ID cannot be '0' or negative !");
                        }
                    } catch (NumberFormatException ex) {
                        customerID = null;
                        CustomerIDValidity_Label.setText("Invalid ID !");
                    }
                } else {
                    customerID = null;
                    CustomerIDValidity_Label.setText("Enter Customer ID !");
                }

                if (ItemID != null & customerID != null) {
                    setEnabled(false);
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null,
                            "You are about to Book the Item: \n" + item.toString() + "\n against the Customer: \n"
                            + customer.toString() + "\n Are you sure you want to continue??",
                            "Book Confirmation", JOptionPane.OK_CANCEL_OPTION);
                    if (showConfirmDialog == 0) {
                        Booking booking = new Booking(0, customer, item, System.currentTimeMillis(), 0);
                        booking.Add();
                        Parent_JFrame.getMainFrame().getContentPane().removeAll();
                        Booking_Details cd = new Booking_Details();
                        Parent_JFrame.getMainFrame().add(cd.getMainPanel());
                        Parent_JFrame.getMainFrame().getContentPane().revalidate();
                        JOptionPane.showMessageDialog(null, "Item Successfully Booked !");
                        Parent_JFrame.getMainFrame().setEnabled(true);
                        dispose();
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
