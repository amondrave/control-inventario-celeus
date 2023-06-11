# Sistema de Inventario Celeus

## Requerimientos
Antes de comenzar a utilizar el sistema de inventario Celeus, asegúrate de cumplir con los siguientes requisitos:

- Tener Java 11 instalado y configurado en el Path.
- Tener Gradle instalado y configurado en el Path.

## Instalación y Configuración
Sigue estos pasos para instalar y configurar el sistema de inventario Celeus:

1. Clona el repositorio del proyecto: `git clone https://github.com/amondrave/control-inventario-celeus`
2. Navega al directorio del proyecto: `cd control-inventario-celeus`
3. Ejecuta la compilación del proyecto: `gradle build`

## Perfiles

Para el desarrollo configurar el archivo application.properties que se encuentra en al ruta
src/main/resources/application.properties con el fin de que activar el perfil dev.

Para producción es necesario definir un perfil prod para eso sobre la misma ruta se crea un archivo
application-prod.properties en donde se deberan definir las variables para entorno productivo

## Uso
A continuación, se detallan los pasos para utilizar el sistema de inventario Celeus:

1. Ejecuta la aplicación: `gradle bootRun`
2. Abre tu navegador web y accede a la siguiente URL: `http://localhost:80900/inventario`
3. Ingresa tus credenciales de inicio de sesión.
4. Explora las diferentes funcionalidades del sistema de inventario.

## Contribución
Si deseas contribuir al desarrollo del sistema de inventario Celeus, sigue estos pasos:

1. Crea una nueva rama: `git checkout -b feature/nueva-funcionalidad`
2. Realiza los cambios necesarios y guarda los archivos modificados.
3. Realiza el commit de tus cambios: `git commit -m "Agrega nueva funcionalidad"`
4. Sube tus cambios a la rama: `git push origin feature/nueva-funcionalidad`
5. Abre un pull request en el repositorio.

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para obtener más detalles.

## Contacto
Si tienes alguna pregunta o consulta relacionada con el sistema de inventario Celeus, puedes contactarnos en <correo@celeus.com> o visitar nuestro sitio web en [www.celeus.com](https://www.celeus.com).
