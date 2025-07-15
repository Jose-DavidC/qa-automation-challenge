@CreacionItems
Feature: Crear estructura jerárquica de evaluación

  Como usuario administrador
  Quiero crear sectores, temas, subtemas y preguntas
  Para la prueba técnica solicitada

  Background:
    Given que el usuario ha iniciado sesión como administrador

  Scenario: Crear múltiples estructuras jerárquicas
    When crea las siguientes estructuras:
      | NombreSector               | NombreTema        | NombreSubtema     | TextoPregunta     |
      | Industria y comercio       | TLC               | Exportacion Arroz | Pregunta 1 prueba |
      | Bioseguridad en el trabajo | Toma temperaturas | Termometros       | Pregunta 2 prueba |
      | COVID                      | Pruebas COVID     | Prueba de sangre  | Pregunta 3 prueba |

    Then las estructuras deben quedar registradas correctamente
