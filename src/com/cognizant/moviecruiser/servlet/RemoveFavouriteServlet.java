package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavouriteEmptyException;
import com.cognizant.moviecruiser.dao.FavouritesDao;
import com.cognizant.moviecruiser.dao.FavouritesDaoCollectionImpl;
import com.cognizant.moviecruiser.model.MovieList;

/**
 * Servlet implementation class RemoveFavouriteServlet
 */
@WebServlet("/RemoveFavouriteServlet")
public class RemoveFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFavouriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long userId=1;
		FavouritesDaoCollectionImpl favouritesDaoCollectionImpl = new FavouritesDaoCollectionImpl();
	    FavouritesDao favouriteDao = favouritesDaoCollectionImpl;
	    String movieListId = request.getParameter("movieListId");
	    System.out.println(movieListId);
		int movielistid=Integer.parseInt(movieListId);
	    System.out.println("after parsing"+movielistid);
		favouriteDao.removeFavouriteList(1,movielistid);
	
	    //List<MenuItem> menuItemList =cartDao.removeCartItem(userId,Long.parseLong(menuItemId));
		
       
		try {
			List<MovieList>  movieList = favouriteDao.getAllFavouriteList(userId);
			request.setAttribute("removeFavouriteStatus",true);
			request.setAttribute("favouriteMovieList",movieList);
			request.getRequestDispatcher("favorites.jsp").forward(request,response);
		} catch (FavouriteEmptyException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("favorites-empty.jsp").forward(request,response);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
