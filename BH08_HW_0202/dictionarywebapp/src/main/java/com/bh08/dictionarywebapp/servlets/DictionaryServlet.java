package com.bh08.dictionarywebapp.servlets;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bh08.dictionarywebapp.model.HunEng;
import com.bh08.dictionarywebapp.service.DictionaryService;



/**
 * Servlet implementation class DictionaryServlet
 */
@WebServlet ("/dictionary")
public class DictionaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DictionaryService dictionaryService = new DictionaryService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DictionaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String hungarian = request.getParameter("hungarian");
		
		response.getWriter().print(hungarian);
		
		Optional<HunEng> wordPair = dictionaryService.findByHun(hungarian);
		if (!wordPair.isPresent()) {
			
			HunEng pair = new HunEng();
			
			pair.setHungarian(hungarian);
			pair.setEnglish(new String("Unknown word"));
						
			dictionaryService.save(pair);
			wordPair = Optional.of(pair);
		}
		
		HunEng pair = wordPair.get();
		request.setAttribute("hun", pair.getHungarian());
		request.setAttribute("eng", pair.getEnglish());
		
		request.getRequestDispatcher("evaluate.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
