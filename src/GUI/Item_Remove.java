package GUI;

import BackendCode.Item;
import BackendCode.Item;
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
public class Item_Remove extends JFrame {

    JButton Remove_Button, Cancel_Button;
    JLabel ItemID_Label, ItemIDValidity_Label;
    JTextField ItemID_TextField;

    private Item item;

    public Item_Remove() {
        super("Remove Item");
        setLayout(new FlowLayout());
        setSize(new Dimension(300, 140));
        setResizable(false);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Parent_JFrame.getMainFrame().setEnabled(true);
                dispose();
            }
        });

        Remove_Button = new JButton("Remove");
        Cancel_Button = new JButton("Cancel");

        ItemID_Label = new JLabel("Enter Item ID to be removed");
        ItemIDValidity_Label = new JLabel();
        ItemID_TextField = new JTextField();

        ItemID_TextField.setPreferredSize(new Dimension(240, 22));
//        ItemID_Label.setPreferredSize(new Dimension(175, 22));
        ItemIDValidity_Label.setPreferredSize(new Dimension(415, 9));
        Remove_Button.setPreferredSize(new Dimension(100, 22));
        Cancel_Button.setPreferredSize(new Dimension(100, 22));

        ItemIDValidity_Label.setForeground(Color.red);

        add(ItemID_Label);
        add(ItemID_TextField);
        add(ItemIDValidity_Label);

        add(Remove_Button);
        add(Cancel_Button);

        Remove_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemID = ItemID_TextField.getText().trim();
                if (!itemID.isEmpty()) {
                    try {
                        if (Integer.parseInt(itemID) > 0) {
                            ItemIDValidity_Label.setText("");
//                            if (itemID != null) {
                            Item item = Item.SearchByID(Integer.parseInt(itemID));
                            if (item != null) {
                                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to remove this item \n "
                                        + item.toString() + "\n Are you sure you want to continue ??", "Confirmation",
                                        JOptionPane.OK_CANCEL_OPTION);
                                if (showConfirmDialog == 0) {
                                    item.Remove();
                                    Parent_JFrame.getMainFrame().getContentPane().removeAll();
                                    Item_Details cd = new Item_Details();
                                    Parent_JFrame.getMainFrame().add(cd.getMainPanel());
                                    Parent_JFrame.getMainFrame().getContentPane().revalidate();
                                    
                                    Parent_JFrame.getMainFrame().setEnabled(true);
                                    dispose();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Item ID not found !");
                            }
                        } else {
                            itemID = null;
                            ItemIDValidity_Label.setText("ID cannot be '0' or negative !");
                        }
                    } catch (NumberFormatException ex) {
                        itemID = null;
                        ItemIDValidity_Label.setText("Invalid ID !");
                    }
                } else {
                    itemID = null;
                    ItemIDValidity_Label.setText("Enter Item ID !");
                }
                /*ID, Maker, Name, Colour, Type, SeatingCapacity, Model, Condition, RegNo, RentPerHour, IsRented RentDate, ItemItem, customer*/

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
