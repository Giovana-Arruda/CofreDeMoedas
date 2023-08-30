package cofre;

public class Real extends Moeda {

	public Real(double valor) {
		super(valor);
	}

	@Override
	public double converterMoeda() {
		return valor;
	}

	@Override
	public void info() {
		System.out.println("Real R$" + valor);
		
	}	
}
