package BackendCode;

import java.io.Serializable;

/**
 *
 * @author @AbdullahShahid01
 */
public abstract class Person implements Serializable {

    protected int ID;
    protected String Name, Contact_No,Address;

    public Person() {
    }
    public Person(int ID, String Address, String Name, String Contact_No) {
        this.ID = ID;
        this.Address = Address;
        this.Name = Name;
        this.Contact_No = Contact_No;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getContact_No() {
        return Contact_No;
    }
    public void setContact_No(String Contact_No) {
        this.Contact_No = Contact_No;
    }
    public abstract void Add();
    public abstract void Update();
    public abstract void Remove();
    @Override
    public String toString() {
        return "Person_new{" + "ID=" + ID + ", Address=" + Address + ", Name=" + Name + ", Contact_No=" + Contact_No + '}';
    }
  
    /**
     * A valid name can contain only letters and white spaces
     * @param Name
     * @return true if the name is valid
     */
    public static boolean isNameValid(String Name) {
        boolean flag = false;
        for (int i = 0; i < Name.length(); i++) {
//            Name can contain white spaces
            if (Character.isLetter(Name.charAt(i)) | Name.charAt(i) == ' ') {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
    /**
     * A valid ID can only be digit greater than 0
     * @param ID
     * @return true if the ID is valid
     */
    public static boolean isIDvalid(String ID) {
        boolean flag = true;
        for (int i = 0; i < ID.length(); i++) {
            if (!Character.isDigit(ID.charAt(i))) {
                flag = false;
                break;
            }
        }
        if (flag) {
            if (Integer.parseInt(ID) <= 0) {
                flag = false;
            }
        }
        return flag;
    }
}