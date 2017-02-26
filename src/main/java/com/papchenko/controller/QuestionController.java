package com.papchenko.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.papchenko.dto.PollDto;
import com.papchenko.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

	@Autowired
	private PollService pollService;

	@RequestMapping(value="/questions", method = RequestMethod.GET )
	public List<PollDto> all(HttpServletResponse response) throws IOException{
		return pollService.all();
	}

	@RequestMapping(value="/questions", method = RequestMethod.POST)
	public void save(PollDto poll) {
		pollService.save(poll);
	}

	@RequestMapping(value="/question/answer/{id}", method = RequestMethod.POST)
	public void saveAnswer(@PathVariable int id) {
		pollService.saveAnswer(id);
	}
}
