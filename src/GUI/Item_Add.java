package GUI;

import BackendCode.Item;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author @AbdullahShahid01
 */
public class Item_Add extends JFrame {

//    int ID;
//    String Name, Model, Type,Specifications;
//    int length,breadth, height,weight,RentPerHour;
//    
    JButton Add_Button, Cancel_Button;
    JLabel Name_Label,Model_Label,Type_Label, Specifications_Label,  RentPerHour_Label,Length_Label,Height_Label,Breadth_Label,Weight_Label,
            NameValidity_Label, ModelValidity_Label, TypeValidity_Label, SpecificationValidity_Label,RentPerHourValidity_Label;
    JTextField Name_TextField, Model_TextField,Type_TextField,Specifications_TextField, RentPerHour_TextField,Length_TextField,Breadth_TextField,Height_TextField,Weight_TextField;
    JComboBox<String> Type_ComboBox, Model_ComboBox;
//    JSpinner SeatingCapacity_Spinner;

    public Item_Add() {
        super("Add Item");
        System.out.println("Item Add worked");
        setLayout(new FlowLayout());
        setSize(new Dimension(450, 475));
        setResizable(false);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Parent_JFrame.getMainFrame().setEnabled(true);
                dispose();
            }
        });
System.out.println("Add 43");
        Add_Button = new JButton("Add");
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

        add(Add_Button);
        add(Cancel_Button);

        System.out.println("Add 127");
        Add_Button.addActionListener(new ActionListener() {
            
            
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
                        Item item = Item.SearchByRegNo(model);

                        
                            if (item == null) {
                                //Item(id, Maker, Name, Colour, Type, SeatingCapacity, Model, Condition, RegNo, RentPerHour, itemOwner)
                                // id is auto
//                                this.ID = ID;
//        this.Name = Name;
//        this.Model = Model;
//        this.Type = Type;
//        this.Specifications = Specifications;
//        this.length = length;
//        this.breadth = breadth;
//        this.height = height;
//        this.weight = weight;
//        this.RentPerHour = RentPerHour;
//    public Item(int ID, String Name, String Model, String Type, String Specifications, int length, int breadth, int height, int weight, int RentPerHour) {
                                System.out.println("Constructor reached");
                                item = new Item(0,name, model,type,specification,length,breadth,height,weight, rentPerHour);
                                item.Add();
                                
                                Parent_JFrame.getMainFrame().getContentPane().removeAll();
                                Item_Details cd = new Item_Details();
                                Parent_JFrame.getMainFrame().add(cd.getMainPanel());
                                Parent_JFrame.getMainFrame().getContentPane().revalidate();
                                JOptionPane.showMessageDialog(null, "Record Successfully Added !");
                                Parent_JFrame.getMainFrame().setEnabled(true);
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "This item Registeration no is already registered !");
                            }
                        
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
