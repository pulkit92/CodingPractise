import java.io.File;
import java.util.Optional;

public class FileSystem {
  private final String filePath;

  public FileSystem(String filePath) {
    this.filePath = filePath;
    createNewFile(filePath);
  }

  private void createNewFile(String filePath) {
    try {
      File file = new File(filePath);
      file.createNewFile();
    } catch (Exception e) {
      System.out.println("Not able to create file");
    }

  }

  public void create(String key, String value) {
    Pair pair = new Pair();
    pair.setKey(key);
    pair.setValue(value);
    FileOperations.write(pair, filePath);
  }

  public String read(String key) {
    Optional<Pair> optionalPair = FileOperations.read(key, filePath);
    if (optionalPair.isPresent()) {
      return optionalPair.get().getValue();
    }
    return "";
  }

  public void update(String key, String value) {
    Pair pair = new Pair();
    pair.setKey(key);
    pair.setValue(value);
    FileOperations.write(pair, filePath);
  }

  public void delete(String key) {
    FileOperations.delete(key,filePath);
  }
}
