package Controller;

import Entity.Store;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public interface IstoreOperations {

    public Store Add(String shopName, String Name, String Family, String Tell, String Email);

    public DefaultListModel showStoreName();

    public Store editStore(String storeName);

    public void Update(Store store);

    public void Delete(String name);

}
