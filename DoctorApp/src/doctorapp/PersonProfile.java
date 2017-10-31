/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctorapp;

import java.util.Calendar;

/**
 *
 * @author mosborn1987
 */
public class PersonProfile {

    public FullName _fullName;
    public Gender _gener;
    public Calendar _birthdate;// = Calendar.getInstance();

    public PersonProfile(
            FullName fullName,
            Gender gender,
            Calendar birthdate
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

        Calendar rightNow = Calendar.getInstance();
        boolean birthdateIsAfterNow
                = (this._birthdate.compareTo(rightNow) >= 1) ? true : false;

        if (birthdateIsAfterNow) {
            throw new InvalidPersonProfile("birthdateIsAfterNow == true");
        }
    }

    public FullName getFullName() {
        return _fullName;
    }

    public Gender getGender() {
        return _gener;
    }

    public Calendar getBirthdate() {
        return _birthdate;
    }

    public class FullName {

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
//            if (((this._first == null) | (this._last == null)) ||
//                    (this._first.toString().length() == 0 &)
//                    ) {
//                throw new InvalidNameException(
//                        "FullName(...) Failed: "
//                        + this.toString() + " invalid");
//            }
        }

        public FullName(String first, String last) throws InvalidNameException {
            this(first, "", last);
        }

        private String getNameString(Name name) {
            if (name == null) {
                return "";
            }
            return name.toString();
        }

        public String getFirstString() {
            return getNameString(_first);
        }

        public String getMiddleString() {
            return getNameString(_middle);
        }

        public String getLastString() {
            return getNameString(_last);
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

    public class Name {

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

    public class InvalidNameException extends Exception {

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
