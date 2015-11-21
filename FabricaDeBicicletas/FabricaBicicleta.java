public class FabricaBicicleta{
	private Rueda rueda1;
	private Rueda rueda2;
	private Cuadro cuadro;
	private double distancia = 0;//metros 
	private static final double DIST_PEDAL = 0.1;
	private static final String TALLA = "mediana";
	public String marca;
	private int direccion;
	private String corredor;

	public FabricaBicicleta(Rueda rueda1, Rueda rueda2, Cuadro cuadro){
		this.rueda1 = rueda1;
		this.rueda2 = rueda2;
		this.cuadro = cuadro;
	}

	public FabricaBicicletas(String talla){
		this.cuadro = new Cuadro(talla);		
	}
	public FabricaBicicleta(String corredor){
		this.corredor = corredor;
	}
	public double pedalear(int cantidad){
		/*distancia = distancia + ( cantidad * DIST_PEDAL );*/
		distancia +=  cantidad * DIST_PEDAL;
		return distancia;
	}

	public void girar(int angulo){
		direccion = angulo;
	}

	public void setDireccion(int direccion){
		this.direccion = direccion;
	}

	public int getDireccion(){
		return this.direccion;
	}
}