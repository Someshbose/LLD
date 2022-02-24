package main.service;

import main.model.Answer;
import main.model.MetaData;
import main.model.Question;
import main.model.User;

import java.util.*;

public class StackOverFlowService {

  private static StackOverFlowService instance = null;

  private HashMap<Integer, Question> questionBank ;
  private UserService userService ;
  //private HashMap<Integer,List<Integer>> answerSearch;
  //private HashMap<Integer,Answer> answerMap;
  private HashMap<Integer,Answer> answerSearch;

  private StackOverFlowService(){
    userService = UserService.getInstance();
    questionBank = new HashMap<>();
    //answerSearch = new HashMap<>();
    //answerMap = new HashMap<>();
    answerSearch = new HashMap<>();
  }

  public static StackOverFlowService getInstance() {
    if(instance == null)
      instance = new StackOverFlowService();
    return instance;
  }

  public int postQuestion(int userId, String description) {

    Optional<User> fetchUser = userService.getUserById(userId);
    if (fetchUser.isPresent() && description!=null && description.length() >0){
      Question newQues = Question.builder().id(IdGeneratorService.getId()).description(description)
          .metaData(MetaData.builder().postedOn(new Date(System.currentTimeMillis())).build())
          .userId(userId)
          .answerList(new ArrayList<>())
          .build();

      questionBank.put(newQues.getId(), newQues);

      return newQues.getId();
    }
      return -1;
  }


  public boolean postAnswerQuestion(int userId, int questionId,String comment) {
    Optional<User> fetchUser = userService.getUserById(userId);

    if (fetchUser.isPresent() && questionBank.containsKey(questionId) && comment!=null && comment.length()>0){

      Answer newAnswer = Answer.builder()
          .id(IdGeneratorService.getId())
          .comment(comment)
          .metaData(MetaData.builder().postedOn(new Date(System.currentTimeMillis())).build())
          .userId(userId)
          .build();


      questionBank.get(questionId).getAnswerList().add(newAnswer);

      answerSearch.put(newAnswer.getId(),newAnswer);
    //  answerMap.put(newAnswer.getId(), newAnswer);

    //  List<Integer> answerList = answerSearch.getOrDefault(userId,new ArrayList<>());
    //  answerList.add(newAnswer.getId());
    //  answerSearch.put(userId,answerList);

      return true;
    }
    return false;
  }


  public List<Answer> getAllAnswerByQuestionId(int questionId) {
    List<Answer> answerList = new ArrayList<>();

    if (questionBank.containsKey(questionId)){
      answerList.addAll(questionBank.get(questionId).getAnswerList());
    }
    return answerList;
  }


  public List<Answer> getAllAnswerByUserId(int userId) {

    List<Answer> answerList = new ArrayList<>();

    for(Map.Entry<Integer,Answer> entry:answerSearch.entrySet()){
      if (entry.getValue().getUserId() == userId)
        answerList.add(entry.getValue());
    //  for (Integer index: answerSearch.get(userId)){
        //  answerList.add(answerMap.get(index));
    //  }
    }

    return answerList;
  }
}
