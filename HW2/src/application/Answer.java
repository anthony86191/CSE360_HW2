package application;

public class Answer {
	private String text;
	private String user;

	public Answer(String text, String user) {
		this.text = text;
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public String getUser() {
		return user;
	}

	public void update(String newQuestion) {
		if (user.equals(UserLoginPage.userNamePublic)) {
			text = newQuestion;
		}
	}

	@Override
	public String toString() {
		return text + " (Posted by: " + user + ")";
	}
}
