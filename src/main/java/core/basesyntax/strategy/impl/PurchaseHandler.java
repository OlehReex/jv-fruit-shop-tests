package core.basesyntax.strategy.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void doTransaction(String fruit, int value) {
        if (Storage.STORAGE.get(fruit) < value) {
            throw new RuntimeException(String.format("It's not enough %ss in storage", fruit));
        }
        int oldValue = Storage.STORAGE.get(fruit);
        Storage.STORAGE.put(fruit, oldValue - value);
    }
}