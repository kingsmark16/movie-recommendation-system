/*
 Developers         : Mark Angel P. Concina
 			          Alwin Y. Onsay Jr.
 Course/Year/Section: BSIT-2B
 Filename           : IT2B_12.java
 About              : Welcome to our Movie Recommendation System, where the world of 
 					  cinema is at your command!. Let us be your compass through
 					  the cinematic wilderness, helping you find the perfect film
 					  for every mood and occasion.
 */
import java.util.*;
public class IT2B_12 {
	public static void main(String[] args) {
		Movie movie = new Movie();
		
		movie.start();
	}
}
class Movie {
	Scanner s = new Scanner(System.in);
	
	private String movieTitle;
	private String genre;
	private double averageUserRating;
	
	public Movie(String movieTitle, String genre, double averageUserRating) {
		this.movieTitle = movieTitle;
		this.genre = genre;
		this.averageUserRating = averageUserRating;
	}
	public Movie() {
		
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public String getGenre() {
		return genre;
	}
	public Double getAverageRating() {
		return averageUserRating;
	}
	public void printIntro() {
		System.out.println("_______________________________________________________________________________________________________________________");
		System.out.println("\t\t\t\t\t*******************************");
		System.out.println("\t\t\t\t\t* MOVIE RECOMMENDATION SYSTEM *");
		System.out.println("\t\t\t\t\t*******************************");
		System.out.println("\t     Welcome to our Movie Recommendation System, where the world of cinema is at your command! ");
		System.out.println("Let us be your compass through the cinematic wilderness, helping you find the perfect film for every mood and occasion.");
		System.out.println("_______________________________________________________________________________________________________________________");
	}
	public void printMainMenu() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Choose Genre: ");
		System.out.println("* Action\n* Romance\n* Comedy\n* Horror\n* Anime\nPress [E] + [ENTER] to Exit.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("Hi, what movie genre do you want me to recommend to you? ");
	}
	public void printSecondaryMenu() {
		System.out.println("[1] Show all movies in this genre\n[0] Exit to Main Menu");
		System.out.print("Enter your option: ");
	}
	public void printErrorMessage() {
		System.out.println("_____________________________");
		System.out.println("Invalid input! Pls try again.");
		System.out.println("_____________________________");
	}
	public void start() {
		printIntro();
		
		while(true) {
			boolean exit = false;
			
			printMainMenu();
			String choice = s.nextLine();
			
			if(choice.equalsIgnoreCase("Action")) {
				ActionMovies action = new ActionMovies();
				action.listOfMovies();
				action.displayTop3Movies();
				while(!exit) {
					printSecondaryMenu();
					int option = s.nextInt();
					s.nextLine();
					
					switch(option) {
					case 1:
						action.displayAllMovies();
						break;
					case 0:
						exit = true;
						break;
					default:
						printErrorMessage();
						break;
					}
					if(exit) break;
				}
			}
			else if(choice.equalsIgnoreCase("Romance")) {
				RomanceMovies romance = new RomanceMovies();
				romance.listOfMovies();
				romance.displayTop3Movies();
				
				while(!exit) {
					printSecondaryMenu();
					int option = s.nextInt();
					s.nextLine();
					
					switch(option) {
					case 1:
						romance.displayAllMovies();
						break;
					case 0:
						exit = true;
						break;
					default:
						printErrorMessage();
						break;
					}
					if(exit) break;
				}
			}
			else if (choice.equalsIgnoreCase("Horror")) {
				HorrorMovies horror = new HorrorMovies();
				horror.listOfMovies();
				horror.displayTop3Movies();
				
				while(!exit) {
					printSecondaryMenu();
					int option = s.nextInt();
					s.nextLine();
					
					switch(option) {
					case 1:
						horror.displayAllMovies();
						break;
					case 0:
						exit = true;
						break;
					default:
						printErrorMessage();
						break;
					}
					if(exit) break;
				}
			}
			else if (choice.equalsIgnoreCase("Comedy")) {
				ComedyMovies comedy = new ComedyMovies ();
				comedy.listOfMovies();
				comedy.displayTop3Movies();
				
				while(!exit) {
					printSecondaryMenu();
					int option = s.nextInt();
					s.nextLine();
					
					switch(option) {
					case 1:
						comedy.displayAllMovies();
						break;
					case 0:
						exit = true;
						break;
					default:
						printErrorMessage();
						break;
					}
					if(exit) break;
				}
			}
			else if (choice.equalsIgnoreCase("Anime")) {
				AnimeMovies anime = new AnimeMovies ();
				anime.listOfMovies();
				anime.displayTop3Movies();
				
				while(!exit) {
					printSecondaryMenu();
					int option = s.nextInt();
					s.nextLine();
					
					switch(option) {
					case 1:
						anime.displayAllMovies();
						break;
					case 0:
						exit = true;
						break;
					default:
						printErrorMessage();
						break;
					}
					if(exit) break;
				}
			}
			else if (choice.equalsIgnoreCase("E")) {
				System.out.println("_____________________________________________________________");
				System.out.println("Goodbye! Thank you for using our Movie Recommendation System.");
				System.out.println("_____________________________________________________________");
				break;
			}
			else {
				printErrorMessage();
			}
		}
	}
}
class ActionMovies{
	protected List <Movie> movies;
	
