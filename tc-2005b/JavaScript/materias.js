// JavaScript source code
function altaMaterias() {
    camposAzules();
    cve = document.f_materias.cve.value;
    nom = document.f_materias.nom.value;
    cre = document.f_materias.cre.value;
    per = document.f_materias.per.value;
    cve = cve.toUpperCase();
    cre = parseInt(cre);
    if (!validaClave(cve)) {
        if (nom.length == 0) {
            alert("Error, se debe indicar el nombre de la materia");
            document.f_materias.nom.style.background = "red";
        }
        else {
            if ((cre < 0) || (cre > 18) || (isNaN(cre))) {
                alert("Error, los creditos debe estar entre 0 y 18");
                document.f_materias.cre.style.background = "red";
            }
            else {
                if (per.length == 0) {
                    alert("Error, se debe indicar el periodo de la materia");
                    document.f_materias.per.style.background = "red";
                }
                else {
                    serv = servidor() + "materias.php?op=altas&cve=" + cve + "&nom=" + nom + "&cre=" + cre + "&per=" + per;
                    location.href = serv;
                }
            }
        }
    }
}

function bajaMaterias() {
    cve = document.f_materias.cve.value;
    cve = cve.toUpperCase();
    if (!validaClave(cve)) {
        serv = servidor() + "materias.php?op=bajas&cve=" + cve;
        location.href = serv;
    }
}

function camposAzules() {
    document.f_materias.cve.style.background = "blue";
    document.f_materias.nom.style.background = "blue";
    document.f_materias.cre.style.background = "blue";
    document.f_materias.per.style.background = "blue";
}
