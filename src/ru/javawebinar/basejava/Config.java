package ru.javawebinar.basejava;

import ru.javawebinar.basejava.storage.SqlStorage;
import ru.javawebinar.basejava.storage.Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Config INSTANCE = new Config();
    protected static final File PROPS = new File("/Users/enway3/Documents/java/basejava/config/resumes.properties");
    private final File storageDir;
    private final Storage storage;

    public static Config get(){
        return INSTANCE;
    }

    private Config() {
        try {
            try (InputStream is = new FileInputStream(PROPS)) {
                Properties props = new Properties();
                props.load(is);
                storageDir = new File(props.getProperty("storage.dir"));
                storage = new SqlStorage(props.getProperty("db.url"), props.getProperty("db.user"), props.getProperty("db.password"));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file");
        }
    }

    public Storage getStorage() {
        return storage;
    }

    public File getStorageDir() {
        return storageDir;
    }
}
