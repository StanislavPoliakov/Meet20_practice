package home.stanislavpoliakov.meet20_practice;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private static int id;
    private int resId = 0;
    private String lastName;
    private String firstName;
    private String patronymic;
    private int personId;


    public Person(String lastName, String firstName, String patronymic) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.personId = ++Person.id;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
        Person.id = personId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getResId() {
        return resId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getPersonId() {
        return personId;
    }

    @Override
    public int hashCode() {
        int result = personId;
        result = 31 * result + resId;
        result = 31 * result + lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + patronymic.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Person personObject = (Person) obj;
        return (this.personId == personObject.personId && this.lastName.equals(personObject.lastName)
        && this.firstName.equals(personObject.firstName) && this.patronymic.equals(personObject.patronymic)
        && this.resId == personObject.resId);
    }

    @Override
    public String toString() {
        return personId + ": " + lastName + " " + firstName + " " + patronymic;
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            int pPersonId = source.readInt();
            int pResId = source.readInt();
            String pLastName = source.readString();
            String pFirstName = source.readString();
            String pPatronymic = source.readString();
            Person pPerson = new Person(pLastName, pFirstName, pPatronymic);
            pPerson.setPersonId(pPersonId);
            pPerson.setResId(pResId);
            return pPerson;
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.personId);
        dest.writeInt(this.resId);
        dest.writeString(this.lastName);
        dest.writeString(this.firstName);
        dest.writeString(this.patronymic);
    }
}
