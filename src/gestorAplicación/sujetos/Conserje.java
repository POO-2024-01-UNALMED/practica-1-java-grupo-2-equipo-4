package gestorAplicación.sujetos;

import java.io.Serializable;

public class Conserje extends Empleado implements Serializable {

	
	private static final long serialVersionUID = -8101559432401102040L;

	@Override
	protected void buscoChamba() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected double cantidadPago() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean validarCriterios() {
		if((this.experiencia>=2)&&this.getEdad()<=25){
			return true;
		}else {
			return false;
		}
	}

}
