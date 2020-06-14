package com.company;

import java.lang.reflect.Array;

public class CustomHashMap<K, V> {

    private class EntryListItem {

        public K key;
        public V value;
        public EntryListItem next;

        public EntryListItem(K key, V value, EntryListItem next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private EntryListItem[] table;
    private int size = 0;

    public CustomHashMap() {
        table = (EntryListItem[]) Array.newInstance(EntryListItem.class, 16);
    }

    private int getIndex(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        return index;
    }

    private EntryListItem getEntry(Object key, int index) {
        if (index < 0) {
            index = getIndex(key);
        }
        for (EntryListItem curr = table[index]; curr != null; curr = curr.next) {
            if (key.equals(curr.key)) {
                return curr;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() <= 0;
    }

    public V get(Object key) {
        EntryListItem item = getEntry(key, -1);
        return (item == null) ? null : item.value;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        EntryListItem item = getEntry(key, index);
        if (item != null) {
            item.value = value;
        } else {
            table[index] = new EntryListItem(key, value, table[index]);
            size++;
        }
    }

    public void remove(Object key) {
        int index = getIndex(key);
        EntryListItem parent = null;
        for (EntryListItem curr = table[index]; curr != null; curr = curr.next) {
            if (key.equals(curr.key)) {
                if (parent == null) {
                    table[index] = curr.next;
                } else {
                    parent.next = curr.next;
                }
                size--;
            }
            parent = curr;
        }
    }

    public String findMax() {
        String item = null;
        int counter = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (table[i].next == null) {
                    if (((int) table[i].getValue() == counter)) {
                        item += "," + " " + table[i].getKey();
                    }
                    if ((int) table[i].getValue() > counter) {
                        counter = (int) table[i].getValue();
                        item = String.valueOf(table[i].getKey());
                    }
                } else {
                    for (EntryListItem curr = table[i]; curr != null; curr = curr.next) {
                        if (((int) curr.getValue() == counter)) {
                            item += "," + " " + curr.getKey();
                        }
                        if ((int) curr.getValue() > counter) {
                            counter = (int) curr.getValue();
                            item = String.valueOf(curr.getKey());
                        }
                    }
                }
            }
        }
        item += " " + "=" + " " + counter;
        return item;
    }
}
