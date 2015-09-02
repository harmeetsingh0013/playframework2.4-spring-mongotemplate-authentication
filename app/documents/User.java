/**
 * 
 */
package documents;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.base.MoreObjects;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@Document(collection="users")
public class User extends AbstractDocument implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).addValue(this.getId()).addValue(this.getName()).toString();
	}
}
