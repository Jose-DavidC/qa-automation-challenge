Feature: Registro automático al fallar login

  Scenario: Intentar login con usuario inexistente y registrar nuevo usuario
    Given el usuario abre la página de inicio
    When intenta iniciar sesión con un usuario inexistente
    Then se debe mostrar un mensaje de error por credenciales inválidas y hacer clic en Registrarse
    And completa el registro con sector "Caficultor"
