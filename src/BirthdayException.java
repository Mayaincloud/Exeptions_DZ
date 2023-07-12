public class BirthdayException extends Exception {

    private final String invalidBirthdayValue;

    public BirthdayException(String invalidBirthdayValue) {
        super(String.format("Введенное значение '%s' не корректно. Введите дату рождения  в формате dd.mm.yyyy.", invalidBirthdayValue));
        this.invalidBirthdayValue = invalidBirthdayValue;
    }


}
