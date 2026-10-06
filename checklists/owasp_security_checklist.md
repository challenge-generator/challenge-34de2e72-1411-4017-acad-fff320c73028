# Checklist de Seguridad OWASP 2017-2021

## A1: Inyección (Injection)
- [ ] Validar entrada de datos en todos los campos de formulario
- [ ] Utilizar consultas parametrizadas (PreparedStatement)
- [ ] Implementar validación en capa de aplicación y base de datos
- [ ] Escapar caracteres especiales en consultas SQL

## A2: Autenticación Rota (Broken Authentication)
- [ ] Implementar autenticación multifactor (MFA)
- [ ] No deploying credenciales predeterminadas
- [ ] Verificar fortaleza de contraseñas (mínimo 12 caracteres, mayúsculas, minúsculas, números, símbolos)
- [ ] Implementar bloqueo de cuenta tras intentos fallidos
- [ ] Gestionar sesiones de forma segura (timeouts, rotación de IDs)

## A3: Exposición de Datos Sensibles
- [ ] Cifrar datos en tránsito (TLS 1.2+)
- [ ] Cifrar datos en reposo con algoritmos fuertes
- [ ] No almacenar datos sensibles sin cifrado
- [ ] Implementar HTTP Strict Transport Security (HSTS)
- [ ] Configurar encabezados de seguridad apropiados

## A4: Configuración de Seguridad Incorrecta
- [ ] Revisar configuraciones de servidor y aplicación
- [ ] Deshabilitar funcionalidades innecesarias
- [ ] Mantener actualizado software y dependencias
- [ ] Configurar políticas de CORS apropiadas
- [ ] Eliminar información de depuración en producción

## A5: Control de Acceso Roto
- [ ] Implementar control de acceso por principio de menor privilegio
- [ ] Validar permisos en cada acceso a recurso
- [ ] Denegar por defecto todo acceso
- [ ] Registar eventos de acceso y fallos de seguridad
- [ ] Realizar revisiones de control de acceso periódicas

## A6: Seguridad de Configuración Incorrecta
- [ ] Verificar que las configuraciones de seguridad sean robustas
- [ ] Revisar permisos en archivos y directorios
- [ ] Implementar separacion de entornos (dev, staging, prod)
- [ ] Gestionar configuraciones sensibles de forma segura

## A7: Cross-Site Scripting (XSS)
- [ ] Escapar contenido no confiable en respuestas HTML
- [ ] Utilizar encabezados de Content-Type apropiados
- [ ] Implementar políticas de CSP (Content Security Policy)
- [ ] Validar y sanear entradas de usuario
- [ ] Utilizar frameworks con protección XSS integrada

## A8: Deserialización Insegura
- [ ] Validar tipos de objetos antes de deserializar
- [ ] No aceptar objetos serializados de fuentes no confiables
- [ ] Utilizar firmas digitales en objetos serializados
- [ ] Limitar puertos y protocolos de deserialización

## A9: Uso de Componentes con Vulnerabilidades Conocidas
- [ ] Mantener inventario de componentes utilizados
- [ ] Monitorear vulnerabilidades de componentes
- [ ] Actualizar componentes a versiones seguras
- [ ] Eliminar componentes no utilizados
- [ ] Obtener componentes de fuentes oficiales

## A10: Registro y Monitoreo Insuficientes
- [ ] Implementar logging de eventos de seguridad
- [ ] Configurar alertas para actividades sospechosas
- [ ] Establecer procedimientos de respuesta a incidentes
- [ ] No registrar datos sensibles (contraseñas, tokens)
- [ ] Revisar y analizar logs regularmente

## A11: Falsificación de Solicitudes del Lado del Servidor (SSRF)
- [ ] Validar y sanear URLs proporcionadas por usuario
- [ ] Implementar listas blancas de recursos permitidos
- [ ] Deshabilitar redirecciones HTTP posteriores
- [ ] Segmentar funcionalidad de acceso a recursos

## Criterios de Aceptación
- Todas las verificaciones críticas (A1-A5) deben estar marcadas
- Máximo 2 items pendientes en categorías de alto riesgo
- Plan de remediación documentado para items pendientes
- Evidencia de pruebas de penetración asociadas

## Referencias
- OWASP Top 10 2017
- OWASP Top 10 2021
- NIST SP 800-53
- ISO/IEC 27001