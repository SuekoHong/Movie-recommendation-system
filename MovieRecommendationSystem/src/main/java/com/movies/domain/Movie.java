package com.movies.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * This class is about movie which include all the information of movies and simple functions.
 * @author sueko
 * @version 1.0
 * @since JDK 8.0
 */
public class Movie implements Serializable {
    private Integer id;
    private String movieName;
    private String movieAverageScore;
    private String movieEvaluatorNumber;
    private String movieFiveStarNumber;
    private String movieFourStarNumber;
    private String movieThreeStarNumber;
    private String movieTwoStarNumber;
    private String movieOneStarNumber;
    private String movieShortCommentNumber;
    private String movieLongCommentNumber;
    private String movieType;
    private String movieDirector;
    private String movieScreenWriter;
    private String movieAct;
    private String movieProductionArea;
    private String movieLanguage;
    private Date movieDate;
    private String movieDuration;
    private String movieIMDb;
    private String moviePoster;
    private String movieIntroduction;
    private String movieTotalScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieAverageScore() {
        return movieAverageScore;
    }

    public void setMovieAverageScore(String movieAverageScore) {
        this.movieAverageScore = movieAverageScore;
    }

    public String getMovieEvaluatorNumber() {
        return movieEvaluatorNumber;
    }

    public void setMovieEvaluatorNumber(String movieEvaluatorNumber) {
        this.movieEvaluatorNumber = movieEvaluatorNumber;
    }

    public String getMovieFiveStarNumber() {
        return movieFiveStarNumber;
    }

    public void setMovieFiveStarNumber(String movieFiveStarNumber) {
        this.movieFiveStarNumber = movieFiveStarNumber;
    }

    public String getMovieFourStarNumber() {
        return movieFourStarNumber;
    }

    public void setMovieFourStarNumber(String movieFourStarNumber) {
        this.movieFourStarNumber = movieFourStarNumber;
    }

    public String getMovieThreeStarNumber() {
        return movieThreeStarNumber;
    }

    public void setMovieThreeStarNumber(String movieThreeStarNumber) {
        this.movieThreeStarNumber = movieThreeStarNumber;
    }

    public String getMovieTwoStarNumber() {
        return movieTwoStarNumber;
    }

    public void setMovieTwoStarNumber(String movieTwoStarNumber) {
        this.movieTwoStarNumber = movieTwoStarNumber;
    }

    public String getMovieOneStarNumber() {
        return movieOneStarNumber;
    }

    public void setMovieOneStarNumber(String movieOneStarNumber) {
        this.movieOneStarNumber = movieOneStarNumber;
    }

    public String getMovieShortCommentNumber() {
        return movieShortCommentNumber;
    }

    public void setMovieShortCommentNumber(String movieShortCommentNumber) {
        this.movieShortCommentNumber = movieShortCommentNumber;
    }

    public String getMovieLongCommentNumber() {
        return movieLongCommentNumber;
    }

    public void setMovieLongCommentNumber(String movieLongCommentNumber) {
        this.movieLongCommentNumber = movieLongCommentNumber;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieScreenWriter() {
        return movieScreenWriter;
    }

    public void setMovieScreenWriter(String movieScreenWriter) {
        this.movieScreenWriter = movieScreenWriter;
    }

    public String getMovieAct() {
        return movieAct;
    }

    public void setMovieAct(String movieAct) {
        this.movieAct = movieAct;
    }

    public String getMovieProductionArea() {
        return movieProductionArea;
    }

    public void setMovieProductionArea(String movieProductionArea) {
        this.movieProductionArea = movieProductionArea;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public Date getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(Date movieDate) {
        this.movieDate = movieDate;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieIMDb() {
        return movieIMDb;
    }

    public void setMovieIMDb(String movieIMDb) {
        this.movieIMDb = movieIMDb;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public String getMovieIntroduction() {
        return movieIntroduction;
    }

    public void setMovieIntroduction(String movieIntroduction) {
        this.movieIntroduction = movieIntroduction;
    }

    public String getMovieTotalScore() {
        return movieTotalScore;
    }

    public void setMovieTotalScore(String movieTotalScore) {
        this.movieTotalScore = movieTotalScore;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", movieAverageScore='" + movieAverageScore + '\'' +
                ", movieEvaluatorNumber='" + movieEvaluatorNumber + '\'' +
                ", movieFiveStarNumber='" + movieFiveStarNumber + '\'' +
                ", movieFourStarNumber='" + movieFourStarNumber + '\'' +
                ", movieThreeStarNumber='" + movieThreeStarNumber + '\'' +
                ", movieTwoStarNumber='" + movieTwoStarNumber + '\'' +
                ", movieOneStarNumber='" + movieOneStarNumber + '\'' +
                ", movieShortCommentNumber='" + movieShortCommentNumber + '\'' +
                ", movieLongCommentNumber='" + movieLongCommentNumber + '\'' +
                ", movieType='" + movieType + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieScreenWriter='" + movieScreenWriter + '\'' +
                ", movieAct='" + movieAct + '\'' +
                ", movieProductionArea='" + movieProductionArea + '\'' +
                ", movieLanguage='" + movieLanguage + '\'' +
                ", movieDate=" + movieDate +
                ", movieDuration='" + movieDuration + '\'' +
                ", movieIMDb='" + movieIMDb + '\'' +
                ", moviePoster='" + moviePoster + '\'' +
                ", movieIntroduction='" + movieIntroduction + '\'' +
                ", movieTotalScore='" + movieTotalScore + '\'' +
                '}';
    }
}
