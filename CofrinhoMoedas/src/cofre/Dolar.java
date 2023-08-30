package cofre;

public class Dolar extends Moeda {

	public Dolar(double valor) {
		super(valor);
	}

	@Override
	public double converterMoeda() {
		return valor * 4.9;
	}

	@Override
	public void info() {
		System.out.println("Dolar $" + valor);
		
	}
	
}
