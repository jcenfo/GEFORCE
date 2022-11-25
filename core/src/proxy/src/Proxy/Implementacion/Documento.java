package proxy.src.Proxy.Implementacion;

//import Proxy.Interface.IDocumento;
import proxy.src.Proxy.Interface.IDocumento;

public class Documento implements IDocumento {

	@Override
	public String acceder(String pUsuario, String pPass) {
		// TODO Auto-generated method stub
		return "Abriendo el documento...";
	}

	@Override
	public String cargarPagina(int pPagina) {
		// TODO Auto-generated method stub
		return "Cargando la Imagen: "+ pPagina;
	} 
	
}