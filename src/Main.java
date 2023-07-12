public class Main {
    public static void main(String[] args) {
        try {
           Data newData = new Data(new GetInfo());
           CreateFile createFile = new CreateFile(newData);
            createFile.write();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}