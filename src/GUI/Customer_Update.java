package GUI;

import BackendCode.Customer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Customer_Update {

    JButton OK_Button, Cancel_Button;
    JLabel ID_Label, IDValidity_Label;
    JTextField ID_TextField;
    
    JFrame frame = new JFrame();
    static Customer customer; // this customer object is used in UpdateCustomer_Inner class to obtain the record for entered ID

    public Customer_Update() {
        frame.setTitle("Update Customer");
        frame.setLayout(new AbsoluteLayout());
        frame.setSize(new Dimension(450, 290));
        frame.setResizable(false);
        frame.setLocationRelativeTo(Parent_JFrame.getMainFrame());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Parent_JFrame.getMainFrame().setEnabled(true);
                frame.dispose();
            }
        });

        OK_Button = new JButton("OK");
        Cancel_Button = new JButton("Cancel");

        ID_Label = new JLabel("Enter ID to be Updated");
        IDValidity_Label = new JLabel();
        ID_TextField = new JTextField();

        ID_TextField.setPreferredSize(new Dimension(240, 22));

        ID_Label.setPreferredSize(new Dimension(175, 22));
        IDValidity_Label.setPreferredSize(new Dimension(240, 9));
        IDValidity_Label.setForeground(Color.red);
        frame.add(ID_Label, new AbsoluteConstraints(10, 5));
        frame.add(ID_TextField, new AbsoluteConstraints(195, 5));
        frame.add(IDValidity_Label, new AbsoluteConstraints(195, 30));
        frame.add(OK_Button, new AbsoluteConstraints(100, 225, 100, 22));
        frame.add(Cancel_Button, new AbsoluteConstraints(250, 225, 100, 22));

        OK_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer CO = new Customer();
                String ID = ID_TextField.getText().trim();
                if (!ID_TextField.getText().isEmpty()) {
                    if (Customer.isIDvalid(ID)) {
                        CO.setID(Integer.parseInt(ID));
                        customer = Customer.SearchByID(Integer.parseInt(ID)); // the ID of this object is used in UpdateManage_GUI_B class. that is why it is kept static
                        if (customer != null) {
                            Parent_JFrame.getMainFrame().setEnabled(false);
                            frame.dispose();
                            new UpdateCustomer_Inner().setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Required ID is not found !");
                        }
                    } else {
                        IDValidity_Label.setText("Invalid ID !");
                    }
                } else {
                    IDValidity_Label.setText("Enter ID !");
                }
            }
        });

        Cancel_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Parent_JFrame.getMainFrame().setEnabled(true);
                frame.dispose();
            }
        });
    }

    public class UpdateCustomer_Inner extends JFrame {

        JButton Update_Button, Cancel_Button;
        JLabel Name_Label,Address_Label,Contact_Label,Password_Label;
        JLabel  contactValidity_Label, NameValidity_Label, AddressValidity_Label, PasswordValidity_Label;
        JTextField Name_TextField, Contact_TextField, Address_TextField;
        
        public UpdateCustomer_Inner() {
            super("Update Customer");
            System.out.println("95");
            setLayout(new AbsoluteLayout());
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
System.out.println("98");
            setSize(new Dimension(450, 290));
            setResizable(false);
            setLocationRelativeTo(this);
            Update_Button = new JButton("Update");
            Cancel_Button = new JButton("Cancel");
System.out.println("103");
            
            Name_Label = new JLabel("Enter Name");
            Contact_Label = new JLabel("Enter Contact");
            Address_Label = new JLabel("Enter Address");

            NameValidity_Label = new JLabel();
            AddressValidity_Label = new JLabel();
            contactValidity_Label = new JLabel();
System.out.println("114");
            Name_TextField = new JTextField();
            Contact_TextField = new JTextField();
            Address_TextField = new JTextField();

            Name_TextField.setPreferredSize(new Dimension(240, 22));
            Contact_TextField.setPreferredSize(new Dimension(240, 22));
            Address_TextField.setPreferredSize(new Dimension(240, 22));
System.out.println("122");
            Name_Label.setPreferredSize(new Dimension(175, 22));
            Contact_Label.setPreferredSize(new Dimension(175, 22));
            NameValidity_Label.setPreferredSize(new Dimension(240, 9));
            contactValidity_Label.setPreferredSize(new Dimension(240, 9));
            AddressValidity_Label.setPreferredSize(new Dimension(240, 9));
            System.out.println("128");
    
            contactValidity_Label.setForeground(Color.red);
            NameValidity_Label.setForeground(Color.red);
            AddressValidity_Label.setForeground(Color.red);
System.out.println("134");
            add(Name_Label, new AbsoluteConstraints(10, 5));
            add(Name_TextField, new AbsoluteConstraints(195, 5));
            add(NameValidity_Label, new AbsoluteConstraints(195, 30));

            add(Address_Label, new AbsoluteConstraints(10, 42));
            add(Address_TextField, new AbsoluteConstraints(195, 42));
            add(AddressValidity_Label, new AbsoluteConstraints(195, 66));
System.out.println("142");
            add(Contact_Label, new AbsoluteConstraints(10, 77));
            add(Contact_TextField, new AbsoluteConstraints(195, 77));
            add(contactValidity_Label, new AbsoluteConstraints(195, 102));

            add(Update_Button, new AbsoluteConstraints(100, 225, 100, 22));
            add(Cancel_Button, new AbsoluteConstraints(250, 225, 100, 22));
System.out.println("150");
            Update_Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    String name = Name_TextField.getText().trim();
                    String contact = Contact_TextField.getText().trim();
                    String address = Address_TextField.getText().trim();
                    if (!name.isEmpty()) {
                        if (Customer.isNameValid(name)) {
                            System.out.println("valid Customer name !");
                        } else {
                            name = null;
                            NameValidity_Label.setText("Invalid Name !");
                        }
                    } else {
                        name = null;
                        NameValidity_Label.setText("Enter Name !");
                    }
                    if (contact.isEmpty()) {
                        contact = null;
                        contactValidity_Label.setText("Enter Contact Number !");
                    }
                    
                    if ( name != null && contact != null) {
                        customer = new Customer(customer.getBill(), customer.getID(), name, contact,address);
                        System.out.println(customer.toString());
                        customer.Update();
                        Parent_JFrame.getMainFrame().getContentPane().removeAll();
                        Customer_Details cd = new Customer_Details();
                        Parent_JFrame.getMainFrame().add(cd.getMainPanel());
                        Parent_JFrame.getMainFrame().getContentPane().revalidate();
                        JOptionPane.showMessageDialog(null, "Record Successfully Updated !");
                        Parent_JFrame.getMainFrame().setEnabled(true);
                        dispose();
                    }
                }
            });

            Cancel_Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Parent_JFrame.getMainFrame().setEnabled(true);
                    dispose();
                }
            });
        }

    }

}
