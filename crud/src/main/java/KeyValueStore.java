public class KeyValueStore {
  private FileSystem fileSystem;

  public KeyValueStore(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  public void create(String key, String value) {
    fileSystem.create(key, value);
  }

  public String read(String key) {
    return fileSystem.read(key);
  }

  public void update(String key, String value) {
    fileSystem.update(key, value);
  }

  public void delete(String key) {
    fileSystem.delete(key);
  }

}