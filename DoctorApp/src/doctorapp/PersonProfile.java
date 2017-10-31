/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctorapp;

import java.util.Date;

/**
 *
 * @author mosborn1987
 */
public class PersonProfile {

    private FullName _fullName;
    private Gender _gener;
    private Date _birthdate;

    public PersonProfile(
            FullName fullName,
            Gender gender,
            Date birthdate
    )
            throws InvalidPersonProfile {
        this._fullName = fullName;
        this._gener = gender;
        this._birthdate = birthdate;

        // Validate Full Name
        if (this._fullName == null) {
            throw new InvalidPersonProfile("this._fullName == null");
        }

        // Validate Gender
        if (this._gener == null) {
            throw new InvalidPersonProfile("this._gender == null");
        }

        // Validate Birthdate
        if (this._birthdate == null) {
            throw new InvalidPersonProfile("this._birthdate == null");
        }

        // TODO - Make sure that the birthdate is before today. 

    }

    public FullName getFullName() {
        return _fullName;
    }

    public Gender getGender() {
        return _gener;
    }

    public int getAge() {
        // TODO - Obtain the calculated age from a Calendar class. 
        return 999;
    }

    public Date getBirthdate() {
        return _birthdate;
    }

    public static class FullName {

        private Name _first;
        private Name _middle;
        private Name _last;

        public FullName(String first, String middle, String last) throws InvalidNameException {

            try {
                this._first = new Name(first);
            } catch (InvalidNameException ex) {
                this._first = new Name("");
            }

            try {
                this._middle = new Name(middle);
            } catch (InvalidNameException ex) {
                this._middle = new Name("");
            }

            try {
                this._last = new Name(last);
            } catch (InvalidNameException ex) {
                this._last = new Name("");
            }

            // TODO - A name must have at least a first and last name
            if (this._first.toString().compareTo("") == 0) {
                throw new InvalidNameException(
                        "FullName(...) Failed: first name invalid ");
            }
        }

        private String getNameString(Name name) {
            if (name == null) {
                return "";
            }
            return name.toString();
        }

        public String getFirstString() {
            return getNameString(this._first);
        }

        public String getMiddleString() {
            return getNameString(this._middle);
        }

        public String getLastString() {
            return getNameString(this._last);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getFirstString());

            sb.append(" ");

            String middleName = getMiddleString();
            boolean hasMiddleName = (middleName.length() != 0) ? true : false;

            if (hasMiddleName) {
                sb.append(middleName);
                sb.append(" ");
            }

            sb.append(getLastString());

            return sb.toString();
        }
    }

    public static class Name {

        private String _name;

        public Name(String name) throws InvalidNameException {
            if (name == null) {
                throw new InvalidNameException("name == null");
            }

            // Trim 'name'
            name = name.trim();

            // TODO - Name should not contains numbers
            // Set name
            this._name = name;
        }

        @Override
        public String toString() {
            if (_name == null) {
                return "";
            }

            return _name;
        }
    }

    public static class InvalidNameException extends Exception {

        public InvalidNameException(String message) {
            super(message);
        }
    }

    public class InvalidPersonProfile extends Exception {

        public InvalidPersonProfile(String message) {
            super(message);
        }
    }

    public enum Gender {
        MALE,
        FEMALE
    }

}