	public ActionMovies() {
		movies = new ArrayList <Movie>();
	}
	public void insertionSort(List <Movie> movies) {
		
		for(int i = 1; i < movies.size(); i++) {
			Movie key = movies.get(i);
			int j = i - 1;
			
			while(j >= 0 && movies.get(j).getAverageRating() < key.getAverageRating()) {
				movies.set(j + 1, movies.get(j));
				j--;
			}
			movies.set(j + 1, key);
		}
	}
	public void listOfMovies() {
		
		movies.add(new Movie("John Wick           ", "Action", 4.95));
		movies.add(new Movie("Mission Impossible  ", "Action", 4.95));
		movies.add(new Movie("James Bond          ", "Action", 4.95));
		movies.add(new Movie("Fast and The Furious", "Action", 4.90));
		movies.add(new Movie("The Expendables     ", "Action", 4.11));
		movies.add(new Movie("Top Gun: Maverick   ", "Action", 4.93));
		movies.add(new Movie("Mad Max: Fury Road  ", "Action", 4.95));
		movies.add(new Movie("The Raid            ", "Action", 4.17));
		movies.add(new Movie("Lone Survivor       ", "Action", 4.23));
		movies.add(new Movie("Ready Player One    ", "Action", 4.48));
		insertionSort(movies);
	}
	public void displayAllMovies() {
		if(movies.isEmpty()) {
			System.out.println("Empty");
		}
		System.out.println("**************************************************************");
		System.out.println("Rank\t\t\tTitle\t\t\t\tRating");
		System.out.println();
		for(int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			
			System.out.println(i + 1 + ".\t\t\t" + movie.getMovieTitle() + "\t\t" + movie.getAverageRating());
		}
		System.out.println("**************************************************************");
	}
	public void displayTop3Movies() {
		if(movies.isEmpty()) {
			System.out.println("Empty");
		}
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Here are the top 3 movies based on viewers’ recommendations:");
		System.out.println();
		System.out.println("**************************************************************");
		System.out.println("Rank\t\t\tTitle\t\t\t\tRating");
		System.out.println();
		
		for(int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			double highest = movies.get(0).getAverageRating();
			
				if(highest == movie.getAverageRating()) {
					System.out.println(i + 1 + ".\t\t\t" + movie.getMovieTitle() + "\t\t" + movie.getAverageRating());
				}
		}
		System.out.println("**************************************************************");
	}
}
class AnimeMovies extends ActionMovies {
	
