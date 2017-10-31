/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctorapp;

/**
 *
 * @author mosborn1987
 */
public class LoginCredentials {

    // Private Member Variables
    private UserName userName;
    private Password password;
    private Email email;

    // Constructor
    public LoginCredentials(
            UserName userName,
            Password password,
            Email email
    ) throws InvalidLoginCredentials {

        if (userName != null) {
            this.userName = userName;
        } else {
            throw new InvalidLoginCredentials("userName is null");
        }

        if (password != null) {
            this.password = password;
        } else {
            throw new InvalidLoginCredentials("password is null");
        }

        if (email != null) {
            this.email = email;
        } else {
            throw new InvalidLoginCredentials("email is null");
        }

    }

    // GETTERS
    public UserName getUserName() {
        return userName;
    }

    public Password getPassword() {
        return password;
    }

    public Email getEmail() {
        return email;
    }

    // Inner Static Classes
    public static class UserName {

        private String userName;

        public UserName(String userName) throws InvalidUserName {

            if (userName == null) {
                throw new InvalidUserName("userName is null");
            }
        }
    }

    public static class Password {

        private String password;

        public Password(String _password) throws InvalidPassword {
            this.password = _password;

            if (this.password == null) {
                throw new InvalidPassword("Password constructor was passed a null string");
            }

            if (this.password.length() == 0) {
                throw new InvalidPassword("Password constructor was passed an empty string");
            }

            // TODO - Create all the criteria needed for a strong password.
            //        Thow exceptions when they are not valid.
        }

        @Override
        public String toString() {
            return this.password;
        }

    }

    public static class Email {

        private String email;

        public Email(String _email) throws InvalidEmail {
            this.email = _email;

            if (this.email == null) {
                throw new InvalidEmail("Eamil Constructor was passed a null string.");
            }

            if (this.email.length() == 0) {
                throw new InvalidEmail("Eamil Constructor was passed an empty string.");
            }

            if (this.email.contains("@") == false) {
                throw new InvalidEmail("Eamil Constructor was passed a string that does not contain the @.");
            }

        }

        @Override
        public String toString() {
            return this.email;
        }

    }

    // Inner Static Exception-Classes
    public static class InvalidLoginCredentials extends Exception {

        public InvalidLoginCredentials(String message) {
            super(message);
        }
    }

    public static class InvalidUserName extends Exception {

        public InvalidUserName(String message) {
            super(message);
        }
    }

    public static class InvalidPassword extends Exception {

        public InvalidPassword(String message) {
            super(message);
        }
    }

    public static class InvalidEmail extends Exception {

        public InvalidEmail(String message) {
            super(message);
        }
    }

}
