package cofre;

public class Euro extends Moeda {

	public Euro(double valor) {
		super(valor);
	}

	@Override
	public double converterMoeda() {
		return valor * 5.2;
	}

	@Override
	public void info() {
		System.out.println("Euro - " + valor);
		
	}

}
