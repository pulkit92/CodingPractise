public class CrudSystem {

  public static void main(String args[]) {
    String filePath = "/Users/pbajpai/Desktop/pulkit.txt";
    FileSystem fileSystem = new FileSystem(filePath);
    KeyValueStore keyValueStore = new KeyValueStore(fileSystem);
    //keyValueStore.create("1", "pulkit");
    System.out.println(keyValueStore.read("1"));
    keyValueStore.update("1", "aks");
    keyValueStore.update("3", "sachine");
    keyValueStore.delete("1");
    System.out.println(keyValueStore.read("1"));

  }

}
