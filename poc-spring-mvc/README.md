# POC Spring MVC
El objetivo de este proyecto es ejecutar un test de carga sobre un proyecto basico (solo /GET) hecho el objetivo de relevar estadisticas de los siguientes frameworks:

* Spring MVC
* Spring MVC con Virtual Threads
* Spring WebFlux

### Pre-requisitos
* Java 21 o superior
* Maven v3.4.2 o superior
* Docker

### Configuración de la aplicación

Para ejecutar de manera local este proyecto:

1) Correr docker-compose para generar la imagen de Postgress


    docker-compose -f docker/dev/docker-compose.yml up -d

2) Conectarse a la BD Postgress usando [DBeaver](https://dbeaver.io/) o cualquier cliente de BD con los siguietes datos:

```
url: jdbc:postgresql://localhost:5432/test
user: test
pass: test
```
3) Crear el esquema `test` si no existe y ejecutar los siguientes scripts:
- [CREATE TABLE USER](/docker/dev/CREATE_USER.sql)
- [INSERT USER](/docker/dev/INSERT_USER.sql)

### Compilación
Ejecutar el comando

```bash 
mvn clean install
```

### Ejecución

En linea de comandos
```bash
mvn spring-boot:run
```

### Test
En linea de comandos
```bash
mvn gatling:test
```
Podemos ver los resultados al final de la ejecución del test, con un link a los graficos

![](/docs/img/link_test_result.jpg)

![](/docs/img/test_result.jpg)


## POC Spring MVC con Virtual Threads

Para habilitar la funcionalidad de VT en un proyecto con Spring Boot >= 3.2, simplemente debemos agregar la siguiente configuración:

```
spring.threads.virtual.enabled=true
```

### Troubleshooting

Si usan [jconsole](https://web.mit.edu/java_v1.5.0_22/distrib/share/docs/guide/management/jconsole.html) o alguna otra herramienta de monitoreo, es importante que agreguen las siguientes variables de entorno a la JVM

```
-Dcom.sun.management.jmxremote 
-Dcom.sun.management.jmxremote.port=5588 
-Dcom.sun.management.jmxremote.ssl=false 
-Dcom.sun.management.jmxremote.authenticate=false 
-Djava.rmi.server.hostname=127.0.0.1
```

![](/docs/img/jconsole.jpg)