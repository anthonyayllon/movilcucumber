Feature: Uso de funciones del app VodQa


  @appium
  Scenario: Validar login exitoso
    Then Enviar los parametros usuario "bob" y password "123456"

  @appium
  Scenario: User calls web service to get a book by its ISBN
    Given a book exists with an isbn of "9781451648546"

  @appium
  Scenario: User calls web service to get a book by its ISBN and headers
    Given a book exists with an isbn of "9781451648546" get headers

  @appium
  Scenario: User calls web service to get a book by its ISBN and body
    Given a book exists with an isbn of "9781451648546" get body

  @appium
  Scenario: User calls web service to get a workers and get element of the body
    Given response json get element of the body

  @appium
  Scenario: User calls web service to get a workers and get object of the body
    Given response json get object of the body


  @appium
  Scenario: User calls web service to update employe
    Then update the employe for id "15410"

  @appium
  Scenario: User calls web service to delete employe
    Then delete the employe for id "15410"