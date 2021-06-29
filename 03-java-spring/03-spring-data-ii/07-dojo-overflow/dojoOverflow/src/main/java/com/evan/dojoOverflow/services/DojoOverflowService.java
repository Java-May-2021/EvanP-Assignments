package com.evan.dojoOverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.dojoOverflow.models.Answer;
import com.evan.dojoOverflow.models.Question;
import com.evan.dojoOverflow.models.Tag;
import com.evan.dojoOverflow.repositories.AnswerRepository;
import com.evan.dojoOverflow.repositories.QuestionRepository;
import com.evan.dojoOverflow.repositories.TagRepository;

@Service
public class DojoOverflowService {
	@Autowired
	private QuestionRepository qRepo;
	
	@Autowired
	private AnswerRepository aRepo;
	
	@Autowired
	private TagRepository tRepo;
	
	public List<Question> getAllQuestions() {
		return this.qRepo.findAll();
	}
	
	public Question createQuestion(Question question) {
		List<Tag> questionsTags = new ArrayList<Tag>();
		String tags = question.getStTags();
		
		String[] qTags = tags.split(",");
		
		for(String subject: qTags) {
			System.out.println(subject);
			Tag tag = this.tRepo.findBySubject(subject.toLowerCase().trim());
			if(tag == null) {
				tag = new Tag(subject);
				tag.setSubject(subject);
				this.tRepo.save(tag);
			}
			
			if(!questionsTags.contains(tag)) {
				questionsTags.add(tag);
			}
		}
		
		Question newQuestion = new Question(question.getQuestion(), questionsTags);
		return this.qRepo.save(newQuestion);
	}
	public Question getQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
	public List<Answer> getAllAnswers() {
		return this.aRepo.findAll();
	}
	
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	
	public Answer getAnswer(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
	
	public void addAnswerToQuestion(Question question, Answer answer) {
		List<Answer> selectedQuestion = question.getAnswers();
		selectedQuestion.add(answer); 
		this.aRepo.save(answer);
	}
	

	public List<Tag> getAllTags() {
		return this.tRepo.findAll();
	}
	
	public Tag createTag(Tag tag) {
		return this.tRepo.save(tag);
	}
	
	public Tag getSingleTag(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}

}
