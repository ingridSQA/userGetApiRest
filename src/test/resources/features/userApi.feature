Feature: Validacion de la API de Users

  Scenario: Validar el codigo de respuesta de una peticion GET a una lista de usuarios
    Given que el usuario realiza una peticion GET a "/api/users?page=2"
    Then la respuesta debe tener un codigo con estado 200