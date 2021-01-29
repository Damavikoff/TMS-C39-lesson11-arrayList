/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom.util;

/**
 *
 * @author SharpSchnitzel
 */
public class CustomList<T> {
     private T body[];
    
    public CustomList() {
        this.body = (T[])new Object[0];
    }
    
    public CustomList(T[] array) {
        this.body = array;
    }
    
    public int length() {
        return this.body.length;
    }
    
    public T get(int index) {
        if (index < 0 || index >= this.length()) {
            throw new IndexOutOfBoundsException("Неверный индекс элемента");
        } else {
            return this.body[index];
        }
    }
    
    public void unshift(T item) {
        T[] result = (T[])new Object[this.length() + 1];
        result[0] = item;
        System.arraycopy(this.body, 0, result, 1, this.length());
        this.body = result;
    }
    
    public void push(T item) {
        T[] result = (T[])new Object[this.length() + 1];
        result[this.length()] = item;
        System.arraycopy(this.body, 0, result, 0, this.length());
        this.body = result;
    }
    
    public void splice(int offset, int count) {
        if (offset < 0 || offset >= this.length()) {
            throw new IndexOutOfBoundsException("Неверный индекс элемента");
        }
        
        if (count == 0) {
            return;
        }
        
        if (count < 0) {
            throw new IllegalArgumentException("Неверный аргумент");
        }
        
        int delete = offset + count > this.length() ? this.length() - offset : count;
        T[] result = (T[])new Object[this.length() - delete];
        
        System.arraycopy(this.body, 0, result, 0, offset);
        
        if (offset + delete < this.length()) {
            System.arraycopy(this.body, offset + delete, result, offset, this.length() - offset - delete);
        }
        
        this.body = result;
    }
    
    public void splice(int offset, int count, T item) {
        this.splice(offset, count);
        T[] result = (T[])new Object[this.length() + 1];
        System.arraycopy(this.body, 0, result, 0, offset);
        result[offset] = item;
        System.arraycopy(this.body, offset, result, offset + 1, this.length() - offset);
        
        this.body = result;
    }
}
