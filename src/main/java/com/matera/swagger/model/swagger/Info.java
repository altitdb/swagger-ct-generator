package com.matera.swagger.model.swagger;

import java.util.Objects;

public class Info {

	private String version;
	private String title;
	private String description;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(version, title, description);
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Info)) {
			return false;
		}
		Info castOther = (Info) other;
		return Objects.equals(version, castOther.version) && Objects.equals(title, castOther.title)
				&& Objects.equals(description, castOther.description);
	}

}
