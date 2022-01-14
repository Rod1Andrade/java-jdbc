package external.db;

/**
 * Exceção para banco de dados.
 *
 * @author Rodrigo Andrade
 */
public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
        super(message);
    }
}
