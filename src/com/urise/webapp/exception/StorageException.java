package com.urise.webapp.exception;

public class StorageException extends RuntimeException{
    private final String uuid;

    public StorageException(String message, String uuid) {
        this.uuid = uuid;
    }

    public StorageException(String uuid) {
        this.uuid = uuid;
    }
}
