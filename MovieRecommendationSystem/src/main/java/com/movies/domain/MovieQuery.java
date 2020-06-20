package com.movies.domain;

/**
 * This class is for movie information search which support for diverse searches.
 * @author sueko
 * @version 1.0
 */
public class MovieQuery {
    //搜索的电影信息
    private Movie movie;
    //显示的数据条数
    private Integer showNumber = 50;
    //搜索结果的排序依据
    private String orderByType = "movieAverageScore";
    //搜索结果的排序正逆序
    private String sortOrder = "asc";

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Integer getShowNumber() {
        return showNumber;
    }

    public void setShowNumber(Integer showNumber) {
        this.showNumber = showNumber;
    }

    public String getOrderByType() {
        return orderByType;
    }

    public void setOrderByType(String orderByType) {
        this.orderByType = orderByType;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
}
