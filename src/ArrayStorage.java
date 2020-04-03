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
            Resume[] storageTemp = new Resume[storage.length];
            System.arraycopy(storage, 0, storageTemp, 0, storage.length);
            storage = new Resume[(int) (storageTemp.length * 1.5 + 1)];
            System.arraycopy(storageTemp, 0, storage, 0, storageTemp.length);
        }
        storage[sizeStorage] = r;
    }

    Resume get(String uuid) {
        Resume resume = null;
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                resume = storage[i];
                break;
            }
        }
        return resume;
    }

    void delete(String uuid) {
        int sizeStorage = size();
        int index = -1;
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
                storage[i] = null;
                break;
            }
        }
        if (index != -1) {
            System.arraycopy(storage, index + 1, storage, index, sizeStorage - index);
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        System.arraycopy(storage, 0, resumes, 0, size());
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
