import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Data {

    private GetInfo data;
    private Fio fio;
    private Birthday birthday;
    private Sex sex;
    private PhoneNumber phoneNumber;

    public Data(GetInfo data) {
        this.data = data;
        setTelephone(phoneNumber);
        setSex(sex);
        setBirthday(birthday);
        setFio(fio);
    }

    private boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.UnicodeBlock.of(s.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || s.charAt(i) == '-') {
                return true;
            }
        }
        return false;
    }

    public Fio getFio() {
        return fio;
    }

    private void setFio(Fio fio) {
        int counter = 0;
        for (int i = 0; i < data.getParseData().length; i++) {
            if(isValid(data.getParseData()[i]) && i + 2 < data.getParseData().length && isValid(data.getParseData()[i + 1]) && isValid(data.getParseData()[i + 2])) {
                this.fio = new Fio(data.getParseData()[i], data.getParseData()[i + 1], data.getParseData()[i + 2]);
                counter++;
            }
        }
        if (counter == 0) {
            try {
                throw new FioException(data.getParseData()[0] + " " + data.getParseData()[1] + " " + data.getParseData()[2]);
            } catch (FioException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Birthday getBirthday() {
        return birthday;
    }

    private void setBirthday(Birthday birthday) {
        int counter = 0;
        for (int i = 0; i < data.getParseData().length; i++) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
                this.birthday = new Birthday(LocalDate.parse(data.getParseData()[i], formatter));
            } catch (DateTimeParseException e) {
                counter++;
                continue;
            }
        }
        if (counter == data.getParseData().length) {
            try {
                throw new BirthdayException(data.getParseData()[3]);
            } catch (BirthdayException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Sex getSex() {
        return sex;
    }

    private void setSex(Sex sex) {
        int counter = 0;
        for (int i = 0; i < data.getParseData().length; i++) {
            if(data.getParseData()[i].equals("f") || data.getParseData()[i].equals("m")) {
                this.sex = new Sex(data.getParseData()[i].charAt(0));
                counter++;
            }
        }
        if (counter == 0) {
            try {
                throw new SexException(data.getParseData()[5]);
            } catch (SexException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    private void setTelephone(PhoneNumber phoneNumber) {
        int counter = 0;
        for (int i = 0; i < data.getParseData().length; i++) {
            try {
                this.phoneNumber = new PhoneNumber(Long.parseLong(data.getParseData()[i]));
            } catch (NumberFormatException e) {
                counter++;
                continue;
            }
        }
        if (counter == data.getParseData().length) {
            try {
                throw new PhoneNumberException(data.getParseData()[4]);
            } catch (PhoneNumberException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
