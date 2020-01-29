/*This method implements Player interface, Choose Category method is still incomplete*/
package commandline;

public class CompPlayer implements Player {

	  String name;


	  public CompPlayer() {		  

	  }
	

	  public String getName() {
		  return name;
	  }


	@Override
	public int chooseCategory() {
		return 0;
	}
	

}

