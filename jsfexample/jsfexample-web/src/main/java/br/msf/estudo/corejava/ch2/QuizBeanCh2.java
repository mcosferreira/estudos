package br.msf.estudo.jsf.bean.numberquiz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.msf.estudo.jsf.entity.ProblemBean;

@Named(value="quizBean")
@SessionScoped
public class QuizBean implements Serializable {
	private static final long serialVersionUID = -4241791894684513500L;
	private List<ProblemBean> problems = new ArrayList<ProblemBean>();
	private int currentIndex;
	private int score;
	
	public QuizBean() {
		super();
		problems.add(
				new ProblemBean(new int[] { 3, 1, 4, 1, 5}, 9)); // pi

		problems.add(
				new ProblemBean(new int[] { 1, 1, 2, 3, 5}, 8)); // fibonacci
		
		problems.add(
				new ProblemBean(new int[] { 1, 4, 9, 16, 25}, 36)); // quadrados

		problems.add(
				new ProblemBean(new int[] { 2, 3, 5, 7, 11}, 13)); // primos

		problems.add(
				new ProblemBean(new int[] { 1, 2, 4, 8, 16}, 32)); // potencias de 2
	}
	
	public int getScore() {
		return score;
	}
	
	public ProblemBean getCurrent() {
		return problems.get(currentIndex);
	}	
	
	public String getAnswer() {
		return "";
	}
	
	public void setAnswer(String newValue) {
		try {
			int answer = Integer.parseInt(newValue.trim());
			
			if (getCurrent().getSolution() == answer) {
				score++;
			}
			
			currentIndex = (currentIndex + 1) % problems.size();
		
		} catch (NumberFormatException ex) {
		}
	}
	
}
