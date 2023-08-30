package cofre;
	
	public abstract class Moeda {
		protected double valor;
		
		public double getValor() {
			return valor;
		}

		public void setValor(double valor) {
			this.valor = valor;
		}

		public Moeda(double valor) {
			super();
			this.valor = valor;
		}
			
		public abstract double converterMoeda(); 		
		
		public abstract void info();	
		
	}


