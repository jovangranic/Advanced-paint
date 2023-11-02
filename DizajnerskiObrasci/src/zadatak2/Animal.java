package zadatak2;


	public abstract class Animal {
		private String name;
		private String breed;

		public abstract void feed();
		public abstract void namePet(String name);
		public abstract void respond();
		


		public Animal (String name, String breed) {
			this.name = name;
			this.breed = breed;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getBreed() {
			return breed;
		}
		public void setBreed(String breed) {
			this.breed = breed;
		}




		}

