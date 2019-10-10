class CreateHylle {
	public static void main(String[] args) {
		//running test
		test();
	}

	//method to check if the class works as expected
	public static void test() {
		int fails = 0;
		Hylle<Bok> container = new Hylle<Bok>();
		container.setSpace(100);
		Bok Qwe = new Bok("Angels");
		Bok Asd = new Bok("Demons");
		Bok Zxc = new Bok("Spirits");

		container.placeObject(Qwe, 0);
		container.removeObject(0);

		//test1 - places object in, removing it, and check if the
		//space is empty or not
		boolean test1 = container.availableSpace(0);
		if(test1 == false) {
			fails++;
			System.out.println("test1 has failed. " + fails + "/5.");
		}
		else {
			System.out.println("test1 has passed.");
		}
		container.placeObject(Qwe, 1);

		//test2 - check if we can place a new item on an already occupied spot
		boolean test2 = container.placeObject(Asd, 1);
		if(test2 != false) {
			fails++;
			System.out.println("test2 has failed. " + fails + "/5.");
		}
		else {
			System.out.println("test2 has passed.");
		}

		//test3 - check if we can place a new item out of max limit
		boolean test3 = container.placeObject(Asd, 101);
		if(test3 == true) {
			fails++;
			System.out.println("test3 has failed. " + fails + "/5.");
		}
		else {
			System.out.println("test3 has passed.");
		}

		//check if the total space is 100 as expected
		int test4 = container.howManySpaces();
		if(test4 != 100) {
			fails++;
			System.out.println("test4 has failed. " + fails + "/5.");
		}
		else {
			System.out.println("test4 has passed.");
		}

		//check if an already occupied spot is available
		boolean test5 = container.availableSpace(1);
		if(test5 == true) {
			fails++;
			System.out.println("test5 has failed. " + fails + "/5.");
		}
		else {
			System.out.println("test5 has passed.");
		}

		//printing out x out of five possibles failed tests
		System.out.println(fails + "/5 test(s) failed.");
	}
}