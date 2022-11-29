package proxy.src.Proxy.Implementacion;

//import Proxy.Auxiliares.Validador;
//import Proxy.Interface.IDocumento;
import proxy.src.Proxy.Auxiliares.Validador;
import proxy.src.Proxy.Interface.IDocumento;

public class DocumentoProxyProfesor implements IDocumento {
	private Documento _Documento = new Documento();
	private boolean _LoginExitoso = false;
	
	@Override
	public String acceder(String pUsuario, String pPass) {
		_LoginExitoso = Validador.validarUsuario(pUsuario, pPass, 1) ;
			
		if (!_LoginExitoso) 
			return "Usuario o contrasenna incorrecta.";
			
		return "Login al sistema exitoso.";
	}

	@Override
	public  String cargarPagina(int pagina) {
		if (_LoginExitoso ) 
			return _Documento.cargarPagina(pagina);	
		else
			return ("Funcion no disponible actualmente");  
	}

	
}