public class PhoneNumberException extends Exception {

    private String invalidTelephoneValue;

    public PhoneNumberException(String invalidTelephoneValue) {
        super(String.format("Введенное значение '%s' не корректно. Введите  11 цифр  без знаков и пробелов.", invalidTelephoneValue));
        this.invalidTelephoneValue = invalidTelephoneValue;
    }

    public String getInvalidTelephoneValue() {
        return invalidTelephoneValue;
    }
}
