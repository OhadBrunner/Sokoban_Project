package levels;

import java.io.InputStream;

/**
* A)The separation has been done by adding a structure of level loaders that implements the same interface in order to perform a loading of a level from any kind of a file (as for now),
* and creating an actual level out of it by holding a level object, and use the Level data to make this possible.
* B)This separation allows us to keep on the open/close principle, by making it possible to add new loaders in the future with different functionality, but also keep the code out of changes
* (they will all have to implement the same interface), so we can make sure all the loaders will keep on having the same purpose.
* c)It also allows us to keep on the Liskov Substitution Principle, by making the LevelLoader interface as abstract as possible so it can indicate on any kind of loader, which keeps us, 
* and others, from making code smells like down-casting in order to use a certain loader.  
* D)We are using an inputStream instead of a String, so it can support loading levels from different types of sources (and not only files)
*/

public interface LevelLoader {

	public Level loadLevel(InputStream is);
	
}
