package proxy.src.Proxy.Implementacion;

//import Proxy.Auxiliares.Validador;
//import Proxy.Interface.IDocumento;
import proxy.src.Proxy.Auxiliares.Validador;
import proxy.src.Proxy.Interface.IDocumento;

public class DocumentoProxyAlumno implements IDocumento {
	private Documento _Documento = new Documento();
	private boolean _LoginExitoso = false;
	private int _PaginaProhibida = 5;
	
	@Override
	public String acceder(String pUsuario, String pPass) {
		_LoginExitoso = Validador.validarUsuario(pUsuario, pPass, 2) ;
		
		if (!_LoginExitoso) 
			return "No se encontro a ningun alumno con esta combinacion de usuario y/o contrasenna.\n";
			
		return "Login al sistema exitoso.\n";
	}
	@Override
	public String cargarPagina(int pagina) {
		String mensajeFinal = "No se pudo acceder al contenido";
		if(this._LoginExitoso) {
			mensajeFinal = "Esta es pagina ["+pagina+"] tiene varias imagenes.";
			if(pagina == _PaginaProhibida) 
				if(Validador.get_Role().equals("Profesor"))
					mensajeFinal =  "Esta p�gina no esta disponible, se la comio mi perro...";
				else
					mensajeFinal = "Lo que se ve ac� es un secreto, no le cuenten al profesor!";
		}
		
		return mensajeFinal + "\n["+ _Documento.cargarPagina(pagina) +"]";
	}

}
