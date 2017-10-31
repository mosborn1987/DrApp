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

    UserName userName;
    Password password;
    Email email;

    public static class UserName {

        String userName;

        public UserName(String _userName) {

            if (_userName == null) {

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

        public String getPassword() {
            return password;
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
