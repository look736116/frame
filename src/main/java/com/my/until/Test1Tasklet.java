package com.my.until;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.fasterxml.jackson.core.sym.Name;

public class Test1Tasklet implements Tasklet {
	
	private String  name;
	

	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("=======Test1Tasklet" + name);
		return RepeatStatus.FINISHED;
	}

}
