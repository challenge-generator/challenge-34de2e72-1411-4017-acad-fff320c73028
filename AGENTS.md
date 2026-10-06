# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de Validaciones de Seguridad en Proyectos**.

| | |
|---|---|
| Tema | Ejecución de Pruebas de Seguridad |
| Nivel | senior-l2 |
| Chapter | Calidad de Software |
| Especialidad | Automatizador |
| Stack | Java / Serenity BDD 4.1.6 + OWASP ZAP 2.15.0 |
| Patron arquitectonico | Screenplay Pattern con capas separadas para tareas, preguntas, interacciones y modelos de seguridad |
| Tiempo estimado | 2 semanas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz con el runner y el plugin de reportes`
- `src/test/resources/features con los .feature en Gherkin`
- `src/test/java/.../runners con el runner`
- `src/test/java/.../pages o /tasks con Page Objects o Screenplay`
- `src/test/java/.../steps con los step definitions`
- `serenity.conf o config del entorno`

Trampas conocidas:

- Sin parent POM que gestione versiones, TODA dependencia lleva su `<version>` completa de tres segmentos.
- El groupId de Serenity es `net.serenity-bdd`, NO `org.serenity-bdd`. Con el groupId equivocado el artefacto no existe y el build muere resolviendo dependencias.
- Coordenadas exactas de lo mas usado: Selenium `org.seleniumhq.selenium:selenium-java`, Rest Assured `io.rest-assured:rest-assured`, Karate `com.intuit.karate:karate-junit5`, Cucumber `io.cucumber:cucumber-java`.
- JUnit 5 se declara con `junit-jupiter` (agregador) y necesita `maven-surefire-plugin` reciente para ejecutarse.
- Serenity y Cucumber tienen que ser de lineas compatibles entre si; mezclarlas rompe el runner.

Dependencias:

- net.serenity-bdd:serenity-core 4.1.6
- net.serenity-bdd:serenity-junit5 4.1.6
- net.serenity-bdd:serenity-cucumber 4.1.6
- org.owasp.zap:zap-clientapi 1.12.0
- io.cucumber:cucumber-java 7.15.0
- io.cucumber:cucumber-junit-platform-engine 7.15.0
- org.junit.jupiter:junit-jupiter-api 5.10.2
- org.junit.jupiter:junit-jupiter-engine 5.10.2
- io.rest-assured:rest-assured 5.4.0
- org.seleniumhq.selenium:selenium-java 4.22.0
- org.apache.maven.plugins:maven-surefire-plugin 3.2.5
- net.serenity-bdd:serenity-maven-plugin 4.1.6
- org.projectlombok:lombok 1.18.30

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean test-compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean test-compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Identificación de Vulnerabilidades**: Lista de vulnerabilidades identificadas en el sistema.
- **Fase 2 — Diseño de Pruebas de Seguridad**: Conjunto de pruebas de seguridad diseñadas para validar las vulnerabilidades identificadas.
- **Fase 3 — Ejecución y Socialización de Resultados**: Informe de resultados de las pruebas de seguridad socializado en los proyectos.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/test/resources/features/security_validation.feature` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/loansecurity/runners/RunSecurityTests.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/loansecurity/steps/SecurityValidationSteps.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/loansecurity/tasks/ScanForVulnerabilities.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/loansecurity/questions/VulnerabilityResults.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/loansecurity/interactions/CallApi.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/loansecurity/models/SecurityReport.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/loansecurity/exceptions/SecurityValidationException.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/loansecurity/utils/SecurityValidator.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/loansecurity/utils/JwtUtils.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `checklists/owasp_security_checklist.md` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `reports/security_report_sample.md` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/loansecurity/config/SecurityConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/loansecurity/interactions/Authenticate.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Archivos que la arquitectura declara (1 de 18)

La propuesta arquitectonica del reto los lista y no llegaron al repo. Crealos con implementacion real, respetando la capa en la que viven:

- [ ] `RunCucumberTest.java`

### 2. Referencias colgando (4)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/test/java/com/pragma/loansecurity/utils/SecurityValidator.java` — `org.owasp.encoder`
      El import org.owasp.encoder.Encode pertenece a org.owasp.encoder, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/pragma/loansecurity/config/SecurityConfig.java` — `org.springframework.stereotype`
      El import org.springframework.stereotype.Component pertenece a org.springframework.stereotype, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `pom.xml` — `org.owasp.zap:zap-clientapi@1.12.0`
      org.owasp.zap:zap-clientapi declara la version 1.12.0, pero Maven Central respondio que esa version no existe. Es una version inventada: reemplazala por una version publicada real, o si no se conoce con certeza, usa el mecanismo centralizado del ecosistema (BOM/parent/platform/version catalog) y no declares una version individual.
- [ ] `pom.xml` — `net.serenity-bdd:serenity-bdd-bom@4.1.6`
      net.serenity-bdd:serenity-bdd-bom declara la version 4.1.6, pero Maven Central respondio que esa version no existe. Es una version inventada: reemplazala por una version publicada real, o si no se conoce con certeza, usa el mecanismo centralizado del ecosistema (BOM/parent/platform/version catalog) y no declares una version individual.

### Presentes (18)

- `pom.xml`
- `src/test/java/com/pragma/loansecurity/models/SecurityReport.java`
- `src/test/java/com/pragma/loansecurity/runners/RunCucumberTest.java`
- `src/test/resources/config/serenity.conf`
- `src/test/resources/features/security_validation.feature`
- `src/test/java/com/pragma/loansecurity/runners/RunSecurityTests.java`
- `src/test/java/com/pragma/loansecurity/steps/SecurityValidationSteps.java`
- `src/test/java/com/pragma/loansecurity/tasks/ScanForVulnerabilities.java`
- `src/test/java/com/pragma/loansecurity/questions/VulnerabilityResults.java`
- `src/test/java/com/pragma/loansecurity/interactions/CallApi.java`
- `src/test/java/com/pragma/loansecurity/exceptions/SecurityValidationException.java`
- `src/test/java/com/pragma/loansecurity/utils/SecurityValidator.java`
- `src/test/java/com/pragma/loansecurity/utils/JwtUtils.java`
- `src/test/resources/data/test_data.csv`
- `src/test/java/com/pragma/loansecurity/config/SecurityConfig.java`
- `src/test/java/com/pragma/loansecurity/interactions/Authenticate.java`
- `checklists/owasp_security_checklist.md`
- `reports/security_report_sample.md`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/test/java/com/pragma/loansecurity`
- `src/test/java/com/pragma/loansecurity/tasks`
- `src/test/java/com/pragma/loansecurity/questions`
- `src/test/java/com/pragma/loansecurity/interactions`
- `src/test/java/com/pragma/loansecurity/models`
- `src/test/java/com/pragma/loansecurity/exceptions`
- `src/test/java/com/pragma/loansecurity/utils`
- `src/test/java/com/pragma/loansecurity/steps`
- `src/test/java/com/pragma/loansecurity/runners`
- `src/test/resources/features`
- `src/test/resources/data`
- `src/test/resources/config`
- `reports`
- `checklists`

## Verificacion

```bash
mvn clean test-compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **Screenplay Pattern con capas separadas para tareas, preguntas, interacciones y modelos de seguridad**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Calidad de Software, Especialidad Automatizador, Tecnología QA Security, Senior
- Brecha que el reto ataca: Realiza validaciones mínimas de seguridad conforme al marco de OWASP 2017-2021 y socializa los resultados en los proyectos, apoyado en el checklist diseñado para este propósito.
- Mision: Candidato con experiencia como automatizador QA, enfocado en garantizar la calidad y seguridad de los proyectos.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
