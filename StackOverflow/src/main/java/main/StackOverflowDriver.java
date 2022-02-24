package main;

import main.model.Answer;
import main.model.User;
import main.service.StackOverFlowService;
import main.service.UserService;

public class StackOverflowDriver {

  public static void main(String[] args) {

    UserService userService = UserService.getInstance();
    int a = userService.addUser("sombose");
    int b =userService.addUser("som");
    int c =userService.addUser("bose");

    StackOverFlowService service = StackOverFlowService.getInstance();
    int qa = service.postQuestion(a,"what is root of 4?");

    service.postAnswerQuestion(b,qa,"2");

    service.postAnswerQuestion(c,qa,"3");

    System.out.println(" Testing with questionId answers");

    for( Answer answer: service.getAllAnswerByQuestionId(qa))
        print(answer);

    System.out.println(" Testing with userId answers");

    for (Answer answer: service.getAllAnswerByUserId(a))
      print(answer);

  }


  public static void print(Answer answer){
    System.out.println(answer.getId()+" "+answer.getUserId()+" "+answer.getComment()+" "+answer.getMetaData().getPostedOn());
  }
}
