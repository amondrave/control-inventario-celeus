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

## Arquitectura

El sistema de inventario Celeus utiliza una arquitectura a 3 capas que sigue los principios de separación de preocupaciones y modularidad. Las tres capas principales son:

1. Capa Web: Esta capa es responsable de manejar todos los accesos hacia los servicios y posibles conexiones con otros microservicios. Aquí se encuentran los controladores, endpoints y componentes relacionados con la interfaz de usuario. La capa web actúa como punto de entrada para las solicitudes y respuestas HTTP, así como también para la autenticación y autorización.

2. Capa Persistence: La capa de persistencia se encarga de toda la operabilidad de acceso a datos y mapeadores. Aquí se definen los repositorios, entidades y configuraciones de acceso a la base de datos. La capa persistence se encarga de las operaciones de lectura y escritura en la base de datos, así como de la gestión de transacciones y consultas.

3. Capa Domain: En esta capa se encuentra toda la lógica del negocio, utilidades y manejo de excepciones. Aquí se definen los servicios, modelos de dominio y reglas de negocio. La capa domain encapsula la lógica central de la aplicación y proporciona interfaces para que las capas superiores puedan interactuar con ella de manera coherente.

Esta arquitectura a 3 capas ayuda a mantener una separación clara de responsabilidades y promueve la reutilización de componentes. Cada capa tiene su propósito específico y se comunica con las capas adyacentes a través de interfaces bien definidas, lo que facilita la escalabilidad, el mantenimiento y la evolución del sistema.

## Uso
A continuación, se detallan los pasos para utilizar el sistema de inventario Celeus:

1. Ejecuta la aplicación: `gradle bootRun`
2. Abre tu navegador web y accede a la siguiente URL: `http://localhost:8090/inventario`
3. Ingresa tus credenciales de inicio de sesión.
4. Explora las diferentes funcionalidades del sistema de inventario.

## Contribución
Si deseas contribuir al desarrollo del sistema de inventario Celeus, sigue estos pasos:

1. Crea una nueva rama: `git checkout -b feature/nueva-funcionalidad`
2. Realiza los cambios necesarios y guarda los archivos modificados.
3. Realiza el commit de tus cambios: `git commit -m "Agrega nueva funcionalidad"`
4. Sube tus cambios a la rama: `git push origin feature/nueva-funcionalidad`
5. Abre un pull request en el repositorio.

## Contribuidores
Agradecemos a las siguientes personas por su contribución a este proyecto:

- [Angel Yesid Mondragon Rodriguez](https://github.com/amondrave) - Desarrollador 👨‍💻

¡Gracias por tu apoyo y contribución!



## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para obtener más detalles.

## Contacto
Si tienes alguna pregunta o consulta relacionada con el sistema de inventario Celeus, puedes contactarnos en <correo@celeus.com> o visitar nuestro sitio web en [www.celeusgroup.com](https://www.celeusgroup.com).