	public AnimeMovies() {
		movies = new ArrayList <Movie>();
	}
	public void listOfMovies() {
		movies.add(new Movie("Weathering With You  ", "Anime", 4.71));
		movies.add(new Movie("One Piece Red Film   ", "Anime", 4.56));
		movies.add(new Movie("Fireworks            ", "Anime", 4.67));
		movies.add(new Movie("Flavors Of Youth     ", "Anime", 4.34));
		movies.add(new Movie("Your Name            ", "Anime", 4.92));
		movies.add(new Movie("Bleach               ", "Anime", 4.25));
		movies.add(new Movie("Demon Slayer         ", "Anime", 4.65));
		movies.add(new Movie("A Silent Voice       ", "Anime", 4.44));
		movies.add(new Movie("The Wind Rises       ", "Anime", 4.15));
		movies.add(new Movie("Blade Of The Immortal", "Anime", 4.27));
		insertionSort(movies);
	}
}
class ComedyMovies extends ActionMovies{

	public ComedyMovies() {
		movies = new ArrayList <Movie>();
	}
	public void listOfMovies() {
		movies.add(new Movie("The Dictator          ", "Comedy", 4.52));
		movies.add(new Movie("Three Idiots          ", "Comedy", 4.82));
		movies.add(new Movie("Mang Boy Multiverse   ", "Comedy", 4.99));
		movies.add(new Movie("Pakners FPJ and Efren ", "Comedy", 4.41));
		movies.add(new Movie("CODA                  ", "Comedy", 4.38));
		movies.add(new Movie("The Gentleman         ", "Comedy", 4.45));
		movies.add(new Movie("The Gods Must Be Crazy", "Comedy", 4.87));
		movies.add(new Movie("No Hard Feelings      ", "Comedy", 4.23));
		movies.add(new Movie("Central Intelligence  ", "Comedy", 4.76));
		movies.add(new Movie("Red Notice            ", "Comedy", 4.64));
		insertionSort(movies);
	}
}
class HorrorMovies extends ActionMovies {
	
	public HorrorMovies () {
		movies = new ArrayList <Movie>();
	}
	public void listOfMovies() {
		movies.add(new Movie("The Nun          ", "Horror", 4.91));
		movies.add(new Movie("The Conjuring    ", "Horror", 4.85));
		movies.add(new Movie("Talk To Me       ", "Horror", 4.46));
		movies.add(new Movie("Evil Dead        ", "Horror", 4.76));
		movies.add(new Movie("Don't Breath     ", "Horror", 4.28));
		movies.add(new Movie("Wrong Turn       ", "Horror", 4.32));
		movies.add(new Movie("Get Out          ", "Horror", 4.96));
		movies.add(new Movie("Insidious        ", "Horror", 4.16));
		movies.add(new Movie("Halloween        ", "Horror", 4.16));
		movies.add(new Movie("Scream           ", "Horror", 4.16));
		insertionSort(movies);
	}
}
class RomanceMovies extends ActionMovies{
	
	public RomanceMovies() {
		movies = new ArrayList <Movie>();
	}
	public void listOfMovies() {
		movies.add(new Movie("La La Land            ", "Romance", 4.29));
		movies.add(new Movie("Titanic               ", "Romance", 4.83));
		movies.add(new Movie("Love Rosie            ", "Romance", 4.11));
		movies.add(new Movie("Me Before You         ", "Romance", 4.91));
		movies.add(new Movie("About Time            ", "Romance", 4.81));
		movies.add(new Movie("The Fault In Our Stars", "Romance", 4.89));
		movies.add(new Movie("Forrest Gump          ", "Romance", 4.75));
		movies.add(new Movie("Pride & Prejudice     ", "Romance", 4.55));
		movies.add(new Movie("A Star Is Born        ", "Romance", 4.46));
		movies.add(new Movie("A Walk To Remember    ", "Romance", 4.80));
		insertionSort(movies);
	}
}