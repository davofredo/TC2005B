public class Servicio {
    public void guardar() {
        //TODO: Logica para preparar los datos y enviarlos al repositorio para ser persistidos en la BD
        IRepositorio r = repositorio();
        r.guardar("nuevo objeto");
    }

    public static IRepositorio repositorio() {
        return new RepositorioSQLServices();
    }
}
