import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FileOperations {

  public static boolean write(Pair pair, String filePath) {
    Map<String, Pair> map = null;
    File file = new File(filePath);
    if (file.length()==0) {
      try (FileInputStream fileInputStream = new FileInputStream(file);
          ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
          FileOutputStream fileOutputStream = new FileOutputStream(file);
          ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

        map = (HashMap<String, Pair>) objectInputStream.readObject();
        map.put(pair.getKey(), pair);
        objectOutputStream.writeObject(map);

      } catch (Exception e) {
        System.out.println(e);
        return false;
      }
    }
    try (
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
      map = new HashMap<>();
      map.put(pair.getKey(), pair);
      objectOutputStream.writeObject(map);

    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
    return true;
  }

  public static Optional<Pair> read(String key, String filePath) {
    Map<String, Pair> map = null;
    File file = new File(filePath);
    try (FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
      map = (HashMap<String, Pair>) objectInputStream.readObject();
      if (map.containsKey(key)) {
        return Optional.of(map.get(key));
      }
      return Optional.empty();

    } catch (Exception e) {
      System.out.println(e);
      return Optional.empty();
    }
  }

  public static boolean delete(String key, String filePath) {
    Map<String, Pair> map = null;
    File file = new File(filePath);
    try (FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
      map = (HashMap<String, Pair>) objectInputStream.readObject();
      map.remove(key);
      objectOutputStream.writeObject(map);
      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }
}
