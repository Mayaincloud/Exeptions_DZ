public class SexException extends Exception {

    private String invalidSexValue;

    public SexException(String invalidSexValue) {
        super(String.format("Введенное значение '%s' не корректно. Введите пол в формате 'm' или 'f'.", invalidSexValue));
        this.invalidSexValue = invalidSexValue;
    }

    public String getInvalidSexValue() {
        return invalidSexValue;
    }
}
