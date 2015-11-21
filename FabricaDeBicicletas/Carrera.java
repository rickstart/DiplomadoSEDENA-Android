public class Carrera{
	private FabricaBicicleta bici1 = new FabricaBicicleta("corredor1");
	private FabricaBicicleta bici2 = new FabricaBicicleta("corredor2");
	private FabricaBicicleta bici3 = new FabricaBicicleta("corredor3");
	bici1.pedalea(5);
	bici1.girar(45);
	bici1.marca = "Giant";


	private FabricaBicicleta competencia(){

		for(int i=0; i<10; i++){
			bici1.pedalea(randInt(1,5));
			bici2.pedalea(randInt(1,5));
			bici3.pedalea(randInt(1,5));
		}

		if((bici1.getDistancia()>bici2.getDistancia()) &&  (bici1.getDistancia() > bici3.getDistancia())){
			return bici1;
		}

		if((bici2.getDistancia()>bici1.getDistancia()) &&  (bici2.getDistancia() > bici3.getDistancia())){
			return bici2;
		}
		if((bici3.getDistancia()>bici2.getDistancia()) &&  (bici3.getDistancia() > bici1.getDistancia())){
			return bici3;
		}

		return null;
	}

	public static int randInt(int min, int max) {

	    Random rand;
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}