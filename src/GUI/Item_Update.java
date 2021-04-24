package GUI;

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
public class Item_Update extends JFrame {

    JButton Update_Button, Cancel_Button;
    JLabel ItemID_Label, ItemIDValidity_Label;
    JTextField ItemID_TextField;

    private Item item;

    public Item_Update() {
        super("Update Item");
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

        Update_Button = new JButton("Update");
        Cancel_Button = new JButton("Cancel");

        ItemID_Label = new JLabel("Enter Item ID to be updated");
        ItemIDValidity_Label = new JLabel();
        ItemID_TextField = new JTextField();

        ItemID_TextField.setPreferredSize(new Dimension(240, 22));
//        ItemID_Label.setPreferredSize(new Dimension(175, 22));
        ItemIDValidity_Label.setPreferredSize(new Dimension(415, 9));
        Update_Button.setPreferredSize(new Dimension(100, 22));
        Cancel_Button.setPreferredSize(new Dimension(100, 22));

        ItemIDValidity_Label.setForeground(Color.red);

        add(ItemID_Label);
        add(ItemID_TextField);
        add(ItemIDValidity_Label);

        add(Update_Button);
        add(Cancel_Button);

        Update_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String itemID = ItemID_TextField.getText().trim();

                if (!itemID.isEmpty()) {
                    try {
                        if (Integer.parseInt(itemID) > 0) {
                            ItemIDValidity_Label.setText("");
                        } else {
                            itemID = null;
                            ItemIDValidity_Label.setText("                                                            ID cannot be '0' or negative !");
                        }
                    } catch (NumberFormatException ex) {
                        itemID = null;
                        ItemIDValidity_Label.setText("                                                            Invalid ID !");
                    }
                } else {
                    itemID = null;
                    ItemIDValidity_Label.setText("                                                            Enter Item ID !");
                }

                if (itemID != null) {
                    item = Item.SearchByID(Integer.parseInt(itemID));
                    if (item != null) {
                        Item_UpdateInner cui = new Item_UpdateInner();
                        cui.setVisible(true);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Item ID not found !");
                    }
                } else {
                    ItemIDValidity_Label.setText("                                                            Enter Item ID !");
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

    private class Item_UpdateInner extends JFrame {

        JButton Update_Button, Cancel_Button;
        JLabel Name_Label,Model_Label,Type_Label, Specifications_Label,  RentPerHour_Label,Length_Label,Height_Label,Breadth_Label,Weight_Label,
            NameValidity_Label, ModelValidity_Label, TypeValidity_Label, SpecificationValidity_Label,RentPerHourValidity_Label;
        JTextField Name_TextField, Model_TextField,Type_TextField,Specifications_TextField, RentPerHour_TextField,Length_TextField,Breadth_TextField,Height_TextField,Weight_TextField;
        

        public Item_UpdateInner() {
            
            super("Update Item");
            
            setLayout(new FlowLayout());
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            setSize(new Dimension(450, 475));
            setResizable(false);
            setLocationRelativeTo(this);

            Update_Button = new JButton("Update");
            Cancel_Button = new JButton("Cancel");

            Name_Label = new JLabel("Name");
            Model_Label = new JLabel("Model");
            Type_Label = new JLabel("Item type");
            Specifications_Label = new JLabel("Specification");
            RentPerHour_Label = new JLabel("Rent Per Hour (in PKR)");
            Length_Label = new JLabel("Length ");
            Breadth_Label = new JLabel("Breadth");
            Height_Label = new JLabel("Height");
            Weight_Label = new JLabel("Weight");


            NameValidity_Label = new JLabel();
            ModelValidity_Label = new JLabel();
            TypeValidity_Label = new JLabel();
            SpecificationValidity_Label= new JLabel();
            RentPerHourValidity_Label = new JLabel();

            Name_TextField = new JTextField();
            Model_TextField = new JTextField();
            Type_TextField = new JTextField();
            Specifications_TextField = new JTextField();
            RentPerHour_TextField = new JTextField();


            Length_TextField = new JTextField();
            Breadth_TextField = new JTextField();
            Height_TextField = new JTextField();
            Weight_TextField = new JTextField();




            Name_TextField.setPreferredSize(new Dimension(240, 22));
            Model_TextField.setPreferredSize(new Dimension(240, 22));
            Type_TextField.setPreferredSize(new Dimension(240, 22));
            Specifications_TextField.setPreferredSize(new Dimension(240, 22));
            RentPerHour_TextField.setPreferredSize(new Dimension(240, 22));

            Length_TextField.setPreferredSize(new Dimension(240, 22));
            Breadth_TextField.setPreferredSize(new Dimension(240, 22));
            Height_TextField.setPreferredSize(new Dimension(240, 22));
            Weight_TextField.setPreferredSize(new Dimension(240, 22));



            Name_Label.setPreferredSize(new Dimension(175, 22));
            Model_Label.setPreferredSize(new Dimension(175, 22));
            Type_Label.setPreferredSize(new Dimension(175, 22));
            Specifications_Label.setPreferredSize(new Dimension(175, 22));
            RentPerHour_Label.setPreferredSize(new Dimension(175, 22));
            Length_Label.setPreferredSize(new Dimension(175, 22));
            Height_Label.setPreferredSize(new Dimension(175, 22));
            Breadth_Label.setPreferredSize(new Dimension(175, 22));
            Weight_Label.setPreferredSize(new Dimension(175, 22));

            NameValidity_Label.setPreferredSize(new Dimension(415, 9));
            ModelValidity_Label.setPreferredSize(new Dimension(415, 9));
            TypeValidity_Label.setPreferredSize(new Dimension(415, 9));
            SpecificationValidity_Label.setPreferredSize(new Dimension(415, 9));
            RentPerHourValidity_Label.setPreferredSize(new Dimension(415, 9));

            NameValidity_Label.setForeground(Color.red);
            ModelValidity_Label.setForeground(Color.red);
            TypeValidity_Label.setForeground(Color.red);
            SpecificationValidity_Label.setForeground(Color.red);
            RentPerHourValidity_Label.setForeground(Color.red);


            add(Name_Label);
            add(Name_TextField);
            add(NameValidity_Label);

            add(Model_Label);
            add(Model_TextField);
            add(ModelValidity_Label);

            add(Type_Label);
            add(Type_TextField);
            add(TypeValidity_Label);

            add(Specifications_Label);
            add(Specifications_TextField);
            add(SpecificationValidity_Label);


            add(RentPerHour_Label);
            add(RentPerHour_TextField);
            add(RentPerHourValidity_Label);

            add(Length_Label);
            add(Length_TextField);

            add(Height_Label);
            add(Height_TextField);

            add(Breadth_Label);
            add(Breadth_TextField);

            add(Weight_Label);
            add(Weight_TextField);

            add(Update_Button);
            add(Cancel_Button);

            Update_Button.addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {
System.out.println("Add button worked");
                String name = Name_TextField.getText().trim(),
                        model = Model_TextField.getText().trim(),
                        type = Type_TextField.getText().trim(),
                        specification = Specifications_TextField.getText().trim(),
                        rentPerHour = RentPerHour_TextField.getText().trim();
                
                String length = Length_TextField.getText().trim();
                String breadth = Breadth_TextField.getText().trim();
                String height = Height_TextField.getText().trim();
                String weight = Weight_TextField.getText().trim();
                System.out.println("Add button value read complete");

                if (!name.isEmpty()) {
                    if (Item.isNameValid(Name_TextField.getText().trim())) {
                        NameValidity_Label.setText("");
//                        name = Name_TextField.getText().trim();
                    } else {
                        name = null;
                        NameValidity_Label.setText("Invalid  Item Name !");
                    }
                } else {
                    name = null;
                    NameValidity_Label.setText("Enter Item Name !");
                }
                
                if (!model.isEmpty()) {
                    if (Item.isNameValid(model)) {
                        ModelValidity_Label.setText("");

                    } else {
                        model = null;
                        ModelValidity_Label.setText("Invalid Model Name !");
                    }
                } else {
                    model = null;
                    ModelValidity_Label.setText("Enter Model Name !");
                }
                
                if (type.isEmpty()) {
                   
                    type = null;
                    TypeValidity_Label.setText("Enter Type!");
                }
                
                if (!specification.isEmpty()) {
                    if (Item.isNameValid(specification)) {
                        SpecificationValidity_Label.setText("");

                    } else {
                        model = null;
                        SpecificationValidity_Label.setText("Invalid specification label !");
                    }
                } else {
                    model = null;
                    SpecificationValidity_Label.setText("Enter specification label !");
                }
                
                
                if (!rentPerHour.isEmpty()) {
                    if (Item.isNameValid(rentPerHour)) {
                        RentPerHourValidity_Label.setText("");

                    } else {
                        rentPerHour = null;
                        RentPerHourValidity_Label.setText("Invalid rentPerHour label !");
                    }
                } else {
                    rentPerHour = null;
                    RentPerHourValidity_Label.setText("Enter rentPerHour label !");
                }
                
                

                    try {
                        if (name != null && model != null && type != null && rentPerHour != null) {
//new item(ID, Maker, Name, Colour, Type, seatingCapacity, model, Condition, RegNo, RentPerHour, itemOwner)
                            item = new Item(item.getID(),name, model,type,specification,length,breadth,height,weight, rentPerHour);
                            item.Update();

                            Parent_JFrame.getMainFrame().getContentPane().removeAll();
                            Item_Details cd = new Item_Details();
                            Parent_JFrame.getMainFrame().add(cd.getMainPanel());
                            Parent_JFrame.getMainFrame().getContentPane().revalidate();

                            JOptionPane.showMessageDialog(null, "Record Successfully Updated !");

                            Parent_JFrame.getMainFrame().setEnabled(true);
                            dispose();

                        }
                    } catch (HeadlessException | NumberFormatException ex) {
                        System.out.println(ex);
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
}
