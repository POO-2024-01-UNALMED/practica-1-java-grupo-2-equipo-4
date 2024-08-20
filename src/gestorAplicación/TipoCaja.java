package gestorAplicación;

public enum TipoCaja { 
	NORMAL("normal"),RAPIDA("rapida");
	final String s;
	private TipoCaja(String s){
	    this.s=s;
	}
}