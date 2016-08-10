package com.pablofiumara.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.pablofiumara.form.*;

/**
 * JSR-303 Validator for our Registration Form
 *
 * @author Bubba Hines <bubba@hines57.com>
 * @since 0.02
 */
public class RegistrationValidator {

  private final Pattern alphaNumPattern;

  RegistrationValidator() {
    this.alphaNumPattern = Pattern.compile("^[a-zA-Z0-9]+$");
  }

  /**
   * This Validator validates just Person instances
   */
  public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
    return RegistrationForm.class.equals(clazz);
  }

  private boolean isNotAlphaNumeric(String input) {
    Matcher m = this.alphaNumPattern.matcher(input);
    return m.find();
  }

  public void validate(Object obj, Errors e) {
    RegistrationForm r = (RegistrationForm) obj;

    /**
     * Username Validation Can't be Empty Must be Alpha Numeric Must be greater
     * than 3 characters Mush be less than 50 characters TODO: Need to check the
     * DB to verify the userID isn't already in use.
     */
    ValidationUtils.rejectIfEmptyOrWhitespace(e, "username", "username.empty");
    if (this.isNotAlphaNumeric(r.getTitulo())) {
      e.rejectValue("username", "username.notAlphaNumberic");
    }
  }
}