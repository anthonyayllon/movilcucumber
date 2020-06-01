Feature: Uso de funciones del app VodQa


  Background:
    Given Yo cargue el app VodQa
    And Inserte usuario "admin" y password "admin"
    And Me logueo


  Scenario: Validate scroll field1
    Then Scroll hacia abajo hasta encontrar la opción "Carousel"

  Scenario: Validate scroll field2
    Then Scroll hacia abajo hasta encontrar la descripción "carousel"


  Scenario: Validate scroll field3
    Then Scroll hacia abajo a la vista "Wheel Picker"

  Scenario: Validate scroll field4
    Then Scroll hacia abajo a la vista description "wheelPicker"

  Scenario: Validate scroll field5
    Then Scroll hacia abajo por cantidad desplazamiento swipe "webView"

  Scenario: Validate scroll field6
    Then Scroll hacia abajo por coordenadas swipe

  Scenario: Validate scroll field7
    Then Scroll hacia abajo por text "Native View" y fin "Long Press"

  Scenario: Validate scroll field8
    Then Scroll hacia abajo por coordenada teniendo punto de referencia "Native View"

  Scenario: Get text of element
    Then Metodos para identificar elements

  Scenario: Use Drag & Drop
    Then Drag & Drop en elemento "Drag & Drop"

  @appium
  Scenario: Use Slider
    Then Slider en elemento "Slider"






