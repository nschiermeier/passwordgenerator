# passwordgenerator
A password generator with a UI to go along with it.

**PasswordGUI.java**: This class contains all the code for the GUI part of this microapplication. Includes functionality such as hitting the buttons, setting the length of the password, viewing the password and allowing user to copy it, etc. An early diagram for this GUI can be viewed in passwordgenerator/out/artifacts/My_Password_Generator_lower_JDK_jar/ .

**Password.java**: This class contains the logic used in order to randomly generate the password. This is done through making a password object with parameters from the buttons clicked in the GUI, and then going through a loop in order to randomly (with a seed) generate each character. It will then return this password, which is displayed in the GUI.

**How to download**: The jar file can be downloaded in passwordgenerator/out/artifacts/My_Password_Generator_lower_JDK_jar/ and downloading the .jar file. It should then be able to run, as long as you have the most updated version of Java.
