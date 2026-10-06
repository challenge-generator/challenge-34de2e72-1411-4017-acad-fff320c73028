# Implementación de Validaciones de Seguridad en Proyectos

El objetivo es garantizar la calidad y seguridad de los proyectos a través de la ejecución de pruebas de seguridad basadas en el marco OWASP 2017-2021. Los resultados de estas pruebas deben ser socializados en los proyectos utilizando un checklist diseñado para este propósito. El proyecto en cuestión es un sistema de gestión de préstamos en una entidad financiera, donde los actores principales son el originador de créditos, el motor antifraude, el buró de riesgos y el core bancario. El sistema debe manejar un volumen de 1 500 solicitudes por segundo en hora pico y mantener un SLA del 99.9%.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Ejecución de Pruebas de Seguridad |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 2 semanas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Identificación de Vulnerabilidades

**Objetivo:** Identificar las vulnerabilidades de seguridad presentes en el sistema de gestión de préstamos.

**Tiempo estimado:** 3 días

**Instrucciones:**

- Analiza el sistema de gestión de préstamos para identificar posibles vulnerabilidades de seguridad.
- Utiliza el marco OWASP 2017-2021 como guía para la identificación de vulnerabilidades.

**Entregable:** Lista de vulnerabilidades identificadas en el sistema.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las interacciones entre el originador de créditos, el motor antifraude, el buró de riesgos y el core bancario.
- Evalúa el impacto de cada vulnerabilidad en el SLA del sistema.

</details>

### Fase 2: Diseño de Pruebas de Seguridad

**Objetivo:** Diseñar pruebas de seguridad para validar las vulnerabilidades identificadas.

**Tiempo estimado:** 4 días

**Instrucciones:**

- Diseña pruebas de seguridad para cada vulnerabilidad identificada en la fase anterior.
- Asegúrate de que las pruebas cubran los diferentes escenarios y edge cases posibles.

**Entregable:** Conjunto de pruebas de seguridad diseñadas para validar las vulnerabilidades identificadas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera el volumen de solicitudes que el sistema debe manejar en hora pico.
- Evalúa la idempotencia del registro de solicitudes por número de operación y canal.

</details>

### Fase 3: Ejecución y Socialización de Resultados

**Objetivo:** Ejecutar las pruebas de seguridad y socializar los resultados en los proyectos.

**Tiempo estimado:** 3 días

**Instrucciones:**

- Ejecuta las pruebas de seguridad diseñadas en la fase anterior.
- Socializa los resultados de las pruebas en los proyectos utilizando un checklist diseñado para este propósito.

**Entregable:** Informe de resultados de las pruebas de seguridad socializado en los proyectos.

<details>
<summary>Pistas de conocimiento</summary>

- Asegúrate de que el checklist incluya todos los puntos de validación necesarios.
- Evalúa la efectividad de las pruebas en función de los resultados obtenidos.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son las pruebas de seguridad y por qué son importantes en un sistema de gestión de préstamos?
- **paraQueSirve**: ¿Para qué sirve el marco OWASP en la identificación de vulnerabilidades de seguridad?
- **comoSeUsa**: ¿Cómo se diseñan y ejecutan pruebas de seguridad efectivas en un sistema de gestión de préstamos?
- **erroresComunes**: ¿Cuáles son los errores comunes al diseñar y ejecutar pruebas de seguridad?
- **queDecisionesImplica**: ¿Qué decisiones debes tomar al socializar los resultados de las pruebas de seguridad en los proyectos?

## Criterios de Evaluacion

- Identificación correcta de vulnerabilidades de seguridad en el sistema de gestión de préstamos.
- Diseño de pruebas de seguridad efectivas para validar las vulnerabilidades identificadas.
- Ejecución y socialización de los resultados de las pruebas de seguridad en los proyectos.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean test-compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
