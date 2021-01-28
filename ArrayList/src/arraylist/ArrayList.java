/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import custom.util.CustomList;

/**
 *
 * @author SharpSchnitzel
 */
public class ArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] array = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        CustomList<String> collection = new CustomList<>(array);
        
        System.out.println(collection.length());
        System.out.println(collection.get(3));       
        collection.splice(3, 1); // removing Apr
        System.out.println(collection.length());
        System.out.println(collection.get(3));
        collection.splice(3, 0, "Apr"); // returning Apr
        System.out.println(collection.get(3));
        System.out.println(collection.length());
        collection.unshift("Left");
        System.out.println(collection.get(0));
        collection.push("Right");
        System.out.println(collection.get(collection.length() - 1));
        System.out.println(collection.length());
    }
    
}
