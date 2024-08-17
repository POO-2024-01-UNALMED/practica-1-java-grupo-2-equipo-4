package gestorAplicación.servicios;
import java.util.ArrayList;

public enum Enums{
	SOLO_EXISTO_PARA_QUE_ESTO_NO_ESTALLE_NO_ME_BORRES;

public static enum Categoria{
	 ALIMENTO(1,"Alimento"),
	 BEBIDA(2,"Bebida"),
	 LIMPIEZA(3,"Limpieza"),
	 PERSONAL(4,"Personal"),
	 HOGAR(5,"Hogar"),
	 ELECTRONICO(6,"Electronico");
	
	 private final int identificador;
	 private final String texto;
	 
	 private Categoria(int identificador,String texto) {
		 this.identificador=identificador;
		 this.texto=texto;
	 }
	 
	 public String getTexto() {
		 return texto;
	 }
	 
	 public int getIdentificador() {
		 return identificador;
	 }
	 
	 public static Categoria resolverEnum(int decision) {
		 for (Enums.Categoria i:Enums.Categoria.values()) {
			 if (decision==i.identificador){
				 return i;
			 }
		 }
		return null;
	 }
}


public static enum Edades{
	MENORES("-18"),
	ADULTOS("+18");
	
	private final String diferenciador;
	
	private Edades(String diferenciador) {
		this.diferenciador=diferenciador;
	}
	
	public String getDiferenciador() {
		return this.diferenciador;
	}
}

public static enum EstadoProducto{
	VENCIDO,
	DEFECTUOSO,
	ACTIVO;
}

public static enum TipoCaja { 
	NORMAL("normal"),
	RAPIDA("rapida");
	final String tipos;
	private TipoCaja(String tipo){
	    this.tipos=tipo;
	}
        /*TipoCaja tCaja=null;
	while(p==null){
	    String tipo = sc.nextLine();
	    if (resolverTipoCaja(tipo,p)!=null){
		p=resolverTipoCaja(tipo,p);
 	        print("La caja es de tipo: "+p);
	    }else {
	        print("Ese no es un tipo válido de caja, introduzca uno válido");
	    }
	}*/
	//SE DEBE COMPLEMENTAR ESTE METODO EN EL MAIN COMO SE MUESTRA ARRIBA
	public static Enums.TipoCaja resolverTipoCaja(String tipo) {
		for (Enums.TipoCaja i:Enums.TipoCaja.values()) {
			if(tipo==i.tipos) {
				return i;
			}
		}
		return null;
    }
  }

public static enum Tamaño{
	GRANDE("Grande"),MEDIANO("Mediano"),PEQUEÑO("Pequeño");
	
	private String tamaño;
	
	private Tamaño(String tamaño) {
		this.tamaño=tamaño;
	}

	public String getTamaño() {
		return tamaño;
	}

}
}


