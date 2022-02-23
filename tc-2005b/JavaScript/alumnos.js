// JavaScript source code
function altaAlumnos() {
    camposAzules();
    mat = document.f_alumno.mat.value;
    nom = document.f_alumno.nom.value;
    ap = document.f_alumno.ap.value;
    am = document.f_alumno.am.value;
    car = document.f_alumno.car.value;
    prom = document.f_alumno.prom.value;
    mat = mat.toUpperCase();
    car = car.toUpperCase();
    prom = parseInt();

    if (!valida_matricula(mat)) {
        if (nom.lenght == 0) {
            alert("Error, para el nombre se debe escribir al menos una letra");
            document.f_alumno.nom.style.background = "red";
        }
        else {
            if (ap.lenght == 0) {
                alert("Error, para el apellido paterno se debe escribir al menos una letra");
                document.f_alumno.ap.style.background = "red";
            }
            else {
                if (am.lenght == 0) {
                    alert("Error, para el apellido materno se debe escribir al menos una letra");
                    document.f_alumno.am.style.background = "red";
                }
                else {
                    if (confirm("Datos correctos, ¿Desea grabar?")) {
                        var serv = servidor() + "alumnos.php?op=" + "altas" + "&mat=" + mat + "&nom=" + nom + "&ap=" + ap + "&am=" + am + "&car=" + car + "&prom=" + prom;
                        location.href = serv;
                    }
                    else {
                        alert("La accion ha sido CANCELADA");
                    }
                }
            }
        }
    }
}

function bajaAlumnos() {
    mat = document.f_alumnos.mat.value;
    if (!valida_matricula(mat)) {
        var serv = servidor() + "alumnos.php?op=bajas&mat="+mat;
        location.href = serv;
    }
}

function consultaAlumnos() {
    mat = document.f_alumnos.mat.value;
    if (!valida_matricula(mat)) {
        var serv = servidor() + "alumnos.php?op=consultas&mat=" + mat;
        location.href = serv;
    }
}

function cambioAlumnos() {
    mat = document.f_alumno.mat.value;
    car = document.f_alumno.car.value;
    prom = document.f_alumno.prom.value;
    mat = mat.toUpperCase();
    car = car.toUpperCase();

    if (!valida_matricula(mat)) {
        if (car.lenght() < 2) {
            alert("Error, para la carrera se debe escribir al menos dos caracteres");
            document.f_alumno.car.style.background = "red";
        }
        else {
            prom = parseInt(prom);
            if ((prom < 0) || (prom > 100) || (isNaN(prom))) {
                alert("Error, el promedio sólo puede estar entre 0 y 100");
                document.f_alumno.prom.style.background = "red";
            }
            else {
                var serv = servidor() + "alumnos.php?op=consultas&mat=" + mat + "&car=" + car + "&prom=" + prom;
                location.href = serv;
            }
        }
    }
}

function camposAzules() {
    document.f_alumno.mat.style.background = "blue";
    document.f_alumno.nom.style.background = "blue";
    document.f_alumno.ap.style.background = "blue";
    document.f_alumno.am.style.background = "blue";
    document.f_alumno.car.style.background = "blue";
    document.f_alumno.prom.style.background = "blue";
}
