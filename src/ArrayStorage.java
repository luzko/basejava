/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int sizeStorage = size();
        for (int i = 0; i < sizeStorage; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        int sizeStorage = size();
        if (sizeStorage >= storage.length) {
            System.out.println("Storage is full.");
            return;
        }
        for (int i = 0; i < sizeStorage; i++) {
            if (r.uuid.equals(storage[i].uuid)) {
                return;
            }
        }
        storage[sizeStorage] = r;
    }

    Resume get(String uuid) {
        int sizeStorage = size();
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int sizeStorage = size();
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, sizeStorage - 1 - i);
                storage[sizeStorage - 1] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int sizeStorage = size();
        Resume[] resumes = new Resume[sizeStorage];
        System.arraycopy(storage, 0, resumes, 0, sizeStorage);
        return resumes;
    }

    int size() {
        int count = 0;
        for (Resume resume : storage) {
            if (resume == null) {
                break;
            }
            count++;
        }
        return count;
    }
}
