
class Pet {
		
	int energyMax;
	int hungryMax;
	int cleanMax;
	private int diamonds;
	private int clean;
	private int energy;
	private int hungry;
	private int age;
	private boolean alive;
	
	Pet (int energyMax, int hungryMax, int cleanMax) { 
		this.energyMax = energyMax;
		this.hungryMax = hungryMax;
		this.cleanMax = cleanMax;
		this.energy = energyMax;
		this.clean = cleanMax;
		this.hungry = hungryMax;
		this.diamonds = 0;
		this.age = 0;
		this.alive = true;
	}
	
	void show() {
		
		System.out.print("energy:" + this.energy + "/" + this.energyMax);
		System.out.print(", hungry:" + this.hungry + "/" + this.hungryMax);
		System.out.print(", clean:" + this.clean + "/" + this.cleanMax);
		System.out.print(", diamonds:" + this.diamonds);
		System.out.print(", age:" + this.age);
		System.out.println(", alive:" + this.alive);
	}
	
	private void setEnergy(int energy) {
		this.energy = energy;
	}
	private void setHungry(int hungry){
		this.hungry = hungry;
	}
	private void setClean(int clean) {
		this.clean = clean;
	}
	
	public int getEnergy() {
		return this.energy;
	}
	public int getHungry(){
		return this.hungry;
	}
	public int getClean() {
		return this.clean;
	}
	public int getAge() {
		return this.age;
	}
	public boolean getAlive(){
		return this.alive;
	}
	public int getDiamonds() {
		return this.diamonds;
	}

	public void play() {
		
		if(this.alive == false) {
			System.out.println("Seu pet está morto!");
			System.out.println();
			return; 
		}
		
		System.out.println("Seu pet está brincando!");
		this.diamonds++;
		this.age++;
		this.energy -= 2;
		this.hungry--;
		this.clean -= 3;

		if (getEnergy() < 0){
			setEnergy(0);
		}
		if(getClean() < 0){
			setClean(0);
		}
		
		if(this.energy < 1) {
			System.out.println("Seu pet morreu sem energia!");
			this.alive = false;
		}
		if(this.clean < 1) {
			System.out.println("Seu pet morreu de sujeira");
			this.alive = false; 
		}
		if(this.hungry < 1) {
			System.out.println("Seu pet morreu de fome!");
			this.alive = false; 
		}

		if(this.alive == false) {
			show(); 
		}
		
	}
	public void shower() {
		
		if(this.alive == false) {
			System.out.println("Seu pet está morto!");
			show();
			return; 
		}
		
		System.out.println("Seu pet está tomando banho!");
		this.age += 2;
		this.energy -= 3;
		this.hungry--;
		this.clean = this.cleanMax;

		if (getEnergy() < 0){
			setEnergy(0);
		}
		
		if(this.energy < 1) {
			System.out.println("Seu pet morreu sem energia!");
			this.alive = false;
		}
		if(this.hungry < 1) {
			System.out.println("Seu pet morreu de fome!");
			this.alive = false; 
		}

		if(this.alive == false) {
			show(); 
		}
	
	}
	public void eat() {
		if(this.alive == false) {
			System.out.println("Seu pet está morto!");
			show();
			return; 
		}
		
		System.out.println("Seu pet está comendo!");
		this.age++;
		this.energy--;
		this.hungry += 4;
		this.clean -= 2;

		if (getEnergy() < 0){
			setEnergy(0);
		}
		if (getHungry() > this.hungryMax){
			setHungry(this.hungryMax);
		}
		if (getClean() < 0){
			setClean(0);
		}
		
		if(this.energy < 1) {
			System.out.println("Seu pet morreu sem energia!");
			this.alive = false;
		}
		if(this.clean < 1) {
			System.out.println("Seu pet morreu de sujeira");
			this.alive = false; 
		}

		if(this.alive == false) {
			show(); 
		}
	}
	public void sleep() {
		
		int x = 0;

		if(this.alive == false) {
			System.out.println("Seu pet está morto!");
			show();
			return; 
		}
		
		if (getEnergy() > (this.energyMax - 5)){
			System.out.println("Seu pet não está com sono!");
			return;
		}

		System.out.println("Seu pet está dormindo!");
		
		while(this.energy < this.energyMax){
			this.energy += 5;
			this.hungry--;
			x++;
		}
		this.age += (x * 5);

		if (getEnergy() > this.energyMax){
			setEnergy(this.energyMax);
		}
		
		if(this.hungry < 1) {
			System.out.println("Seu pet morreu de fome!");
			this.alive = false;

		if(this.alive == false) {
			show(); 
		}

	}
	
}


    public static void main(String[] args) {
		Pet koba = new Pet(20, 20, 20);
		koba.play();
		koba.show();
		koba.play();
		koba.show();
		koba.show();
		koba.eat();
		koba.show();
		koba.play();
		koba.show();
		koba.play();
		koba.show();
		koba.show();
		koba.eat();
		koba.show();
		koba.sleep();
		koba.show();
		koba.play();
		koba.show();
		koba.play();
		koba.eat();
	}
	
}
