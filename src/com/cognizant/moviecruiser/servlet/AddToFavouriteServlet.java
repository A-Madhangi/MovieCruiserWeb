package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavouritesDao;
import com.cognizant.moviecruiser.dao.FavouritesDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.MovieListDao;
import com.cognizant.moviecruiser.dao.MovieListDaoCollectionImpl;
import com.cognizant.moviecruiser.model.MovieList;


/**
 * Servlet implementation class AddToFavouriteServlet
 */
@WebServlet("/AddToFavouriteServlet")
public class AddToFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToFavouriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        long userId=1;
		
		System.out.println("inside do get");
		String movieListId = request.getParameter("movieListId");
		int movielistid=Integer.parseInt(movieListId);
		FavouritesDaoCollectionImpl favouritesDaoCollectionImpl = new FavouritesDaoCollectionImpl();
	    FavouritesDao favouriteDao = favouritesDaoCollectionImpl;
		favouriteDao.addFavouriteList(1,movielistid);
		MovieListDaoCollectionImpl movie= new MovieListDaoCollectionImpl();
		
		MovieListDao movieListDao=movie;
		List<MovieList> movieList= movieListDao.getMovieListCustomer();
		
		request.setAttribute("addFavouriteStatus",true);
		request.setAttribute("customerMovieList",movieList);
		request.getRequestDispatcher("movie-list-customer.jsp").forward(request,response);
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
