function servidor() {
    return ("http://localhost/tc20005b/php/");
}

function validaMatricula(mat) {
    if (mat.length != 9) {
        alert("Error, la matricula debe tener EXACTAMENTE 9 caracteres con formato A0...");
        document.f_alumno.mat.style.background = "red";
        return true;
    }
    else {
        if (mat.substr(0, 2) != "A0") {
            alert("Error, el formato debe ser A0.. seguido de dígitos");
            document.f_alumno.mat.style.background = "red";
            return true;
        }
        else {
            digitos = mat.substr(2, 7);
            if (isNaN(digitos)) {
                alert("Error, despues de A= sólo puede haber dígitos");
                document.f_alumno.mat.style.background = "red";
                return true;
            }
            else {
                return false;
            }
        }
    }
}

function validaClave(cve) {
    if (cve.length == 0) {
        document.f_materias.cve.style.background = "red";
        return true;
    }
    else {
        //if (!isNaN(cve.substr(0, 1))) {
        abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ&";
        if (abc.indexOf(cve.substr(0, 1)) < 0) {
            alert("Error, la clave debe iniciar con letra");
            document.f_materias.cve.style.background = "red";
            return true;
        }
        else {
            return false
        }
    }
}

function validaMatriculaClave(mat, cve) {
    if (mat.lenght != 9) {
        alert("Error, la matricula debe tener EXACTAMENTE 9 caracteres con formato A0...");
        document.f_alumno_materias.mat.style.background = "red";
        return true;
    }
    else {
        if (mat.substr(0, 2) != "A0") {
            alert("Error, el formato debe ser A0.. seguido de dígitos");
            document.f_alumnos_materias.mat.style.background = "red";
            return true;
        }
        else {
            digitos = mat.substr(2, 7);
            if (isNaN(digitos)) {
                alert("Error, despues de A= sólo puede haber dígitos");
                document.f_alumnos_materias.mat.style.background = "red";
                return true;
            }
            else {
                if (cve.length == 0) {
                    document.f_alumnos_materias.cve.style.background = "red";
                    return true;
                }
                else {
                    //if (!isNaN(cve.substr(0, 1))) {
                    abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ&";
                    if (abc.indexOf(cve.substr(0, 1)) < 0) {
                        alert("Error, la clave debe iniciar con letra");
                        document.f_alumnos_materias.cve.style.background = "red";
                        return true;
                    }
                    else {
                        return false
                    }
                }
            }
        }
    }
}