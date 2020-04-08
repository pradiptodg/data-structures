package com.pdg.hashtable;

public class SimpleHashtable<T> {
    private StoredObject<T>[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredObject[10];
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (occupied(hashedKey) && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }
        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (stopIndex == hashedKey) {
            return -1;
        } else {
            return hashedKey;
        }
    }

    public void put(String key, T value) {
        int hashedKey = hashKey(key);

        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }


        if (occupied(hashedKey)) {
            System.out.println("Sorry there is already a value at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredObject<T>(key, value);
        }
    }

    @SuppressWarnings("unchecked")
    public T get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].value;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("empty");
            } else {
                System.out.println(hashtable[i].value);
            }
        }
    }

}
