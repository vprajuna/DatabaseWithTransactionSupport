package org.example;// Build an in-memory key-value database

import java.util.HashMap;
import java.util.Map;

// class definition for memoryDatabase
public class memoryDatabase implements InMemoryDB {
    Map<String, Integer> database = new HashMap<>(); // elements of the in-memory database
    Map<String, Integer> transaction = new HashMap<>(); // elements of the transaction
    boolean transactionInProg = false; // indicates if a transaction is in progress

    // get(key) will return the value associated with the key or null if the key doesn’t exist. get(key) can be called anytime even when a transaction is not in progress.
    public Integer get (String key) {
        return database.get(key); // return null if the key doesn’t exist
    }

    // put(key, val) will create a new key with the provided value if a key doesn’t exist. Otherwise it will update the value of an existing key. If put(key, val) is
    // called when a transaction is not in progress throw an exception
    public void put(String key, int val) {
        if (!transactionInProg) {
            throw new RuntimeException("No transaction is in progress."); // throw an exception if no transaction is in progress
        }
        transaction.put(key, val); // update the value of an existing key
    }

    // begin_transaction() starts a new transaction. At a time only a single transaction may exist.
    public void begin_transaction() {
        if (transactionInProg) {
            throw new RuntimeException("Transaction already in progress."); // throw an exception if a transaction is already in progress
        }
        transactionInProg = true; // set transactionInProg to true
    }

    // commit() applies changes made within the transaction to the main state. Allowing any future gets() to see the changes made within the transaction
    public void commit() {
        if (!transactionInProg) {
            throw new RuntimeException("No transaction is in progress."); // throw an exception if no transaction is in progress
        }
        database = new HashMap<>(transaction); // apply changes made within the transaction to the main state
        transactionInProg = false; // set transactionInProg to false in order to close it
    }

    // rollback() should abort all the changes made within the transaction and everything should go back to the way it was before.
    public void rollback() {
        if (!transactionInProg) {
            throw new RuntimeException("No transaction is in progress."); // throw an exception if no transaction is in progress
        }
        transaction = new HashMap<>(database); // abort all the changes made within the transaction
        transactionInProg = false; // set transactionInProg to false in order to close it
    }
}