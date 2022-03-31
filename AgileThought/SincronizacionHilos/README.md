/**
Realizar una aplicación con las siguientes características:

     1. Crear un menú con las opciones
         * 1 - Registrar nuevo cálculo de figura (mensaje a gusto de cada uso)
         * 2 - Abrir archivos con cálculos generados (mensaje a gusto de cada uno)
         * 3 - Salir del programa

     2. El usuario deberá ingresar el número de la opción que desee

     3. Si se selecciona la opción "Registrar nuevo cálculo de figura" (o el mensaje que le hayan puesto)

         3.1 Mostrar lista de opciones de figuras
             * 1 - Circulo
             * 2 - Cuadrado
             * 3 - Rectángulo
             * 4 - Triángulo Equilátero
             * 5 - Triángulo Isósceles

         3.2 De acuerdo a la figura seleccionada, serán los datos que el sistema solicitará para calcular el perímetro y el área,
         para el caso de los triángulos, deberá calcular la altura primero para posteriormente calcular el área con ese dato,
         si es posible, la unidad de medida (cm, mm, m, etc.) manejarla como una property, para que pueda ser configurable.

         3.3 Si todos los cálculos se realizaron correctamente, mostrar un mensaje al usuario de que así fue, adicional, mencionándole
         que serán guardados en un fichero, la misma ventana le solicitará al usuario ingresar el nombre del archivo, validar que
         el nombre del fichero y la extensión no se encuentren previamente creados, de ser así mencionarle que el archivo con el
         mismo nombre ya existe y si desea sobrescribirlo, de ser así eliminar el fichero existente y crear uno nuevo, de lo
         contrario, solicitar nuevamente el nombre del fichero al usuario.


         3.4 Crear el fichero con extensión (.txt), en la carpeta "cálculos" (o como gusten llamarle), que se encuentre en la raíz del
         programa que será la carpeta principal, dentro de esa carpeta principal, se deberán crear carpetas por día con formato yyyy-MM-dd,
         y dentro de ella, guardar el archivo, el nombre de la carpeta principal y extensión de los archivos, de preferencia que
         se definan en un archivo properties, para que también sean configurables.


         3.5 Para la creación de los archivos, deberán utilizar hilos (threads), es decir, la lógica para la creación de archivos deberán
         implementarla en una clase que será un hilo (Thread o Runnable).

         3.6 La información que contendrá el archivo serán los valores del área, perímetro y nombre de la figura seleccionada, adicional todos los
         atributos particulares que le corresponden junto con sus unidades de medida, formateando los valores:

         * Circulo: radio y diámetro
         * Cuadrado: lados
         * Rectángulo: largo y ancho
         * Triángulo Equilátero: lados y altura
         * Triángulo Isósceles: lados, base y altura

         3.7 Al momento en que es invocado el hilo, deberá mostrar nuevamente la primera ventana de opciones (punto 1), para que no se
         quede esperando a que finalice la creación del archivo para que muestre la ventana.

         3.8 Mostrar un mensaje al usuario de que el archivo ha sido creado con éxito, dado que la creación del fichero lo manejaremos
         con hilos, muy probablemente aparezca este mensaje justo después de que aparezca la ventana de opciones, lo cual sería
         correcto, dado que estamos trabajando esa parte (la creación del fichero) de manera asíncrona.

     4. Si el usuario ingresa la opción "Abrir archivos con cálculos generados", o el mensaje que le hayan puesto:

         4.1 Deberá mostrar una lista con el nombre de las carpetas creadas por fecha que se encuentran dentro de la carpeta principal,
         y dependiendo de la carpeta seleccionada (podrá ingresar por opción enumerada o por nombre de carpeta, es a elección de cada uno),
         deberá mostrar la lista de archivos que se encuentran en ella.

         4.2 Ingresar (ya sea por opción enumerada o por nombre de archivo) los archivos que se desean abrir, separados por una coma (,) para
         que se abran esos archivos al mismo tiempo, usar hilos para la parte de apertura de los ficheros, para evitar demoras.

     * Recomendaciones:
     * Aplicar los principios de la POO
     * Aplicar los principios SOLID
     * Usar Enumerarles de estructura simple y compuesta
     * Usar la Clase StringBuilder para armar y dar estructura los mensajes
     * Usar el método format de la Clase String para concatenar
     * Implementar uso de properties para leer configuración utilizando la Clase System
     * Utilizar la Clase LocalDate de Java 8 para la creación de las carpetas basada en la fecha
     * Utilizar la Clase File
     * Dar formato a los valores de los cálculos y medidas de las figuras utilizando el método format de la Clase NumberFormat
     * Implementar excepciones
     * Implementar excepciones personalizadas (pueden crearse las que se consideren necesarias, a gusto de cada uno)
     * Utilizar paquetes (servicios, constantes, domain, utilerías, abstracts, etc)
     */