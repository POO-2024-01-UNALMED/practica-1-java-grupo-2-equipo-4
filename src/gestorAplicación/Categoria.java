package gestorAplicación;

public enum Categoria{
 ALIMENTO(1),
 BEBIDA(2),
 LIMPIEZA(3),
 PERSONAL(4),
 HOGAR(5),
 ELECTRONICO(6);
 
 private final int identificador;
 
 private Categoria(int identificador) {
	 this.identificador=identificador;
 }
 
 public int getIdentificador() {
	 return identificador;
 }
 
}
