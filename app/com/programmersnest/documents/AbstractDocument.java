/**
 * 
 */
package com.programmersnest.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.google.common.base.Objects;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */
public abstract class AbstractDocument {

	@Id
	protected String id;
	private Date createdAt;
	private Date updateAt;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractDocument other = (AbstractDocument) obj;
		return Objects.equal(this.id, other.id);
	}
}
