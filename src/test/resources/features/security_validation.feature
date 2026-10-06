#language: es
Característica: Validacion de Seguridad en Sistema de Prestamos
  Como tester de seguridad
  Necesito ejecutar pruebas de vulnerabilidad sobre el sistema de gestion de prestamos
  Para identificar y documentar debilidades de seguridad antes de produccion

  # Superficie de practica: completar con escenarios basados en OWASP Top 10 2017-2021
  # El sistema bajo prueba es un sistema de gestion de prestamos para entidad financiera
  # Los actores principales son: originador de creditos, motor antifraude, buró de riesgos, core bancario

  @security @owasp-a1 @sql-injection
  Escenario: Validar proteccion contra inyeccion SQL en endpoint de consulta de prestamos
    Dado que el sistema esta disponible
    Cuando realizo una peticion con payload malicioso contendo "' OR '1'='1"
    Entonces el sistema debe rechazar la peticion con codigo de error
    Y debe registrar el intento en logs de seguridad

  @security @owasp-a2 @broken-auth
  Escenario: Validar proteccion contra autenticacion debil en acceso a prestamos
    Dado que el sistema esta disponible
    Cuando intento autenticarme con credenciales por defecto "admin"
    Entonces el sistema debe rechazar la autenticacion
    Y debe implementar politica de bloqueo despues de 3 intentos fallidos

  @security @owasp-a3 @sensitive-data
  Escenario: Validar proteccion de datos sensibles en respuestas de API
    Dado que el sistema procesa solicitudes de prestamo
    Cuando consulto los detalles de un prestamo
    Entonces los datos sensibles deben estar cifrados
    Y no deben exponerse en logs o respuestas sin cifrar

  @security @owasp-a4 @xxe
  Escenario: Validar proteccion contra XXE en procesamiento de documentos
    Dado que el sistema acepta documentos XML para validacion de prestamos
    Cuando envio un documento con entidades externas maliciosas
    Entonces el sistema debe rechazar el documento
    Y debe registrar el intento de ataque

  @security @owasp-a5 @broken-access-control
  Escenario: Validar control de acceso en consulta de prestamos de otros usuarios
    Dado que estoy autenticado como usuario con rol de cliente
    Cuando intento acceder a prestamos de otro usuario mediante manipulacion de ID
    Entonces el sistema debe denegar el acceso
    Y debe registrar el intento de acceso no autorizado

  @security @owasp-a6 @security-misconfiguration
  Escenario: Validar que endpoints de diagnostico no expongan informacion sensible
    Dado que el sistema esta desplegado
    Cuando accedo al endpoint de health check
    Entonces no debe exponer informacion de configuracion interna
    Y no debe mostrar stack traces en respuestas de error

  @security @owasp-a7 @xss
  Escenario: Validar proteccion contra XSS en campos de formulario de prestamo
    Dado que el sistema permite registro de solicitudes de prestamo
    Cuando ingreso codigo JavaScript en campos de texto "<script>alert(1)</script>"
    Entonces el sistema debe sanitizar o rechazar el input
    Y debe escapar caracteres especiales en respuestas

  @security @owasp-a8 @deserialization
  Escenario: Validar proteccion contra deserializacion insegura
    Dado que el sistema procesa objetos serializados
    Cuando recibo un payload serializado malicioso
    Entonces el sistema debe validar y rechazar objetos no confiables
    Y debe usar serializacion segura o JSON

  @security @owasp-a9 @vulnerable-components
  Escenario: Validar que componentes terceros no tengan vulnerabilidades conocidas
    Dado que el sistema utiliza librerias externas
    Cuando realizo el analisis de dependencias
    Entonces no deben existir vulnerabilidades con severidad alta o critica
    Y todas las librerias deben estar actualizadas

  @security @owasp-a10 @logging
  Escenario: Validar que logs no contengan informacion sensible
    Dado que el sistema procesa solicitudes de prestamo
    Cuando realizo operaciones con datos de clientes
    Entonces los logs no deben contener numeros de identificacion completos
    Y no deben contener tokens de sesion o contraseñas

  @security @rate-limiting
  Escenario: Validar proteccion contra ataques de fuerza bruta
    Dado que el sistema ofrece endpoint de autenticacion
    Cuando realizo mas de 10 intentos de login en un minuto
    Entonces el sistema debe implementar limitacion de tasa
    Y debe bloquear temporalmente las requests del origen

  @security @api-security
  Escenario: Validar que API REST implementa buenas practicas de seguridad
    Dado que consumo los endpoints de la API de prestamos
    Cuando realizo peticines sin headers de seguridad
    Entonces la API debe requerir Content-Type
    Y debe implementar CORS con origenes confiables
    Y debe设置了Headers de seguridad (X-Content-Type-Options, X-Frame-Options)