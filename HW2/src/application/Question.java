package application;

public class Question {
	private String text;
	private String user;
	private int questionId;

	public Question(String text, String user) {
		this.text = text;
		this.user = user;
		this.questionId = -1;

	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getText() {
		return text;
	}

	public String getUser() {
		return user;
	}

	public String update(String newQuestion, String user) {
		if (user.equals(this.user)) {
			text = newQuestion;
			return "Updated Question";
		}
		return "Users did not match! Did not update question!";
	}

	@Override
	public String toString() {
		return text + " (Posted by: " + user + ")";
	}
}
