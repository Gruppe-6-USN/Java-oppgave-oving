package org.example.gui.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;

public class SqlExceptions extends RuntimeException {

    private static final long serialVersionUID = 2565294309342199990L;

    public SqlExceptions(String message) {
        super(message);
    }
}
