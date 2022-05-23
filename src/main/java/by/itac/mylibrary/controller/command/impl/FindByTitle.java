package by.itac.mylibrary.controller.command.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;
import by.itac.mylibrary.start.view.View;

public class FindByTitle implements Command {

	private final char paramDelimeter = ' ';
	
	@Override
	public String execute(String request) throws ServiceException {
		String response = null;

		ServiceProvider provider = ServiceProvider.getInstance();
		BookService service = provider.getBookService();
		View view = new View();

		String enteredTitle = request.substring(request.indexOf(paramDelimeter) + 1);

		try {
			String listOfBookChoosedTitle = service.findByTitle(enteredTitle);

			view.printLibrary(listOfBookChoosedTitle, "List of books with title: " + enteredTitle);

			response = "Book search by title is completed.";
		} catch (ServiceException e) {
//			log
			response = "Error in find_by_title process.";
		}

		return response;
	}

}
