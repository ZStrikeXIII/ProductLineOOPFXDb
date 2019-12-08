package sample;

/**
 * This class contains the information of employees, including their name, username and password.
 *
 * @author jbturner6375
 */
public class Employee {

  String firstLastName;
  String password;
  String finalPassword;

  Employee(String name, String password) {
    boolean isSpace = checkName(name);
    this.firstLastName = name;
    this.password = password;
    String username;
    String email;
    String passwordSet;
    if (isSpace == true) {
      username = setUsername(name);
      email = setEmail(name);
    } else {
      username = "default";
      email = "user@oracleacademy.Test";
    }
    boolean valid = isValidPassword(password);
    if (valid == true) {
      passwordSet = password;
    } else {
      passwordSet = "pw";
    }
    this.finalPassword = passwordSet;
    toString();
  }

  /**
   * A method that checks if the employee's name contains a space or not.
   *
   * @param name The employee's name.
   * @return Returns a Boolean value for if the user's name contains a space or not.
   */
  public boolean checkName(String name) {
    boolean hasSpace;
    hasSpace = name.contains(" ");
    return hasSpace;
  }

  /**
   * A method that generates an employee username using their own name.
   *
   * @param name The employee's name.
   * @return Returns the employee's newly generated username in the form of a String.
   */
  public String setUsername(String name) {
    String usernameSet;
    boolean isSpace = checkName(name);
    if (isSpace == true) {
      usernameSet = name.substring(0, 1).toLowerCase() + name.substring(4, 7).toLowerCase();
    } else {
      usernameSet = "default";
    }
    return usernameSet;
  }

  /**
   * A method that generates an employee email using their own name.
   *
   * @param name The employee's name.
   * @return Will return the employee's newly generated email in the form of a String.
   */
  public String setEmail(String name) {
    String emailSet;
    boolean isSpace = checkName(name);
    if (isSpace == true) {
      emailSet = name.substring(0, 3).toLowerCase() + "." + name.substring(4, 7).toLowerCase()
          + "@oracleacademy.Test";
    } else {
      emailSet = "user@oracleacademy.Test";
    }
    return emailSet;
  }

  /**
   * A method that checks the validity of the employee's password.
   *
   * @param password The employee's original password to be checked.
   * @return Will return either the employee's original password or a default password if the
   * original is invalid.
   */
  public boolean isValidPassword(String password) {
    boolean validity;
    if (password.matches("[a-z][A-Z][a-z]{2}[^a-zA-Z0-9]")) {
      //Regular Expression to see if the user entered password is valid.
      validity = true;
    } else {
      validity = false;
    }
    return validity;
  }

  @Override
  public String toString() {
    return "Employee Details\nName : " + firstLastName + "\nUsername : "
        + setUsername(firstLastName) + "\nEmail : " + setEmail(firstLastName)
        + "\nInitial Password : " + finalPassword;
  }
}
