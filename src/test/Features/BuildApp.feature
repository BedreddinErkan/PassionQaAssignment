Feature: Test Set Build App Page


  @AppCategory @Done
  Scenario Outline: Choose App Category
  Given User on the "BuildApp" Page
  When User choose App Category "<AppCategory>"
 # Then Verify user see theme Related App Category "<AppCategory>"

  Examples:
    |AppCategory   |
    |education     |
    |business      |
    |food_and_drink|
    |entertainment |
    |lifestyle     |
    |medical       |
    |sports        |
    |travel        |

    @SignUp @NotDone
    Scenario Outline: Create Account on Build App Valid Credentials
      Given User on the "SignUpPageURL" Page
      When User create account valid credentials "<Email>" "<password>"
      Then Verify user able create account

      Examples:
        |Email          |password |
        |testautomation2|123456789|

     @Payment @NotDone
      Scenario Outline: Create Account and Check Payment Valid Credentials
        Given User on the "CheckOutPage" Page
        When User create account valid credentials "<FullName>" "<Email>" "<Country>" "<PhoneNumber>"
        And User able to check payment credentials "<CreditCardNumber>" "<Expiry>" "<CvCode>"

        Examples:
        |FullName       |Email                       |Country         |PhoneNumber        |CreditCardNumber   |Expiry|CvCode|
        |test automation|testautomation3452@gmail.com|US              |99 999 999 99 99   |1111 1111 1111 1111|1221  |123   |