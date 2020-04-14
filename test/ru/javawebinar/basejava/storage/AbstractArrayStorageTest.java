package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        String uuid1 = "uuid1";
        Resume resume = new Resume(uuid1);
        storage.update(resume);
        Assert.assertEquals(resume, storage.get(uuid1));
    }

    @Test
    public void getAll() {
        Resume[] resumes = storage.getAll();
        Assert.assertEquals(3, resumes.length);
        Assert.assertEquals("uuid1", resumes[0].getUuid());
    }

    @Test
    public void save() {
        String uuid4 = "uuid4";
        Resume resume = new Resume(uuid4);
        storage.save(resume);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(uuid4, storage.get(uuid4).getUuid());
    }

    @Test
    public void delete() {
        String uuid1 = "uuid1";
        storage.delete(uuid1);
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void get() {
        String uuid1 = "uuid1";
        Resume resume = storage.get(uuid1);
        Assert.assertEquals(uuid1, resume.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
}