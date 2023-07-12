public class Fio {

    private String familyname;
    private String name;
    private String surname;

    public Fio(String familyname, String name, String surname) {
        this.familyname = familyname;
        this.name = name;
        this.surname = surname;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "{" + familyname + " " +
                name + " " +
                surname + "}";
    }
}
