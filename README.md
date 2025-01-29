# POC: Spring MVC vs Spring WebFlux vs Spring MVC con VT
POC para ejecutar pruebas de Spring MVC vs Spring Web Flux vs Spring MVC con VT

## Objetivo
El objetivo de esta prueba es mostrar evidencia que ayude a determinar como es el comportamiento de los siguientes frameworks:
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Web Flux](https://docs.spring.io/spring-framework/reference/web/webflux.html)
- [Spring MVC con Virtual Threads](https://spring.io/blog/2022/10/11/embracing-virtual-threads)

## POC Spring MVC

* [Documentación y pruebas](/poc-spring-mvc/README.md)

## POC Spring WebFlux

* [Documentación y pruebas](/poc-spring-mvc/README.md)

## POC Spring MVC + Virtual Threads

* [Documentación y pruebas](/poc-spring-mvc/README.md#poc-spring-mvc-con-virtual-threads)

## Spring MVC vs. Spring WebFlux

| Aspecto | Spring MVC | Reactor WebFlux | 
| --- | --- | --- | 
| Programming Model | Utiliza un modelo de procesamiento sincrónico e imperativo con mecanismos de concurrencia tradicionales de Java | Emplea un modelo de procesamiento asincrónico y reactivo utilizando principios de programación reactiva. |     
| Concurrency Model | Sigue un modelo de hilo por solicitud, lo que puede provocar el agotamiento del hilo bajo una carga elevada. | Utiliza una pequeña cantidad de subprocesos para manejar una gran cantidad de solicitudes, lo que lo hace más escalable en condiciones de alta concurrencia. |    
| Learning Curve | Más fácil para los desarrolladores familiarizados con el desarrollo web tradicional y el procesamiento sincrónico. | Requires an understanding of reactive programming, which can have a steeper learning curve | 
| Performance | Funciona bien en aplicaciones con simultaneidad moderada, pero puede tener dificultades con cargas muy altas debido al bloqueo de I/O. | Optimizado para escenarios de alto rendimiento y alta concurrencia con E/S sin bloqueo y transmisiones reactivas. | 
| Development Style | Más tradicional y sencillo, adecuado para la mayoría de aplicaciones web estándar. | Adecuado para aplicaciones modernas que necesitan funciones reactivas, como actualizaciones en tiempo real y alta escalabilidad. | 

mas [info](https://www.geeksforgeeks.org/spring-mvc-vs-spring-web-flux/)


## Spring WebFlux vs. Spring MVC + Virtual Threads

| Aspecto | Reactor WebFlux | Hilos virtuales | 
| --- | --- | --- | 
| Paradigma de programación | Reactivo, sin bloqueo, impulsado por eventos | Imperativo, bloqueante |
| Modelo de concurrencia | Maneja la concurrencia mediante flujos reactivos (Flux, Mono) |   Maneja la concurrencia usando subprocesos virtuales livianos |
| Gestión de subprocesos | Administra los subprocesos internamente con un bucle de eventos |  JVM administra subprocesos, lo que permite miles de subprocesos virtuales |
| Escalabilidad | Alta escalabilidad para tareas limitadas por E/S |   Alta escalabilidad tanto para E/S como para tareas limitadas por la CPU |
| Facilidad de uso | Curva de aprendizaje más pronunciada debido a la programación reactiva | Modelo de subprocesamiento más fácil de usar y familiar |
| Manejo de contrapresión | Soporte de contrapresión incorporado para gestionar el control del flujo. | Sin contrapresión incorporada, se basa en mecanismos tradicionales |
| Modelo de concurrencia| Maneja la concurrencia mediante flujos reactivos (Flux, Mono)  |   Maneja la concurrencia usando subprocesos virtuales livianos |
| Actuación | Optimizado para operaciones limitadas de E/S con baja sobrecarga de subprocesos | Eficiente tanto para tareas de E/S como limitadas por CPU, lo que reduce la sobrecarga de subprocesos |
| Integración con el código existente | Requiere cambios significativos para adoptar patrones reactivos | Es más fácil de integrar con el código existente mediante subprocesos tradicionales |
| Manejo de errores | Complejo, requiere comprensión de la propagación de errores reactivos. | Manejo de errores simplificado similar a los modelos tradicionales basados ​​en subprocesos |
| Casos de uso | Ideal para aplicaciones en tiempo real, transmisión de datos y microservicios. | Ideal para aplicaciones que requieren alta concurrencia con código más simple |


mas [info](https://www.geeksforgeeks.org/reactor-webflux-vs-virtual-threads/)


## Conclusión

¿Cuál es mejor? ....... => **DEPENDE!!!!!!!!!**

### Consejos
- Si no se necesita mucho rendimiento… **da igual!**
- Si no se esperan muchas operaciones bloqueantes IO… **Spring MVC + VT**
- Si las integraciones no tienen librerías reactivas… **Spring MVC + VT**
- Si no es posible implementar todo reactivo… **Spring MVC + VT**
- Si es un microservicio nuevo… **apostar por VT en principio**

NOTA: *Ojo al activar el VT en microservicios existentes… revisar el uso de ThreadLocal, Synchronized y Pools*

Por último:
- *Si tiene mucha experiencia….*    
- *Si tiene clara la necesidad…*
- *Si tiene tiempo y es valiente…*

recomendamos usar **Spring WebFlux**







## Autor 🖊️

* [Gabriel Jiménez](https://github.com/demaryhuerto?tab=repositories)

## Notas 📋
_It's recommended to use [IntelliJ Community](https://www.jetbrains.com/idea/download/) or [Eclipse IDE for Enterprise Java Developers](https://www.eclipse.org/downloads/packages/)_