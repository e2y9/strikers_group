
public class Test {

	public static void main(String[] args) {
		Connect conn=new Connect();
		Integer a[]={1,2,3};
		Integer b[]={3,4,4};
		conn.gamerecords(1, 5, 3, 4,a ,b );
		System.out.println(conn.averageOfDraws());
		System.out.println(conn.maxRoundInGame());
		System.out.println(conn.numberofAIwin());
		System.out.println(conn.numberOfGames());
		System.out.println(conn.numberofHumanWin());
	}

}
