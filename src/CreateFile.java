import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;


public class CreateFile {

    private Data data;

    public CreateFile(Data data) {
        this.data = data;
    }

    private  String getString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String birthday = this.data.getBirthday().getBirthday().format(formatter);
        String string = this.data.getFio().getFamilyname() + " " + this.data.getFio().getName() + " " +
                this.data.getFio().getSurname() + " " + birthday + " " +
                this.data.getPhoneNumber().getPhoneNumber() + " " + this.data.getSex().getSex() + "\n";
        return string;
    }

    public void write() {
        String path = this.data.getFio().getFamilyname();
        try (BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + ".txt", true), StandardCharsets.UTF_8))) {
            bf.write(getString());
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}