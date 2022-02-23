// JavaScript source code
function altaAlumnosMaterias() {
    document.f_alumnos_materias.mat.style.background = "blue";
    document.f_alumnos_materias.cve.style.background = "blue";

    mat = document.f_alumnos_materias.mat.value;
    cve = document.f_alumnos_materias.cve.value;
    mat = mat.toUpperCase();
    cve = cve.toUpperCase();
    if (!validaMatriculaClave(mat, cve)) {
        serv = servidor() + "alumnos_materias.php?op=altas&mat=" + mat + "&cve=" + cve;
        location.href = serv;
    }
}

function baja_alumnos_materia() {
    document.f_alumnos_materias.mat.style.background = "blue";
    document.f_alumnos_materias.cve.style.background = "blue";

    mat = document.f_alumnos_materias.mat.value;
    cve = document.f_alumnos_materias.cve.value;
    mat = mat.toUpperCase();
    cve = cve.toUpperCase();
    if (!validaMatriculaClave(mat, cve)) {
        serv = servidor() + "alumnos_materias.php?op=altas&mat=" + mat + "&cve=" + cve;
        location.href = serv;
    }
}