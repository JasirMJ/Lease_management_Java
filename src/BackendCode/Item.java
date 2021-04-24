package BackendCode;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author @AbdullahShahid01
 */
public class Item implements Serializable {

    int ID;
    String Name, Model, Type,Specifications;
    String length,breadth, height,weight,RentPerHour;
    
    @Override
    public String toString() {
        return "item_new{" + 
                "ID=" + ID + 
                ", Name=" + Name + 
                ", Model=" + Model +
                ", \nType=" + Type +
                ", Specification=" + Specifications + 
                ", length=" + length + 
                ", breadth=" + breadth + 
                ", height=" + height + 
                ", weight=" + weight + 
                ", RentPerHour=" + RentPerHour + 
                '}' + "\n";
    }
    public Item(int ID, String Name, String Model, String Type, String Specifications, String length, String breadth, String height, String weight, String RentPerHour) {
        this.ID = ID;
        this.Name = Name;
        this.Model = Model;
        this.Type = Type;
        this.Specifications = Specifications;
        this.length = length;
        this.breadth = breadth;
        this.height = height;
        this.weight = weight;
        this.RentPerHour = RentPerHour;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getSpecifications() {
        return Specifications;
    }

    public void setSpecifications(String Specifications) {
        this.Specifications = Specifications;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getBreadth() {
        return breadth;
    }

    public void setBreadth(String breadth) {
        this.breadth = breadth;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getRentPerHour() {
        return RentPerHour;
    }

    public void setRentPerHour(String RentPerHour) {
        this.RentPerHour = RentPerHour;
    }

    public Item() {}

    

    public void Add() {
        ArrayList<Item> leaseItem = Item.View();
        if (leaseItem.isEmpty()) {
            this.ID = 1;
        } else {
            this.ID = leaseItem.get(leaseItem.size() - 1).ID + 1; // Auto ID...
        }
        leaseItem.add(this);
        File file = new File("item.ser");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(file));
            for (int i = 0; i < leaseItem.size(); i++) {
                System.out.println("+ adding "+leaseItem.get(i));
                outputStream.writeObject(leaseItem.get(i));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

   
    public void Update() {
        ArrayList<Item> leaseItem = Item.View();

        // for loop for replacing the new Item object with old one with same ID
        for (int i = 0; i < leaseItem.size(); i++) {
            if (leaseItem.get(i).ID == ID) {
                leaseItem.set(i, this);
            }
        }

        // code for writing new Item record 
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("item.ser"));
            for (int i = 0; i < leaseItem.size(); i++) {
                outputStream.writeObject(leaseItem.get(i));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    public void Remove() {

        ArrayList<Item> leaseItem = Item.View();
        // for loop for deleting the required Item
        for (int i = 0; i < leaseItem.size(); i++) {
            if ((leaseItem.get(i).ID == ID)) {
                leaseItem.remove(i);
            }
        }
        // code for writing new Item record 
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("item.ser"));
            for (int i = 0; i < leaseItem.size(); i++) {
                outputStream.writeObject(leaseItem.get(i));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    public static ArrayList<Item> SearchByName(String name) {
        ArrayList<Item> leaseItem = Item.View();
        ArrayList<Item> s = new ArrayList<>();
        for (int i = 0; i < leaseItem.size(); i++) {
            if (leaseItem.get(i).Name.equalsIgnoreCase(name)) {
                s.add(leaseItem.get(i));
            }
        }
        return s;
    }

    public static Item SearchByID(int id) {
        ArrayList<Item> leaseItem = Item.View();
        for (int i = 0; i < leaseItem.size(); i++) {
            System.out.println("Lease item id "+leaseItem.get(i).ID);
            if (leaseItem.get(i).ID == id) {
                return leaseItem.get(i);
            }
        }
        return null;
    }

    public static Item SearchByRegNo(String model) {
        ArrayList<Item> leaseItem = Item.View();
        for (int i = 0; i < leaseItem.size(); i++) {
            if (leaseItem.get(i).Model.equalsIgnoreCase(model)) {
                return leaseItem.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Item> View() {
        ArrayList<Item> itemList = new ArrayList<>(0);
        ObjectInputStream inputStream = null;
        try {
// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("item.ser"));
            boolean EOF = false;
// Keep reading file until file ends
            while (!EOF) {
                try {
                    Item myObj = (Item) inputStream.readObject();
                    itemList.add(myObj);
                } catch (ClassNotFoundException e) {
                    System.out.println(e);
                } catch (EOFException end) {
                    EOF = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return itemList;
    }

    public static boolean isNameValid(String Name) {
        boolean flag = false;
        for (int i = 0; i < Name.length(); i++) {
//            Name can contain white spaces
            if (Character.isLetter(Name.charAt(i)) |Character.isDigit(Name.charAt(i))| Name.charAt(i) == ' ') {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static boolean isRegNoValid(String RegNo) {
        if(Integer.parseInt(RegNo)>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean isRented() {
        ArrayList<Item> BookedItems = Booking.getBookedItems();
        for (int i = 0; i < BookedItems.size(); i++) {
            if (BookedItems.get(i).ID == this.ID) {
                return true;
            }
        }
        return false;
    }

}
