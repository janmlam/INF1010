public interface Ansatt {

}

public interface Professor {

}

public interface Student {

}

public class Person {

}

public class MStud extends Personer implements Student {

}

public class BStud extends Personer implements Student{
	
}

public class AnsattBstud extends Bstud implements Ansatt {

}



Person[] personer;
personer = new personer(5);

personer[0] = new MStud();
personer[4] = new AnsattBstud();