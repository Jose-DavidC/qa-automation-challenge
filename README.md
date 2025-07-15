## Estructura del Proyecto

```
src/
 └── main/
     └── java/
         
 └── test/
     └── java/
         └── pages/            # Page Object Models (POM)
         └── utils/            # Configuración, screenshots, esperas
         └── stepdefinitions/  # Definición de pasos de Cucumber
         └── runners/          # Test Runner (JUnit)
     └── resources/
         └── features/         # Archivos .feature con los escenarios BDD
         └── config.properties # Credenciales y URL


## Problema Encontrado

Durante la ejecución del flujo completo con varios registros consecutivos (tres filas en la tabla Gherkin), se presentó el siguiente error:

```
ElementClickInterceptedException:
Other element would receive the click: <div class="dxgvLoadingDiv_Material" ...>
```

Esto ocurre porque el sistema utiliza un **loader (overlay)** al actualizar las grillas, y este no siempre desaparece a tiempo antes del siguiente clic.

---

## Soluciones posibles

1. **Separar la creación en distintos escenarios** (uno por flujo)
2. **Agregar esperas explícitas robustas hasta que desaparezca el loader**:
   ```java
   wait.until(ExpectedConditions.invisibilityOfElementLocated(
       By.id("ContentPlaceHolder_GridSector_LD")
   ));
   ```
3. **Usar JavaScriptExecutor como último recurso si el clic convencional no funciona**:
   ```java
   WebElement el = driver.findElement(locator);
   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
   ```

---

## Requisitos

- JDK 21
- Maven 3.x
- Google Chrome actualizado
- ChromeDriver compatible
- IntelliJ IDEA / Eclipse

---

## Configuración

1. Clonar el proyecto:
   ```bash
   git clone https://tu-repositorio.git
   ```

2. Importar como proyecto Maven


3. Ejecutar el runner:
    -Para la ejecución del primer punto, cambiar el tag a @Registro, para el segundo punto cambiar el tag a @CreacionItems
    - Desde IDE: clic derecho en `TestRunner.java` > Run
    - O desde terminal:
      ```bash
      mvn test
      ```

---

## 📸 Evidencias

Las capturas de pantalla se almacenan automáticamente en la carpeta `screenshots/` con nombres descriptivos como:
- `Login-admin.png`
- `Sector-COVID.png`
- `Tema-TLC.png`
- etc.


Autor

Automatizado por: **Jose David Carreño**