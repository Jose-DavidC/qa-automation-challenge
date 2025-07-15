@Registro
Feature: Registro de usuario al fallar inicio de sesión

  Scenario: Registro de usuario nuevo al fallar inicio de sesión
    Given el usuario abre la página de inicio
    When intenta iniciar sesión con usuario "mail@mail.com" y clave "claveIncorrecta123"
    Then se debe mostrar un mensaje de error por credenciales inválidas
    When hace clic en Registrarse
    And completa el formulario con los siguientes datos:
      | Nombre   | Empresa123    |
      | NIT      | 11221212111   |
      | Sector   | Caficultor    |
      | Teléfono | 3001234567    |
      | Correo   | mail@mail.com |
      | Clave    | Password123   |
    Then se muestra un mensaje de éxito indicando que el registro fue exitoso
