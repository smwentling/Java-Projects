package tokenizer;

import java.util.ArrayList;

/** Provides a single method that turns a String s into a list of
 *  individual tokens (i.e., word terms) for indexing.
 * 
 * @author ssanner@mie.utoronto.ca; Matthew Kwan, matthewky.kwan@gmail.com
 *
 */
public interface Tokenizer {
	public abstract ArrayList<String> tokenize(String s);
}
