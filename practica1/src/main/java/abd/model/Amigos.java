package abd.model;

public class Amigos {
	private String usuario_source;
	private String usuario_target;
	
	public Amigos(String usuario_source, String usuario_target) {
		this.usuario_source = usuario_source;
		this.usuario_target = usuario_target;
	}
	public String getUsuario_source() {
		return usuario_source;
	}
	public void setUsuario_source(String usuario_source) {
		this.usuario_source = usuario_source;
	}
	public String getUsuario_target() {
		return usuario_target;
	}
	public void setUsuario_target(String usuario_target) {
		this.usuario_target = usuario_target;
	}
	
	
}
