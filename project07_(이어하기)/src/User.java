
public class User {
	String user;
	int win;
	int lose;
	int total;
	
	public User() {	
		
	}
	
	public User(String user, int win, int lose, int total) {
		this.user = user;
		this.win = win;
		this.lose = lose;
		this.total = total;
	}

	public String getUser() {
		return user;
	}

	public int getWin() {
		return win;
	}

	public int getLose() {
		return lose;
	}

	public int getTotal() {
		return total;
	}
	
	
	
}
