package com.pdg.hashtable;

public class StoredObject<T> {
    String key;
    T value;

    public StoredObject(String key, T value) {
        this.key = key;
        this.value = value;
    }
}
