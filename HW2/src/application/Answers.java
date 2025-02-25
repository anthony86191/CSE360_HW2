package application;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Answers {
	//private String user;

    private final Map<String, List<Answer>> answersMap;

    public Answers(String user) {
        answersMap = new HashMap<>();
        
        //this.user = user;

        // Sample data
        addAnswer("What is Java?", "Java is a programming language.", "Alice");
        addAnswer("What is Java?", "Java is platform-independent.", "Bob");
        addAnswer("How does garbage collection work?", "Garbage collection reclaims unused memory.", "Charlie");
    }

    // Add an answer to a question
    public Answer addAnswer(String question, String answer, String user) {
    	Answer newAnswer = new Answer(answer, user);
        answersMap.computeIfAbsent(question, k -> new ArrayList<>()).add(newAnswer);
        return newAnswer;
    }
    
    // Remove answers for a question
    public String removeAnswers(String question, String user) {
    	//if (user.equals(this.user)) { // will probably need to check for question's user if it matches to remove completly, add question user to answer?
	    	if (answersMap.containsKey(question)) {
	            answersMap.get(question).clear(); // Clears the list of answers for the given question
				return "Removed Answers";
	        }
	    	return "User Match but Could not Find Answers";
    	//}
		//return "Users did not match! Did not Remove Answers!";
    }

    // Get all answers for a question
    public List<Answer> getAnswers(String question) {
        return answersMap.getOrDefault(question, new ArrayList<>());
    }

	public String removeAnswer(String question, Answer answerToRemove, String user) {
		if (answerToRemove.getUser().equals(user)) {
			List<Answer> answerList = answersMap.get(question);
	        if (answerList != null) {
	            answerList.remove(answerToRemove); // Removes the specific answer from the list
				return "Removed Answer";
	        }
	    	return "User Match but Could not Find Answer";
		}
		return "Users did not match! Did not Remove Answer!";
	}
}
