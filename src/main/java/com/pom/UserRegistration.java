package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.TestBase;

public class UserRegistration extends TestBase {

    public UserRegistration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public class User {
        private String name;
        private String mobileNumber;
        private String gender;
        private String department;
        private String city;
        private String password;
        private String confirmPassword;

        // Getters and Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getMobileNumber() { return mobileNumber; }
        public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }
        public String getDepartment() { return department; }
        public void setDepartment(String department) { this.department = department; }
        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
        public String getConfirmPassword() { return confirmPassword; }
        public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
		public CharSequence getEmail() {
			// TODO Auto-generated method stub
			return null;
		}
		public CharSequence getExperience() {
			// TODO Auto-generated method stub
			return null;
		}
    }

    public class UserService {
        public boolean registerUser(User user) {
            if (user == null) { return false; }
            if (!user.getPassword().equals(user.getConfirmPassword())) { return false; }
            return isValidPassword(user.getPassword());
        }

        private boolean isValidPassword(String password) {
            if (password == null || password.length() < 6 || password.length() > 20) {
                return false;
            }

            boolean hasUpperCase = !password.equals(password.toLowerCase());
            boolean hasLowerCase = !password.equals(password.toUpperCase());
            boolean hasDigit = password.chars().anyMatch(Character::isDigit);
            boolean hasSpecialChar = password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));

            return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
        }
    }

    @FindBy(name = "professorName")
    private WebElement professorNameInput;

    @FindBy(name = "gender")
    private WebElement genderSelect;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "mobile")
    private WebElement mobileInput;

    @FindBy(name = "address")
    private WebElement addressInput;

    @FindBy(name = "department")
    private WebElement departmentSelect;

    @FindBy(name = "experience")
    private WebElement experienceInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(id = "eyeButton")
    private WebElement eyeButton;

    @FindBy(name = "agree")
    private WebElement agreeCheckbox;

    @FindBy(name = "register")
    private WebElement registerButton;

    public void fillRegistrationForm(User user) {
        professorNameInput.sendKeys(user.getName());
        genderSelect.sendKeys(user.getGender());
        emailInput.sendKeys(user.getEmail());
        mobileInput.sendKeys(user.getMobileNumber());
        addressInput.sendKeys(user.getCity());
        departmentSelect.sendKeys(user.getDepartment());
        experienceInput.sendKeys(user.getExperience());
        passwordInput.sendKeys(user.getPassword());
        confirmPasswordInput.sendKeys(user.getConfirmPassword());
        eyeButton.click();
        agreeCheckbox.click();
        registerButton.click();
    }
}
