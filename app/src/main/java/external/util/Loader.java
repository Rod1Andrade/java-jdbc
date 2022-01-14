package external.util;

import external.db.DatabaseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe para carregar arquivos.
 *
 * @author Rodrigo Andrade
 */
public class Loader {

    /**
     * Carrega o arquivo de propriedades
     *
     * @param path Caminho do arquivo.
     * @return java.util.Properties
     */
    public static Properties properties(String path) {
        try (FileInputStream file = new FileInputStream(path)) {

            Properties properties = new Properties();
            properties.load(file);

            return properties;
        } catch (IOException e) {
            throw new DatabaseException("Não foi possível carregar o arquivo de propriedades: " + e.getMessage());
        }
    }
}
