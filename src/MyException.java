public class MyException extends NumberFormatException {

    private int length;

    public MyException(int length) {
        super(String.format("Вы ввели: %d значений. Введите 6 значений (фамилия, имя, отчество, дата рождения, телефон и пол)", length));
    }

    public int getLength() {
        return length;
    }

}
