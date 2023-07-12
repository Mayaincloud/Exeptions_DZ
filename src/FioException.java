public class FioException extends Exception {

    private String invalidFioValue;

    public FioException(String invalidFioValue) {
        super(String.format("Введенное значение '%s' не является корректным форматом ФИО. ФИО должно содержать фамилию, имя и отчество.", invalidFioValue));
        this.invalidFioValue = invalidFioValue;
    }

    public String getInvalidFioValue() {
        return invalidFioValue;
    }
}