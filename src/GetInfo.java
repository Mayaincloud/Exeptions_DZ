import java.util.Scanner;

public class GetInfo {

    private Scanner input;
    private String dataString;

    private String[] parseData;

    public String[] getParseData() {
        return parseData;
    }

    public GetInfo() {
        System.out.println("Введите данные: ФИО, дату рождения, номер телефона, пол");
        this.input = new Scanner(System.in);
        this.dataString = this.input.nextLine();
        this.parseData = this.dataString.split(" ");
        if (parseData.length != 6) {
            throw new MyException(parseData.length);
        }
    }

    public String toString(int index) {
        return parseData[index];
    }

    public void printParseData() {
        for (int i = 0; i < this.parseData.length; i++) {
            System.out.println(this.parseData[i] + " ");
        }
    }
}
