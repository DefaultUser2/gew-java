
//Personal details
//List of qualifications
//Working History

//POJO stands for Plain Old Java Object. It is an ordinary Java object, 
//not bound by any special restriction other than those forced by the Java Language Specification 
//and not requiring any class path.

//Immutable class requirements:
//The class must be declared as final (So that child classes can’t be created)
//Data members in the class must be declared as final (So that we can’t change the value of it after object creation)
//A parameterized constructor
//Getter method for all the variables in it
//No setters(To not have the option to change the value of the instance variable)

public final class CV {
    private final PersonalDetails Personal;
    private final Qualifications Qual;
    private final WorkingHistory Work;
    public CV(PersonalDetails Personal, Qualifications Qual, WorkingHistory Work) {
        this.Personal = Personal;
        this.Qual= Qual;
        this.Work = Work;
    }
    
    public PersonalDetails getPersonal()
    {
    	return Personal;
    }
    
    public Qualifications getQual()
    {
    	return Qual;
    }
    public WorkingHistory getWork()
    {
    	return Work;
    }
}

class PersonalDetails
{
	private PersonalDetails()
	{
		
	}
}

class Qualifications
{
	private Qualifications()
	{
		
	}
}

class WorkingHistory
{
	private WorkingHistory()
	{
		
	}
}