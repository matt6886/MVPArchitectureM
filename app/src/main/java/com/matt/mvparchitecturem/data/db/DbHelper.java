package com.matt.mvparchitecturem.data.db;

import io.reactivex.Observable;

import com.matt.mvparchitecturem.data.db.model.Option;
import com.matt.mvparchitecturem.data.db.model.Question;
import com.matt.mvparchitecturem.data.db.model.User;

import java.util.List;

public interface DbHelper {
    Observable<Long> insertUser(final User user);

    Observable<List<User>> getAllUsers();

    Observable<List<Question>> getAllQuestions();

    Observable<Boolean> isQuestionEmpty();

    Observable<Boolean> isOptionEmpty();

    Observable<Boolean> saveQuestion(Question question);

    Observable<Boolean> saveOption(Option option);

    Observable<Boolean> saveQuestionList(List<Question> questionList);

    Observable<Boolean> saveOptionList(List<Option> optionList);

}
