package org.example;

public class Main {
    public static void main(String[] args) {
        memoryDatabase db = new memoryDatabase(); // InMemoryDB inmemoryDB; is a new instance of memoryDatabase

        Integer a = db.get("A");
        System.out.println(a); // should return null, because A doesn’t exist in the DB yet

        db.put("A", 5); // should throw an error because a transaction is not in progress

        db.begin_transaction(); // starts a new transaction

        db.put("A", 5); // set’s value of A to 5, but its not committed yet

        Integer b = db.get("A");
        System.out.println(b); // should return null, because updates to A are not committed yet

        db.put("A", 6); // update A’s value to 6 within the transaction

        db.commit(); // commits the open transaction

        Integer c = db.get("A");
        System.out.println(c); // should return 6, that was the last value of A to be committed

        db.commit(); // throws an error, because there is no open transaction

        db.rollback(); // throws an error because there is no ongoing transaction

        Integer d = db.get("B");
        System.out.println(d); // should return null because B does not exist in the database

        db.begin_transaction(); // starts a new transaction

        db.put("B", 10); // Set key B’s value to 10 within the transaction

        db.rollback(); // Rollback the transaction - revert any changes made to B

        Integer e = db.get("B");
        System.out.println(e); // Should return null because changes to B were rolled back
    }
}